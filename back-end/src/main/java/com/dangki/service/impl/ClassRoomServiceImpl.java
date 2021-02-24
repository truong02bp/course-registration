package com.dangki.service.impl;

import com.dangki.common.MessageConstants;
import com.dangki.common.exception.ApiException;
import com.dangki.common.utils.Converter;
import com.dangki.data.dto.ClassRoomDto;
import com.dangki.data.dto.DetailsDto;
import com.dangki.data.dto.UserDto;
import com.dangki.data.entities.*;
import com.dangki.data.repository.*;
import com.dangki.service.ClassRoomService;
import com.dangki.service.DetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ClassRoom}.
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final Logger log = LoggerFactory.getLogger(ClassRoomServiceImpl.class);

    private final ClassRoomRepository classRoomRepository;

    private final UserRepository userRepository;

    private final SubjectRepository subjectRepository;

    private final DetailsRepository detailsRepository;

    private final DetailsService detailsService;

    private final TimeRepository timeRepository;

    private final ProfessorRepository professorRepository;

    private final WeekRepository weekRepository;

    private final RoomRepository roomRepository;
    private final Converter<ClassRoomDto , ClassRoom> converter = new Converter<>(ClassRoomDto.class,ClassRoom.class);
    private final Converter<UserDto, User> userConverter = new Converter<>(UserDto.class,User.class);
    private final Converter<DetailsDto, Details> detailsConverter = new Converter<>(DetailsDto.class,Details.class);

    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository, UserRepository userRepository, SubjectRepository subjectRepository, DetailsRepository detailsRepository, DetailsService detailsService, TimeRepository timeRepository, ProfessorRepository professorRepository, WeekRepository weekRepository, RoomRepository roomRepository) {
        this.classRoomRepository = classRoomRepository;
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
        this.detailsRepository = detailsRepository;
        this.detailsService = detailsService;
        this.timeRepository = timeRepository;
        this.professorRepository = professorRepository;
        this.weekRepository = weekRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<ClassRoomDto> add(List<ClassRoomDto> classRooms) {
        List<ClassRoomDto> result = new ArrayList<>();
        classRooms.forEach(classRoomDto -> {
            ClassRoom classRoom = converter.toEntity(classRoomDto);
            System.out.println(classRoom.getNmh());
            String subjectName = classRoomDto.getSubject().getName().substring(1);
            Subject subject = subjectRepository.findByName(subjectName);
            System.out.println(subject);
            classRoom.setSubject(subject);
            Set<Details> detailsSet = new HashSet<>();
            classRoomDto.getDetails().forEach(detailsDto -> {
              Set<Week> weeks = new HashSet<>();
              detailsDto.getWeeks().forEach(weekDto -> {
                  weeks.add(weekRepository.findByName(weekDto.getName()));
              });
                List<Details> details = detailsRepository
                        .find(detailsDto.getTime().getName(),detailsDto.getTime().getLesson(),
                                detailsDto.getProfessor().getName(),detailsDto.getRoom().getName())
                        .stream().filter(item -> {
                    return item.getWeeks().containsAll(weeks);
                }).collect(Collectors.toList());
                if (details.size()==0)
                    details.add(detailsConverter.toEntity(detailsService.add(detailsDto)));
                detailsSet.add(details.get(0));
            });
            classRoom.setDetails(detailsSet);
            result.add(converter.toDto(classRoomRepository.save(classRoom)));
        });
        return result;
    }

    @Override
    public ClassRoom update(ClassRoom classRoom) {
        log.debug("Request to save ClassRoom : {}", classRoom);
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoomDto findById(Long id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        if (classRoom == null)
            throw ApiException.from(HttpStatus.NOT_FOUND).message(MessageConstants.NOT_FOUND);
        List<User> users = userRepository.findAllByClassRoomId(id);
        ClassRoomDto result = converter.toDto(classRoom);
        List<UserDto> userDtos = userConverter.toDto(users);
        userDtos.forEach(userDto -> {
            userDto.setClassRooms(null);
        });
        result.setUsers(userDtos);
        return result;
    }

    @Override
    public List<ClassRoomDto> findAllBySubjectId(Long id) {
        return converter.toDto(classRoomRepository.findAllBySubjectId(id));
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ClassRoom : {}", id);
        classRoomRepository.deleteById(id);
    }
}

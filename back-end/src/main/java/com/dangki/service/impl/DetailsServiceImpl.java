package com.dangki.service.impl;

import com.dangki.common.utils.Converter;
import com.dangki.data.dto.DetailsDto;
import com.dangki.data.entities.*;
import com.dangki.data.repository.*;
import com.dangki.service.DetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Details}.
 */
@Service
public class DetailsServiceImpl implements DetailsService {

    private final Logger log = LoggerFactory.getLogger(DetailsServiceImpl.class);

    private final Converter<DetailsDto, Details> converter = new Converter<>(DetailsDto.class, Details.class);

    private final DetailsRepository detailsRepository;

    private final TimeRepository timeRepository;

    private final ProfessorRepository professorRepository;

    private final WeekRepository weekRepository;

    private final RoomRepository roomRepository;

    public DetailsServiceImpl(DetailsRepository detailsRepository, TimeRepository timeRepository, ProfessorRepository professorRepository, WeekRepository weekRepository, RoomRepository roomRepository) {
        this.detailsRepository = detailsRepository;
        this.timeRepository = timeRepository;
        this.professorRepository = professorRepository;
        this.weekRepository = weekRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Details update(Details details) {
        log.debug("Request to save Details : {}", details);
        return detailsRepository.save(details);
    }

    @Override
    public DetailsDto add(DetailsDto detail) {
        String timeName = detail.getTime().getName().trim();
        Details details = new Details();
        Time time = timeRepository.findByNameAndLesson(timeName, detail.getTime().getLesson());
        System.out.println(time);
        String professorName = detail.getProfessor().getName().trim();
        Professor professor = professorRepository.findByName(professorName);
        System.out.println(professor);
        String roomName = detail.getRoom().getName().trim();
        Room room = roomRepository.findByName(roomName);
        Set<Week> weeks = new HashSet<>();
        detail.getWeeks().forEach(weekDto -> {
            weeks.add(weekRepository.findByName(weekDto.getName()));
        });
        System.out.println(weeks);
        return converter.toDto(detailsRepository.save(details.time(time).professor(professor).room(room).weeks(weeks)));
    }
    @Override
    public List<DetailsDto> add(List<DetailsDto> details) {
        List<DetailsDto> list = new ArrayList<>();
        for (DetailsDto detail : details)
            list.add(add(detail));
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Details> findAll(Pageable pageable) {
        log.debug("Request to get all Details");
        return detailsRepository.findAll(pageable);
    }


    public Page<Details> findAllWithEagerRelationships(Pageable pageable) {
        return detailsRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Details> findOne(Long id) {
        log.debug("Request to get Details : {}", id);
        return detailsRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Details : {}", id);
        detailsRepository.deleteById(id);
    }
}

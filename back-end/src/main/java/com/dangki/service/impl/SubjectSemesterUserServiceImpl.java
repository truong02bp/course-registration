package com.dangki.service.impl;

import com.dangki.common.utils.SecurityUtil;
import com.dangki.data.dto.ParamDto;
import com.dangki.data.entities.Semester;
import com.dangki.data.entities.Subject;
import com.dangki.data.entities.SubjectSemesterUser;
import com.dangki.data.entities.User;
import com.dangki.data.repository.SemesterRepository;
import com.dangki.data.repository.SubjectRepository;
import com.dangki.data.repository.SubjectSemesterUserRepository;
import com.dangki.data.repository.UserRepository;
import com.dangki.service.SubjectSemesterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link SubjectSemesterUser}.
 */
@Service
@Transactional
public class SubjectSemesterUserServiceImpl implements SubjectSemesterUserService {

    @Autowired
    private SecurityUtil securityUtil;

    private final Logger log = LoggerFactory.getLogger(SubjectSemesterUserServiceImpl.class);

    private final SubjectSemesterUserRepository subjectSemesterUserRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SemesterRepository semesterRepository;

    public SubjectSemesterUserServiceImpl(SubjectSemesterUserRepository subjectSemesterUserRepository, UserRepository userRepository, SubjectRepository subjectRepository, SemesterRepository semesterRepository) {
        this.subjectSemesterUserRepository = subjectSemesterUserRepository;
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
        this.semesterRepository = semesterRepository;
    }

    @Override
    public List<SubjectSemesterUser> add(List<ParamDto> paramDtos) {
        List<SubjectSemesterUser> list = new ArrayList<>();
        for (ParamDto paramDto : paramDtos) {
            SubjectSemesterUser subjectSemesterUser = new SubjectSemesterUser();
            Subject subject = subjectRepository.findById(paramDto.getSubjectId()).get();
            User user = userRepository.findById(securityUtil.getUserDetails().getUser().getId()).get();
            Semester semester = semesterRepository.findById((long)5).get();
            subjectSemesterUser.subject(subject).user(user).semester(semester);
            subjectSemesterUser = subjectSemesterUserRepository.save(subjectSemesterUser);
            list.add(subjectSemesterUser);
        }
        return list;
    }

    @Override
    public SubjectSemesterUser update(SubjectSemesterUser subjectSemesterUser) {
        return subjectSemesterUserRepository.save(subjectSemesterUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubjectSemesterUser> findAll() {
        log.debug("Request to get all SubjectSemesterUsers");
        return subjectSemesterUserRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SubjectSemesterUser> findOne(Long id) {
        log.debug("Request to get SubjectSemesterUser : {}", id);
        return subjectSemesterUserRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SubjectSemesterUser : {}", id);
        subjectSemesterUserRepository.deleteById(id);
    }
}

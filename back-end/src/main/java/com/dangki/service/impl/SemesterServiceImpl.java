package com.dangki.service.impl;

import com.dangki.data.entities.Semester;
import com.dangki.data.repository.SemesterRepository;
import com.dangki.service.SemesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Semester}.
 */
@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {

    private final Logger log = LoggerFactory.getLogger(SemesterServiceImpl.class);

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public Semester save(Semester semester) {
        log.debug("Request to save Semester : {}", semester);
        return semesterRepository.save(semester);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Semester> findAll(Pageable pageable) {
        log.debug("Request to get all Semesters");
        return semesterRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Semester> findOne(Long id) {
        log.debug("Request to get Semester : {}", id);
        return semesterRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Semester : {}", id);
        semesterRepository.deleteById(id);
    }
}

package com.dangki.service.impl;

import com.dangki.data.entities.Subject;
import com.dangki.data.repository.SubjectRepository;
import com.dangki.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Subject}.
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> save(List<Subject> subjects) {
        log.debug("Request to save Subject : {}", subjects);
        List<Subject> list = new ArrayList<>();
        subjects.forEach(subject -> {
            list.add(subjectRepository.save(subject));
        });
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Subject> findAll(Pageable pageable) {
        log.debug("Request to get all Subjects");
        return subjectRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> findOne(Long id) {
        log.debug("Request to get Subject : {}", id);
        return subjectRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Subject : {}", id);
        subjectRepository.deleteById(id);
    }
}

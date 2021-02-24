package com.dangki.service.impl;


import com.dangki.data.entities.Professor;
import com.dangki.data.repository.ProfessorRepository;
import com.dangki.service.ProfessorService;
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
 * Service Implementation for managing {@link Professor}.
 */
@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    private final Logger log = LoggerFactory.getLogger(ProfessorServiceImpl.class);

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    @Override
    public List<Professor> add(List<Professor> professors) {
        List<Professor> result = new ArrayList<>();
        for (Professor professor : professors) {
            result.add(professor);
            professorRepository.save(professor);
        }
        return result;
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Professor> findAll(Pageable pageable) {
        log.debug("Request to get all Professors");
        return professorRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Professor> findOne(Long id) {
        log.debug("Request to get Professor : {}", id);
        return professorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Professor : {}", id);
        professorRepository.deleteById(id);
    }
}

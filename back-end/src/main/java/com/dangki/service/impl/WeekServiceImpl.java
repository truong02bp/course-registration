package com.dangki.service.impl;


import com.dangki.data.entities.Week;
import com.dangki.data.repository.WeekRepository;
import com.dangki.service.WeekService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Week}.
 */
@Service
@Transactional
public class WeekServiceImpl implements WeekService {

    private final Logger log = LoggerFactory.getLogger(WeekServiceImpl.class);

    private final WeekRepository weekRepository;

    public WeekServiceImpl(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
    }

    @Override
    public Week save(Week week) {
        log.debug("Request to save Week : {}", week);
        return weekRepository.save(week);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Week> findAll(Pageable pageable) {
        log.debug("Request to get all Weeks");
        return weekRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Week> findOne(Long id) {
        log.debug("Request to get Week : {}", id);
        return weekRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Week : {}", id);
        weekRepository.deleteById(id);
    }
}

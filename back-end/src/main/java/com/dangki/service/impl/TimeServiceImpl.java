package com.dangki.service.impl;

import com.dangki.common.utils.Converter;
import com.dangki.data.dto.TimeDto;
import com.dangki.data.entities.Time;
import com.dangki.data.repository.TimeRepository;
import com.dangki.service.TimeService;
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
 * Service Implementation for managing {@link Time}.
 */
@Service
@Transactional
public class TimeServiceImpl implements TimeService {

    private final Logger log = LoggerFactory.getLogger(TimeServiceImpl.class);

    private final TimeRepository timeRepository;

    private final Converter<TimeDto,Time> converter = new Converter<>(TimeDto.class,Time.class);

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public List<TimeDto> add(List<TimeDto> timeDtos) {
        List<TimeDto> result = new ArrayList<>();
        for (TimeDto timeDto : timeDtos) {
            log.debug("Request to save Time : {}", timeDto);
            Time time = timeRepository.findByNameAndLesson(timeDto.getName(),timeDto.getLesson());
            if (time == null)
            {
                time = converter.toEntity(timeDto);
                timeRepository.save(time);
            }
            result.add(converter.toDto(time));
        }
        return result;
    }


    @Override
    public TimeDto update(Time time) {
        return converter.toDto(timeRepository.save(time));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Time> findAll(Pageable pageable) {
        log.debug("Request to get all Times");
        return timeRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Time> findOne(Long id) {
        log.debug("Request to get Time : {}", id);
        return timeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Time : {}", id);
        timeRepository.deleteById(id);
    }
}

package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Tribunal;
import com.fourquality.mandata.repository.TribunalRepository;
import com.fourquality.mandata.service.dto.TribunalDTO;
import com.fourquality.mandata.service.mapper.TribunalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Tribunal.
 */
@Service
@Transactional
public class TribunalService {

    private final Logger log = LoggerFactory.getLogger(TribunalService.class);

    private final TribunalRepository tribunalRepository;

    private final TribunalMapper tribunalMapper;

    public TribunalService(TribunalRepository tribunalRepository, TribunalMapper tribunalMapper) {
        this.tribunalRepository = tribunalRepository;
        this.tribunalMapper = tribunalMapper;
    }

    /**
     * Save a tribunal.
     *
     * @param tribunalDTO the entity to save
     * @return the persisted entity
     */
    public TribunalDTO save(TribunalDTO tribunalDTO) {
        log.debug("Request to save Tribunal : {}", tribunalDTO);
        Tribunal tribunal = tribunalMapper.toEntity(tribunalDTO);
        tribunal = tribunalRepository.save(tribunal);
        return tribunalMapper.toDto(tribunal);
    }

    /**
     * Get all the tribunals.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TribunalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tribunals");
        return tribunalRepository.findAll(pageable)
            .map(tribunalMapper::toDto);
    }


    /**
     * Get one tribunal by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TribunalDTO> findOne(Long id) {
        log.debug("Request to get Tribunal : {}", id);
        return tribunalRepository.findById(id)
            .map(tribunalMapper::toDto);
    }

    /**
     * Delete the tribunal by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Tribunal : {}", id);
        tribunalRepository.deleteById(id);
    }
}

package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Risco;
import com.fourquality.mandata.repository.RiscoRepository;
import com.fourquality.mandata.service.dto.RiscoDTO;
import com.fourquality.mandata.service.mapper.RiscoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Risco.
 */
@Service
@Transactional
public class RiscoService {

    private final Logger log = LoggerFactory.getLogger(RiscoService.class);

    private final RiscoRepository riscoRepository;

    private final RiscoMapper riscoMapper;

    public RiscoService(RiscoRepository riscoRepository, RiscoMapper riscoMapper) {
        this.riscoRepository = riscoRepository;
        this.riscoMapper = riscoMapper;
    }

    /**
     * Save a risco.
     *
     * @param riscoDTO the entity to save
     * @return the persisted entity
     */
    public RiscoDTO save(RiscoDTO riscoDTO) {
        log.debug("Request to save Risco : {}", riscoDTO);
        Risco risco = riscoMapper.toEntity(riscoDTO);
        risco = riscoRepository.save(risco);
        return riscoMapper.toDto(risco);
    }

    /**
     * Get all the riscos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<RiscoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Riscos");
        return riscoRepository.findAll(pageable)
            .map(riscoMapper::toDto);
    }


    /**
     * Get one risco by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<RiscoDTO> findOne(Long id) {
        log.debug("Request to get Risco : {}", id);
        return riscoRepository.findById(id)
            .map(riscoMapper::toDto);
    }

    /**
     * Delete the risco by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Risco : {}", id);
        riscoRepository.deleteById(id);
    }
}

package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Representado;
import com.fourquality.mandata.repository.RepresentadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Representado.
 */
@Service
@Transactional
public class RepresentadoService {

    private final Logger log = LoggerFactory.getLogger(RepresentadoService.class);

    private final RepresentadoRepository representadoRepository;

    public RepresentadoService(RepresentadoRepository representadoRepository) {
        this.representadoRepository = representadoRepository;
    }

    /**
     * Save a representado.
     *
     * @param representado the entity to save
     * @return the persisted entity
     */
    public Representado save(Representado representado) {
        log.debug("Request to save Representado : {}", representado);
        return representadoRepository.save(representado);
    }

    /**
     * Get all the representados.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Representado> findAll(Pageable pageable) {
        log.debug("Request to get all Representados");
        return representadoRepository.findAll(pageable);
    }


    /**
     * Get one representado by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Representado> findOne(Long id) {
        log.debug("Request to get Representado : {}", id);
        return representadoRepository.findById(id);
    }

    /**
     * Delete the representado by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Representado : {}", id);
        representadoRepository.deleteById(id);
    }
}

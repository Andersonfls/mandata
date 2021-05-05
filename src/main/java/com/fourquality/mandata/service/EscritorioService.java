package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Escritorio;
import com.fourquality.mandata.repository.EscritorioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Escritorio.
 */
@Service
@Transactional
public class EscritorioService {

    private final Logger log = LoggerFactory.getLogger(EscritorioService.class);

    private final EscritorioRepository escritorioRepository;

    public EscritorioService(EscritorioRepository escritorioRepository) {
        this.escritorioRepository = escritorioRepository;
    }

    /**
     * Save a escritorio.
     *
     * @param escritorio the entity to save
     * @return the persisted entity
     */
    public Escritorio save(Escritorio escritorio) {
        log.debug("Request to save Escritorio : {}", escritorio);
        return escritorioRepository.save(escritorio);
    }

    /**
     * Get all the escritorios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Escritorio> findAll(Pageable pageable) {
        log.debug("Request to get all Escritorios");
        return escritorioRepository.findAll(pageable);
    }


    /**
     * Get one escritorio by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Escritorio> findOne(Long id) {
        log.debug("Request to get Escritorio : {}", id);
        return escritorioRepository.findById(id);
    }

    /**
     * Delete the escritorio by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Escritorio : {}", id);
        escritorioRepository.deleteById(id);
    }
}

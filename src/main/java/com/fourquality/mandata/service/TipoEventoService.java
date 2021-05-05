package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.TipoEvento;
import com.fourquality.mandata.repository.TipoEventoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoEvento.
 */
@Service
@Transactional
public class TipoEventoService {

    private final Logger log = LoggerFactory.getLogger(TipoEventoService.class);

    private final TipoEventoRepository tipoEventoRepository;

    public TipoEventoService(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }

    /**
     * Save a tipoEvento.
     *
     * @param tipoEvento the entity to save
     * @return the persisted entity
     */
    public TipoEvento save(TipoEvento tipoEvento) {
        log.debug("Request to save TipoEvento : {}", tipoEvento);
        return tipoEventoRepository.save(tipoEvento);
    }

    /**
     * Get all the tipoEventos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoEvento> findAll(Pageable pageable) {
        log.debug("Request to get all TipoEventos");
        return tipoEventoRepository.findAll(pageable);
    }


    /**
     * Get one tipoEvento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoEvento> findOne(Long id) {
        log.debug("Request to get TipoEvento : {}", id);
        return tipoEventoRepository.findById(id);
    }

    /**
     * Delete the tipoEvento by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoEvento : {}", id);
        tipoEventoRepository.deleteById(id);
    }
}

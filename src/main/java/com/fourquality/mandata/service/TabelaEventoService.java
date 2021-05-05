package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.TabelaEvento;
import com.fourquality.mandata.repository.TabelaEventoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TabelaEvento.
 */
@Service
@Transactional
public class TabelaEventoService {

    private final Logger log = LoggerFactory.getLogger(TabelaEventoService.class);

    private final TabelaEventoRepository tabelaEventoRepository;

    public TabelaEventoService(TabelaEventoRepository tabelaEventoRepository) {
        this.tabelaEventoRepository = tabelaEventoRepository;
    }

    /**
     * Save a tabelaEvento.
     *
     * @param tabelaEvento the entity to save
     * @return the persisted entity
     */
    public TabelaEvento save(TabelaEvento tabelaEvento) {
        log.debug("Request to save TabelaEvento : {}", tabelaEvento);
        return tabelaEventoRepository.save(tabelaEvento);
    }

    /**
     * Get all the tabelaEventos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TabelaEvento> findAll(Pageable pageable) {
        log.debug("Request to get all TabelaEventos");
        return tabelaEventoRepository.findAll(pageable);
    }


    /**
     * Get one tabelaEvento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TabelaEvento> findOne(Long id) {
        log.debug("Request to get TabelaEvento : {}", id);
        return tabelaEventoRepository.findById(id);
    }

    /**
     * Delete the tabelaEvento by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TabelaEvento : {}", id);
        tabelaEventoRepository.deleteById(id);
    }
}

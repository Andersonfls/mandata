package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.TipoTabela;
import com.fourquality.mandata.repository.TipoTabelaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoTabela.
 */
@Service
@Transactional
public class TipoTabelaService {

    private final Logger log = LoggerFactory.getLogger(TipoTabelaService.class);

    private final TipoTabelaRepository tipoTabelaRepository;

    public TipoTabelaService(TipoTabelaRepository tipoTabelaRepository) {
        this.tipoTabelaRepository = tipoTabelaRepository;
    }

    /**
     * Save a tipoTabela.
     *
     * @param tipoTabela the entity to save
     * @return the persisted entity
     */
    public TipoTabela save(TipoTabela tipoTabela) {
        log.debug("Request to save TipoTabela : {}", tipoTabela);
        return tipoTabelaRepository.save(tipoTabela);
    }

    /**
     * Get all the tipoTabelas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoTabela> findAll(Pageable pageable) {
        log.debug("Request to get all TipoTabelas");
        return tipoTabelaRepository.findAll(pageable);
    }


    /**
     * Get one tipoTabela by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoTabela> findOne(Long id) {
        log.debug("Request to get TipoTabela : {}", id);
        return tipoTabelaRepository.findById(id);
    }

    /**
     * Delete the tipoTabela by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoTabela : {}", id);
        tipoTabelaRepository.deleteById(id);
    }
}

package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Tabela;
import com.fourquality.mandata.repository.TabelaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Tabela.
 */
@Service
@Transactional
public class TabelaService {

    private final Logger log = LoggerFactory.getLogger(TabelaService.class);

    private final TabelaRepository tabelaRepository;

    public TabelaService(TabelaRepository tabelaRepository) {
        this.tabelaRepository = tabelaRepository;
    }

    /**
     * Save a tabela.
     *
     * @param tabela the entity to save
     * @return the persisted entity
     */
    public Tabela save(Tabela tabela) {
        log.debug("Request to save Tabela : {}", tabela);
        return tabelaRepository.save(tabela);
    }

    /**
     * Get all the tabelas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Tabela> findAll(Pageable pageable) {
        log.debug("Request to get all Tabelas");
        return tabelaRepository.findAll(pageable);
    }


    /**
     * Get one tabela by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Tabela> findOne(Long id) {
        log.debug("Request to get Tabela : {}", id);
        return tabelaRepository.findById(id);
    }

    /**
     * Delete the tabela by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Tabela : {}", id);
        tabelaRepository.deleteById(id);
    }
}

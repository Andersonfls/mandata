package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.TipoCliente;
import com.fourquality.mandata.repository.TipoClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoCliente.
 */
@Service
@Transactional
public class TipoClienteService {

    private final Logger log = LoggerFactory.getLogger(TipoClienteService.class);

    private final TipoClienteRepository tipoClienteRepository;

    public TipoClienteService(TipoClienteRepository tipoClienteRepository) {
        this.tipoClienteRepository = tipoClienteRepository;
    }

    /**
     * Save a tipoCliente.
     *
     * @param tipoCliente the entity to save
     * @return the persisted entity
     */
    public TipoCliente save(TipoCliente tipoCliente) {
        log.debug("Request to save TipoCliente : {}", tipoCliente);
        return tipoClienteRepository.save(tipoCliente);
    }

    /**
     * Get all the tipoClientes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoCliente> findAll(Pageable pageable) {
        log.debug("Request to get all TipoClientes");
        return tipoClienteRepository.findAll(pageable);
    }


    /**
     * Get one tipoCliente by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoCliente> findOne(Long id) {
        log.debug("Request to get TipoCliente : {}", id);
        return tipoClienteRepository.findById(id);
    }

    /**
     * Delete the tipoCliente by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoCliente : {}", id);
        tipoClienteRepository.deleteById(id);
    }
}

package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.TipoAdvogado;
import com.fourquality.mandata.repository.TipoAdvogadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoAdvogado.
 */
@Service
@Transactional
public class TipoAdvogadoService {

    private final Logger log = LoggerFactory.getLogger(TipoAdvogadoService.class);

    private final TipoAdvogadoRepository tipoAdvogadoRepository;

    public TipoAdvogadoService(TipoAdvogadoRepository tipoAdvogadoRepository) {
        this.tipoAdvogadoRepository = tipoAdvogadoRepository;
    }

    /**
     * Save a tipoAdvogado.
     *
     * @param tipoAdvogado the entity to save
     * @return the persisted entity
     */
    public TipoAdvogado save(TipoAdvogado tipoAdvogado) {
        log.debug("Request to save TipoAdvogado : {}", tipoAdvogado);
        return tipoAdvogadoRepository.save(tipoAdvogado);
    }

    /**
     * Get all the tipoAdvogados.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoAdvogado> findAll(Pageable pageable) {
        log.debug("Request to get all TipoAdvogados");
        return tipoAdvogadoRepository.findAll(pageable);
    }


    /**
     * Get one tipoAdvogado by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoAdvogado> findOne(Long id) {
        log.debug("Request to get TipoAdvogado : {}", id);
        return tipoAdvogadoRepository.findById(id);
    }

    /**
     * Delete the tipoAdvogado by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoAdvogado : {}", id);
        tipoAdvogadoRepository.deleteById(id);
    }
}

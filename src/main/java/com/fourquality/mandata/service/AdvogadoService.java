package com.fourquality.mandata.service;

import com.fourquality.mandata.domain.Advogado;
import com.fourquality.mandata.repository.AdvogadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Advogado.
 */
@Service
@Transactional
public class AdvogadoService {

    private final Logger log = LoggerFactory.getLogger(AdvogadoService.class);

    private final AdvogadoRepository advogadoRepository;

    public AdvogadoService(AdvogadoRepository advogadoRepository) {
        this.advogadoRepository = advogadoRepository;
    }

    /**
     * Save a advogado.
     *
     * @param advogado the entity to save
     * @return the persisted entity
     */
    public Advogado save(Advogado advogado) {
        log.debug("Request to save Advogado : {}", advogado);
        return advogadoRepository.save(advogado);
    }

    /**
     * Get all the advogados.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Advogado> findAll(Pageable pageable) {
        log.debug("Request to get all Advogados");
        return advogadoRepository.findAll(pageable);
    }


    /**
     * Get one advogado by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Advogado> findOne(Long id) {
        log.debug("Request to get Advogado : {}", id);
        return advogadoRepository.findById(id);
    }

    /**
     * Delete the advogado by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Advogado : {}", id);
        advogadoRepository.deleteById(id);
    }
}

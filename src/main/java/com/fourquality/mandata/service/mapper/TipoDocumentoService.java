package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.domain.TipoDocumento;
import com.fourquality.mandata.repository.TipoDocumentoRepository;
import com.fourquality.mandata.service.dto.TipoDocumentoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing TipoDocumento.
 */
@Service
@Transactional
public class TipoDocumentoService {

    private final Logger log = LoggerFactory.getLogger(TipoDocumentoService.class);

    private final TipoDocumentoRepository tipoDocumentoRepository;

    private final TipoDocumentoMapper tipoDocumentoMapper;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }

    /**
     * Save a tipoDocumento.
     *
     * @param tipoDocumentoDTO the entity to save
     * @return the persisted entity
     */
    public TipoDocumentoDTO save(TipoDocumentoDTO tipoDocumentoDTO) {
        log.debug("Request to save TipoDocumento : {}", tipoDocumentoDTO);
        TipoDocumento tipoDocumento = tipoDocumentoMapper.toEntity(tipoDocumentoDTO);
        tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
        return tipoDocumentoMapper.toDto(tipoDocumento);
    }

    /**
     * Get all the tipoDocumentos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TipoDocumentoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TipoDocumentos");
        return tipoDocumentoRepository.findAll(pageable)
            .map(tipoDocumentoMapper::toDto);
    }


    /**
     * Get one tipoDocumento by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<TipoDocumentoDTO> findOne(Long id) {
        log.debug("Request to get TipoDocumento : {}", id);
        return tipoDocumentoRepository.findById(id)
            .map(tipoDocumentoMapper::toDto);
    }

    /**
     * Delete the tipoDocumento by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete TipoDocumento : {}", id);
        tipoDocumentoRepository.deleteById(id);
    }
}

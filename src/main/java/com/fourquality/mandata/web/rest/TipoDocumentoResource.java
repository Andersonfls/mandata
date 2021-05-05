package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.service.mapper.TipoDocumentoService;
import com.fourquality.mandata.service.dto.TipoDocumentoDTO;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TipoDocumento.
 */
@RestController
@RequestMapping("/api")
public class TipoDocumentoResource {

    private final Logger log = LoggerFactory.getLogger(TipoDocumentoResource.class);

    private static final String ENTITY_NAME = "tipoDocumento";

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoResource(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    /**
     * POST  /tipo-documentos : Create a new tipoDocumento.
     *
     * @param tipoDocumentoDTO the tipoDocumentoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tipoDocumentoDTO, or with status 400 (Bad Request) if the tipoDocumento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tipo-documentos")
    public ResponseEntity<TipoDocumentoDTO> createTipoDocumento(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) throws URISyntaxException {
        log.debug("REST request to save TipoDocumento : {}", tipoDocumentoDTO);
        if (tipoDocumentoDTO.getId() != null) {
            throw new BadRequestAlertException("A new tipoDocumento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoDocumentoDTO result = tipoDocumentoService.save(tipoDocumentoDTO);
        return ResponseEntity.created(new URI("/api/tipo-documentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tipo-documentos : Updates an existing tipoDocumento.
     *
     * @param tipoDocumentoDTO the tipoDocumentoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tipoDocumentoDTO,
     * or with status 400 (Bad Request) if the tipoDocumentoDTO is not valid,
     * or with status 500 (Internal Server Error) if the tipoDocumentoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tipo-documentos")
    public ResponseEntity<TipoDocumentoDTO> updateTipoDocumento(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) throws URISyntaxException {
        log.debug("REST request to update TipoDocumento : {}", tipoDocumentoDTO);
        if (tipoDocumentoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoDocumentoDTO result = tipoDocumentoService.save(tipoDocumentoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoDocumentoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tipo-documentos : get all the tipoDocumentos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tipoDocumentos in body
     */
    @GetMapping("/tipo-documentos")
    public ResponseEntity<List<TipoDocumentoDTO>> getAllTipoDocumentos(Pageable pageable) {
        log.debug("REST request to get a page of TipoDocumentos");
        Page<TipoDocumentoDTO> page = tipoDocumentoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipo-documentos");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /tipo-documentos/:id : get the "id" tipoDocumento.
     *
     * @param id the id of the tipoDocumentoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tipoDocumentoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tipo-documentos/{id}")
    public ResponseEntity<TipoDocumentoDTO> getTipoDocumento(@PathVariable Long id) {
        log.debug("REST request to get TipoDocumento : {}", id);
        Optional<TipoDocumentoDTO> tipoDocumentoDTO = tipoDocumentoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tipoDocumentoDTO);
    }

    /**
     * DELETE  /tipo-documentos/:id : delete the "id" tipoDocumento.
     *
     * @param id the id of the tipoDocumentoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tipo-documentos/{id}")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable Long id) {
        log.debug("REST request to delete TipoDocumento : {}", id);
        tipoDocumentoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

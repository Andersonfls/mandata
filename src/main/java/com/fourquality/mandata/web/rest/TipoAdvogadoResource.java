package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.TipoAdvogado;
import com.fourquality.mandata.service.TipoAdvogadoService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TipoAdvogadoCriteria;
import com.fourquality.mandata.service.TipoAdvogadoQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TipoAdvogado.
 */
@RestController
@RequestMapping("/api")
public class TipoAdvogadoResource {

    private final Logger log = LoggerFactory.getLogger(TipoAdvogadoResource.class);

    private static final String ENTITY_NAME = "tipoAdvogado";

    private final TipoAdvogadoService tipoAdvogadoService;

    private final TipoAdvogadoQueryService tipoAdvogadoQueryService;

    public TipoAdvogadoResource(TipoAdvogadoService tipoAdvogadoService, TipoAdvogadoQueryService tipoAdvogadoQueryService) {
        this.tipoAdvogadoService = tipoAdvogadoService;
        this.tipoAdvogadoQueryService = tipoAdvogadoQueryService;
    }

    /**
     * POST  /tipo-advogados : Create a new tipoAdvogado.
     *
     * @param tipoAdvogado the tipoAdvogado to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tipoAdvogado, or with status 400 (Bad Request) if the tipoAdvogado has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tipo-advogados")
    public ResponseEntity<TipoAdvogado> createTipoAdvogado(@Valid @RequestBody TipoAdvogado tipoAdvogado) throws URISyntaxException {
        log.debug("REST request to save TipoAdvogado : {}", tipoAdvogado);
        if (tipoAdvogado.getId() != null) {
            throw new BadRequestAlertException("A new tipoAdvogado cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoAdvogado result = tipoAdvogadoService.save(tipoAdvogado);
        return ResponseEntity.created(new URI("/api/tipo-advogados/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tipo-advogados : Updates an existing tipoAdvogado.
     *
     * @param tipoAdvogado the tipoAdvogado to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tipoAdvogado,
     * or with status 400 (Bad Request) if the tipoAdvogado is not valid,
     * or with status 500 (Internal Server Error) if the tipoAdvogado couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tipo-advogados")
    public ResponseEntity<TipoAdvogado> updateTipoAdvogado(@Valid @RequestBody TipoAdvogado tipoAdvogado) throws URISyntaxException {
        log.debug("REST request to update TipoAdvogado : {}", tipoAdvogado);
        if (tipoAdvogado.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoAdvogado result = tipoAdvogadoService.save(tipoAdvogado);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoAdvogado.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tipo-advogados : get all the tipoAdvogados.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tipoAdvogados in body
     */
    @GetMapping("/tipo-advogados")
    public ResponseEntity<List<TipoAdvogado>> getAllTipoAdvogados(TipoAdvogadoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TipoAdvogados by criteria: {}", criteria);
        Page<TipoAdvogado> page = tipoAdvogadoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipo-advogados");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tipo-advogados/count : count all the tipoAdvogados.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tipo-advogados/count")
    public ResponseEntity<Long> countTipoAdvogados(TipoAdvogadoCriteria criteria) {
        log.debug("REST request to count TipoAdvogados by criteria: {}", criteria);
        return ResponseEntity.ok().body(tipoAdvogadoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tipo-advogados/:id : get the "id" tipoAdvogado.
     *
     * @param id the id of the tipoAdvogado to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tipoAdvogado, or with status 404 (Not Found)
     */
    @GetMapping("/tipo-advogados/{id}")
    public ResponseEntity<TipoAdvogado> getTipoAdvogado(@PathVariable Long id) {
        log.debug("REST request to get TipoAdvogado : {}", id);
        Optional<TipoAdvogado> tipoAdvogado = tipoAdvogadoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tipoAdvogado);
    }

    /**
     * DELETE  /tipo-advogados/:id : delete the "id" tipoAdvogado.
     *
     * @param id the id of the tipoAdvogado to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tipo-advogados/{id}")
    public ResponseEntity<Void> deleteTipoAdvogado(@PathVariable Long id) {
        log.debug("REST request to delete TipoAdvogado : {}", id);
        tipoAdvogadoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

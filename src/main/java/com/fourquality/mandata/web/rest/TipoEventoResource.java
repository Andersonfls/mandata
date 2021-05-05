package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.TipoEvento;
import com.fourquality.mandata.service.TipoEventoService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TipoEventoCriteria;
import com.fourquality.mandata.service.TipoEventoQueryService;
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
 * REST controller for managing TipoEvento.
 */
@RestController
@RequestMapping("/api")
public class TipoEventoResource {

    private final Logger log = LoggerFactory.getLogger(TipoEventoResource.class);

    private static final String ENTITY_NAME = "tipoEvento";

    private final TipoEventoService tipoEventoService;

    private final TipoEventoQueryService tipoEventoQueryService;

    public TipoEventoResource(TipoEventoService tipoEventoService, TipoEventoQueryService tipoEventoQueryService) {
        this.tipoEventoService = tipoEventoService;
        this.tipoEventoQueryService = tipoEventoQueryService;
    }

    /**
     * POST  /tipo-eventos : Create a new tipoEvento.
     *
     * @param tipoEvento the tipoEvento to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tipoEvento, or with status 400 (Bad Request) if the tipoEvento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tipo-eventos")
    public ResponseEntity<TipoEvento> createTipoEvento(@Valid @RequestBody TipoEvento tipoEvento) throws URISyntaxException {
        log.debug("REST request to save TipoEvento : {}", tipoEvento);
        if (tipoEvento.getId() != null) {
            throw new BadRequestAlertException("A new tipoEvento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoEvento result = tipoEventoService.save(tipoEvento);
        return ResponseEntity.created(new URI("/api/tipo-eventos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tipo-eventos : Updates an existing tipoEvento.
     *
     * @param tipoEvento the tipoEvento to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tipoEvento,
     * or with status 400 (Bad Request) if the tipoEvento is not valid,
     * or with status 500 (Internal Server Error) if the tipoEvento couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tipo-eventos")
    public ResponseEntity<TipoEvento> updateTipoEvento(@Valid @RequestBody TipoEvento tipoEvento) throws URISyntaxException {
        log.debug("REST request to update TipoEvento : {}", tipoEvento);
        if (tipoEvento.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoEvento result = tipoEventoService.save(tipoEvento);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoEvento.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tipo-eventos : get all the tipoEventos.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tipoEventos in body
     */
    @GetMapping("/tipo-eventos")
    public ResponseEntity<List<TipoEvento>> getAllTipoEventos(TipoEventoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TipoEventos by criteria: {}", criteria);
        Page<TipoEvento> page = tipoEventoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipo-eventos");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tipo-eventos/count : count all the tipoEventos.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tipo-eventos/count")
    public ResponseEntity<Long> countTipoEventos(TipoEventoCriteria criteria) {
        log.debug("REST request to count TipoEventos by criteria: {}", criteria);
        return ResponseEntity.ok().body(tipoEventoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tipo-eventos/:id : get the "id" tipoEvento.
     *
     * @param id the id of the tipoEvento to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tipoEvento, or with status 404 (Not Found)
     */
    @GetMapping("/tipo-eventos/{id}")
    public ResponseEntity<TipoEvento> getTipoEvento(@PathVariable Long id) {
        log.debug("REST request to get TipoEvento : {}", id);
        Optional<TipoEvento> tipoEvento = tipoEventoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tipoEvento);
    }

    /**
     * DELETE  /tipo-eventos/:id : delete the "id" tipoEvento.
     *
     * @param id the id of the tipoEvento to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tipo-eventos/{id}")
    public ResponseEntity<Void> deleteTipoEvento(@PathVariable Long id) {
        log.debug("REST request to delete TipoEvento : {}", id);
        tipoEventoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.TabelaEvento;
import com.fourquality.mandata.service.TabelaEventoService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TabelaEventoCriteria;
import com.fourquality.mandata.service.TabelaEventoQueryService;
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
 * REST controller for managing TabelaEvento.
 */
@RestController
@RequestMapping("/api")
public class TabelaEventoResource {

    private final Logger log = LoggerFactory.getLogger(TabelaEventoResource.class);

    private static final String ENTITY_NAME = "tabelaEvento";

    private final TabelaEventoService tabelaEventoService;

    private final TabelaEventoQueryService tabelaEventoQueryService;

    public TabelaEventoResource(TabelaEventoService tabelaEventoService, TabelaEventoQueryService tabelaEventoQueryService) {
        this.tabelaEventoService = tabelaEventoService;
        this.tabelaEventoQueryService = tabelaEventoQueryService;
    }

    /**
     * POST  /tabela-eventos : Create a new tabelaEvento.
     *
     * @param tabelaEvento the tabelaEvento to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tabelaEvento, or with status 400 (Bad Request) if the tabelaEvento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tabela-eventos")
    public ResponseEntity<TabelaEvento> createTabelaEvento(@RequestBody TabelaEvento tabelaEvento) throws URISyntaxException {
        log.debug("REST request to save TabelaEvento : {}", tabelaEvento);
        if (tabelaEvento.getId() != null) {
            throw new BadRequestAlertException("A new tabelaEvento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TabelaEvento result = tabelaEventoService.save(tabelaEvento);
        return ResponseEntity.created(new URI("/api/tabela-eventos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tabela-eventos : Updates an existing tabelaEvento.
     *
     * @param tabelaEvento the tabelaEvento to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tabelaEvento,
     * or with status 400 (Bad Request) if the tabelaEvento is not valid,
     * or with status 500 (Internal Server Error) if the tabelaEvento couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tabela-eventos")
    public ResponseEntity<TabelaEvento> updateTabelaEvento(@RequestBody TabelaEvento tabelaEvento) throws URISyntaxException {
        log.debug("REST request to update TabelaEvento : {}", tabelaEvento);
        if (tabelaEvento.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TabelaEvento result = tabelaEventoService.save(tabelaEvento);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tabelaEvento.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tabela-eventos : get all the tabelaEventos.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tabelaEventos in body
     */
    @GetMapping("/tabela-eventos")
    public ResponseEntity<List<TabelaEvento>> getAllTabelaEventos(TabelaEventoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TabelaEventos by criteria: {}", criteria);
        Page<TabelaEvento> page = tabelaEventoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tabela-eventos");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tabela-eventos/count : count all the tabelaEventos.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tabela-eventos/count")
    public ResponseEntity<Long> countTabelaEventos(TabelaEventoCriteria criteria) {
        log.debug("REST request to count TabelaEventos by criteria: {}", criteria);
        return ResponseEntity.ok().body(tabelaEventoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tabela-eventos/:id : get the "id" tabelaEvento.
     *
     * @param id the id of the tabelaEvento to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tabelaEvento, or with status 404 (Not Found)
     */
    @GetMapping("/tabela-eventos/{id}")
    public ResponseEntity<TabelaEvento> getTabelaEvento(@PathVariable Long id) {
        log.debug("REST request to get TabelaEvento : {}", id);
        Optional<TabelaEvento> tabelaEvento = tabelaEventoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tabelaEvento);
    }

    /**
     * DELETE  /tabela-eventos/:id : delete the "id" tabelaEvento.
     *
     * @param id the id of the tabelaEvento to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tabela-eventos/{id}")
    public ResponseEntity<Void> deleteTabelaEvento(@PathVariable Long id) {
        log.debug("REST request to delete TabelaEvento : {}", id);
        tabelaEventoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

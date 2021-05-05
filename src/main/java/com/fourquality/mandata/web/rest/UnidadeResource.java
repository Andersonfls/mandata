package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Unidade;
import com.fourquality.mandata.service.UnidadeService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.UnidadeCriteria;
import com.fourquality.mandata.service.UnidadeQueryService;
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
 * REST controller for managing Unidade.
 */
@RestController
@RequestMapping("/api")
public class UnidadeResource {

    private final Logger log = LoggerFactory.getLogger(UnidadeResource.class);

    private static final String ENTITY_NAME = "unidade";

    private final UnidadeService unidadeService;

    private final UnidadeQueryService unidadeQueryService;

    public UnidadeResource(UnidadeService unidadeService, UnidadeQueryService unidadeQueryService) {
        this.unidadeService = unidadeService;
        this.unidadeQueryService = unidadeQueryService;
    }

    /**
     * POST  /unidades : Create a new unidade.
     *
     * @param unidade the unidade to create
     * @return the ResponseEntity with status 201 (Created) and with body the new unidade, or with status 400 (Bad Request) if the unidade has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/unidades")
    public ResponseEntity<Unidade> createUnidade(@Valid @RequestBody Unidade unidade) throws URISyntaxException {
        log.debug("REST request to save Unidade : {}", unidade);
        if (unidade.getId() != null) {
            throw new BadRequestAlertException("A new unidade cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Unidade result = unidadeService.save(unidade);
        return ResponseEntity.created(new URI("/api/unidades/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /unidades : Updates an existing unidade.
     *
     * @param unidade the unidade to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated unidade,
     * or with status 400 (Bad Request) if the unidade is not valid,
     * or with status 500 (Internal Server Error) if the unidade couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/unidades")
    public ResponseEntity<Unidade> updateUnidade(@Valid @RequestBody Unidade unidade) throws URISyntaxException {
        log.debug("REST request to update Unidade : {}", unidade);
        if (unidade.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Unidade result = unidadeService.save(unidade);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, unidade.getId().toString()))
            .body(result);
    }

    /**
     * GET  /unidades : get all the unidades.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of unidades in body
     */
    @GetMapping("/unidades")
    public ResponseEntity<List<Unidade>> getAllUnidades(UnidadeCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Unidades by criteria: {}", criteria);
        Page<Unidade> page = unidadeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/unidades");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /unidades/count : count all the unidades.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/unidades/count")
    public ResponseEntity<Long> countUnidades(UnidadeCriteria criteria) {
        log.debug("REST request to count Unidades by criteria: {}", criteria);
        return ResponseEntity.ok().body(unidadeQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /unidades/:id : get the "id" unidade.
     *
     * @param id the id of the unidade to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the unidade, or with status 404 (Not Found)
     */
    @GetMapping("/unidades/{id}")
    public ResponseEntity<Unidade> getUnidade(@PathVariable Long id) {
        log.debug("REST request to get Unidade : {}", id);
        Optional<Unidade> unidade = unidadeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(unidade);
    }

    /**
     * DELETE  /unidades/:id : delete the "id" unidade.
     *
     * @param id the id of the unidade to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/unidades/{id}")
    public ResponseEntity<Void> deleteUnidade(@PathVariable Long id) {
        log.debug("REST request to delete Unidade : {}", id);
        unidadeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

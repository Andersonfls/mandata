package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Representado;
import com.fourquality.mandata.service.RepresentadoService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.RepresentadoCriteria;
import com.fourquality.mandata.service.RepresentadoQueryService;
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
 * REST controller for managing Representado.
 */
@RestController
@RequestMapping("/api")
public class RepresentadoResource {

    private final Logger log = LoggerFactory.getLogger(RepresentadoResource.class);

    private static final String ENTITY_NAME = "representado";

    private final RepresentadoService representadoService;

    private final RepresentadoQueryService representadoQueryService;

    public RepresentadoResource(RepresentadoService representadoService, RepresentadoQueryService representadoQueryService) {
        this.representadoService = representadoService;
        this.representadoQueryService = representadoQueryService;
    }

    /**
     * POST  /representados : Create a new representado.
     *
     * @param representado the representado to create
     * @return the ResponseEntity with status 201 (Created) and with body the new representado, or with status 400 (Bad Request) if the representado has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/representados")
    public ResponseEntity<Representado> createRepresentado(@Valid @RequestBody Representado representado) throws URISyntaxException {
        log.debug("REST request to save Representado : {}", representado);
        if (representado.getId() != null) {
            throw new BadRequestAlertException("A new representado cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Representado result = representadoService.save(representado);
        return ResponseEntity.created(new URI("/api/representados/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /representados : Updates an existing representado.
     *
     * @param representado the representado to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated representado,
     * or with status 400 (Bad Request) if the representado is not valid,
     * or with status 500 (Internal Server Error) if the representado couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/representados")
    public ResponseEntity<Representado> updateRepresentado(@Valid @RequestBody Representado representado) throws URISyntaxException {
        log.debug("REST request to update Representado : {}", representado);
        if (representado.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Representado result = representadoService.save(representado);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, representado.getId().toString()))
            .body(result);
    }

    /**
     * GET  /representados : get all the representados.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of representados in body
     */
    @GetMapping("/representados")
    public ResponseEntity<List<Representado>> getAllRepresentados(RepresentadoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Representados by criteria: {}", criteria);
        Page<Representado> page = representadoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/representados");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /representados/count : count all the representados.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/representados/count")
    public ResponseEntity<Long> countRepresentados(RepresentadoCriteria criteria) {
        log.debug("REST request to count Representados by criteria: {}", criteria);
        return ResponseEntity.ok().body(representadoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /representados/:id : get the "id" representado.
     *
     * @param id the id of the representado to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the representado, or with status 404 (Not Found)
     */
    @GetMapping("/representados/{id}")
    public ResponseEntity<Representado> getRepresentado(@PathVariable Long id) {
        log.debug("REST request to get Representado : {}", id);
        Optional<Representado> representado = representadoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(representado);
    }

    /**
     * DELETE  /representados/:id : delete the "id" representado.
     *
     * @param id the id of the representado to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/representados/{id}")
    public ResponseEntity<Void> deleteRepresentado(@PathVariable Long id) {
        log.debug("REST request to delete Representado : {}", id);
        representadoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

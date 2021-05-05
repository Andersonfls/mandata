package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Advogado;
import com.fourquality.mandata.service.AdvogadoService;
import com.fourquality.mandata.service.dto.AdvogadoCriteria;
import com.fourquality.mandata.service.AdvogadoQueryService;
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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Advogado.
 */
@RestController
@RequestMapping("/api")
public class AdvogadoResource {

    private final Logger log = LoggerFactory.getLogger(AdvogadoResource.class);

    private static final String ENTITY_NAME = "advogado";

    private final AdvogadoService advogadoService;

    private final AdvogadoQueryService advogadoQueryService;

    public AdvogadoResource(AdvogadoService advogadoService, AdvogadoQueryService advogadoQueryService) {
        this.advogadoService = advogadoService;
        this.advogadoQueryService = advogadoQueryService;
    }

    /**
     * POST  /advogados : Create a new advogado.
     *
     * @param advogado the advogado to create
     * @return the ResponseEntity with status 201 (Created) and with body the new advogado, or with status 400 (Bad Request) if the advogado has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/advogados")
    public ResponseEntity<Advogado> createAdvogado(@Valid @RequestBody Advogado advogado) throws URISyntaxException {
        log.debug("REST request to save Advogado : {}", advogado);
        if (advogado.getId() != null) {
            throw new BadRequestAlertException("A new advogado cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Advogado result = advogadoService.save(advogado);
        return ResponseEntity.created(new URI("/api/advogados/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /advogados : Updates an existing advogado.
     *
     * @param advogado the advogado to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated advogado,
     * or with status 400 (Bad Request) if the advogado is not valid,
     * or with status 500 (Internal Server Error) if the advogado couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/advogados")
    public ResponseEntity<Advogado> updateAdvogado(@Valid @RequestBody Advogado advogado) throws URISyntaxException {
        log.debug("REST request to update Advogado : {}", advogado);
        if (advogado.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Advogado result = advogadoService.save(advogado);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, advogado.getId().toString()))
            .body(result);
    }

    /**
     * GET  /advogados : get all the advogados.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of advogados in body
     */
    @GetMapping("/advogados")
    public ResponseEntity<List<Advogado>> getAllAdvogados(AdvogadoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Advogados by criteria: {}", criteria);
        Page<Advogado> page = advogadoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/advogados");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /advogados/count : count all the advogados.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/advogados/count")
    public ResponseEntity<Long> countAdvogados(AdvogadoCriteria criteria) {
        log.debug("REST request to count Advogados by criteria: {}", criteria);
        return ResponseEntity.ok().body(advogadoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /advogados/:id : get the "id" advogado.
     *
     * @param id the id of the advogado to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the advogado, or with status 404 (Not Found)
     */
    @GetMapping("/advogados/{id}")
    public ResponseEntity<Advogado> getAdvogado(@PathVariable Long id) {
        log.debug("REST request to get Advogado : {}", id);
        Optional<Advogado> advogado = advogadoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(advogado);
    }

    /**
     * DELETE  /advogados/:id : delete the "id" advogado.
     *
     * @param id the id of the advogado to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/advogados/{id}")
    public ResponseEntity<Void> deleteAdvogado(@PathVariable Long id) {
        log.debug("REST request to delete Advogado : {}", id);
        advogadoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

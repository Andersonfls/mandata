package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Escritorio;
import com.fourquality.mandata.service.EscritorioService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.EscritorioCriteria;
import com.fourquality.mandata.service.EscritorioQueryService;
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
 * REST controller for managing Escritorio.
 */
@RestController
@RequestMapping("/api")
public class EscritorioResource {

    private final Logger log = LoggerFactory.getLogger(EscritorioResource.class);

    private static final String ENTITY_NAME = "escritorio";

    private final EscritorioService escritorioService;

    private final EscritorioQueryService escritorioQueryService;

    public EscritorioResource(EscritorioService escritorioService, EscritorioQueryService escritorioQueryService) {
        this.escritorioService = escritorioService;
        this.escritorioQueryService = escritorioQueryService;
    }

    /**
     * POST  /escritorios : Create a new escritorio.
     *
     * @param escritorio the escritorio to create
     * @return the ResponseEntity with status 201 (Created) and with body the new escritorio, or with status 400 (Bad Request) if the escritorio has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/escritorios")
    public ResponseEntity<Escritorio> createEscritorio(@Valid @RequestBody Escritorio escritorio) throws URISyntaxException {
        log.debug("REST request to save Escritorio : {}", escritorio);
        if (escritorio.getId() != null) {
            throw new BadRequestAlertException("A new escritorio cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Escritorio result = escritorioService.save(escritorio);
        return ResponseEntity.created(new URI("/api/escritorios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /escritorios : Updates an existing escritorio.
     *
     * @param escritorio the escritorio to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated escritorio,
     * or with status 400 (Bad Request) if the escritorio is not valid,
     * or with status 500 (Internal Server Error) if the escritorio couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/escritorios")
    public ResponseEntity<Escritorio> updateEscritorio(@Valid @RequestBody Escritorio escritorio) throws URISyntaxException {
        log.debug("REST request to update Escritorio : {}", escritorio);
        if (escritorio.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Escritorio result = escritorioService.save(escritorio);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, escritorio.getId().toString()))
            .body(result);
    }

    /**
     * GET  /escritorios : get all the escritorios.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of escritorios in body
     */
    @GetMapping("/escritorios")
    public ResponseEntity<List<Escritorio>> getAllEscritorios(EscritorioCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Escritorios by criteria: {}", criteria);
        Page<Escritorio> page = escritorioQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/escritorios");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /escritorios/count : count all the escritorios.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/escritorios/count")
    public ResponseEntity<Long> countEscritorios(EscritorioCriteria criteria) {
        log.debug("REST request to count Escritorios by criteria: {}", criteria);
        return ResponseEntity.ok().body(escritorioQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /escritorios/:id : get the "id" escritorio.
     *
     * @param id the id of the escritorio to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the escritorio, or with status 404 (Not Found)
     */
    @GetMapping("/escritorios/{id}")
    public ResponseEntity<Escritorio> getEscritorio(@PathVariable Long id) {
        log.debug("REST request to get Escritorio : {}", id);
        Optional<Escritorio> escritorio = escritorioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(escritorio);
    }

    /**
     * DELETE  /escritorios/:id : delete the "id" escritorio.
     *
     * @param id the id of the escritorio to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/escritorios/{id}")
    public ResponseEntity<Void> deleteEscritorio(@PathVariable Long id) {
        log.debug("REST request to delete Escritorio : {}", id);
        escritorioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

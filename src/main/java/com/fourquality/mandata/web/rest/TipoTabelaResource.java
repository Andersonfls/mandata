package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.TipoTabela;
import com.fourquality.mandata.service.TipoTabelaService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TipoTabelaCriteria;
import com.fourquality.mandata.service.TipoTabelaQueryService;
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
 * REST controller for managing TipoTabela.
 */
@RestController
@RequestMapping("/api")
public class TipoTabelaResource {

    private final Logger log = LoggerFactory.getLogger(TipoTabelaResource.class);

    private static final String ENTITY_NAME = "tipoTabela";

    private final TipoTabelaService tipoTabelaService;

    private final TipoTabelaQueryService tipoTabelaQueryService;

    public TipoTabelaResource(TipoTabelaService tipoTabelaService, TipoTabelaQueryService tipoTabelaQueryService) {
        this.tipoTabelaService = tipoTabelaService;
        this.tipoTabelaQueryService = tipoTabelaQueryService;
    }

    /**
     * POST  /tipo-tabelas : Create a new tipoTabela.
     *
     * @param tipoTabela the tipoTabela to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tipoTabela, or with status 400 (Bad Request) if the tipoTabela has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tipo-tabelas")
    public ResponseEntity<TipoTabela> createTipoTabela(@Valid @RequestBody TipoTabela tipoTabela) throws URISyntaxException {
        log.debug("REST request to save TipoTabela : {}", tipoTabela);
        if (tipoTabela.getId() != null) {
            throw new BadRequestAlertException("A new tipoTabela cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoTabela result = tipoTabelaService.save(tipoTabela);
        return ResponseEntity.created(new URI("/api/tipo-tabelas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tipo-tabelas : Updates an existing tipoTabela.
     *
     * @param tipoTabela the tipoTabela to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tipoTabela,
     * or with status 400 (Bad Request) if the tipoTabela is not valid,
     * or with status 500 (Internal Server Error) if the tipoTabela couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tipo-tabelas")
    public ResponseEntity<TipoTabela> updateTipoTabela(@Valid @RequestBody TipoTabela tipoTabela) throws URISyntaxException {
        log.debug("REST request to update TipoTabela : {}", tipoTabela);
        if (tipoTabela.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoTabela result = tipoTabelaService.save(tipoTabela);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoTabela.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tipo-tabelas : get all the tipoTabelas.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tipoTabelas in body
     */
    @GetMapping("/tipo-tabelas")
    public ResponseEntity<List<TipoTabela>> getAllTipoTabelas(TipoTabelaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TipoTabelas by criteria: {}", criteria);
        Page<TipoTabela> page = tipoTabelaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipo-tabelas");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tipo-tabelas/count : count all the tipoTabelas.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tipo-tabelas/count")
    public ResponseEntity<Long> countTipoTabelas(TipoTabelaCriteria criteria) {
        log.debug("REST request to count TipoTabelas by criteria: {}", criteria);
        return ResponseEntity.ok().body(tipoTabelaQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tipo-tabelas/:id : get the "id" tipoTabela.
     *
     * @param id the id of the tipoTabela to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tipoTabela, or with status 404 (Not Found)
     */
    @GetMapping("/tipo-tabelas/{id}")
    public ResponseEntity<TipoTabela> getTipoTabela(@PathVariable Long id) {
        log.debug("REST request to get TipoTabela : {}", id);
        Optional<TipoTabela> tipoTabela = tipoTabelaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tipoTabela);
    }

    /**
     * DELETE  /tipo-tabelas/:id : delete the "id" tipoTabela.
     *
     * @param id the id of the tipoTabela to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tipo-tabelas/{id}")
    public ResponseEntity<Void> deleteTipoTabela(@PathVariable Long id) {
        log.debug("REST request to delete TipoTabela : {}", id);
        tipoTabelaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

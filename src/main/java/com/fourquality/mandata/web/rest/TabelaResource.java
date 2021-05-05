package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Tabela;
import com.fourquality.mandata.service.TabelaService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TabelaCriteria;
import com.fourquality.mandata.service.TabelaQueryService;
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
 * REST controller for managing Tabela.
 */
@RestController
@RequestMapping("/api")
public class TabelaResource {

    private final Logger log = LoggerFactory.getLogger(TabelaResource.class);

    private static final String ENTITY_NAME = "tabela";

    private final TabelaService tabelaService;

    private final TabelaQueryService tabelaQueryService;

    public TabelaResource(TabelaService tabelaService, TabelaQueryService tabelaQueryService) {
        this.tabelaService = tabelaService;
        this.tabelaQueryService = tabelaQueryService;
    }

    /**
     * POST  /tabelas : Create a new tabela.
     *
     * @param tabela the tabela to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tabela, or with status 400 (Bad Request) if the tabela has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tabelas")
    public ResponseEntity<Tabela> createTabela(@Valid @RequestBody Tabela tabela) throws URISyntaxException {
        log.debug("REST request to save Tabela : {}", tabela);
        if (tabela.getId() != null) {
            throw new BadRequestAlertException("A new tabela cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Tabela result = tabelaService.save(tabela);
        return ResponseEntity.created(new URI("/api/tabelas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tabelas : Updates an existing tabela.
     *
     * @param tabela the tabela to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tabela,
     * or with status 400 (Bad Request) if the tabela is not valid,
     * or with status 500 (Internal Server Error) if the tabela couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tabelas")
    public ResponseEntity<Tabela> updateTabela(@Valid @RequestBody Tabela tabela) throws URISyntaxException {
        log.debug("REST request to update Tabela : {}", tabela);
        if (tabela.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Tabela result = tabelaService.save(tabela);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tabela.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tabelas : get all the tabelas.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tabelas in body
     */
    @GetMapping("/tabelas")
    public ResponseEntity<List<Tabela>> getAllTabelas(TabelaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Tabelas by criteria: {}", criteria);
        Page<Tabela> page = tabelaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tabelas");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tabelas/count : count all the tabelas.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tabelas/count")
    public ResponseEntity<Long> countTabelas(TabelaCriteria criteria) {
        log.debug("REST request to count Tabelas by criteria: {}", criteria);
        return ResponseEntity.ok().body(tabelaQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tabelas/:id : get the "id" tabela.
     *
     * @param id the id of the tabela to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tabela, or with status 404 (Not Found)
     */
    @GetMapping("/tabelas/{id}")
    public ResponseEntity<Tabela> getTabela(@PathVariable Long id) {
        log.debug("REST request to get Tabela : {}", id);
        Optional<Tabela> tabela = tabelaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tabela);
    }

    /**
     * DELETE  /tabelas/:id : delete the "id" tabela.
     *
     * @param id the id of the tabela to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tabelas/{id}")
    public ResponseEntity<Void> deleteTabela(@PathVariable Long id) {
        log.debug("REST request to delete Tabela : {}", id);
        tabelaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

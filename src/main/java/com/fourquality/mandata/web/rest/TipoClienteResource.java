package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.TipoCliente;
import com.fourquality.mandata.service.TipoClienteService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TipoClienteCriteria;
import com.fourquality.mandata.service.TipoClienteQueryService;
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
 * REST controller for managing TipoCliente.
 */
@RestController
@RequestMapping("/api")
public class TipoClienteResource {

    private final Logger log = LoggerFactory.getLogger(TipoClienteResource.class);

    private static final String ENTITY_NAME = "tipoCliente";

    private final TipoClienteService tipoClienteService;

    private final TipoClienteQueryService tipoClienteQueryService;

    public TipoClienteResource(TipoClienteService tipoClienteService, TipoClienteQueryService tipoClienteQueryService) {
        this.tipoClienteService = tipoClienteService;
        this.tipoClienteQueryService = tipoClienteQueryService;
    }

    /**
     * POST  /tipo-clientes : Create a new tipoCliente.
     *
     * @param tipoCliente the tipoCliente to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tipoCliente, or with status 400 (Bad Request) if the tipoCliente has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tipo-clientes")
    public ResponseEntity<TipoCliente> createTipoCliente(@Valid @RequestBody TipoCliente tipoCliente) throws URISyntaxException {
        log.debug("REST request to save TipoCliente : {}", tipoCliente);
        if (tipoCliente.getId() != null) {
            throw new BadRequestAlertException("A new tipoCliente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoCliente result = tipoClienteService.save(tipoCliente);
        return ResponseEntity.created(new URI("/api/tipo-clientes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tipo-clientes : Updates an existing tipoCliente.
     *
     * @param tipoCliente the tipoCliente to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tipoCliente,
     * or with status 400 (Bad Request) if the tipoCliente is not valid,
     * or with status 500 (Internal Server Error) if the tipoCliente couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tipo-clientes")
    public ResponseEntity<TipoCliente> updateTipoCliente(@Valid @RequestBody TipoCliente tipoCliente) throws URISyntaxException {
        log.debug("REST request to update TipoCliente : {}", tipoCliente);
        if (tipoCliente.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoCliente result = tipoClienteService.save(tipoCliente);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoCliente.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tipo-clientes : get all the tipoClientes.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of tipoClientes in body
     */
    @GetMapping("/tipo-clientes")
    public ResponseEntity<List<TipoCliente>> getAllTipoClientes(TipoClienteCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TipoClientes by criteria: {}", criteria);
        Page<TipoCliente> page = tipoClienteQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipo-clientes");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /tipo-clientes/count : count all the tipoClientes.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/tipo-clientes/count")
    public ResponseEntity<Long> countTipoClientes(TipoClienteCriteria criteria) {
        log.debug("REST request to count TipoClientes by criteria: {}", criteria);
        return ResponseEntity.ok().body(tipoClienteQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /tipo-clientes/:id : get the "id" tipoCliente.
     *
     * @param id the id of the tipoCliente to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tipoCliente, or with status 404 (Not Found)
     */
    @GetMapping("/tipo-clientes/{id}")
    public ResponseEntity<TipoCliente> getTipoCliente(@PathVariable Long id) {
        log.debug("REST request to get TipoCliente : {}", id);
        Optional<TipoCliente> tipoCliente = tipoClienteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tipoCliente);
    }

    /**
     * DELETE  /tipo-clientes/:id : delete the "id" tipoCliente.
     *
     * @param id the id of the tipoCliente to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tipo-clientes/{id}")
    public ResponseEntity<Void> deleteTipoCliente(@PathVariable Long id) {
        log.debug("REST request to delete TipoCliente : {}", id);
        tipoClienteService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.service.RiscoService;
import com.fourquality.mandata.service.dto.RiscoDTO;
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

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Risco.
 */
@RestController
@RequestMapping("/api")
public class RiscoResource {

    private final Logger log = LoggerFactory.getLogger(RiscoResource.class);

    private static final String ENTITY_NAME = "risco";

    private final RiscoService riscoService;

    public RiscoResource(RiscoService riscoService) {
        this.riscoService = riscoService;
    }

    /**
     * POST  /riscos : Create a new risco.
     *
     * @param riscoDTO the riscoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new riscoDTO, or with status 400 (Bad Request) if the risco has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/riscos")
    public ResponseEntity<RiscoDTO> createRisco(@RequestBody RiscoDTO riscoDTO) throws URISyntaxException {
        log.debug("REST request to save Risco : {}", riscoDTO);
        if (riscoDTO.getId() != null) {
            throw new BadRequestAlertException("A new risco cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RiscoDTO result = riscoService.save(riscoDTO);
        return ResponseEntity.created(new URI("/api/riscos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /riscos : Updates an existing risco.
     *
     * @param riscoDTO the riscoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated riscoDTO,
     * or with status 400 (Bad Request) if the riscoDTO is not valid,
     * or with status 500 (Internal Server Error) if the riscoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/riscos")
    public ResponseEntity<RiscoDTO> updateRisco(@RequestBody RiscoDTO riscoDTO) throws URISyntaxException {
        log.debug("REST request to update Risco : {}", riscoDTO);
        if (riscoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RiscoDTO result = riscoService.save(riscoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, riscoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /riscos : get all the riscos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of riscos in body
     */
    @GetMapping("/riscos")
    public ResponseEntity<List<RiscoDTO>> getAllRiscos(Pageable pageable) {
        log.debug("REST request to get a page of Riscos");
        Page<RiscoDTO> page = riscoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/riscos");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /riscos/:id : get the "id" risco.
     *
     * @param id the id of the riscoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the riscoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/riscos/{id}")
    public ResponseEntity<RiscoDTO> getRisco(@PathVariable Long id) {
        log.debug("REST request to get Risco : {}", id);
        Optional<RiscoDTO> riscoDTO = riscoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(riscoDTO);
    }

    /**
     * DELETE  /riscos/:id : delete the "id" risco.
     *
     * @param id the id of the riscoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/riscos/{id}")
    public ResponseEntity<Void> deleteRisco(@PathVariable Long id) {
        log.debug("REST request to delete Risco : {}", id);
        riscoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

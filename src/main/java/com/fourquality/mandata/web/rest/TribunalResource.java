package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.service.TribunalService;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import com.fourquality.mandata.service.dto.TribunalDTO;
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
 * REST controller for managing Tribunal.
 */
@RestController
@RequestMapping("/api")
public class TribunalResource {

    private final Logger log = LoggerFactory.getLogger(TribunalResource.class);

    private static final String ENTITY_NAME = "tribunal";

    private final TribunalService tribunalService;

    public TribunalResource(TribunalService tribunalService) {
        this.tribunalService = tribunalService;
    }

    /**
     * POST  /tribunals : Create a new tribunal.
     *
     * @param tribunalDTO the tribunalDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tribunalDTO, or with status 400 (Bad Request) if the tribunal has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tribunals")
    public ResponseEntity<TribunalDTO> createTribunal(@RequestBody TribunalDTO tribunalDTO) throws URISyntaxException {
        log.debug("REST request to save Tribunal : {}", tribunalDTO);
        if (tribunalDTO.getId() != null) {
            throw new BadRequestAlertException("A new tribunal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TribunalDTO result = tribunalService.save(tribunalDTO);
        return ResponseEntity.created(new URI("/api/tribunals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tribunals : Updates an existing tribunal.
     *
     * @param tribunalDTO the tribunalDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tribunalDTO,
     * or with status 400 (Bad Request) if the tribunalDTO is not valid,
     * or with status 500 (Internal Server Error) if the tribunalDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tribunals")
    public ResponseEntity<TribunalDTO> updateTribunal(@RequestBody TribunalDTO tribunalDTO) throws URISyntaxException {
        log.debug("REST request to update Tribunal : {}", tribunalDTO);
        if (tribunalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TribunalDTO result = tribunalService.save(tribunalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tribunalDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tribunals : get all the tribunals.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tribunals in body
     */
    @GetMapping("/tribunals")
    public ResponseEntity<List<TribunalDTO>> getAllTribunals(Pageable pageable) {
        log.debug("REST request to get a page of Tribunals");
        Page<TribunalDTO> page = tribunalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tribunals");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /tribunals/:id : get the "id" tribunal.
     *
     * @param id the id of the tribunalDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tribunalDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tribunals/{id}")
    public ResponseEntity<TribunalDTO> getTribunal(@PathVariable Long id) {
        log.debug("REST request to get Tribunal : {}", id);
        Optional<TribunalDTO> tribunalDTO = tribunalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tribunalDTO);
    }

    /**
     * DELETE  /tribunals/:id : delete the "id" tribunal.
     *
     * @param id the id of the tribunalDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tribunals/{id}")
    public ResponseEntity<Void> deleteTribunal(@PathVariable Long id) {
        log.debug("REST request to delete Tribunal : {}", id);
        tribunalService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

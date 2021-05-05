package com.fourquality.mandata.web.rest;
import com.fourquality.mandata.domain.Advogado;
import com.fourquality.mandata.domain.AdvogadoCliente;
import com.fourquality.mandata.repository.Advogado_clienteRepository;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * REST controller for managing AdvogadoCliente.
 */
@RestController
@RequestMapping("/api")
public class AdvogadoClienteResource {

    private final Logger log = LoggerFactory.getLogger(AdvogadoClienteResource.class);

    private static final String ENTITY_NAME = "advogado_cliente";

    private final Advogado_clienteRepository advogado_clienteRepository;

    public AdvogadoClienteResource(Advogado_clienteRepository advogado_clienteRepository) {
        this.advogado_clienteRepository = advogado_clienteRepository;
    }

    /**
     * POST  /advogado-clientes : Create a new advogadoCliente.
     *
     * @param advogadoCliente the advogado_cliente to create
     * @return the ResponseEntity with status 201 (Created) and with body the new advogado_cliente, or with status 400 (Bad Request) if the advogado_cliente has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/advogado-clientes")
    public ResponseEntity<AdvogadoCliente> createAdvogado_cliente(@RequestBody AdvogadoCliente advogadoCliente) throws URISyntaxException {
        log.debug("REST request to save AdvogadoCliente : {}", advogadoCliente);
        if (advogadoCliente.getId() != null) {
            throw new BadRequestAlertException("A new advogado_cliente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        advogadoCliente.data_criacao(LocalDate.now());
        AdvogadoCliente result = advogado_clienteRepository.save(advogadoCliente);
        return ResponseEntity.created(new URI("/api/advogado-clientes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /advogado-clientes : Updates an existing advogado_cliente.
     *
     * @param advogado_cliente the advogado_cliente to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated advogado_cliente,
     * or with status 400 (Bad Request) if the advogado_cliente is not valid,
     * or with status 500 (Internal Server Error) if the advogado_cliente couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/advogado-clientes")
    public ResponseEntity<AdvogadoCliente> updateAdvogado_cliente(@RequestBody AdvogadoCliente advogado_cliente) throws URISyntaxException {
        log.debug("REST request to update AdvogadoCliente : {}", advogado_cliente);
        if (advogado_cliente.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AdvogadoCliente result = advogado_clienteRepository.save(advogado_cliente);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, advogado_cliente.getId().toString()))
            .body(result);
    }

    /**
     * GET  /advogado-clientes : get all the advogado_clientes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of advogado_clientes in body
     */
    @GetMapping("/advogado-clientes")
    public List<AdvogadoCliente> getAllAdvogado_clientes() {
        log.debug("REST request to get all Advogado_clientes");
        return advogado_clienteRepository.findAll();
    }

    @GetMapping("/advogado-clientes/cliente/{id}")
    public List<Advogado> getAdvogadoClienteByClienteId(@PathVariable Long id) {
        log.debug("REST request to get AdvogadoCliente : {}", id);
        List<AdvogadoCliente> adv = advogado_clienteRepository.findAllByClienteId(id);
        List<Advogado> advogados = new ArrayList<>();
        if (Objects.nonNull(adv)) {
            adv.stream().forEach(i -> {
                advogados.add(i.getAdvogado());
            });
        }
        return advogados;
    }

    /**
     * GET  /advogado-clientes/:id : get the "id" advogado_cliente.
     *
     * @param id the id of the advogado_cliente to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the advogado_cliente, or with status 404 (Not Found)
     */
    @GetMapping("/advogado-clientes/{id}")
    public ResponseEntity<AdvogadoCliente> getAdvogado_cliente(@PathVariable Long id) {
        log.debug("REST request to get AdvogadoCliente : {}", id);
        Optional<AdvogadoCliente> advogado_cliente = advogado_clienteRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(advogado_cliente);
    }

    /**
     * DELETE  /advogado-clientes/:id : delete the "id" advogado_cliente.
     *
     * @param id the id of the advogado_cliente to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/advogado-clientes/{id}")
    public ResponseEntity<Void> deleteAdvogado_cliente(@PathVariable Long id) {
        log.debug("REST request to delete AdvogadoCliente : {}", id);
        advogado_clienteRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    @DeleteMapping("/advogado-clientes/clientes/{id}")
    public ResponseEntity<Void> deleteAllAdvogadoClienteByClienteId(@PathVariable Long id) {
        List<AdvogadoCliente> adv = advogado_clienteRepository.findAllByClienteId(id);
        List<Advogado> advogados = new ArrayList<>();
        if (Objects.nonNull(adv)) {
           advogado_clienteRepository.deleteAll(adv);
        }
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

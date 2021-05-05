package com.fourquality.mandata.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.fourquality.mandata.domain.Cliente;
import com.fourquality.mandata.repository.ClienteRepository;
import com.fourquality.mandata.service.dto.ClienteCriteria;

/**
 * Service for executing complex queries for Cliente entities in the database.
 * The main input is a {@link ClienteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Cliente} or a {@link Page} of {@link Cliente} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ClienteQueryService extends QueryService<Cliente> {

    private final Logger log = LoggerFactory.getLogger(ClienteQueryService.class);

    private final ClienteRepository clienteRepository;

    public ClienteQueryService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Return a {@link List} of {@link Cliente} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Cliente> findByCriteria(ClienteCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cliente> specification = createSpecification(criteria);
        return clienteRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Cliente} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Cliente> findByCriteria(ClienteCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cliente> specification = createSpecification(criteria);
        return clienteRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ClienteCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cliente> specification = createSpecification(criteria);
        return clienteRepository.count(specification);
    }

    /**
     * Function to convert ClienteCriteria to a {@link Specification}
     */
    private Specification<Cliente> createSpecification(ClienteCriteria criteria) {
        Specification<Cliente> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Cliente_.id));
//            }
//            if (criteria.getEscritorioId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getEscritorioId(), Cliente_.escritorioId));
//            }
//            if (criteria.getTipoClienteId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTipoClienteId(), Cliente_.tipoClienteId));
//            }
//            if (criteria.getCnpj() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCnpj(), Cliente_.cnpj));
//            }
//            if (criteria.getCpf() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCpf(), Cliente_.cpf));
//            }
//            if (criteria.getLogradouro() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getLogradouro(), Cliente_.logradouro));
//            }
//            if (criteria.getNumero() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getNumero(), Cliente_.numero));
//            }
//            if (criteria.getComplemento() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getComplemento(), Cliente_.complemento));
//            }
//            if (criteria.getBairro() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getBairro(), Cliente_.bairro));
//            }
//            if (criteria.getCidade() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCidade(), Cliente_.cidade));
//            }
//            if (criteria.getUf() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getUf(), Cliente_.uf));
//            }
//            if (criteria.getCep() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCep(), Cliente_.cep));
//            }
//            if (criteria.getEmail() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getEmail(), Cliente_.email));
//            }
//            if (criteria.getFoneFixo() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneFixo(), Cliente_.foneFixo));
//            }
//            if (criteria.getFoneCel() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneCel(), Cliente_.foneCel));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Cliente_.status));
//            }
        }
        return specification;
    }
}

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

import com.fourquality.mandata.domain.TipoCliente;
import com.fourquality.mandata.repository.TipoClienteRepository;
import com.fourquality.mandata.service.dto.TipoClienteCriteria;

/**
 * Service for executing complex queries for TipoCliente entities in the database.
 * The main input is a {@link TipoClienteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TipoCliente} or a {@link Page} of {@link TipoCliente} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TipoClienteQueryService extends QueryService<TipoCliente> {

    private final Logger log = LoggerFactory.getLogger(TipoClienteQueryService.class);

    private final TipoClienteRepository tipoClienteRepository;

    public TipoClienteQueryService(TipoClienteRepository tipoClienteRepository) {
        this.tipoClienteRepository = tipoClienteRepository;
    }

    /**
     * Return a {@link List} of {@link TipoCliente} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TipoCliente> findByCriteria(TipoClienteCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TipoCliente> specification = createSpecification(criteria);
        return tipoClienteRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link TipoCliente} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TipoCliente> findByCriteria(TipoClienteCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TipoCliente> specification = createSpecification(criteria);
        return tipoClienteRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TipoClienteCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TipoCliente> specification = createSpecification(criteria);
        return tipoClienteRepository.count(specification);
    }

    /**
     * Function to convert TipoClienteCriteria to a {@link Specification}
     */
    private Specification<TipoCliente> createSpecification(TipoClienteCriteria criteria) {
        Specification<TipoCliente> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), TipoCliente_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), TipoCliente_.descricao));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), TipoCliente_.status));
//            }
//            if (criteria.getTipoClienteId() != null) {
//                specification = specification.and(buildSpecification(criteria.getTipoClienteId(),
//                    root -> root.join(TipoCliente_.tipoClientes, JoinType.LEFT).get(Cliente_.id)));
//            }
        }
        return specification;
    }
}

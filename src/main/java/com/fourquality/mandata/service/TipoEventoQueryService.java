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

import com.fourquality.mandata.domain.TipoEvento;
import com.fourquality.mandata.repository.TipoEventoRepository;
import com.fourquality.mandata.service.dto.TipoEventoCriteria;

/**
 * Service for executing complex queries for TipoEvento entities in the database.
 * The main input is a {@link TipoEventoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TipoEvento} or a {@link Page} of {@link TipoEvento} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TipoEventoQueryService extends QueryService<TipoEvento> {

    private final Logger log = LoggerFactory.getLogger(TipoEventoQueryService.class);

    private final TipoEventoRepository tipoEventoRepository;

    public TipoEventoQueryService(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }

    /**
     * Return a {@link List} of {@link TipoEvento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TipoEvento> findByCriteria(TipoEventoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TipoEvento> specification = createSpecification(criteria);
        return tipoEventoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link TipoEvento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TipoEvento> findByCriteria(TipoEventoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TipoEvento> specification = createSpecification(criteria);
        return tipoEventoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TipoEventoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TipoEvento> specification = createSpecification(criteria);
        return tipoEventoRepository.count(specification);
    }

    /**
     * Function to convert TipoEventoCriteria to a {@link Specification}
     */
    private Specification<TipoEvento> createSpecification(TipoEventoCriteria criteria) {
        Specification<TipoEvento> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), TipoEvento_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), TipoEvento_.descricao));
//            }
        }
        return specification;
    }
}

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

import com.fourquality.mandata.domain.TipoAdvogado;
import com.fourquality.mandata.repository.TipoAdvogadoRepository;
import com.fourquality.mandata.service.dto.TipoAdvogadoCriteria;

/**
 * Service for executing complex queries for TipoAdvogado entities in the database.
 * The main input is a {@link TipoAdvogadoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TipoAdvogado} or a {@link Page} of {@link TipoAdvogado} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TipoAdvogadoQueryService extends QueryService<TipoAdvogado> {

    private final Logger log = LoggerFactory.getLogger(TipoAdvogadoQueryService.class);

    private final TipoAdvogadoRepository tipoAdvogadoRepository;

    public TipoAdvogadoQueryService(TipoAdvogadoRepository tipoAdvogadoRepository) {
        this.tipoAdvogadoRepository = tipoAdvogadoRepository;
    }

    /**
     * Return a {@link List} of {@link TipoAdvogado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TipoAdvogado> findByCriteria(TipoAdvogadoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TipoAdvogado> specification = createSpecification(criteria);
        return tipoAdvogadoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link TipoAdvogado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TipoAdvogado> findByCriteria(TipoAdvogadoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TipoAdvogado> specification = createSpecification(criteria);
        return tipoAdvogadoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TipoAdvogadoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TipoAdvogado> specification = createSpecification(criteria);
        return tipoAdvogadoRepository.count(specification);
    }

    /**
     * Function to convert TipoAdvogadoCriteria to a {@link Specification}
     */
    private Specification<TipoAdvogado> createSpecification(TipoAdvogadoCriteria criteria) {
        Specification<TipoAdvogado> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), TipoAdvogado_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), TipoAdvogado_.descricao));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), TipoAdvogado_.status));
//            }
        }
        return specification;
    }
}

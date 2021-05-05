package com.fourquality.mandata.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.fourquality.mandata.domain.Representado;
import com.fourquality.mandata.repository.RepresentadoRepository;
import com.fourquality.mandata.service.dto.RepresentadoCriteria;

/**
 * Service for executing complex queries for Representado entities in the database.
 * The main input is a {@link RepresentadoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Representado} or a {@link Page} of {@link Representado} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class RepresentadoQueryService extends QueryService<Representado> {

    private final Logger log = LoggerFactory.getLogger(RepresentadoQueryService.class);

    private final RepresentadoRepository representadoRepository;

    public RepresentadoQueryService(RepresentadoRepository representadoRepository) {
        this.representadoRepository = representadoRepository;
    }

    /**
     * Return a {@link List} of {@link Representado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Representado> findByCriteria(RepresentadoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Representado> specification = createSpecification(criteria);
        return representadoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Representado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Representado> findByCriteria(RepresentadoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Representado> specification = createSpecification(criteria);
        return representadoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(RepresentadoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Representado> specification = createSpecification(criteria);
        return representadoRepository.count(specification);
    }

    /**
     * Function to convert RepresentadoCriteria to a {@link Specification}
     */
    private Specification<Representado> createSpecification(RepresentadoCriteria criteria) {
        Specification<Representado> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Representado_.id));
//            }
//            if (criteria.getNome() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getNome(), Representado_.nome));
//            }
//            if (criteria.getContato() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getContato(), Representado_.contato));
//            }
//            if (criteria.getEmail() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getEmail(), Representado_.email));
//            }
//            if (criteria.getFoneFixo() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneFixo(), Representado_.foneFixo));
//            }
//            if (criteria.getFoneCel() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneCel(), Representado_.foneCel));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Representado_.status));
//            }
        }
        return specification;
    }
}

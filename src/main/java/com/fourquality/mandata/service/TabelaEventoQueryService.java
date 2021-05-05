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

import com.fourquality.mandata.domain.TabelaEvento;
import com.fourquality.mandata.repository.TabelaEventoRepository;
import com.fourquality.mandata.service.dto.TabelaEventoCriteria;

/**
 * Service for executing complex queries for TabelaEvento entities in the database.
 * The main input is a {@link TabelaEventoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TabelaEvento} or a {@link Page} of {@link TabelaEvento} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TabelaEventoQueryService extends QueryService<TabelaEvento> {

    private final Logger log = LoggerFactory.getLogger(TabelaEventoQueryService.class);

    private final TabelaEventoRepository tabelaEventoRepository;

    public TabelaEventoQueryService(TabelaEventoRepository tabelaEventoRepository) {
        this.tabelaEventoRepository = tabelaEventoRepository;
    }

    /**
     * Return a {@link List} of {@link TabelaEvento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TabelaEvento> findByCriteria(TabelaEventoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TabelaEvento> specification = createSpecification(criteria);
        return tabelaEventoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link TabelaEvento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TabelaEvento> findByCriteria(TabelaEventoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TabelaEvento> specification = createSpecification(criteria);
        return tabelaEventoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TabelaEventoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TabelaEvento> specification = createSpecification(criteria);
        return tabelaEventoRepository.count(specification);
    }

    /**
     * Function to convert TabelaEventoCriteria to a {@link Specification}
     */
    private Specification<TabelaEvento> createSpecification(TabelaEventoCriteria criteria) {
        Specification<TabelaEvento> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), TabelaEvento_.id));
//            }
//            if (criteria.getUnidade() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getUnidade(), TabelaEvento_.unidade));
//            }
//            if (criteria.getValor() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getValor(), TabelaEvento_.valor));
//            }
        }
        return specification;
    }
}

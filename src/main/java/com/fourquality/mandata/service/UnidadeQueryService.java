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

import com.fourquality.mandata.domain.Unidade;
import com.fourquality.mandata.repository.UnidadeRepository;
import com.fourquality.mandata.service.dto.UnidadeCriteria;

/**
 * Service for executing complex queries for Unidade entities in the database.
 * The main input is a {@link UnidadeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Unidade} or a {@link Page} of {@link Unidade} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UnidadeQueryService extends QueryService<Unidade> {

    private final Logger log = LoggerFactory.getLogger(UnidadeQueryService.class);

    private final UnidadeRepository unidadeRepository;

    public UnidadeQueryService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    /**
     * Return a {@link List} of {@link Unidade} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Unidade> findByCriteria(UnidadeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Unidade> specification = createSpecification(criteria);
        return unidadeRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Unidade} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Unidade> findByCriteria(UnidadeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Unidade> specification = createSpecification(criteria);
        return unidadeRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UnidadeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Unidade> specification = createSpecification(criteria);
        return unidadeRepository.count(specification);
    }

    /**
     * Function to convert UnidadeCriteria to a {@link Specification}
     */
    private Specification<Unidade> createSpecification(UnidadeCriteria criteria) {
        Specification<Unidade> specification = Specification.where(null);
        if (criteria != null) {
        }
        return specification;
    }
}

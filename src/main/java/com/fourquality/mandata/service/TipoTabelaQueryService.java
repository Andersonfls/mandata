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

import com.fourquality.mandata.domain.TipoTabela;
import com.fourquality.mandata.repository.TipoTabelaRepository;
import com.fourquality.mandata.service.dto.TipoTabelaCriteria;

/**
 * Service for executing complex queries for TipoTabela entities in the database.
 * The main input is a {@link TipoTabelaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TipoTabela} or a {@link Page} of {@link TipoTabela} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TipoTabelaQueryService extends QueryService<TipoTabela> {

    private final Logger log = LoggerFactory.getLogger(TipoTabelaQueryService.class);

    private final TipoTabelaRepository tipoTabelaRepository;

    public TipoTabelaQueryService(TipoTabelaRepository tipoTabelaRepository) {
        this.tipoTabelaRepository = tipoTabelaRepository;
    }

    /**
     * Return a {@link List} of {@link TipoTabela} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TipoTabela> findByCriteria(TipoTabelaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TipoTabela> specification = createSpecification(criteria);
        return tipoTabelaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link TipoTabela} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TipoTabela> findByCriteria(TipoTabelaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TipoTabela> specification = createSpecification(criteria);
        return tipoTabelaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TipoTabelaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TipoTabela> specification = createSpecification(criteria);
        return tipoTabelaRepository.count(specification);
    }

    /**
     * Function to convert TipoTabelaCriteria to a {@link Specification}
     */
    private Specification<TipoTabela> createSpecification(TipoTabelaCriteria criteria) {
        Specification<TipoTabela> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), TipoTabela_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), TipoTabela_.descricao));
//            }
        }
        return specification;
    }
}

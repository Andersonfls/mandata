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

import com.fourquality.mandata.domain.Tabela;
import com.fourquality.mandata.repository.TabelaRepository;
import com.fourquality.mandata.service.dto.TabelaCriteria;

/**
 * Service for executing complex queries for Tabela entities in the database.
 * The main input is a {@link TabelaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Tabela} or a {@link Page} of {@link Tabela} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TabelaQueryService extends QueryService<Tabela> {

    private final Logger log = LoggerFactory.getLogger(TabelaQueryService.class);

    private final TabelaRepository tabelaRepository;

    public TabelaQueryService(TabelaRepository tabelaRepository) {
        this.tabelaRepository = tabelaRepository;
    }

    /**
     * Return a {@link List} of {@link Tabela} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Tabela> findByCriteria(TabelaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Tabela> specification = createSpecification(criteria);
        return tabelaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Tabela} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Tabela> findByCriteria(TabelaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Tabela> specification = createSpecification(criteria);
        return tabelaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TabelaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Tabela> specification = createSpecification(criteria);
        return tabelaRepository.count(specification);
    }

    /**
     * Function to convert TabelaCriteria to a {@link Specification}
     */
    private Specification<Tabela> createSpecification(TabelaCriteria criteria) {
        Specification<Tabela> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Tabela_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), Tabela_.descricao));
//            }
//            if (criteria.getClienteId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getClienteId(), Tabela_.clienteId));
//            }
//            if (criteria.getTipoTabelaId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTipoTabelaId(), Tabela_.tipoTabelaId));
//            }
//            if (criteria.getDataCriacao() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getDataCriacao(), Tabela_.dataCriacao));
//            }
//            if (criteria.getAtual() != null) {
//                specification = specification.and(buildSpecification(criteria.getAtual(), Tabela_.atual));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Tabela_.status));
//            }
//            if (criteria.getTabelaId() != null) {
//                specification = specification.and(buildSpecification(criteria.getTabelaId(),
//                    root -> root.join(Tabela_.tabela, JoinType.LEFT).get(TipoTabela_.id)));
//            }
//            if (criteria.getTabelaId() != null) {
//                specification = specification.and(buildSpecification(criteria.getTabelaId(),
//                    root -> root.join(Tabela_.tabelas, JoinType.LEFT).get(TabelaEvento_.id)));
//            }
        }
        return specification;
    }
}

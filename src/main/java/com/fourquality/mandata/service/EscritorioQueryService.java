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

import com.fourquality.mandata.domain.Escritorio;
import com.fourquality.mandata.repository.EscritorioRepository;
import com.fourquality.mandata.service.dto.EscritorioCriteria;

/**
 * Service for executing complex queries for Escritorio entities in the database.
 * The main input is a {@link EscritorioCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Escritorio} or a {@link Page} of {@link Escritorio} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EscritorioQueryService extends QueryService<Escritorio> {

    private final Logger log = LoggerFactory.getLogger(EscritorioQueryService.class);

    private final EscritorioRepository escritorioRepository;

    public EscritorioQueryService(EscritorioRepository escritorioRepository) {
        this.escritorioRepository = escritorioRepository;
    }

    /**
     * Return a {@link List} of {@link Escritorio} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Escritorio> findByCriteria(EscritorioCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Escritorio> specification = createSpecification(criteria);
        return escritorioRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Escritorio} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Escritorio> findByCriteria(EscritorioCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Escritorio> specification = createSpecification(criteria);
        return escritorioRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EscritorioCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Escritorio> specification = createSpecification(criteria);
        return escritorioRepository.count(specification);
    }

    /**
     * Function to convert EscritorioCriteria to a {@link Specification}
     */
    private Specification<Escritorio> createSpecification(EscritorioCriteria criteria) {
        Specification<Escritorio> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Escritorio_.id));
//            }
//            if (criteria.getCnpj() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCnpj(), Escritorio_.cnpj));
//            }
//            if (criteria.getLogradouro() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getLogradouro(), Escritorio_.logradouro));
//            }
//            if (criteria.getNumero() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getNumero(), Escritorio_.numero));
//            }
//            if (criteria.getComplemento() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getComplemento(), Escritorio_.complemento));
//            }
//            if (criteria.getBairro() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getBairro(), Escritorio_.bairro));
//            }
//            if (criteria.getCidade() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCidade(), Escritorio_.cidade));
//            }
//            if (criteria.getUf() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getUf(), Escritorio_.uf));
//            }
//            if (criteria.getCep() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getCep(), Escritorio_.cep));
//            }
//            if (criteria.getEmail() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getEmail(), Escritorio_.email));
//            }
//            if (criteria.getFoneFixo() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneFixo(), Escritorio_.foneFixo));
//            }
//            if (criteria.getFoneCel() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getFoneCel(), Escritorio_.foneCel));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Escritorio_.status));
//            }
//            if (criteria.getEscritorioId() != null) {
//                specification = specification.and(buildSpecification(criteria.getEscritorioId(),
//                    root -> root.join(Escritorio_.escritorios, JoinType.LEFT).get(Advogado_.id)));
//            }
//            if (criteria.getEscritorioId() != null) {
//                specification = specification.and(buildSpecification(criteria.getEscritorioId(),
//                    root -> root.join(Escritorio_.escritorios, JoinType.LEFT).get(Cliente_.id)));
//            }
        }
        return specification;
    }
}

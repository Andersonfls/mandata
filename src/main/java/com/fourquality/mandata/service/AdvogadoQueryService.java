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

import com.fourquality.mandata.domain.Advogado;
import com.fourquality.mandata.repository.AdvogadoRepository;
import com.fourquality.mandata.service.dto.AdvogadoCriteria;

/**
 * Service for executing complex queries for Advogado entities in the database.
 * The main input is a {@link AdvogadoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Advogado} or a {@link Page} of {@link Advogado} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AdvogadoQueryService extends QueryService<Advogado> {

    private final Logger log = LoggerFactory.getLogger(AdvogadoQueryService.class);

    private final AdvogadoRepository advogadoRepository;

    public AdvogadoQueryService(AdvogadoRepository advogadoRepository) {
        this.advogadoRepository = advogadoRepository;
    }

    /**
     * Return a {@link List} of {@link Advogado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Advogado> findByCriteria(AdvogadoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Advogado> specification = createSpecification(criteria);
        return advogadoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Advogado} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Advogado> findByCriteria(AdvogadoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Advogado> specification = createSpecification(criteria);
        return advogadoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AdvogadoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Advogado> specification = createSpecification(criteria);
        return advogadoRepository.count(specification);
    }

    /**
     * Function to convert AdvogadoCriteria to a {@link Specification}
     */
    private Specification<Advogado> createSpecification(AdvogadoCriteria criteria) {
        Specification<Advogado> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Advogado_.id));
//            }
//            if (criteria.getEscritorioId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getEscritorioId(), Advogado_.escritorioId));
//            }
//            if (criteria.getTipoAdvogadoId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTipoAdvogadoId(), Advogado_.tipoAdvogadoId));
//            }
//            if (criteria.getClienteId() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getClienteId(), Advogado_.clienteId));
//            }
//            if (criteria.getNome() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getNome(), Advogado_.nome));
//            }
//            if (criteria.getOab() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getOab(), Advogado_.oab));
//            }
//            if (criteria.getOabUf() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getOabUf(), Advogado_.oabUf));
//            }
//            if (criteria.getEmail() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getEmail(), Advogado_.email));
//            }
//            if (criteria.getTelefone() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getTelefone(), Advogado_.telefone));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Advogado_.status));
//            }
        }
        return specification;
    }
}

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

import com.fourquality.mandata.domain.Evento;
import com.fourquality.mandata.repository.EventoRepository;
import com.fourquality.mandata.service.dto.EventoCriteria;

/**
 * Service for executing complex queries for Evento entities in the database.
 * The main input is a {@link EventoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Evento} or a {@link Page} of {@link Evento} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EventoQueryService extends QueryService<Evento> {

    private final Logger log = LoggerFactory.getLogger(EventoQueryService.class);

    private final EventoRepository eventoRepository;

    public EventoQueryService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    /**
     * Return a {@link List} of {@link Evento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Evento> findByCriteria(EventoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Evento> specification = createSpecification(criteria);
        return eventoRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Evento} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Evento> findByCriteria(EventoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Evento> specification = createSpecification(criteria);
        return eventoRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EventoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Evento> specification = createSpecification(criteria);
        return eventoRepository.count(specification);
    }

    /**
     * Function to convert EventoCriteria to a {@link Specification}
     */
    private Specification<Evento> createSpecification(EventoCriteria criteria) {
        Specification<Evento> specification = Specification.where(null);
        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.and(buildSpecification(criteria.getId(), Evento_.id));
//            }
//            if (criteria.getDescricao() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getDescricao(), Evento_.descricao));
//            }
//            if (criteria.getStatus() != null) {
//                specification = specification.and(buildSpecification(criteria.getStatus(), Evento_.status));
//            }
//            if (criteria.getEventoId() != null) {
//                specification = specification.and(buildSpecification(criteria.getEventoId(),
//                    root -> root.join(Evento_.evento, JoinType.LEFT).get(TipoEvento_.id)));
//            }
//            if (criteria.getEventoId() != null) {
//                specification = specification.and(buildSpecification(criteria.getEventoId(),
//                    root -> root.join(Evento_.eventos, JoinType.LEFT).get(TabelaEvento_.id)));
//            }
        }
        return specification;
    }
}

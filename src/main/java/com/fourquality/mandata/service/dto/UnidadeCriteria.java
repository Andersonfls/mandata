package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Unidade entity. This class is used in UnidadeResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /unidades?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UnidadeCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter descricao;

    private BooleanFilter status;

    private LongFilter unidadeId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getDescricao() {
        return descricao;
    }

    public void setDescricao(StringFilter descricao) {
        this.descricao = descricao;
    }

    public BooleanFilter getStatus() {
        return status;
    }

    public void setStatus(BooleanFilter status) {
        this.status = status;
    }

    public LongFilter getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(LongFilter unidadeId) {
        this.unidadeId = unidadeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UnidadeCriteria that = (UnidadeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(descricao, that.descricao) &&
            Objects.equals(status, that.status) &&
            Objects.equals(unidadeId, that.unidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        descricao,
        status,
        unidadeId
        );
    }

    @Override
    public String toString() {
        return "UnidadeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (descricao != null ? "descricao=" + descricao + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (unidadeId != null ? "unidadeId=" + unidadeId + ", " : "") +
            "}";
    }

}

package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the TipoEvento entity. This class is used in TipoEventoResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /tipo-eventos?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TipoEventoCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter descricao;

    private LongFilter tabelaEventoId;

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

    public LongFilter getTabelaEventoId() {
        return tabelaEventoId;
    }

    public void setTabelaEventoId(LongFilter tabelaEventoId) {
        this.tabelaEventoId = tabelaEventoId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TipoEventoCriteria that = (TipoEventoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(descricao, that.descricao) &&
            Objects.equals(tabelaEventoId, that.tabelaEventoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        descricao,
        tabelaEventoId
        );
    }

    @Override
    public String toString() {
        return "TipoEventoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (descricao != null ? "descricao=" + descricao + ", " : "") +
                (tabelaEventoId != null ? "tabelaEventoId=" + tabelaEventoId + ", " : "") +
            "}";
    }

}

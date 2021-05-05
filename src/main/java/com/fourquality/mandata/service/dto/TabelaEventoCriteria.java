package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;

/**
 * Criteria class for the TabelaEvento entity. This class is used in TabelaEventoResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /tabela-eventos?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TabelaEventoCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter unidade;

    private FloatFilter valor;

    private LongFilter tabelaEventoId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getUnidade() {
        return unidade;
    }

    public void setUnidade(IntegerFilter unidade) {
        this.unidade = unidade;
    }

    public FloatFilter getValor() {
        return valor;
    }

    public void setValor(FloatFilter valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TabelaEventoCriteria that = (TabelaEventoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(unidade, that.unidade) &&
            Objects.equals(valor, that.valor) &&
            Objects.equals(tabelaEventoId, that.tabelaEventoId) &&
            Objects.equals(tabelaEventoId, that.tabelaEventoId) &&
            Objects.equals(tabelaEventoId, that.tabelaEventoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        unidade,
        valor,
        tabelaEventoId,
        tabelaEventoId,
        tabelaEventoId
        );
    }

    @Override
    public String toString() {
        return "TabelaEventoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (unidade != null ? "unidade=" + unidade + ", " : "") +
                (valor != null ? "valor=" + valor + ", " : "") +
                (tabelaEventoId != null ? "tabelaEventoId=" + tabelaEventoId + ", " : "") +
                (tabelaEventoId != null ? "tabelaEventoId=" + tabelaEventoId + ", " : "") +
                (tabelaEventoId != null ? "tabelaEventoId=" + tabelaEventoId + ", " : "") +
            "}";
    }

}

package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the Tabela entity. This class is used in TabelaResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /tabelas?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TabelaCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter descricao;

    private LongFilter clienteId;

    private LongFilter tipoTabelaId;

    private LocalDateFilter dataCriacao;

    private BooleanFilter atual;

    private BooleanFilter status;

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

    public LongFilter getClienteId() {
        return clienteId;
    }

    public void setClienteId(LongFilter clienteId) {
        this.clienteId = clienteId;
    }

    public LongFilter getTipoTabelaId() {
        return tipoTabelaId;
    }

    public void setTipoTabelaId(LongFilter tipoTabelaId) {
        this.tipoTabelaId = tipoTabelaId;
    }

    public LocalDateFilter getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateFilter dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BooleanFilter getAtual() {
        return atual;
    }

    public void setAtual(BooleanFilter atual) {
        this.atual = atual;
    }

    public BooleanFilter getStatus() {
        return status;
    }

    public void setStatus(BooleanFilter status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TabelaCriteria that = (TabelaCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(descricao, that.descricao) &&
            Objects.equals(clienteId, that.clienteId) &&
            Objects.equals(tipoTabelaId, that.tipoTabelaId) &&
            Objects.equals(dataCriacao, that.dataCriacao) &&
            Objects.equals(atual, that.atual) &&
            Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        descricao,
        clienteId,
        tipoTabelaId,
        dataCriacao,
        atual,
        status
        );
    }

    @Override
    public String toString() {
        return "TabelaCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (descricao != null ? "descricao=" + descricao + ", " : "") +
                (clienteId != null ? "clienteId=" + clienteId + ", " : "") +
                (tipoTabelaId != null ? "tipoTabelaId=" + tipoTabelaId + ", " : "") +
                (dataCriacao != null ? "dataCriacao=" + dataCriacao + ", " : "") +
                (atual != null ? "atual=" + atual + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
            "}";
    }

}

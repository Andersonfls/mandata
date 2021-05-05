package com.fourquality.mandata.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Tabela.
 */
@Entity
@Table(name = "tabela")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tabela implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "atual")
    private Boolean atual;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JsonIgnoreProperties("tipo_tabela_id")
    private TipoTabela tipoTabela;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tabela descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Tabela clienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Tabela dataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean isAtual() {
        return atual;
    }

    public Tabela atual(Boolean atual) {
        this.atual = atual;
        return this;
    }

    public void setAtual(Boolean atual) {
        this.atual = atual;
    }

    public Boolean isStatus() {
        return status;
    }

    public Tabela status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAtual() {
        return atual;
    }

    public Boolean getStatus() {
        return status;
    }

    public TipoTabela getTipoTabela() {
        return tipoTabela;
    }

    public void setTipoTabela(TipoTabela tipoTabela) {
        this.tipoTabela = tipoTabela;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tabela tabela = (Tabela) o;
        if (tabela.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tabela.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tabela{" +
            "id=" + getId() +
            ", descricao='" + getDescricao() + "'" +
            ", clienteId=" + getClienteId() +
            ", dataCriacao='" + getDataCriacao() + "'" +
            ", atual='" + isAtual() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

package com.fourquality.mandata.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A AdvogadoCliente.
 */
@Entity
@Table(name = "advogado_cliente")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdvogadoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data_criacao")
    private LocalDate data_criacao;

    @Column(name = "data_exclusao")
    private LocalDate data_exclusao;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JsonIgnoreProperties("cliente_id")
    private User cliente;

    @ManyToOne
    @JsonIgnoreProperties("advogado_id")
    private Advogado advogado;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public AdvogadoCliente data_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
        return this;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public LocalDate getData_exclusao() {
        return data_exclusao;
    }

    public AdvogadoCliente data_exclusao(LocalDate data_exclusao) {
        this.data_exclusao = data_exclusao;
        return this;
    }

    public void setData_exclusao(LocalDate data_exclusao) {
        this.data_exclusao = data_exclusao;
    }

    public Boolean isStatus() {
        return status;
    }

    public AdvogadoCliente status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getCliente() {
        return cliente;
    }

    public AdvogadoCliente cliente(User user) {
        this.cliente = user;
        return this;
    }

    public void setCliente(User user) {
        this.cliente = user;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public AdvogadoCliente advogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
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
        AdvogadoCliente advogado_cliente = (AdvogadoCliente) o;
        if (advogado_cliente.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), advogado_cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AdvogadoCliente{" +
            "id=" + getId() +
            ", data_criacao='" + getData_criacao() + "'" +
            ", data_exclusao='" + getData_exclusao() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

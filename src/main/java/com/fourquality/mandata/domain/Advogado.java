package com.fourquality.mandata.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Advogado.
 */
@Entity
@Table(name = "advogado")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Advogado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    @Column(name = "nome", length = 150)
    private String nome;

    @Size(max = 8)
    @Column(name = "oab", length = 8)
    private String oab;

    @Size(max = 2)
    @Column(name = "oab_uf", length = 2)
    private String oabUf;

    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;

    @Size(max = 11)
    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JsonIgnoreProperties("escritorios")
    private Escritorio escritorio;

    @ManyToOne
    @JsonIgnoreProperties("clientes")
    private Cliente cliente;

    @ManyToOne
    @JsonIgnoreProperties("tipoAdvogados")
    private TipoAdvogado tipoAdvogado;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Advogado nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOab() {
        return oab;
    }

    public Advogado oab(String oab) {
        this.oab = oab;
        return this;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getOabUf() {
        return oabUf;
    }

    public Advogado oabUf(String oabUf) {
        this.oabUf = oabUf;
        return this;
    }

    public void setOabUf(String oabUf) {
        this.oabUf = oabUf;
    }

    public String getEmail() {
        return email;
    }

    public Advogado email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Advogado telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean isStatus() {
        return status;
    }

    public Advogado status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoAdvogado getTipoAdvogado() {
        return tipoAdvogado;
    }

    public void setTipoAdvogado(TipoAdvogado tipoAdvogado) {
        this.tipoAdvogado = tipoAdvogado;
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
        Advogado advogado = (Advogado) o;
        if (advogado.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), advogado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Advogado{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", oab='" + getOab() + "'" +
            ", oabUf='" + getOabUf() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

package com.fourquality.mandata.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Escritorio.
 */
@Entity
@Table(name = "escritorio")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Escritorio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 14)
    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Size(max = 150)
    @Column(name = "logradouro", length = 150)
    private String logradouro;

    @Size(max = 5)
    @Column(name = "numero", length = 5)
    private String numero;

    @Size(max = 100)
    @Column(name = "complemento", length = 100)
    private String complemento;

    @Size(max = 75)
    @Column(name = "bairro", length = 75)
    private String bairro;

    @Size(max = 100)
    @Column(name = "cidade", length = 100)
    private String cidade;

    @Size(max = 2)
    @Column(name = "uf", length = 2)
    private String uf;

    @Size(max = 8)
    @Column(name = "cep", length = 8)
    private String cep;

    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;

    @Size(max = 11)
    @Column(name = "fone_fixo", length = 11)
    private String foneFixo;

    @Size(max = 11)
    @Column(name = "fone_cel", length = 11)
    private String foneCel;

    @Column(name = "status")
    private Boolean status;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Escritorio cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Escritorio logradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public Escritorio numero(String numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Escritorio complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public Escritorio bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public Escritorio cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public Escritorio uf(String uf) {
        this.uf = uf;
        return this;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public Escritorio cep(String cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public Escritorio email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public Escritorio foneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
        return this;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public Escritorio foneCel(String foneCel) {
        this.foneCel = foneCel;
        return this;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

    public Boolean isStatus() {
        return status;
    }

    public Escritorio status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
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
        Escritorio escritorio = (Escritorio) o;
        if (escritorio.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), escritorio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Escritorio{" +
            "id=" + getId() +
            ", cnpj='" + getCnpj() + "'" +
            ", logradouro='" + getLogradouro() + "'" +
            ", numero='" + getNumero() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", uf='" + getUf() + "'" +
            ", cep='" + getCep() + "'" +
            ", email='" + getEmail() + "'" +
            ", foneFixo='" + getFoneFixo() + "'" +
            ", foneCel='" + getFoneCel() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

package com.fourquality.mandata.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Representado.
 */
@Entity
@Table(name = "representado")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Representado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "nome", length = 100)
    private String nome;

    @Size(max = 100)
    @Column(name = "contato", length = 100)
    private String contato;

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

    @ManyToOne
    @JsonIgnoreProperties("cliente_id")
    private Cliente cliente;

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

    public Representado nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public Representado contato(String contato) {
        this.contato = contato;
        return this;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public Representado email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public Representado foneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
        return this;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public Representado foneCel(String foneCel) {
        this.foneCel = foneCel;
        return this;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

    public Boolean isStatus() {
        return status;
    }

    public Representado status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        Representado representado = (Representado) o;
        if (representado.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), representado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Representado{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", contato='" + getContato() + "'" +
            ", email='" + getEmail() + "'" +
            ", foneFixo='" + getFoneFixo() + "'" +
            ", foneCel='" + getFoneCel() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

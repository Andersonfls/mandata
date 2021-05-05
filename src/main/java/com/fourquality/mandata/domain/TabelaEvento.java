package com.fourquality.mandata.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TabelaEvento.
 */
@Entity
@Table(name = "tabela_evento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TabelaEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private Float valor;

    @ManyToOne
    @JsonIgnoreProperties("evento_id")
    private Evento evento;

    @ManyToOne
    @JsonIgnoreProperties("unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JsonIgnoreProperties("tabela_id")
    private Tabela tabela;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public TabelaEvento valor(Float valor) {
        this.valor = valor;
        return this;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
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
        TabelaEvento tabelaEvento = (TabelaEvento) o;
        if (tabelaEvento.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tabelaEvento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TabelaEvento{" +
            "id=" + getId() +
            ", valor=" + getValor() +
            "}";
    }
}

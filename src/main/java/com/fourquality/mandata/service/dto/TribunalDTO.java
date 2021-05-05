package com.fourquality.mandata.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Tribunal entity.
 */
public class TribunalDTO implements Serializable {

    private Long id;

    private String nome;

    private String sigla;

    private Boolean status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

        TribunalDTO tribunalDTO = (TribunalDTO) o;
        if (tribunalDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tribunalDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TribunalDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", sigla='" + getSigla() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

package com.fourquality.mandata.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the TipoDocumento entity.
 */
public class TipoDocumentoDTO implements Serializable {

    private Long id;

    private String descricao;

    private Boolean status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

        TipoDocumentoDTO tipoDocumentoDTO = (TipoDocumentoDTO) o;
        if (tipoDocumentoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tipoDocumentoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TipoDocumentoDTO{" +
            "id=" + getId() +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}

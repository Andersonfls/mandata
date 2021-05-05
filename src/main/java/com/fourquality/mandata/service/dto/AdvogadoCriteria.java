package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Advogado entity. This class is used in AdvogadoResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /advogados?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AdvogadoCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter escritorioId;

    private LongFilter tipoAdvogadoId;

    private LongFilter clienteId;

    private StringFilter nome;

    private StringFilter oab;

    private StringFilter oabUf;

    private StringFilter email;

    private StringFilter telefone;

    private BooleanFilter status;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getEscritorioId() {
        return escritorioId;
    }

    public void setEscritorioId(LongFilter escritorioId) {
        this.escritorioId = escritorioId;
    }

    public LongFilter getTipoAdvogadoId() {
        return tipoAdvogadoId;
    }

    public void setTipoAdvogadoId(LongFilter tipoAdvogadoId) {
        this.tipoAdvogadoId = tipoAdvogadoId;
    }

    public LongFilter getClienteId() {
        return clienteId;
    }

    public void setClienteId(LongFilter clienteId) {
        this.clienteId = clienteId;
    }

    public StringFilter getNome() {
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public StringFilter getOab() {
        return oab;
    }

    public void setOab(StringFilter oab) {
        this.oab = oab;
    }

    public StringFilter getOabUf() {
        return oabUf;
    }

    public void setOabUf(StringFilter oabUf) {
        this.oabUf = oabUf;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getTelefone() {
        return telefone;
    }

    public void setTelefone(StringFilter telefone) {
        this.telefone = telefone;
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
        final AdvogadoCriteria that = (AdvogadoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(escritorioId, that.escritorioId) &&
            Objects.equals(tipoAdvogadoId, that.tipoAdvogadoId) &&
            Objects.equals(clienteId, that.clienteId) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(oab, that.oab) &&
            Objects.equals(oabUf, that.oabUf) &&
            Objects.equals(email, that.email) &&
            Objects.equals(telefone, that.telefone) &&
            Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        escritorioId,
        tipoAdvogadoId,
        clienteId,
        nome,
        oab,
        oabUf,
        email,
        telefone,
        status
        );
    }

    @Override
    public String toString() {
        return "AdvogadoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (escritorioId != null ? "escritorioId=" + escritorioId + ", " : "") +
                (tipoAdvogadoId != null ? "tipoAdvogadoId=" + tipoAdvogadoId + ", " : "") +
                (clienteId != null ? "clienteId=" + clienteId + ", " : "") +
                (nome != null ? "nome=" + nome + ", " : "") +
                (oab != null ? "oab=" + oab + ", " : "") +
                (oabUf != null ? "oabUf=" + oabUf + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (telefone != null ? "telefone=" + telefone + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
            "}";
    }

}

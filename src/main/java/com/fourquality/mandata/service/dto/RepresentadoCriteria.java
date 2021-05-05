package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Representado entity. This class is used in RepresentadoResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /representados?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RepresentadoCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private StringFilter contato;

    private StringFilter email;

    private StringFilter foneFixo;

    private StringFilter foneCel;

    private BooleanFilter status;

    private LongFilter representadoId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNome() {
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public StringFilter getContato() {
        return contato;
    }

    public void setContato(StringFilter contato) {
        this.contato = contato;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(StringFilter foneFixo) {
        this.foneFixo = foneFixo;
    }

    public StringFilter getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(StringFilter foneCel) {
        this.foneCel = foneCel;
    }

    public BooleanFilter getStatus() {
        return status;
    }

    public void setStatus(BooleanFilter status) {
        this.status = status;
    }

    public LongFilter getRepresentadoId() {
        return representadoId;
    }

    public void setRepresentadoId(LongFilter representadoId) {
        this.representadoId = representadoId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RepresentadoCriteria that = (RepresentadoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(contato, that.contato) &&
            Objects.equals(email, that.email) &&
            Objects.equals(foneFixo, that.foneFixo) &&
            Objects.equals(foneCel, that.foneCel) &&
            Objects.equals(status, that.status) &&
            Objects.equals(representadoId, that.representadoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        nome,
        contato,
        email,
        foneFixo,
        foneCel,
        status,
        representadoId
        );
    }

    @Override
    public String toString() {
        return "RepresentadoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (nome != null ? "nome=" + nome + ", " : "") +
                (contato != null ? "contato=" + contato + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (foneFixo != null ? "foneFixo=" + foneFixo + ", " : "") +
                (foneCel != null ? "foneCel=" + foneCel + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (representadoId != null ? "representadoId=" + representadoId + ", " : "") +
            "}";
    }

}

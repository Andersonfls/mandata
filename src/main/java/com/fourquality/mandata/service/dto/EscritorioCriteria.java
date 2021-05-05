package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Escritorio entity. This class is used in EscritorioResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /escritorios?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class EscritorioCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cnpj;

    private StringFilter logradouro;

    private StringFilter numero;

    private StringFilter complemento;

    private StringFilter bairro;

    private StringFilter cidade;

    private StringFilter uf;

    private StringFilter cep;

    private StringFilter email;

    private StringFilter foneFixo;

    private StringFilter foneCel;

    private BooleanFilter status;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCnpj() {
        return cnpj;
    }

    public void setCnpj(StringFilter cnpj) {
        this.cnpj = cnpj;
    }

    public StringFilter getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(StringFilter logradouro) {
        this.logradouro = logradouro;
    }

    public StringFilter getNumero() {
        return numero;
    }

    public void setNumero(StringFilter numero) {
        this.numero = numero;
    }

    public StringFilter getComplemento() {
        return complemento;
    }

    public void setComplemento(StringFilter complemento) {
        this.complemento = complemento;
    }

    public StringFilter getBairro() {
        return bairro;
    }

    public void setBairro(StringFilter bairro) {
        this.bairro = bairro;
    }

    public StringFilter getCidade() {
        return cidade;
    }

    public void setCidade(StringFilter cidade) {
        this.cidade = cidade;
    }

    public StringFilter getUf() {
        return uf;
    }

    public void setUf(StringFilter uf) {
        this.uf = uf;
    }

    public StringFilter getCep() {
        return cep;
    }

    public void setCep(StringFilter cep) {
        this.cep = cep;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EscritorioCriteria that = (EscritorioCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(cnpj, that.cnpj) &&
            Objects.equals(logradouro, that.logradouro) &&
            Objects.equals(numero, that.numero) &&
            Objects.equals(complemento, that.complemento) &&
            Objects.equals(bairro, that.bairro) &&
            Objects.equals(cidade, that.cidade) &&
            Objects.equals(uf, that.uf) &&
            Objects.equals(cep, that.cep) &&
            Objects.equals(email, that.email) &&
            Objects.equals(foneFixo, that.foneFixo) &&
            Objects.equals(foneCel, that.foneCel) &&
            Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        cnpj,
        logradouro,
        numero,
        complemento,
        bairro,
        cidade,
        uf,
        cep,
        email,
        foneFixo,
        foneCel,
        status
        );
    }

    @Override
    public String toString() {
        return "EscritorioCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (cnpj != null ? "cnpj=" + cnpj + ", " : "") +
                (logradouro != null ? "logradouro=" + logradouro + ", " : "") +
                (numero != null ? "numero=" + numero + ", " : "") +
                (complemento != null ? "complemento=" + complemento + ", " : "") +
                (bairro != null ? "bairro=" + bairro + ", " : "") +
                (cidade != null ? "cidade=" + cidade + ", " : "") +
                (uf != null ? "uf=" + uf + ", " : "") +
                (cep != null ? "cep=" + cep + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (foneFixo != null ? "foneFixo=" + foneFixo + ", " : "") +
                (foneCel != null ? "foneCel=" + foneCel + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
            "}";
    }

}

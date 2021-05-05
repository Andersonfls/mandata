package com.fourquality.mandata.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Cliente entity. This class is used in ClienteResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /clientes?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ClienteCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter escritorioId;

    private LongFilter tipoClienteId;

    private StringFilter cnpj;

    private StringFilter cpf;

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

    public LongFilter getEscritorioId() {
        return escritorioId;
    }

    public void setEscritorioId(LongFilter escritorioId) {
        this.escritorioId = escritorioId;
    }

    public LongFilter getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(LongFilter tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public StringFilter getCnpj() {
        return cnpj;
    }

    public void setCnpj(StringFilter cnpj) {
        this.cnpj = cnpj;
    }

    public StringFilter getCpf() {
        return cpf;
    }

    public void setCpf(StringFilter cpf) {
        this.cpf = cpf;
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
        final ClienteCriteria that = (ClienteCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(escritorioId, that.escritorioId) &&
            Objects.equals(tipoClienteId, that.tipoClienteId) &&
            Objects.equals(cnpj, that.cnpj) &&
            Objects.equals(cpf, that.cpf) &&
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
        escritorioId,
        tipoClienteId,
        cnpj,
        cpf,
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
        return "ClienteCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (escritorioId != null ? "escritorioId=" + escritorioId + ", " : "") +
                (tipoClienteId != null ? "tipoClienteId=" + tipoClienteId + ", " : "") +
                (cnpj != null ? "cnpj=" + cnpj + ", " : "") +
                (cpf != null ? "cpf=" + cpf + ", " : "") +
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

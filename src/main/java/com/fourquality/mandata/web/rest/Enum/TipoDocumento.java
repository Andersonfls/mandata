package com.fourquality.mandata.web.rest.Enum;

public enum TipoDocumento {
    RG,
    CPF,
    TITULOELEITOR,
    RESERVISTA,
    CERTIDAO,
    DECJUDICIAL,
    TPSANGUINEO,
    CONTRATODIGITALIZADO,
    OUTROS;

    public static TipoDocumento definirTipoDocumento(String nome) {
        if (nome.equalsIgnoreCase(RG.toString().toLowerCase())) {
            return RG;
        } else  if (nome.equalsIgnoreCase(CERTIDAO.toString().toLowerCase())) {
            return CERTIDAO;
        } else if (nome.equalsIgnoreCase(CONTRATODIGITALIZADO.toString().toLowerCase())) {
            return CONTRATODIGITALIZADO;
        } else if (nome.equalsIgnoreCase(CPF.toString().toLowerCase())) {
            return CPF;
        } else if (nome.equalsIgnoreCase(DECJUDICIAL.toString().toLowerCase())) {
            return DECJUDICIAL;
        } else if (nome.equalsIgnoreCase(RESERVISTA.toString().toLowerCase())) {
            return RESERVISTA;
        } else if (nome.equalsIgnoreCase(TITULOELEITOR.toString().toLowerCase())) {
            return TITULOELEITOR;
        } else if (nome.equalsIgnoreCase(TPSANGUINEO.toString().toLowerCase())) {
            return TPSANGUINEO;
        }
        return OUTROS;
    }
}

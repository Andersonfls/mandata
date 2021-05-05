export interface IDocumento {
    id?: number;
    numeroRg?: string;
    dataEmissaoRg?: Date;
    orgaoExpedidorRg?: string;
    uriRg?: string;
    cpf?: string;
    uriCpf?: string;
    numeroTituloEleitor?: string;
    zonaTitulo?: string;
    secaoTitulo?: string;
    dataEmissaoTitulo?: Date;
    uriTitulo?: string;
    numeroReservista?: string;
    uriReservista?: string;
    numeroCertidao?: string;
    dataEmissaoCertidao?: Date;
    livroCertidao?: string;
    folhaCertidao?: string;
    uriCertidao?: string;
    tipoSanguineo?: string;
    uriTipoSanguineo?: string;
    uriContrato?: string;
    decJudicialNrProcesso?: string;
    decJudicialNomeJuiz?: string;
    uriDecJudical?: string;
    cartorioEmissao?: string;
    cartorioUf?: string;
    cartorioCidade?: string;
    uriCartVacina?: string;
}
export class Documento implements IDocumento {
    constructor(
        public id?: number,
        public numeroRg?: string,
        public orgaoExpedidorRg?: string,
        public dataEmissaoRg?: Date,
        public uriRg?: string,
        public cpf?: string,
        public uriCpf?: string,
        public numeroTituloEleitor?: string,
        public zonaTitulo?: string,
        public secaoTitulo?: string,
        public dataEmissaoTitulo?: Date,
        public uriTitulo?: string,
        public numeroReservista?: string,
        public uriReservista?: string,
        public numeroCertidao?: string,
        public dataEmissaoCertidao?: Date,
        public livroCertidao?: string,
        public folhaCertidao?: string,
        public uriCertidao?: string,
        public tipoSanguineo?: string,
        public uriTipoSanguineo?: string,
        public ufNascimento?: string,
        public uriContrato?: string,
        public decJudicialNrProcesso?: string,
        public decJudicialNomeJuiz?: string,
        public uriDecJudical?: string,
        public cartorioEmissao?: string,
        public cartorioUf?: string,
        public cartorioCidade?: string
    ) {
        this.id = id ? id : null;
    }
}

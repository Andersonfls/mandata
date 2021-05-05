package com.fourquality.mandata.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tabela.class)
public abstract class Tabela_ {

	public static volatile SingularAttribute<Tabela, Boolean> atual;
	public static volatile SingularAttribute<Tabela, Long> clienteId;
	public static volatile SingularAttribute<Tabela, TipoTabela> tipoTabela;
	public static volatile SingularAttribute<Tabela, Long> id;
	public static volatile SingularAttribute<Tabela, LocalDate> dataCriacao;
	public static volatile SingularAttribute<Tabela, String> descricao;
	public static volatile SingularAttribute<Tabela, Boolean> status;

}


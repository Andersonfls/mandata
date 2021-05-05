package com.fourquality.mandata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Advogado.class)
public abstract class Advogado_ {

	public static volatile SingularAttribute<Advogado, String> oab;
	public static volatile SingularAttribute<Advogado, Cliente> cliente;
	public static volatile SingularAttribute<Advogado, String> telefone;
	public static volatile SingularAttribute<Advogado, Escritorio> escritorio;
	public static volatile SingularAttribute<Advogado, String> oabUf;
	public static volatile SingularAttribute<Advogado, TipoAdvogado> tipoAdvogado;
	public static volatile SingularAttribute<Advogado, String> nome;
	public static volatile SingularAttribute<Advogado, Long> id;
	public static volatile SingularAttribute<Advogado, String> email;
	public static volatile SingularAttribute<Advogado, Boolean> status;

}


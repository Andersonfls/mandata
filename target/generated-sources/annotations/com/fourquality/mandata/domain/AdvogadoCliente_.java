package com.fourquality.mandata.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdvogadoCliente.class)
public abstract class AdvogadoCliente_ {

	public static volatile SingularAttribute<AdvogadoCliente, User> cliente;
	public static volatile SingularAttribute<AdvogadoCliente, LocalDate> data_criacao;
	public static volatile SingularAttribute<AdvogadoCliente, Advogado> advogado;
	public static volatile SingularAttribute<AdvogadoCliente, Long> id;
	public static volatile SingularAttribute<AdvogadoCliente, LocalDate> data_exclusao;
	public static volatile SingularAttribute<AdvogadoCliente, Boolean> status;

}


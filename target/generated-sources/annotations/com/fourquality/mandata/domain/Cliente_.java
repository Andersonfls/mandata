package com.fourquality.mandata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> cidade;
	public static volatile SingularAttribute<Cliente, String> numero;
	public static volatile SingularAttribute<Cliente, Escritorio> escritorio;
	public static volatile SingularAttribute<Cliente, String> bairro;
	public static volatile SingularAttribute<Cliente, String> foneCel;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> foneFixo;
	public static volatile SingularAttribute<Cliente, String> cep;
	public static volatile SingularAttribute<Cliente, String> uf;
	public static volatile SingularAttribute<Cliente, TipoCliente> tipoCliente;
	public static volatile SingularAttribute<Cliente, String> complemento;
	public static volatile SingularAttribute<Cliente, String> logradouro;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, Boolean> status;

}


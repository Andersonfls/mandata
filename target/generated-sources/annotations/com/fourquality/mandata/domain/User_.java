package com.fourquality.mandata.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.fourquality.mandata.domain.AbstractAuditingEntity_ {

	public static volatile SingularAttribute<User, String> cidade;
	public static volatile SingularAttribute<User, Instant> resetDate;
	public static volatile SingularAttribute<User, String> numero;
	public static volatile SingularAttribute<User, Escritorio> escritorio;
	public static volatile SingularAttribute<User, String> foneCel;
	public static volatile SingularAttribute<User, String> cnpj;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> resetKey;
	public static volatile SingularAttribute<User, String> cep;
	public static volatile SingularAttribute<User, String> uf;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> complemento;
	public static volatile SingularAttribute<User, String> imageUrl;
	public static volatile SingularAttribute<User, String> cpf;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> bairro;
	public static volatile SingularAttribute<User, String> foneFixo;
	public static volatile SingularAttribute<User, String> activationKey;
	public static volatile SetAttribute<User, Authority> authorities;
	public static volatile SingularAttribute<User, TipoCliente> tipoCliente;
	public static volatile SingularAttribute<User, String> langKey;
	public static volatile SingularAttribute<User, String> logradouro;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Boolean> activated;
	public static volatile SingularAttribute<User, Boolean> status;

}


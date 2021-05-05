package com.fourquality.mandata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evento.class)
public abstract class Evento_ {

	public static volatile SingularAttribute<Evento, TipoEvento> tipoEvento;
	public static volatile SingularAttribute<Evento, Long> id;
	public static volatile SingularAttribute<Evento, String> descricao;
	public static volatile SingularAttribute<Evento, Boolean> status;

}


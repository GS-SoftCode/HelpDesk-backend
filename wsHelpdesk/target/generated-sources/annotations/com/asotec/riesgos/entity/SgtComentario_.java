package com.asotec.riesgos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-24T11:35:56")
@StaticMetamodel(SgtComentario.class)
public class SgtComentario_ { 

    public static volatile SingularAttribute<SgtComentario, String> codTecnico;
    public static volatile SingularAttribute<SgtComentario, String> codUsuario;
    public static volatile SingularAttribute<SgtComentario, Integer> ticket;
    public static volatile SingularAttribute<SgtComentario, String> txtComentario;
    public static volatile SingularAttribute<SgtComentario, Long> codDetalle;
    public static volatile SingularAttribute<SgtComentario, Date> fecCreacion;
    public static volatile SingularAttribute<SgtComentario, Long> codEmpresa;
    public static volatile SingularAttribute<SgtComentario, Long> codCliente;

}
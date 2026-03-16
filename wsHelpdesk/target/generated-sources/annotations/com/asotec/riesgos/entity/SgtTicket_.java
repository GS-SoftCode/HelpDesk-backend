package com.asotec.riesgos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-03-16T09:41:53")
@StaticMetamodel(SgtTicket.class)
public class SgtTicket_ { 

    public static volatile SingularAttribute<SgtTicket, Long> codTicket;
    public static volatile SingularAttribute<SgtTicket, String> codTecnico;
    public static volatile SingularAttribute<SgtTicket, String> passRemote;
    public static volatile SingularAttribute<SgtTicket, String> tfnoCliente;
    public static volatile SingularAttribute<SgtTicket, String> codRemote;
    public static volatile SingularAttribute<SgtTicket, Long> codEmpresa;
    public static volatile SingularAttribute<SgtTicket, Date> fecCreacion;
    public static volatile SingularAttribute<SgtTicket, String> typeRemote;
    public static volatile SingularAttribute<SgtTicket, String> txtDesc;
    public static volatile SingularAttribute<SgtTicket, String> txtTitulo;
    public static volatile SingularAttribute<SgtTicket, String> codCliente;
    public static volatile SingularAttribute<SgtTicket, Long> codEstado;

}
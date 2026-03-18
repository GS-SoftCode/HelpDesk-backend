package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.SgfReclamosId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-03-18T15:06:38")
@StaticMetamodel(SgfReclamos.class)
public class SgfReclamos_ { 

    public static volatile SingularAttribute<SgfReclamos, String> stsReclamo;
    public static volatile SingularAttribute<SgfReclamos, Date> fecRespuestaReclamo;
    public static volatile SingularAttribute<SgfReclamos, String> tipoResolucionReclamo;
    public static volatile SingularAttribute<SgfReclamos, Date> fecReclamo;
    public static volatile SingularAttribute<SgfReclamos, String> canalReclamo;
    public static volatile SingularAttribute<SgfReclamos, Double> valInteresRestituido;
    public static volatile SingularAttribute<SgfReclamos, String> concepto;
    public static volatile SingularAttribute<SgfReclamos, Double> valRestituido;
    public static volatile SingularAttribute<SgfReclamos, String> tipoTransaccion;
    public static volatile SingularAttribute<SgfReclamos, SgfReclamosId> id;
    public static volatile SingularAttribute<SgfReclamos, Double> valTotalRestituido;

}
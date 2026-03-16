package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.ScgTmpSaldosId;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-03-16T09:41:53")
@StaticMetamodel(ScgTmpSaldos.class)
public class ScgTmpSaldos_ { 

    public static volatile SingularAttribute<ScgTmpSaldos, ScgTmpSaldosId> scgTmpSaldosPK;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> valCreditos;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> valDebitos;
    public static volatile SingularAttribute<ScgTmpSaldos, String> nomCuenta;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> valSaldoAnt;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> numDA;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> codOficina;
    public static volatile SingularAttribute<ScgTmpSaldos, Long> numNivel;
    public static volatile SingularAttribute<ScgTmpSaldos, Character> stsMovimiento;

}
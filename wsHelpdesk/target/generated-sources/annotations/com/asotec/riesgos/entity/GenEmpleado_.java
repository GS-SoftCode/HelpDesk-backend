package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.GenDepartamento;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-03-11T09:32:12")
@StaticMetamodel(GenEmpleado.class)
public class GenEmpleado_ { 

    public static volatile SingularAttribute<GenEmpleado, String> codCuentaGasto;
    public static volatile SingularAttribute<GenEmpleado, String> stsSexo;
    public static volatile SingularAttribute<GenEmpleado, Date> fecEntrada;
    public static volatile SingularAttribute<GenEmpleado, Character> stsCalHExtras;
    public static volatile SingularAttribute<GenEmpleado, String> numId;
    public static volatile SingularAttribute<GenEmpleado, Long> codPartida;
    public static volatile SingularAttribute<GenEmpleado, String> codTipoRelacion;
    public static volatile SingularAttribute<GenEmpleado, String> codTipoCuenta;
    public static volatile SingularAttribute<GenEmpleado, Long> codFinanciera;
    public static volatile SingularAttribute<GenEmpleado, String> nomEmpleado;
    public static volatile SingularAttribute<GenEmpleado, String> codTipoId;
    public static volatile SingularAttribute<GenEmpleado, byte[]> imgFoto;
    public static volatile SingularAttribute<GenEmpleado, Long> codEmpleado;
    public static volatile SingularAttribute<GenEmpleado, Long> numTelefono;
    public static volatile SingularAttribute<GenEmpleado, Character> stsControlAsistencia;
    public static volatile SingularAttribute<GenEmpleado, String> numCuenta;
    public static volatile SingularAttribute<GenEmpleado, String> txtDireccion;
    public static volatile SingularAttribute<GenEmpleado, String> stsEmpleado;
    public static volatile SingularAttribute<GenEmpleado, String> stsEstadoCivil;
    public static volatile SingularAttribute<GenEmpleado, GenDepartamento> codDepartamento;
    public static volatile SingularAttribute<GenEmpleado, BigDecimal> valSueldoBasico;
    public static volatile SingularAttribute<GenEmpleado, Long> codOficina;
    public static volatile SingularAttribute<GenEmpleado, Long> codHorario;
    public static volatile SingularAttribute<GenEmpleado, String> codCargoActual;
    public static volatile SingularAttribute<GenEmpleado, String> codTipoPago;
    public static volatile SingularAttribute<GenEmpleado, String> codCuentaBanco;
    public static volatile SingularAttribute<GenEmpleado, Long> codProyecto;
    public static volatile SingularAttribute<GenEmpleado, Long> codAgencia;
    public static volatile SingularAttribute<GenEmpleado, Date> fecNacimiento;
    public static volatile SingularAttribute<GenEmpleado, String> codGrupo;
    public static volatile SingularAttribute<GenEmpleado, Long> numAfiliacionIess;
    public static volatile SingularAttribute<GenEmpleado, Long> codBanco;

}
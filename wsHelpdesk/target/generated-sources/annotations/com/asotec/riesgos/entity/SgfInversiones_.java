package com.asotec.riesgos.entity;

import com.asotec.riesgos.entity.SgfInversionesId;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-24T11:35:56")
@StaticMetamodel(SgfInversiones.class)
public class SgfInversiones_ { 

    public static volatile SingularAttribute<SgfInversiones, Long> numPlazo;
    public static volatile SingularAttribute<SgfInversiones, Double> valProvisionConstituida;
    public static volatile SingularAttribute<SgfInversiones, String> clasifEmisorDepositario;
    public static volatile SingularAttribute<SgfInversiones, Long> codCalificacionRiesgoInv;
    public static volatile SingularAttribute<SgfInversiones, Long> codTipoEmisorDepositarioInv;
    public static volatile SingularAttribute<SgfInversiones, Date> fecUltimaCalificacion;
    public static volatile SingularAttribute<SgfInversiones, String> codCuentaContable;
    public static volatile SingularAttribute<SgfInversiones, Long> codStsTituloInv;
    public static volatile SingularAttribute<SgfInversiones, Long> codPais;
    public static volatile SingularAttribute<SgfInversiones, Double> valInteresGenerado;
    public static volatile SingularAttribute<SgfInversiones, Date> fecVencimiento;
    public static volatile SingularAttribute<SgfInversiones, Double> valNominal;
    public static volatile SingularAttribute<SgfInversiones, Long> codCalifRiesgoNormativaInv;
    public static volatile SingularAttribute<SgfInversiones, Double> valTasaInteresNominal;
    public static volatile SingularAttribute<SgfInversiones, Double> valLibros;
    public static volatile SingularAttribute<SgfInversiones, Long> codInstrumentoInv;
    public static volatile SingularAttribute<SgfInversiones, SgfInversionesId> id;
    public static volatile SingularAttribute<SgfInversiones, Double> valCompra;
    public static volatile SingularAttribute<SgfInversiones, Long> codCalificadoraRiesgoInv;

}
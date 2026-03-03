/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenBanco;
import com.asotec.riesgos.entity.GenPais;
import com.asotec.riesgos.entity.SgfCalificacionRiesgoNormativa;
import com.asotec.riesgos.entity.SgfEstadoTitulo;
import com.asotec.riesgos.entity.SgfInstrumento;
import com.asotec.riesgos.entity.SgfInversiones;
import com.asotec.riesgos.entity.SgfTipoEmisorDepositario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class SgfInversionesDao extends GenericDao<SgfInversiones> implements ISgfInversionesDao{
    /**
     * Constructor general
     */
    public SgfInversionesDao() {
        super();
        setClase(SgfInversiones.class); //agrega pojo
    }

    @Override
    public List<SgfInversiones> findAll() {
        Query query = entityManager.createQuery("from " + SgfInversiones.class.getName() +" where id.fecDeposito not in ('1999-12-31')");
        return query.getResultList();
    }
    

    @Override
    public List<Object> findbyDateI01(String fecha) {
        String sql = "select i.id.numDeposito, b.numRuc, i.id.fecDeposito, i.id.fecCompra, ins.codTipoInstrumento, p.nomAbrevPais, i.valNominal, i.valCompra, i.numPlazo, i.clasifEmisorDepositario, t.tipoEmisorDepositario from "+ SgfInversiones.class.getName() +" i "
                + " INNER JOIN "+GenPais.class.getName()+" p ON i.codPais = p.codPais "
                + " INNER JOIN "+GenBanco.class.getName()+" b ON i.id.codBanco = b.codBanco "
                + " INNER JOIN "+SgfInstrumento.class.getName()+" ins ON i.codInstrumentoInv = ins.codInstrumento "
                + " INNER JOIN "+SgfTipoEmisorDepositario.class.getName()+" t ON i.codTipoEmisorDepositarioInv = t.codTipoEmisorDepositario"
                + " where TO_CHAR(i.id.fecDeposito,'YYYY-MM')='"+fecha+"'"; 
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<Object> findbyDateI02(String fecha) {
        String sql = "select i.id.numDeposito, b.numRuc, i.id.fecDeposito, i.id.fecCompra, i.fecVencimiento, i.codCalificacionRiesgoInv, i.codCalificadoraRiesgoInv, i.fecUltimaCalificacion, i.codCuentaContable, i.valLibros, st.stsTitulo, i.valTasaInteresNominal, i.valInteresGenerado, calfnorm.califRiesgoNormativa, i.valProvisionConstituida from "+ SgfInversiones.class.getName() +" i "
                + " INNER JOIN "+GenBanco.class.getName()+" b ON i.id.codBanco = b.codBanco "
                + " INNER JOIN "+SgfEstadoTitulo.class.getName()+" st ON i.codStsTituloInv = st.codStsTitulo "
                + " INNER JOIN "+SgfCalificacionRiesgoNormativa.class.getName()+" calfnorm ON i.codCalifRiesgoNormativaInv = calfnorm.codCalifRiesgoNormativa "
                + " where fec_deposito not in ('1999-12-31') and fec_deposito <= '"+fecha+"' "
                + " and i.fecVencimiento > '"+fecha+"'"; 
            //Revisar where si da error o no
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<SgfInversiones> findAllI01(String fecha) {
        Query query = entityManager.createQuery("from " + SgfInversiones.class.getName()+ " where TO_CHAR(id.fecDeposito,'YYYY-MM')='"+fecha+"'");
        return query.getResultList();
    }

    @Override
    public List<SgfInversiones> findAllI02(String fecha) {
        Query query = entityManager.createQuery("from " + SgfInversiones.class.getName()+ " where id.fecDeposito not in ('1999-12-31') and id.fecDeposito <= '"+fecha+"' and fecVencimiento > '"+fecha+"'");
        return query.getResultList();
    }

    @Override
    public SgfInversiones findOneById(SgfInversiones inversionJson) {

        Date getFechaDep = inversionJson.getId().getFecDeposito();
        Date getFechaDepTom = new Date(getFechaDep.getTime() + (1000 * 60 * 60 * 24));
        Date getFechaComp = inversionJson.getId().getFecCompra();
        Date getFechaCompTom = new Date(getFechaComp.getTime() + (1000 * 60 * 60 * 24));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateDepos = simpleDateFormat.format(getFechaDepTom);
        String dateCompra = simpleDateFormat.format(getFechaCompTom);

        String msg = "Query findOneById: from " + SgfInversiones.class.getName() + " "
                    + " where id.numDeposito = '"+inversionJson.getId().getNumDeposito()+ "' "
                    + " and id.codBanco = "+inversionJson.getId().getCodBanco()+ " "
                    + " and id.fecDeposito = '"+dateDepos+"' "
                    + " and id.fecCompra = '"+dateCompra+"'";
        Query query = entityManager.createQuery("from " + SgfInversiones.class.getName() + " "
                    + " where id.numDeposito = '"+inversionJson.getId().getNumDeposito()+ "' "
                    + " and id.codBanco = "+inversionJson.getId().getCodBanco()+ " "
                    + " and id.fecDeposito = '"+dateDepos+"' "
                    + " and id.fecCompra = '"+dateCompra+"'");
        
        SgfInversiones res = null;
        try {
            res = (SgfInversiones) query.getSingleResult();
            System.out.println("Registro recuperado");
        } catch (Exception e) {
            msg = "Error sql: "+e;
            System.out.println(msg);
            return null; 
        }
        return res;
    }

    @Override
    public int insertRegistry(SgfInversiones objInver) {
        int res = 0;
        try {
            entityManager.persist(objInver);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }


       

}

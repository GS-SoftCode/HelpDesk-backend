/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfDacionPago;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class SgfDacionPagoDao extends GenericDao<SgfDacionPago> implements ISgfDacionPagoDao{
    /**
     * Constructor general
     */
    public SgfDacionPagoDao() {
        super();
        setClase(SgfDacionPago.class); //agrega pojo
    }

    @Override
    public List<SgfDacionPago> findAll() {
        Query query = entityManager.createQuery("from " + SgfDacionPago.class.getName());
        return query.getResultList();
    }

    @Override
    public int insertRegistry(SgfDacionPago objDacionPago) {
        int res = 0;
        try {
            entityManager.persist(objDacionPago);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }

    @Override
    public List<SgfDacionPago> findAllC04(String fecha) {
        Query query = entityManager.createQuery("from " + SgfDacionPago.class.getName()+ " where id.fecEmision <= '"+fecha+"'");
        return query.getResultList();
    }

    @Override
    public List<Object> findbyDateC04(String fecha) {
        String sql = "select d.numOperacion, d.tipoIdentificacionSujeto, d.idSujeto, d.codBienTitulo, d.codTipoBien, d.nombreEmisor, d.fecEmision, d.fecVencimiento, d.valNominal, d.fecContabilizacion, d.valLibros, d.valUltimoAvaluo, d.valProvisionConstituida, d.fecRealizacion, d.valRealizacion, d.codEstado from "+ SgfDacionPago.class.getName() +" d ";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }
}

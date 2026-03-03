/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfOperacionCredito;
import java.sql.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class SgfOperacionCreditoDao extends GenericDao<SgfOperacionCredito> implements ISgfOperacionCreditoDao{
    /**
     * Constructor general
     */
    public SgfOperacionCreditoDao() {
        super();
        setClase(SgfOperacionCredito.class); //agrega pojo
    }

    @Override
    public List<SgfOperacionCredito> findAll() {
        Query query = entityManager.createQuery("from " + SgfOperacionCredito.class.getName());
        return query.getResultList();

    }

    @Override
    public int deleteAll() {
        try {
            Query query = entityManager.createQuery("delete from "+SgfOperacionCredito.class.getName());
            query.executeUpdate();
            //query.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("ERROR delete_reset_SgfOperacionCredito: "+e);
            return 0;
        }
    }

    /**
     * Genera la BCE01 en la tabla temporal
     * @param fecha1
     * @param fecha2
     */
    @Override
    public int generacionBCE02(Date fecha1, Date fecha2) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("coop_oper_credito");
            query.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
            query.setParameter(1, fecha1);
            query.setParameter(2, fecha2);
            query.execute();
            return 1; 
        } catch (Exception e) {
            System.out.println("ERROR coop_oper_credito: "+e);
            return 0;
        }
    }
}

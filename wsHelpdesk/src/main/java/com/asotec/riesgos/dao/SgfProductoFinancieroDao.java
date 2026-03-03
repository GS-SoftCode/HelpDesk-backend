/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfProductoFinanciero;
import java.sql.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.UserTransaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */

@Repository
public class SgfProductoFinancieroDao extends GenericDao<SgfProductoFinanciero> implements ISgfProductoFinancieroDao{
    /**
     * Constructor general
     */
    public SgfProductoFinancieroDao() {
        super();
        setClase(SgfProductoFinanciero.class); //agrega pojo
    }

    @Override
    public List<SgfProductoFinanciero> findAll() {
        Query query = entityManager.createQuery("from " + SgfProductoFinanciero.class.getName());
        return query.getResultList();

    }

    @Override
    public int deleteAll() {
        try {
            Query query = entityManager.createQuery("delete from "+SgfProductoFinanciero.class.getName());
            query.executeUpdate();
            //query.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("ERROR delete_reset_SgfProductoFinanciero: "+e);
            return 0;
        }
    }

    /**
     * Genera la BCE01 en la tabla temporal
     * @param fecha1
     * @param fecha2
     */
    @Override
    public int generacionBCE01(Date fecha1, Date fecha2) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("coop_prod_financ");
            query.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
            query.setParameter(1, fecha1);
            query.setParameter(2, fecha2);
            query.execute();
            return 1; 
        } catch (Exception e) {
            System.out.println("ERROR coop_prod_financ: "+e);
            return 0;
        }
    }
}

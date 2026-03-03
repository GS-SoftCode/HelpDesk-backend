/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfReclamos;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class SgfReclamosDao extends GenericDao<SgfReclamos> implements ISgfReclamosDao{
    
    /**
     * Constructor general
     */
    public SgfReclamosDao() {
        super();
        setClase(SgfReclamos.class); //agrega pojo
    }

    @Override
    public List<SgfReclamos> findAll() {
        Query query = entityManager.createQuery("from " + SgfReclamos.class.getName());
        return query.getResultList();
    }

    @Override
    public int createRegistry(SgfReclamos reclamoJson) {
        int res = 0;
        try {
            entityManager.persist(reclamoJson);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }
}

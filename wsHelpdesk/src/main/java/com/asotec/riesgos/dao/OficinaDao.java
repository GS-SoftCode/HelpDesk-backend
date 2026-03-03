/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenOficina;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josesanchez
 */
@Repository
public class OficinaDao extends GenericDao<GenOficina> implements IOficinaDao {

    /**
     * Constructor general
     */
    public OficinaDao() {
        super();
        setClase(GenOficina.class); //agrega pojo
    }

    @Override
    public List<GenOficina> findAll() {
        Query query = entityManager.createQuery("from " + GenOficina.class.getName() + " where stsOficina='A'");
        return query.getResultList();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtEmpresa;
import com.asotec.riesgos.entity.SgtTicket;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtEmpresaDao extends GenericDao<SgtEmpresa> implements ISgtEmpresaDao{
    /**
     * Constructor general
     */
    public SgtEmpresaDao() {
        super();
        setClase(SgtEmpresa.class); //agrega pojo
    }

    @Override
    public List<SgtEmpresa> findAll() {
        Query query = entityManager.createQuery("from " + SgtEmpresa.class.getName());
        return query.getResultList();
    }
    
    @Override
    public SgtEmpresa create(SgtEmpresa objEmpresa) {
        entityManager.persist(objEmpresa);
        return objEmpresa;
    }
    
//    @Override
//    public SgtEmpresa update(SgtEmpresa objEmpresa) {
//        return entityManager.merge(objEmpresa);
//    }
//    
//    @Override
//    public SgtEmpresa delete(long id) {
//        SgtEmpresa obj = findOne(id);
//        delete(obj);
//        return obj;
//    }
}

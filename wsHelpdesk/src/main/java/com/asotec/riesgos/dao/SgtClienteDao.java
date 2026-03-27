/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtCliente;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtClienteDao extends GenericDao<SgtCliente> implements ISgtClienteDao{
    /**
     * Constructor general
     */
    public SgtClienteDao() {
        super();
        setClase(SgtCliente.class); //agrega pojo
    }

    @Override
    public List<SgtCliente> findAll() {
        Query query = entityManager.createQuery("from " + SgtCliente.class.getName());
        return query.getResultList();
    }
    
    @Override
    public SgtCliente create(SgtCliente objCliente) {
        entityManager.persist(objCliente);
        return objCliente;
    }
}

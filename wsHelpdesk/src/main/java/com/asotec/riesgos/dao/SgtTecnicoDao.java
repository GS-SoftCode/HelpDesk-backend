/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtTecnico;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtTecnicoDao extends GenericDao<SgtTecnico> implements ISgtTecnicoDao{
    
    /**
     * Constructor general
     */
    public SgtTecnicoDao() {
        super();
        setClase(SgtTecnico.class); //agrega pojo
    }
    
    @Override
    public List<SgtTecnico> findAll() {
        Query query = entityManager.createQuery("from " + SgtTecnico.class.getName()); //Add sts tecnico = A
        return query.getResultList();
    }
    
}

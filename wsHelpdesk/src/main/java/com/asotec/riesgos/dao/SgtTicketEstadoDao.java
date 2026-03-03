/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtTicketEstado;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtTicketEstadoDao extends GenericDao<SgtTicketEstado> implements ISgtTicketEstadoDao{
    /**
     * Constructor general
     */
    public SgtTicketEstadoDao() {
        super();
        setClase(SgtTicketEstado.class); //agrega pojo
    }

    @Override
    public List<SgtTicketEstado> findAll() {
        Query query = entityManager.createQuery("from " + SgtTicketEstado.class.getName());
        return query.getResultList();
    }
}

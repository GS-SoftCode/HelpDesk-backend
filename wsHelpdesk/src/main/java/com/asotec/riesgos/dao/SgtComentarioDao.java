/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtComentario;
import com.asotec.riesgos.entity.SgtTicket;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtComentarioDao extends GenericDao<SgtComentario> implements ISgtComentarioDao{
    /**
     * Constructor general
     */
    public SgtComentarioDao() {
        super();
        setClase(SgtComentario.class); //agrega pojo
    }

    @Override
    public List<SgtComentario> findbyCodTicketEmpresa(int codTicket, long codEmpresa) {
        Query query = entityManager.createQuery("from " + SgtComentario.class.getName()+ " where ticket = "+codTicket+" and codEmpresa = "+codEmpresa+ " order by fecCreacion desc");
        return query.getResultList();
    }
    
    @Override
    public int createComentario(SgtComentario comentarioJson) {
        
        int res = 0;
        try {
            entityManager.persist(comentarioJson);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL createComentario: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }
    
    

    @Override
    public int updateComentario(SgtComentario comentarioJson) {
        int res = 0;
        try {
            entityManager.merge(comentarioJson);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL UpdateTicket: "+e);
            res = 0;
        }
        if (res == 0) {return 0;}
        return 1;
    }
}

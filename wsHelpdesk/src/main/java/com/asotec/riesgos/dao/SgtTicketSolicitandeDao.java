/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgtTicketSolicitante;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SgtTicketSolicitandeDao extends GenericDao<SgtTicketSolicitante> implements ISgtTicketSolicitandeDao{

    public SgtTicketSolicitandeDao() {
        super();
    }

    
    @Override
    public int createTicket(SgtTicketSolicitante ticketJson) {
        int res = 0;
        try {
            entityManager.persist(ticketJson);
            res = 1;
        } catch (Exception e) {
            System.out.println("ErrorSQL createTicketSolicitante: " + e);
            res = 0;
        }
        if (res == 0) {
            return 0;
        }
        return 1;
    }
}

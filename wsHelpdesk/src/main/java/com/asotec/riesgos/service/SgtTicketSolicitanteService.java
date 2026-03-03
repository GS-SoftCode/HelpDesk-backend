/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtTicketSolicitandeDao;
import com.asotec.riesgos.entity.SgtTicketSolicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SgtTicketSolicitanteService extends GenericService<SgtTicketSolicitante> implements ISgtTicketSolicitanteService{

    @Autowired
    private ISgtTicketSolicitandeDao dao;
    
    public SgtTicketSolicitanteService() {
        super();
    }
    
    @Override
    public int createTicket(SgtTicketSolicitante objTicket) {
        return dao.createTicket(objTicket);
    }
    
}

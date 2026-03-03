/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtTicketDao;
import com.asotec.riesgos.entity.SgtTicket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SgtTicketService extends GenericService<SgtTicket> implements ISgtTicketService{
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtTicketDao dao;

    /**
     * Constructor
     */
    public SgtTicketService() {
        super();
    }
    
    @Override
    public List<SgtTicket> findAllEmpresa(long codEmpresa) {
        return dao.findAllEmpresa(codEmpresa);
    }
    
    @Override
    public List<SgtTicket> filterTicketsEmpresa(List<String> listaEstados, List<String> listaTecnicos, long codEmpresa) {
        return dao.filterTicketsEmpresa(listaEstados, listaTecnicos, codEmpresa);
    }
    
    @Override
    public int createTicket(SgtTicket objTicket) {
        return dao.createTicket(objTicket);
    }
    
    @Override
    public SgtTicket crearTicket(SgtTicket objTicket) {
        return dao.crearTicket(objTicket);
    }
    
    @Override
    public int updateTicket(SgtTicket objTicket) {
        return dao.updateTicket(objTicket);
    }
    
    @Override
    public int deleteTicket(SgtTicket objTicket) {
        return dao.deleteTicket(objTicket);
    }
    
}

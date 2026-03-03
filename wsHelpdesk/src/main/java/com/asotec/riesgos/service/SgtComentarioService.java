/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtComentarioDao;
import com.asotec.riesgos.entity.SgtComentario;
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
public class SgtComentarioService extends GenericService<SgtComentario> implements ISgtComentarioService{
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtComentarioDao dao;

    /**
     * Constructor
     */
    public SgtComentarioService() {
        super();
    }
    
    @Override
    public List<SgtComentario> findbyCodTicketEmpresa(int codTicket, long codEmpresa) {
        return dao.findbyCodTicketEmpresa(codTicket, codEmpresa);
    }
    
    @Override
    public int createTicket(SgtComentario objComentario) {
        return dao.createComentario(objComentario);
    }
    
    @Override
    public int updateTicket(SgtComentario objComentario) {
        return dao.updateComentario(objComentario);
    }
    
//    @Override
//    public int deleteTicket(SgtTicket objTicket) {
//        return dao.deleteTicket(objTicket);
//    }
}

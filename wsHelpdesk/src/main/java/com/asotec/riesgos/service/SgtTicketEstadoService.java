/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtTicketEstadoDao;
import com.asotec.riesgos.entity.SgtTicketEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SgtTicketEstadoService extends GenericService<SgtTicketEstado> implements ISgtTicketEstadoService {
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtTicketEstadoDao dao;

    /**
     * Constructor
     */
    public SgtTicketEstadoService() {
        super();
    }
}

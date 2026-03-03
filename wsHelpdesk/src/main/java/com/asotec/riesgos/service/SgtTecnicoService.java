/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgtTecnicoDao;
import com.asotec.riesgos.entity.SgtTecnico;
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
public class SgtTecnicoService extends GenericService<SgtTecnico> implements ISgtTecnicoService {
    
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtTecnicoDao dao;

    /**
     * Constructor
     */
    public SgtTecnicoService() {
        super();
    }
    
}

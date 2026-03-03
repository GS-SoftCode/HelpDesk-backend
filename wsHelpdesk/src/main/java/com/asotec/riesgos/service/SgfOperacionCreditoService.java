/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfOperacionCreditoDao;
import com.asotec.riesgos.entity.SgfOperacionCredito;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class SgfOperacionCreditoService extends GenericService<SgfOperacionCredito> implements ISgfOperacionCreditoService {
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgfOperacionCreditoDao dao;

    /**
     * Constructor
     */
    public SgfOperacionCreditoService() {
        super();
    }

    @Override
    public int deleteAll() {
        return dao.deleteAll();
    }

    @Override
    public int generacionBCE02(Date fecha1, Date fecha2){
        return dao.generacionBCE02(fecha1, fecha2);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfDacionPagoDao;
import com.asotec.riesgos.entity.SgfDacionPago;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class SgfDacionPagoService extends GenericService<SgfDacionPago> implements ISgfDacionPagoService{
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgfDacionPagoDao dao;

    /**
     * Constructor
     */
    public SgfDacionPagoService() {
        super();
    }

    @Override
    public int insertRegistry(SgfDacionPago dacionPagoJson) {
        return dao.insertRegistry(dacionPagoJson);
    }

    @Override
    public List<SgfDacionPago> findAllC04(String fechaRest) {
        return dao.findAllC04(fechaRest);
    }

    @Override
    public List<Object> findbyDateC04(String fechaRest){
        return dao.findbyDateC04(fechaRest);
    }
}

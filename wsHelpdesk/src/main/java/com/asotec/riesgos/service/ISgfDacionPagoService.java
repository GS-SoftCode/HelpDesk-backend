/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgfDacionPago;
import java.util.List;

/**
 *
 * @author User
 */
public interface ISgfDacionPagoService extends IGenericService<SgfDacionPago>{

    public int insertRegistry(SgfDacionPago dacionPagoJson);

    public List<SgfDacionPago> findAllC04(String fechaRest);

    public List<Object> findbyDateC04(String fechaRest);
    
}

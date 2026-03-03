/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgfInversiones;
import java.util.List;

/**
 *
 * @author User
 */
public interface ISgfInversionesService extends IGenericService<SgfInversiones> {
    
    public int insertRegistry(SgfInversiones objInver);

    public SgfInversiones findOneById(SgfInversiones inversionJson);

    public List<Object> findbyDateI01(String fecha);

    public List<Object> findbyDateI02(String fechaRest);

    public List<SgfInversiones> findAllI01(String fecha);

    public List<SgfInversiones> findAllI02(String fecha);

}

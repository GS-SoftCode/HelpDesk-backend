/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfInversiones;
import java.util.List;

/**
 *
 * @author User
 */
public interface ISgfInversionesDao extends IGenericDao<SgfInversiones> {
    
    public int insertRegistry(SgfInversiones objInver);

    public List<Object> findbyDateI01(String fecha);
    public List<Object> findbyDateI02(String fecha);

    public SgfInversiones findOneById(SgfInversiones inversionJson);

    public List<SgfInversiones> findAllI01(String fecha);

    public List<SgfInversiones> findAllI02(String fecha);

}

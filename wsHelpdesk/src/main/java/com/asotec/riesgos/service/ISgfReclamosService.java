/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgfReclamos;

/**
 *
 * @author User
 */
public interface ISgfReclamosService extends IGenericService<SgfReclamos>{

    public int createRegistry(SgfReclamos reclamoJson);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgtComentario;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISgtComentarioService extends IGenericService<SgtComentario>{
    public List<SgtComentario> findbyCodTicketEmpresa(int codTicket, long codEmpresa);
    public int createTicket(SgtComentario objComentario);
    public int updateTicket(SgtComentario objComentario);
    //public int deleteTicket(SgtComentario objComentario);
}

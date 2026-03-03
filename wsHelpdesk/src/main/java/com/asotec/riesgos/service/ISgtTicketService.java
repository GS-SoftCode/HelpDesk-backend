/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgtTicket;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISgtTicketService extends IGenericService<SgtTicket> {
    public List<SgtTicket> findAllEmpresa(long codEmpresa);
    public int createTicket(SgtTicket objTicket);
    public SgtTicket crearTicket(SgtTicket objTicket);
    public int updateTicket(SgtTicket objTicket);
    public int deleteTicket(SgtTicket objTicket);
    public List<SgtTicket> filterTicketsEmpresa(List<String> listaEstados, List<String> listaTecnicos, long codEmpresa);
}

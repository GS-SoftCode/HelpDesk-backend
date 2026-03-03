/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.SgtTecnico;
import com.asotec.riesgos.entity.SgtTicket;
import com.asotec.riesgos.service.ISgtTecnicoService;
import com.asotec.riesgos.service.ISgtTicketService;
import com.asotec.riesgos.util.NoResultException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASOTEC
 */
@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
    
    @Autowired
    private ISgtTecnicoService tecnicoService;
    
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtTecnico>> listarTecnicos() throws NoResultException {

        List<SgtTecnico> resp = tecnicoService.findAll();

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
}

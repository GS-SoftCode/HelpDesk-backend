/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.SgtComentario;
import com.asotec.riesgos.service.ISgtComentarioService;
import com.asotec.riesgos.util.NoResultException;
import com.asotec.riesgos.util.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASOTEC
 */
@RestController
@RequestMapping("/detalle")
public class ComentarioController {
    
    @Autowired
    private ISgtComentarioService comentService;
    
    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity crearComentario(
            @RequestBody SgtComentario comentarioJson
    ) throws NoResultException {
        int resp = comentService.createTicket(comentarioJson);
        if (resp == 0) {
            return Response.get(1, "error de creacion", resp, HttpStatus.NOT_FOUND);
        } //envia al frontend
        return Response.get(0, "creado", resp, HttpStatus.CREATED);
    }
    
    @RequestMapping(
            value = "/get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtComentario>> listaTicketEmpresaComentarios(
            @RequestParam(value = "ticket", required = true) int idTicket,
            @RequestParam(value = "codigo", required = true) long codEmpresa
    ) throws NoResultException {

        List<SgtComentario> resp = comentService.findbyCodTicketEmpresa(idTicket,codEmpresa);
        
        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    } 
    
//    @RequestMapping(
//            value = "/{idTicket}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<SgtComentario>> listaTicketComentarios(
//            @PathVariable int idTicket
//    ) throws NoResultException {
//
//        List<SgtComentario> resp = comentService.findbyCodTicket(idTicket);
//
//        if (resp == null) {
//            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
//        } //envia al frontend
//        return new ResponseEntity<>(resp, HttpStatus.OK);
//    }
    
    
}

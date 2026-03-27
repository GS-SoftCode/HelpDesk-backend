/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.SgtCliente;
import com.asotec.riesgos.service.ISgtClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/clientes")
public class ClienteController {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private ISgtClienteService clienteService;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtCliente>> listarClientes() {

        List<SgtCliente> resp = clienteService.findAll();

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
    public ResponseEntity<SgtCliente> crearCliente(
            @RequestBody SgtCliente clienteJson
    ) {
        
        SgtCliente resp = clienteService.create(clienteJson);

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
    
    @RequestMapping(
            value = "/actualizar",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SgtCliente> actualizarCliente(
            @RequestBody SgtCliente clienteJson
    ) {
        SgtCliente obj = clienteService.findOne(clienteJson.getCodCliente());
        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
        }
        
        obj.setCodEmpresa(clienteJson.getCodEmpresa());
        obj.setNomCliente(clienteJson.getNomCliente());
        obj.setNomClienteRep(clienteJson.getNomClienteRep());
        obj.setApeClienteRep(clienteJson.getApeClienteRep());
        obj.setDirEmail(clienteJson.getDirEmail());
        obj.setStsCliente(clienteJson.getStsCliente());
        obj.setNumId(clienteJson.getNumId());
        obj.setNumCelular(clienteJson.getNumCelular());
        
        SgtCliente resp = clienteService.update(obj);

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SgtCliente> getCliente(
            @RequestParam(value = "codigo", required = true) long idCliente
    ) {
        SgtCliente respuesta = clienteService.findOne(idCliente);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
}

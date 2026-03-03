/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

//import com.asotec.riesgos.entity.GenEmpresa;
import com.asotec.riesgos.entity.SgtEmpresa;
import com.asotec.riesgos.entity.SgtTicket;
//import com.asotec.riesgos.service.IGenEmpresaService;
import com.asotec.riesgos.service.ISgtEmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
//@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("/empresas")
public class EmpresaController {

    /**
     * Resuelve la dependencia
     */
//    @Autowired
//    private IGenEmpresaService empresaService;
    @Autowired
    private ISgtEmpresaService empresaService;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtEmpresa>> listarEmpresas() {

        List<SgtEmpresa> resp = empresaService.findAll();

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/crear",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
    public ResponseEntity<SgtEmpresa> crearEmpresa(
            @RequestBody SgtEmpresa empresaJson
    ) {
        
        SgtEmpresa resp = empresaService.create(empresaJson);
        //SgtEmpresa obj = empresaService.create(new SgtEmpresa());

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/actualizar",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SgtEmpresa> acualizarEmpresa(
            @RequestBody SgtEmpresa empresaJson
    ) {
        SgtEmpresa obj = empresaService.findOne(empresaJson.getCodEmpresa());
        if (obj==null) {
            return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND.OK);
        }
        
        obj.setNomEmpresa(empresaJson.getNomEmpresa());
        obj.setNomAbreviado(empresaJson.getNomAbreviado());
        obj.setNomRuc(empresaJson.getNomRuc());
        obj.setDirEmail(empresaJson.getDirEmail());
        obj.setStsEmpresa(empresaJson.getStsEmpresa());
        obj.setStsSoporte(empresaJson.getStsSoporte());
        obj.setRutaReporte(empresaJson.getRutaReporte());
        
        SgtEmpresa resp = empresaService.update(obj);
        //SgtEmpresa obj = empresaService.create(new SgtEmpresa());

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/get",
            method = RequestMethod.POST)
    public ResponseEntity<SgtEmpresa> getEmpresa(
            @RequestParam(value = "codigo", required = true) long idEmpresa
    ) {
//        SgtEmpresa target = new SgtEmpresa();
//        target.setCodEmpresa(idEmpresa);
        SgtEmpresa repuesta = empresaService.findOne(idEmpresa);
        return new ResponseEntity<>(repuesta, HttpStatus.OK);
    }
    
}

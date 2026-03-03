/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.SgtComentario;
import com.asotec.riesgos.entity.SgtTicket;
import com.asotec.riesgos.entity.SgtTicketEstado;
import com.asotec.riesgos.entity.SgtTicketSolicitante;
import com.asotec.riesgos.service.ISgtComentarioService;
import com.asotec.riesgos.service.ISgtTicketEstadoService;
import com.asotec.riesgos.service.ISgtTicketService;
import com.asotec.riesgos.service.ISgtTicketSolicitanteService;
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
import com.asotec.email.emailService;
import com.asotec.riesgos.entity.TicketSolicitante;
import java.util.logging.Level;
import javax.mail.MessagingException;
import java.util.logging.Logger;

/**
 *
 * @author ASOTEC
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    private ISgtTicketService ticketService;
    @Autowired
    private ISgtTicketEstadoService estadoService;
    @Autowired
    private ISgtTicketSolicitanteService solicitanteService;
    
    @Autowired
    private emailService emailSrv;
    
    private final Logger log = Logger.getLogger(TicketController.class.getName());
            
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtTicket>> listaTodosTickets() throws NoResultException {

        List<SgtTicket> resp = ticketService.findAll();

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtTicket>> listaTicketsEmpresa(
            @RequestParam(value = "codigo", required = true) long idEmpresa
    ) throws NoResultException {

        List<SgtTicket> resp = ticketService.findAllEmpresa(idEmpresa);

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/estados",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtTicketEstado>> listaEstadosTickets() throws NoResultException {

        List<SgtTicketEstado> resp = estadoService.findAll();

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/filtrar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SgtTicket>> filtrarTickets(
            @RequestParam(value = "estados", required = true) List<String> listaEstados, 
            @RequestParam(value = "tecnicos", required = true) List<String> listaTecnicos,
            @RequestParam(value = "codigo", required = true) long codEmpresa
    ) throws NoResultException {
        List<SgtTicket> resp = ticketService.filterTicketsEmpresa(listaEstados, listaTecnicos, codEmpresa);

        if (resp == null) {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND.OK);
        } //envia al frontend
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity crearTicket(
            @RequestBody SgtTicket ticketJson
    ) throws NoResultException {
        int resp = ticketService.createTicket(ticketJson);
        if (resp == 0) {
            return Response.get(1, "error de creacion", resp, HttpStatus.NOT_FOUND);
        } //envia al frontend
        return Response.get(0, "creado", resp, HttpStatus.CREATED);
    }
    
    @RequestMapping(
            value = "/crearTicket",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createTicket(
            @RequestBody SgtTicket ticketJson
    ) throws NoResultException, MessagingException {
        
        SgtTicket resp = ticketService.crearTicket(ticketJson);
        if (resp==null) {
            return Response.get(1, "error de creacion", resp, HttpStatus.NOT_FOUND);
        } 
        return Response.get(0, "creado", "Se envio el mensaje al correo", HttpStatus.CREATED);
    }
    
    //Metodo que crea el ticket con el rellena datos del solicitante y envia el email de confirmacion
    @RequestMapping(
        value = "/mailTicket",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> sendMailTicket(@RequestBody TicketSolicitante ticketSol) {
        
        SgtTicketSolicitante solicitante = ticketSol.getSolicitante();
        SgtTicket ticket = ticketSol.getTicket();
        //Crear el ticket
        log.log(Level.INFO, "Creando ticket con Titulo: {0}", ticket.getTxtTitulo());
        SgtTicket respTicket = ticketService.crearTicket(ticket);
        if (respTicket==null) {
            //si no se creo devuelve 1 
            return Response.get(1, "error de creacion ticket", respTicket, HttpStatus.NOT_FOUND);
        }
        log.log(Level.INFO, "Ticket creado con ID: {0}", respTicket.getCodTicket());
        //Setear el codigo de ticket creado para el solicitante
        SgtTicketSolicitante solicTick= solicitante;
        solicTick.setCodTicket(respTicket.getCodTicket());
        
        //crear la solicitud que contiene el solicitante con el ticket correcto
        int respSolic = solicitanteService.createTicket(solicTick);
        if (respSolic == 0) {
            return Response.get(1, "error de creacion Solicitante", solicTick, HttpStatus.NOT_FOUND);
        }
        
        //enviar el email
        log.info("Solicitante.getCodTicket: "+ solicTick.getCodTicket()+" ticket.getCodTicket: "+ticket.getCodTicket());
        try {
            emailSrv.senMailTicketCreation(solicitante, respTicket);
            // Éxito
            return Response.get(0,"Email enviado correctamente","El ticket fue creado y se envió el correo a " + solicitante.getEmailSolicitante(),HttpStatus.CREATED);

        }catch (Exception e) {
            // Error general
            return Response.get(2,"No se pudo enviarl el email","Respuesta Servidor: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(
            value = "/modificar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity actualizarReclamo(
            @RequestBody SgtTicket ticketJson
    ) {
        System.out.println("-- TicketDataUpdate: "+ticketJson.getCodTicket());
        int resp = ticketService.updateTicket(ticketJson);

        if (resp == 0) {
            return Response.get(1, "error de actualizado", resp, HttpStatus.NOT_FOUND);
        } 

        //envia al frontend
        return Response.get(0, "actualizado", resp, HttpStatus.ACCEPTED);
    }

    //Mediante un solicitante
    @RequestMapping(
            value = "/solicitante",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity crearTicketSolicitante(
            @RequestBody SgtTicketSolicitante ticketJson
    ) throws NoResultException {
        
        //Crear un ticket con con el solicitante
        int resp = solicitanteService.createTicket(ticketJson);
        if (resp == 0) {
            return Response.get(1, "error de creacion", resp, HttpStatus.NOT_FOUND);
        }
        
        return Response.get(0, "creado", resp, HttpStatus.CREATED);
    }
    
    
//    @RequestMapping(
//            value = "/delete",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity eliminarTicket(
//            @RequestBody SgtTicket ticketJson
//    ) {
//        System.out.println("-- Recl: "+reclamoJson.getId().getCodSocio());
//        System.out.println("-- Recl: "+reclamoJson.getId().getNumReclamo());
//        System.out.println("-- Recl: "+reclamoJson.getConcepto());
//        int resp = reclamosService.deleteReclamo(reclamoJson);
//
//        if (resp == 0) {
//            return Response.get(0, "error de borrado", resp, HttpStatus.NOT_FOUND);
//        } //envia al frontend
//        return Response.get(0, "eliminado", resp, HttpStatus.ACCEPTED);
//    }

}

package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.TicketModel;
import com.bezkoder.springjwt.services.TicketServiceInterface;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TicketController {

    private final TicketServiceInterface ticketServiceInterface;
    @Autowired
    public TicketController(TicketServiceInterface ticketServiceInterface) {
        this.ticketServiceInterface = ticketServiceInterface;
    }


    @GetMapping("/tickets")
    public ResponseEntity<List<TicketModel>> getAllTickets(){
        List<TicketModel> tickets= ticketServiceInterface.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    @PostMapping("/tickets")
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticketModel){
        TicketModel ticket=ticketServiceInterface.AddTicket(ticketModel);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketModel> getTicketById(@PathVariable Long id){
        TicketModel ticket =ticketServiceInterface.findTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);

    }
    /*@GetMapping("/tickets/{username}")
    public ResponseEntity<TicketModel> getTicketByUsername(@PathVariable String username){
        TicketModel ticket =ticketServiceInterface.findTicketByRequester(username);
        return new ResponseEntity<>(ticket, HttpStatus.OK);

    }*/
    @GetMapping("/ticket/{name}")
    public ResponseEntity<List<TicketModel>> getTicketByRequester(@PathVariable String name){
        List<TicketModel> ticket =ticketServiceInterface.findTicketByRequester(name);
        return new ResponseEntity<>(ticket, HttpStatus.OK);

    }

    @PutMapping("/tickets/{id}")

    public ResponseEntity<TicketModel> updateTicket(@PathVariable Long id, @RequestBody TicketModel ticketDetails){
        TicketModel t1=ticketServiceInterface.updateTicket(id,ticketDetails);
        return   new ResponseEntity<>(t1,HttpStatus.OK);
    }
    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTicket(@PathVariable Long id){
        Map<String,Boolean> response=ticketServiceInterface.deleteTicket(id);
        return  ResponseEntity.ok(response);
    }
    @GetMapping("tickets1/{id}")
    public ResponseEntity<String> getStatusById(@PathVariable Long id){
        String title= ticketServiceInterface.getStatusTitle(id);
        return new ResponseEntity<>(title, HttpStatus.OK);
    }
    @GetMapping("tickets2/{id}")
    public ResponseEntity<String> getCategoryById(@PathVariable Long id){
        String title= ticketServiceInterface.getCategoryTitle(id);
        return new ResponseEntity<>(title, HttpStatus.OK);
    }
    @GetMapping("tickets3/{id}")
    public ResponseEntity<Any> updateStatus(@PathVariable Long id, String status){
        ticketServiceInterface.updateStatus(id,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}


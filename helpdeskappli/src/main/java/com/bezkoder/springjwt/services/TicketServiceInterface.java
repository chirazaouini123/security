package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.TicketModel;

import java.util.List;
import java.util.Map;

public interface TicketServiceInterface {
    public List<TicketModel> findAllTickets();
    public TicketModel AddTicket( TicketModel ticket);
    public TicketModel findTicketById( Long id);
    public List<TicketModel> findTicketByRequester( String requester);

    public TicketModel updateTicket(Long id,  TicketModel ticketDetails);
    public Map<String,Boolean> deleteTicket(Long id);
    public String getStatusTitle(Long id);
    public String getCategoryTitle(Long id);
    public void updateStatus(Long id, String status);
}

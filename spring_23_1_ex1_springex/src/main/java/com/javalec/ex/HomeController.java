package com.javalec.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.ex.dao.TicketDao;
import com.javalec.ex.dto.TicketDto;

@Controller
public class HomeController {
  private TicketDao dao;

  @Autowired
  public void setDao(TicketDao dao) {
    this.dao = dao;
  }

  @RequestMapping("/buyTicket")
  public String buyTicket() {
    return "buyTicket";
  }

  @RequestMapping("/buyTicketCard")
  public String buyTicketCard(TicketDto ticketDto, Model model) {
    System.out.println("buyTicketCard");
    System.out.println("ticketDto : " + ticketDto.getConsumerId());
    System.out.println("ticketDto : " + ticketDto.getAmount());

    dao.buyTicket(ticketDto);
    model.addAttribute("ticketInfo", ticketDto);

    return "buyTicketEnd";
  }
}

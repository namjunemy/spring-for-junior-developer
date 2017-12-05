package com.javalec.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.ex.com.ITicketCommand;
import com.javalec.ex.dao.TicketDao;
import com.javalec.ex.dto.TicketDto;

@Controller
public class HomeController {
  private ITicketCommand ticketCommand;

  @Autowired
  public void setTicketCommand(ITicketCommand ticketCommand) {
    this.ticketCommand = ticketCommand;
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

    ticketCommand.execute(ticketDto);
    model.addAttribute("ticketInfo", ticketDto);

    return "buyTicketEnd";
  }
}

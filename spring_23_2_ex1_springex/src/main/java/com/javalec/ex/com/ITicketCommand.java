package com.javalec.ex.com;

import com.javalec.ex.dto.TicketDto;

public interface ITicketCommand {
  public void execute(TicketDto ticketDto);
}

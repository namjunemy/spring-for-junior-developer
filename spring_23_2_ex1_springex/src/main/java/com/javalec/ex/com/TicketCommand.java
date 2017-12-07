package com.javalec.ex.com;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.ex.dao.TicketDao;
import com.javalec.ex.dto.TicketDto;

public class TicketCommand implements ITicketCommand {
  private TicketDao ticketDao;
  private TransactionTemplate transactionTemplate2;
  
  public void setTicketDao(TicketDao ticketDao) {
    this.ticketDao = ticketDao;
  }
  
  public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
    this.transactionTemplate2 = transactionTemplate2;
  }
  
  @Override
  public void execute(final TicketDto ticketDto) {
    transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
      @Override
      protected void doInTransactionWithoutResult(TransactionStatus arg0) {
        ticketDao.buyTicket(ticketDto);
        
        ticketDto.setConsumerId("22222222222222222222222222222222222");
        ticketDao.buyTicket(ticketDto);        
      }
    });
  }
}

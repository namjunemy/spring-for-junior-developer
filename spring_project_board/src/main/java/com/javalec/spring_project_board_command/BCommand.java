package com.javalec.spring_project_board_command;

import org.springframework.ui.Model;

public interface BCommand {
  public void execute(Model model);
}

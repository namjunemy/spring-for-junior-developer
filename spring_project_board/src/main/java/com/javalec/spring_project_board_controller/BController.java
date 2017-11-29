package com.javalec.spring_project_board_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_project_board_command.BCommand;
import com.javalec.spring_project_board_command.BContentCommand;
import com.javalec.spring_project_board_command.BDeleteCommand;
import com.javalec.spring_project_board_command.BListCommand;
import com.javalec.spring_project_board_command.BModifyCommand;
import com.javalec.spring_project_board_command.BReplyCommand;
import com.javalec.spring_project_board_command.BReplyViewCommand;
import com.javalec.spring_project_board_command.BWriteCommand;

@Controller
public class BController {
  BCommand command;

  @RequestMapping("/list")
  public String list(Model model) {
    System.out.println("list()");

    command = new BListCommand();
    command.execute(model);

    return "list";
  }

  @RequestMapping("/writeView")
  public String writeView(Model model) {
    System.out.println("writeView()");

    return "writeView";
  }

  @RequestMapping("/write")
  public String write(HttpServletRequest request, Model model) {
    System.out.println("write()");

    model.addAttribute("request", request);
    command = new BWriteCommand();
    command.execute(model);

    return "redirect:list";
  }

  @RequestMapping("/contentView")
  public String contentView(HttpServletRequest request, Model model) {
    System.out.println("contentView()");

    model.addAttribute("request", request);
    command = new BContentCommand();
    command.execute(model);

    return "contentView";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/modify")
  public String modify(HttpServletRequest request, Model model) {
    System.out.println("modify()");

    model.addAttribute("request", request);
    command = new BModifyCommand();
    command.execute(model);

    return "redirect:list";
  }

  @RequestMapping("/replyView")
  public String replyView(HttpServletRequest request, Model model) {
    System.out.println("replyView()");

    model.addAttribute("request", request);
    command = new BReplyViewCommand();
    command.execute(model);

    return "replyView";
  }

  @RequestMapping("/reply")
  public String reply(HttpServletRequest request, Model model) {
    System.out.println("reply()");

    model.addAttribute("request", request);
    command = new BReplyCommand();
    command.execute(model);

    return "redirect:list";
  }

  @RequestMapping("/delete")
  public String delete(HttpServletRequest request, Model model) {
    System.out.println("delete");

    model.addAttribute("request", request);
    command = new BDeleteCommand();
    command.execute(model);

    return "redirect:list";
  }
}

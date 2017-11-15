package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
  @RequestMapping("/view")
  public String view() {
    return "view";
  }

  @RequestMapping("/content/contentView")
  public String contentView(Model model) {
    model.addAttribute("id", "namjunemy");

    return "/content/contentView";
  }

  @RequestMapping("/content/modelAndView")
  public ModelAndView contentView() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("id", "namjunemyModel");
    mv.setViewName("/content/contentView");

    return mv;
  }
}

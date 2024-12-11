package com.example.tust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ToPage {

    @RequestMapping("/")
    public String index() {
        // model.addAttribute("name", "simonsfan");Model model, HttpServletResponse response
        return "/page/login.html";
    }
    @RequestMapping(value="/tologin", method = RequestMethod.GET)
    public String tologin(){
        return "/page/login";
    }
    @RequestMapping(value="/toregister")
    public String toregister(){
        return "/page/register";
    }
    @RequestMapping(value="/toindex")
    public String toindex(HttpSession session){
        if (session.getAttribute("username") != null) {
            return "index";
        }else {
            return "redirect:/tologin";
        }
    }
    @RequestMapping(value="/towelcome")
    public String totable_welcome(){
        return "page/welcome";
    }
    @RequestMapping(value="/touser_setting")
    public String touser_setting(){
        return "page/user-setting";
    }


    @RequestMapping(value="/totable_users")
    public String totable_users(){
        return "page/table_users";
    }
    @RequestMapping(value="/toadd_users")
    public String toadd_users(){
        return "page/table/add_users";
    }
    @RequestMapping(value="/toedit_users")
    public String toedit_users(){
        return "page/table/edit_users";
    }

    @RequestMapping(value="/totable_jouInfo")
    public String totable_jouInfo(){
        return "page/table_jouInfo";
    }
    @RequestMapping(value="/toadd_jouInfo")
    public String toadd_jouInfo(){
        return "page/table/add_jouInfo";
    }
    @RequestMapping(value="/toedit_jouInfo")
    public String toedit_jouInfo(){
        return "page/table/edit_jouInfo";
    }

    @RequestMapping(value="/totable_jouInfo2")
    public String totable_jouInfo2(){
        return "page/table_jouInfo2";
    }
    @RequestMapping(value="/toedit_jouInfo2")
    public String toedit_jouInfo2(){
        return "page/table/edit_jouInfo2";
    }
}

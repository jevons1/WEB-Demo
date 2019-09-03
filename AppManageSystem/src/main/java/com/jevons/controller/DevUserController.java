package com.jevons.controller;


import com.jevons.pojo.DevUser;
import com.jevons.service.AppInfoService;
import com.jevons.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "dev/login";

    }
    @RequestMapping("/login")
    public String login(DevUser devUser, Model model, HttpSession session){
        devUser = devUserService.login(devUser);
        if (devUser != null){
            //登陆成功
            session.setAttribute("devUser",devUser);
            return "dev/index";
        }else{
            model.addAttribute("errorMsg","登陆失败");
            return "dev/login";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){

        session.removeAttribute("devUser");
        session.invalidate();

        return "redirect:/";
    }


}

package com.federal.checklist.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppViewController {


    @GetMapping("/")
    public String index() {
        return "loginActionSSO.jsp";
    }

	@GetMapping("/view")
    public String view() {
        return "checklist.jsp";
    }


    @GetMapping("/signout")
    public String logoutWebpage() {
        return "/logout.jsp";
    }


}

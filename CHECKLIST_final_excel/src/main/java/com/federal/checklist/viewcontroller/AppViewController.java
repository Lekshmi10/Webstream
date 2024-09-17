package com.federal.checklist.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AppViewController {


    @GetMapping("/")
    public String index(HttpServletResponse response, HttpSession session)
    {
        String sessionId = session.getId();
        setSameSiteAttribute(response, sessionId);
        System.out.println(sessionId);
        return "loginActionSSO.jsp";
    }

    @GetMapping("/view")
    public String view() {

        return "checklist.jsp";
    }

    private void setSameSiteAttribute(HttpServletResponse response, String sessionId) {

        response.setHeader("Set-Cookie", "JSESSIONID=" + sessionId + "; Path=/WebStream; Secure; HttpOnly; SameSite=Lax");
    }


    @GetMapping("/signout")
    public String logoutWebpage(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        return "logout.jsp";
    }


}

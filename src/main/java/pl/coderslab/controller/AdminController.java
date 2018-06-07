package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("")
    @ResponseBody
    public String login(Principal principal){
        return principal.getName();
    }

}

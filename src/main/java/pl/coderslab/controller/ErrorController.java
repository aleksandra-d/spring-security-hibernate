package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/access-denied")
    @ResponseBody
    public String error403(){
        return "Brak dostępu";
    }

}

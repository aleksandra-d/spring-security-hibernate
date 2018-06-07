package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.model.UserRole;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.repository.UserRolerRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolerRepository userRolerRepository;

    @GetMapping("/registration")
    public String registerForm(){
        return "auth/register";
    }

    @PostMapping("/registration")
    public String register(HttpServletRequest request){

        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        User user = new User();
        user.setUsername(username);
        user.setPassword(hashed);
        user.setEnabled(true);

        userRepository.save(user);

        UserRole userRole = new UserRole(user, "ROLE_USER");

        userRolerRepository.save(userRole);

        return "auth/after-register";
    }

}

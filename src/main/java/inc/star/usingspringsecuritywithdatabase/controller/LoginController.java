package inc.star.usingspringsecuritywithdatabase.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLogin(){
        return "login";
    }
}


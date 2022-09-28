package inc.star.usingspringsecuritywithdatabase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String Home(){
        return "Home";
    }
}

package os;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")

public class firstPage {
    @GetMapping(value = "/r")
    public String firstPage(){
        return "index";

    }
}

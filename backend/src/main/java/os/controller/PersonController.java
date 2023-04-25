package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.PersonEntity;
import os.service11.PersonService;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService ps;

    @GetMapping(value = "/person")

    public String getAll(Model model) {

        List<PersonEntity> pe = ps.personGetAll();
        model.addAttribute("persons", pe);
        return "person";

    }
}

package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.PersonEntity;
import os.service11.PersonService;

import java.util.List;
@Controller

//@RestController
public class AllPersons {
    @Autowired
    private PersonService ps;
    @GetMapping(value = "/get")
//  @RequestMapping          (value = "/get", method = RequestMethod.GET)
//  public String d() { return  "tc/src/main/webapp/index.jsp";}
    public ResponseEntity<List<PersonEntity>> getAll(Model model){
//    public String getAll(Model model){

        List<PersonEntity> pe = ps.personGetAll();
//        model.addAttribute("persons", pe);
//        return "AllPersons";
        pe.forEach(System.out::println);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity<>(pe, headers, HttpStatus.OK);
        return ResponseEntity.ok().body(pe);
    }
}

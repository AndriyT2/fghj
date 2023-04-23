package controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import osHibernate.PersonEntity;
import service11.PersonService;

import java.util.List;
@Controller

//@RestController
public class AllPersons {
    @Autowired
    private PersonService ps;
    @GetMapping(value = "/get")
//  @RequestMapping          (value = "/get", method = RequestMethod.GET)
//  public String d() { return  "tc/src/main/webapp/index.jsp";}
    public ResponseEntity<List<PersonEntity>> getAll(){
        List<PersonEntity> pe = ps.personGetAll();
        System.out.println(pe);
//        pe.forEach(System.out::println);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(pe, headers, HttpStatus.OK);
//        return ResponseEntity.ok().body(pe);
    }
}

package main;

import org.springframework.context.annotation.ComponentScan;
import service.Menu;

import java.io.IOException;

@ComponentScan( {"models", "utility", "service"})
public class Main11 {


    public static void main(String[] args) throws IOException {


        Menu menu = new Menu();
        menu.menu();



    }

}
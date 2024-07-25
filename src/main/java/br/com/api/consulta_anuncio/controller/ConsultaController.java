package br.com.api.consulta_anuncio.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {


    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

}

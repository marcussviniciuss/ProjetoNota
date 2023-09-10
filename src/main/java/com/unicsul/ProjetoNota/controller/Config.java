package com.unicsul.ProjetoNota.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean (name = "recadoNota")
    public String recadoNota(){
        String recado = "A media é 6";
        return "A media é 6";
    }

    @Bean (name = "appRecado")
    public String appRecado(){
        String app = "Seja bem vindo";
        return "Seja bem-vindo(a)!!1";
    }

}

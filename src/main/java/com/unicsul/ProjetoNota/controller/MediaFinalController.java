package com.unicsul.ProjetoNota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DecimalFormat;

@Controller
@RequestMapping("/")
public class MediaFinalController {

    @Autowired
    @Qualifier("recadoNota")
    private String recadoNota;

    @Autowired
    @Qualifier("appRecado")
    private String appRecado;

    @GetMapping("/")
    public String home(ModelMap model){
        model.addAttribute("appRecado", appRecado);
        return "home";
    }

    @GetMapping("/ola/{nome}")
    public String saudacao(@PathVariable String nome, ModelMap model){
        model.addAttribute("nome", nome);
        return "saudacao";
    }

    @GetMapping("/media/{notaA1}/{notaA2}")
    public String calcularMedia(@PathVariable double notaA1, @PathVariable double notaA2, ModelMap model){
        double mediaFinal = (notaA1 + notaA2) / 2;
        model.addAttribute("mediaFinal", mediaFinal);
        model.addAttribute("recadoNota", recadoNota);
        return "media";
        /*
        acessar um localhost:8080 como /media/{nota-da-a1}/{nota-da-a2}
        */
    }

    @GetMapping("/raiz/{numero}")
    public String calcularRaiz(@PathVariable double numero, ModelMap model) {
        double raiz = Math.sqrt(numero);
        DecimalFormat df = new DecimalFormat("#.##"); // Formata para 2 casas decimais
        String raizFormatada = df.format(raiz);
        model.addAttribute("raiz", raizFormatada);
        return "raiz";
        /*
        acesse localhost:8080 como /raiz/{numero} para calcular a raiz de um
        número.
        */
    }
}
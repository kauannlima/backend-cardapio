package com.example.cardapio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealizaConexaoController {

    @GetMapping("/connect")
    public ResponseEntity<String> RealizaConexao(){
        return ResponseEntity.ok("Conexão bem-sucedida!");
    }
}

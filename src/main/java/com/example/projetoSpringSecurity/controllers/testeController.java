package com.example.projetoSpringSecurity.controllers;

import com.example.projetoSpringSecurity.entities.Usuario;
import com.example.projetoSpringSecurity.repositories.UsuarioRepository;
import com.example.projetoSpringSecurity.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class testeController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService userService;
    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public String teste(){
        return "<h1>TESTE</h1>";
    }
    @GetMapping("/livre")
    public String livre(){
        return "<h1>Rota livre</h1>";
    }

    @GetMapping("/teste")
    public String usuario(){
        return "<h1>Rota livre</h1>";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar (@RequestBody Usuario usuario){
        String senhaEncriptada = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(senhaEncriptada);
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }



}


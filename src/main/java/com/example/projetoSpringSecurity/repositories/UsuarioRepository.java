package com.example.projetoSpringSecurity.repositories;

import com.example.projetoSpringSecurity.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}

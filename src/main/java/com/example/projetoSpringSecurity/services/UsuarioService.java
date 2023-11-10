package com.example.projetoSpringSecurity.services;

import com.example.projetoSpringSecurity.entities.Usuario;
import com.example.projetoSpringSecurity.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var Usuario = usuarioRepository.findByUsername(username);
            System.out.println(Usuario.getUsername());
            return (UserDetails) Usuario;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não localizado");
        }

    }
}

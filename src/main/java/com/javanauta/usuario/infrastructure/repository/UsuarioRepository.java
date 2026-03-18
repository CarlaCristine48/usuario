package com.javanauta.usuario.infrastructure.repository;


import com.javanauta.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /*Script de Banco de Dados que retorna um boolean, verificando se
    o dado informado existe no banco de dados ou não*/

    boolean existsByEmail(String email);

    Optional <Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}

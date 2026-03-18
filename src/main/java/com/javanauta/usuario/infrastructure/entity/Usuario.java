package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // Apontamento informando ao Spring, que é uma tabela do banco de dados
@Table(name = "usuario") // Nome da tabela no banco de dados

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "nome", length = 100) // Nome da coluna no banco de dados
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL) // Relacionamento em cascata de um usuário para muitos endereços.
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") //Nome que vai constar na coluna endereços, identificando qual endereço pertence ao usuário pelo ID
    private List<Endereco> enderecos; //Apontamento da tabela endereço
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = ("id"))
    private List<Telefone> telefones;

    public Collection < ? extends GrantedAuthority> getAuthorities(){
        return List.of();
    }
    public String getPassword(){
        return senha;
    }

    public String getUsername(){
        return email;
    }



}

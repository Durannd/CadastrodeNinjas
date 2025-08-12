package br.com.ricaeldurand.CadastroDeNinjas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    String nome;
    String email;
    int idade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}

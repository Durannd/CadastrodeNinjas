package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Services.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_Missoes")
public class MissoesModel {
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // isso vai dizer que uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> participantesMissao;

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    private String dificulty;
    public MissoesModel() {
    }

    public MissoesModel(String nome, Long id, List<NinjaModel> participantesMissao) {
        this.nome = nome;
        this.id = id;
        this.participantesMissao = participantesMissao;
    }

    public String getNomeMissao() {
        return nome;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nome = nomeMissao;
    }



    public Long getIdMissao() {
        return id;
    }

    public void setIdMissao(Long idMissao) {
        this.id = idMissao;
    }

    public List<NinjaModel> getParticipantesMissao() {
        return participantesMissao;
    }

    public void setParticipantesMissao(List<NinjaModel> participantesMissao) {
        this.participantesMissao = participantesMissao;
    }

    public void addParticipantesMissao(NinjaModel a ){
        participantesMissao.add(a);
    }
}
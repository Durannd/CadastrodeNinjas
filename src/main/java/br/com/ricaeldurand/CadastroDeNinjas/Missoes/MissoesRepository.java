package br.com.ricaeldurand.CadastroDeNinjas.Missoes;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}

package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.repository;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}

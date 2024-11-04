package com.phm.gestao_de_gastos_de_veiculos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.phm.gestao_de_gastos_de_veiculos.models.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

	public Veiculo findByPlaca(String placa);
}

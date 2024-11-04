package com.phm.gestao_de_gastos_de_veiculos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.phm.gestao_de_gastos_de_veiculos.models.Gasto;

public interface GastoRepository extends CrudRepository<Gasto, Long>{

	List<Gasto> findByVeiculoPlaca(String placa);
}

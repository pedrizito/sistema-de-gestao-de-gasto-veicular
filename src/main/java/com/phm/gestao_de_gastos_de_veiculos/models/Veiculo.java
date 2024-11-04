package com.phm.gestao_de_gastos_de_veiculos.models;

import java.io.Serializable;
import java.util.List;

import com.phm.gestao_de_gastos_de_veiculos.utils.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Pattern(regexp = "[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}")
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String placa;
	
	@NotEmpty
	private String marca;
	
	@NotEmpty
	private String modelo;
	
	@NotEmpty
	private String ano;
	
	@OneToMany(mappedBy = "veiculo")
	List<Gasto> gastos; 
	
	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}

	public String getMarca() {
		return marca;
	}

	  public void setMarca(String marca) {
	        this.marca = StringUtils.capitalizeWords(marca);
	    }

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
        this.modelo = StringUtils.capitalizeWords(modelo);
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public String getPlaca() {
		return placa;
	}	
}

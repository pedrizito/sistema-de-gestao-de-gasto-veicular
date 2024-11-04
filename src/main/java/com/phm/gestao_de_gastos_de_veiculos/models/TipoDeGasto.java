package com.phm.gestao_de_gastos_de_veiculos.models;

public enum TipoDeGasto {
	MANUTENCAO_PREVENTIVA,
	MANUTENCAO_CORRETIVA,
	IMPOSTO,
	ACESSORIO,
	LIMPEZA,
	SEGURO,
	COMBUSTIVEL,
	OUTRO;
	
	public static String ToString(TipoDeGasto tipoDeGasto) {
		String tipoDeGastoString = switch(tipoDeGasto) {
		case MANUTENCAO_PREVENTIVA -> "Manuteção Preventiva";
		case MANUTENCAO_CORRETIVA -> "Manuteção Corretiva";
		case IMPOSTO -> "Imposto";
		case ACESSORIO -> "Acessório";
		case LIMPEZA -> "Limpeza";
		case SEGURO -> "Seguro";
		case COMBUSTIVEL -> "Combustível";
		default -> "Outros";
		};
		
		return tipoDeGastoString;
	}	
	
	/* public static String ToEnum(String tipoDeGastoString) {
		Enum tipoDeGasto = switch(tipoDeGastoString.toLowerCase()) {
		case "manutenção corretiva" -> TipoDeGasto.MANUTENCAO_PREVENTIVA,
		case "" -> TipoDeGasto.MANUTENCAO_CORRETIVA,
		case "" -> TipoDeGasto.IMPOSTO,
		case "" -> TipoDeGasto.ACESSORIO,
		case "" -> TipoDeGasto.LIMPEZA,
		case "" -> TipoDeGasto.SEGURO,
		case "" -> TipoDeGasto.COMBUSTIVEL,
		default -> TipoDeGasto.OUTROS;
		};
		
		return tipoDeGastoString;
	}	*/
}
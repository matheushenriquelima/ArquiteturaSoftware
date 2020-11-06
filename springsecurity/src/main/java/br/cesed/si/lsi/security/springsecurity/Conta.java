package br.cesed.si.lsi.security.springsecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

	private int conta;
	
	private int agencia;
	
	private String titular;
	
	private double saldo;
}

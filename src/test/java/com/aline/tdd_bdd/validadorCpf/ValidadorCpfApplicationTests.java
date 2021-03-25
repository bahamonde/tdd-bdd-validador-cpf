package com.aline.tdd_bdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aline.tdd_bdd.validadorCpf.models.Cliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	@DisplayName("Dado que eu faça um teste com CPF valido") //Descrição do que o teste faz
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("23177729042");
		assertEquals(true, cliente.validarCPF()); 
	}

	@Test
	void fazendoTesteDeCpfValidoComPonto() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("231.777.290-42");
		assertEquals(true, cliente.validarCPF()); 
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFIM() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("23177729042 ");
		assertEquals(true, cliente.validarCPF());  
	}

	@Test
	void fazendoTesteDeCpfMalucoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("231,777.290-42");
		assertEquals(true, cliente.validarCPF());  
	}

	@Test
	void fazendoTesteDeCpfInValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("23177729041");
		assertEquals(false, cliente.validarCPF());  
	}

	@Test
	void fazendoTesteDeCpfInValidoComPonto() {
		Cliente cliente = new Cliente();
		cliente.setNome("Aline");
		cliente.setCpf("231.777.290-41");
		assertEquals(false, cliente.validarCPF());
	}
			
}





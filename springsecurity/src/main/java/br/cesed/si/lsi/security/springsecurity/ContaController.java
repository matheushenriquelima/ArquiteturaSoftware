package br.cesed.si.lsi.security.springsecurity;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	List<Conta> contas = Arrays.asList(
			new Conta(123,123456,"Matheus",2000),
			new Conta(321,123213,"Henrique",3000)
	);
	
	
	@Secured({"ROLE_CORRENTISTA","ROLE_GERENTE"})
	@GetMapping("/{numeroConta}")
	public ResponseEntity<Conta> findById(@PathVariable int numeroConta){
		return new ResponseEntity<Conta> (new Conta(123,123456,"Matheus",2000),HttpStatus.OK);
	}
	
	@Secured({"ROLE_GERENTE"})
	@GetMapping()
	public ResponseEntity< List<Conta> > listar(){
		return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
	}
	
	@Secured({"ROLE_GERENTE"})
	@PostMapping()
	public ResponseEntity<Conta> criarConta(){
		return new ResponseEntity<Conta>(new Conta(312,128902,"Julia",1000),HttpStatus.CREATED);
	}

	@Secured({"ROLE_GERENTE"})
	@DeleteMapping("/{numeroConta}")
	public ResponseEntity<Conta> deletarConta(@PathVariable int numeroConta){
		return new ResponseEntity<Conta>(new Conta(312,128902,"Julia",1000),HttpStatus.OK);
	}
}

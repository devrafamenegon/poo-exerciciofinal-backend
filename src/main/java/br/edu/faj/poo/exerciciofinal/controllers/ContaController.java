package br.edu.faj.poo.exerciciofinal.controllers;

import br.edu.faj.poo.exerciciofinal.dtos.RequestLogin;
import br.edu.faj.poo.exerciciofinal.dtos.ResponseCadastrarLogin;
import br.edu.faj.poo.exerciciofinal.dtos.ResponseLogin;
import br.edu.faj.poo.exerciciofinal.dtos.ResponseObterContas;
import br.edu.faj.poo.exerciciofinal.entities.Conta;
import br.edu.faj.poo.exerciciofinal.errors.ContaErrors;
import br.edu.faj.poo.exerciciofinal.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping("/cadastrarLogin")
    public ResponseEntity<ResponseCadastrarLogin> cadastrar(@RequestBody Conta conta) {
        try {
            contaService.cadastrar(conta);
            return ResponseEntity.ok().body(new ResponseCadastrarLogin("OK", null));
        } catch (Exception e) {

            if (e instanceof ContaErrors.ContaJaExisteException) {
                return ResponseEntity.badRequest().body(new ResponseCadastrarLogin("NOK", "Usuário já existe"));
            }

            return ResponseEntity.internalServerError().body(new ResponseCadastrarLogin("NOK", "Erro inesperado"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin requestLogin) {
        try {
            contaService.logar(requestLogin);
            return ResponseEntity.ok().body(new ResponseLogin("OK", "adm", null));
        } catch (Exception e) {
            if (e instanceof ContaErrors.CredenciaisInvalidasException) {
                return ResponseEntity.badRequest().body(new ResponseLogin("NOK", null, "Senha inválida"));
            }

            return ResponseEntity.internalServerError().body(new ResponseLogin("NOK", null, "Erro inesperado"));
        }
    }

    @GetMapping("/conta")
    public ResponseEntity<ResponseObterContas> obter() {
        try {
            List<Conta> contas = contaService.obter();
            return ResponseEntity.ok().body(new ResponseObterContas("OK", contas, null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ResponseObterContas("NOK", null, "Erro inesperado"));
        }
    }
}

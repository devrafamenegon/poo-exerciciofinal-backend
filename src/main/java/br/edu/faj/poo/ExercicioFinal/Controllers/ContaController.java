package br.edu.faj.poo.ExercicioFinal.Controllers;

import br.edu.faj.poo.ExercicioFinal.Dtos.ResponseCadastrarLogin;
import br.edu.faj.poo.ExercicioFinal.Dtos.ResponseLogin;
import br.edu.faj.poo.ExercicioFinal.Entities.Conta;
import br.edu.faj.poo.ExercicioFinal.Errors.ContaErrors;
import br.edu.faj.poo.ExercicioFinal.Services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseLogin> login(@RequestBody Conta conta) {
        try {
            contaService.logar(conta);
            return ResponseEntity.badRequest().body(new ResponseLogin("OK", "adm", null));
        } catch (Exception e) {
            if (e instanceof ContaErrors.CredenciaisInvalidasException) {
                return ResponseEntity.badRequest().body(new ResponseLogin("NOK", null, "Senha inválida"));
            }

            return ResponseEntity.internalServerError().body(new ResponseLogin("NOK", null, "Erro inesperado"));
        }
    }
}

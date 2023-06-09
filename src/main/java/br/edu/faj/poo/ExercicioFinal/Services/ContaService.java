package br.edu.faj.poo.ExercicioFinal.Services;

import br.edu.faj.poo.ExercicioFinal.Entities.Conta;
import br.edu.faj.poo.ExercicioFinal.Errors.ContaErrors;
import br.edu.faj.poo.ExercicioFinal.Repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public Conta cadastrar(Conta conta) throws Exception {
        if (contaRepository.obterPorLogin(conta.getLogin()) != null) {
            throw new ContaErrors.ContaJaExisteException();
        }

        return contaRepository.cadastrar(conta);
    }

    public Conta logar(Conta conta) throws Exception {
        Conta contaCadastrada = contaRepository.obterPorLogin(conta.getLogin());

        if (contaCadastrada != null && contaCadastrada.getSenha().equals(conta.getSenha())) {
            return contaCadastrada;
        }

        throw new ContaErrors.CredenciaisInvalidasException();
    }
}

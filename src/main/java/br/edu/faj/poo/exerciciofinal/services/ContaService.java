package br.edu.faj.poo.exerciciofinal.services;

import br.edu.faj.poo.exerciciofinal.dtos.RequestLogin;
import br.edu.faj.poo.exerciciofinal.entities.Conta;
import br.edu.faj.poo.exerciciofinal.errors.ContaErrors;
import br.edu.faj.poo.exerciciofinal.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Conta logar(RequestLogin requestLogin) throws Exception {
        Conta contaCadastrada = contaRepository.obterPorLogin(requestLogin.login.toString());

        System.out.println(contaCadastrada);
        System.out.println(requestLogin.login);
        System.out.println(requestLogin.senha);
        if (contaCadastrada != null && contaCadastrada.getSenha().equals(requestLogin.senha.toString())) {
            return contaCadastrada;
        }

        throw new ContaErrors.CredenciaisInvalidasException();
    }

    public List<Conta> obter() throws Exception {
        return contaRepository.obter();
    }
}

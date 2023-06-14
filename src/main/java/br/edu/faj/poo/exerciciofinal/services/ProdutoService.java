package br.edu.faj.poo.exerciciofinal.services;

import br.edu.faj.poo.exerciciofinal.entities.Conta;
import br.edu.faj.poo.exerciciofinal.entities.Produto;
import br.edu.faj.poo.exerciciofinal.errors.ContaErrors;
import br.edu.faj.poo.exerciciofinal.errors.ProdutoErrors;
import br.edu.faj.poo.exerciciofinal.repositories.ContaRepository;
import br.edu.faj.poo.exerciciofinal.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ContaRepository contaRepository;

    public Produto cadastrar(Produto produto) throws Exception {
        if (contaRepository.obterPorId(produto.getConta_id()) == null) {
            throw new ContaErrors.ContaNaoExisteException();
        }

        return produtoRepository.cadastrar(produto);
    }

    public List<Produto> obter() throws Exception {
        return produtoRepository.obter();
    }

    public Produto obterPorId(int id) throws Exception {
        return produtoRepository.obterPorId(id);
    }

    public List<Produto> obterPorContaId(int contaId) throws Exception {
        return produtoRepository.obterPorContaId(contaId);
    }

    public List<Produto> obterPorContaLogin(String contaLogin) throws Exception {
        Conta conta = contaRepository.obterPorLogin(contaLogin);
        if (conta == null) {
            throw new ContaErrors.ContaNaoExisteException();
        }

        return produtoRepository.obterPorContaId(conta.getId());
    }

    public void excluir(int id) throws Exception {
        if (produtoRepository.obterPorId(id) == null) {
            throw new ProdutoErrors.ProdutoNaoExisteException();
        }

        produtoRepository.excluir(id);
    }
}

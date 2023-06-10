package br.edu.faj.poo.ExercicioFinal.Services;

import br.edu.faj.poo.ExercicioFinal.Entities.Conta;
import br.edu.faj.poo.ExercicioFinal.Entities.Produto;
import br.edu.faj.poo.ExercicioFinal.Errors.ContaErrors;
import br.edu.faj.poo.ExercicioFinal.Errors.ProdutoErrors;
import br.edu.faj.poo.ExercicioFinal.Repositories.ContaRepository;
import br.edu.faj.poo.ExercicioFinal.Repositories.ProdutoRepository;
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

    public void excluir(int id) throws Exception {
        if (produtoRepository.obterPorId(id) == null) {
            throw new ProdutoErrors.ProdutoNaoExisteException();
        }

        produtoRepository.excluir(id);
    }
}

package br.edu.faj.poo.exerciciofinal.controllers;

import br.edu.faj.poo.exerciciofinal.dtos.*;
import br.edu.faj.poo.exerciciofinal.entities.Produto;
import br.edu.faj.poo.exerciciofinal.errors.ContaErrors;
import br.edu.faj.poo.exerciciofinal.errors.ProdutoErrors;
import br.edu.faj.poo.exerciciofinal.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<ResponseCadastrarProduto> cadastrar(@RequestBody Produto produto) {
        try {
            produtoService.cadastrar(produto);
            return ResponseEntity.ok().body(new ResponseCadastrarProduto("OK", null));
        } catch (Exception e) {

            if (e instanceof ContaErrors.ContaNaoExisteException) {
                return ResponseEntity.badRequest().body(new ResponseCadastrarProduto("NOK", "Conta não existe"));
            }

            return ResponseEntity.internalServerError().body(new ResponseCadastrarProduto("NOK", "Erro inesperado"));
        }
    }

    @GetMapping("/produto")
    public ResponseEntity<ResponseObterProdutos> obter() {
        try {
            List<Produto> produtos = produtoService.obter();
            return ResponseEntity.ok().body(new ResponseObterProdutos("OK", produtos, null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ResponseObterProdutos("NOK", null, "Erro inesperado"));
        }
    }


    @GetMapping("/produto/conta/{contaId}")
    public ResponseEntity<ResponseObterProdutos> obterPorContaId(@PathVariable("contaId") int contaId) {
        try {
            List<Produto> produtos = produtoService.obterPorContaId(contaId);
            return ResponseEntity.ok().body(new ResponseObterProdutos("OK", produtos, null));
        } catch (Exception e) {
            if (e instanceof ContaErrors.ContaNaoExisteException) {
                return ResponseEntity.badRequest().body(new ResponseObterProdutos("NOK", null, "Conta não existe"));
            }

            return ResponseEntity.internalServerError().body(new ResponseObterProdutos("NOK", null, "Erro inesperado"));
        }
    }

    @GetMapping("/produto/conta/login/{contaLogin}")
    public ResponseEntity<ResponseObterProdutos> obterPorContaLogin(@PathVariable("contaLogin") String contaLogin) {
        try {
            List<Produto> produtos = produtoService.obterPorContaLogin(contaLogin);
            return ResponseEntity.ok().body(new ResponseObterProdutos("OK", produtos, null));
        } catch (Exception e) {
            if (e instanceof ContaErrors.ContaNaoExisteException) {
                return ResponseEntity.badRequest().body(new ResponseObterProdutos("NOK", null, "Conta não existe"));
            }

            return ResponseEntity.internalServerError().body(new ResponseObterProdutos("NOK", null, "Erro inesperado"));
        }
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ResponseObterProduto> obterPorId(@PathVariable("id") int id) {
        try {
            Produto produto = produtoService.obterPorId(id);
            return ResponseEntity.ok().body(new ResponseObterProduto("OK", produto, null));
        } catch (Exception e) {
            if (e instanceof ContaErrors.ContaNaoExisteException) {
                return ResponseEntity.badRequest().body(new ResponseObterProduto("NOK", null, "Produto não existe"));
            }

            return ResponseEntity.internalServerError().body(new ResponseObterProduto("NOK", null, "Erro inesperado"));
        }
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<ResponseExcluirProduto> excluir(@PathVariable("id") int id) {
        try {
            produtoService.excluir(id);
            return ResponseEntity.ok().body(new ResponseExcluirProduto("OK", null));
        } catch (Exception e) {
            if (e instanceof ProdutoErrors.ProdutoNaoExisteException) {
                return ResponseEntity.badRequest().body(new ResponseExcluirProduto("NOK",  "Produto não existe"));
            }
            return ResponseEntity.internalServerError().body(new ResponseExcluirProduto("NOK",  "Erro inesperado"));
        }
    }
}

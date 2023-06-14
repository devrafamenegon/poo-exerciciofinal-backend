package br.edu.faj.poo.exerciciofinal.errors;

public class ProdutoErrors {
    public static class ProdutoNaoExisteException extends RuntimeException {
        public ProdutoNaoExisteException() {
            super("Produto não existe!");
        }
    }
}

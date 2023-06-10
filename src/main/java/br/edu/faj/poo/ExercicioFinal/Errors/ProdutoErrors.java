package br.edu.faj.poo.ExercicioFinal.Errors;

public class ProdutoErrors {
    public static class ProdutoNaoExisteException extends RuntimeException {
        public ProdutoNaoExisteException() {
            super("Produto não existe!");
        }
    }
}

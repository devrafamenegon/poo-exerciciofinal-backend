package br.edu.faj.poo.exerciciofinal.errors;

public class ContaErrors {
    public static class ContaJaExisteException extends RuntimeException {
        public ContaJaExisteException() {
            super("Conta já existe!");
        }
    }

    public static class ContaNaoExisteException extends RuntimeException {
        public ContaNaoExisteException() {
            super("Conta não existe!");
        }
    }

    public static class CredenciaisInvalidasException extends RuntimeException {
        public CredenciaisInvalidasException() {
            super("Credenciais inválidas!");
        }
    }
}

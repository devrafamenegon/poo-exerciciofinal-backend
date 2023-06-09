package br.edu.faj.poo.ExercicioFinal.Errors;

public class ContaErrors {
    public static class ContaJaExisteException extends RuntimeException {
        public ContaJaExisteException() {
            super("Conta já existe!");
        }
    }

    public static class CredenciaisInvalidasException extends RuntimeException {
        public CredenciaisInvalidasException() {
            super("Credenciais inválidas!");
        }
    }
}

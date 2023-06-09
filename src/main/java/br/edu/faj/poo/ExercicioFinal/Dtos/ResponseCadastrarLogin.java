package br.edu.faj.poo.ExercicioFinal.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseCadastrarLogin {
    public String status;
    public String error;
}
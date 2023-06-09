package br.edu.faj.poo.ExercicioFinal.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseLogin {
    public String status;
    public String perfil;
    public String error;
}
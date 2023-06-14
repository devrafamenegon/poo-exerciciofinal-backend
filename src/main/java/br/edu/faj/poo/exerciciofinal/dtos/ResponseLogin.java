package br.edu.faj.poo.exerciciofinal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseLogin {
    public String status;
    public String perfil;
    public String error;
}
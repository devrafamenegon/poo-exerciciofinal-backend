package br.edu.faj.poo.ExercicioFinal.Dtos;

import br.edu.faj.poo.ExercicioFinal.Entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseExcluirProduto {
    public String status;
    public String error;
}
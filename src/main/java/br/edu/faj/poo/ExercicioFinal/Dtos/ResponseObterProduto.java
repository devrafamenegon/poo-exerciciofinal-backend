package br.edu.faj.poo.ExercicioFinal.Dtos;

import br.edu.faj.poo.ExercicioFinal.Entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseObterProduto {
    public String status;
    public Produto produto;
    public String error;
}
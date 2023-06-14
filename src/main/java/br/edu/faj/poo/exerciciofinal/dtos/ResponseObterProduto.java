package br.edu.faj.poo.exerciciofinal.dtos;

import br.edu.faj.poo.exerciciofinal.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObterProduto {
    public String status;
    public Produto produto;
    public String error;
}
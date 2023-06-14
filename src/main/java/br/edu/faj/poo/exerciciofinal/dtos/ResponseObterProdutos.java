package br.edu.faj.poo.exerciciofinal.dtos;

import br.edu.faj.poo.exerciciofinal.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseObterProdutos {
    public String status;
    public List<Produto> produtos;
    public String error;
}
package br.edu.faj.poo.exerciciofinal.dtos;

import br.edu.faj.poo.exerciciofinal.entities.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseObterContas {
    public String status;
    public List<Conta> contas;
    public String error;
}
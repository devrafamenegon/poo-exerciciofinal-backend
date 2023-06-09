package br.edu.faj.poo.ExercicioFinal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String quantidade;
    private Double valor;
    private int conta_id;
}

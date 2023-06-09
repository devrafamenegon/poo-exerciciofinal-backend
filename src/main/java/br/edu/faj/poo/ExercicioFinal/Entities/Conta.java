package br.edu.faj.poo.ExercicioFinal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    private int id;
    private String login;
    private String senha;
    private List<Produto> estoque;
}
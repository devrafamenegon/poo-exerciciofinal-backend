package br.edu.faj.poo.exerciciofinal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    private int id;
    private String login;
    private String senha;
}
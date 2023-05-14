package controllers;

import java.util.List;

import Models.Funcionario;
import data.Database;

public class FuncionarioController {
    private static List<Funcionario> funcionarios = Database.getFuncionarios();

    public static Funcionario buscaFuncionario(String nome) {
        return funcionarios.stream()
        .filter(c -> c.getNome().equals(nome))
        .findFirst()
        .orElse(null);
    }
}

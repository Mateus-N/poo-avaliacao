package Models.funcionarios;

import Models.funcionarios.cargos.TipoDeCargo;

public class Funcionario {
    private String nome;
    private TipoDeCargo cargo;
    private double salario;
    private String horarioDeTrabalho;

    public Funcionario(String nome, TipoDeCargo cargo, double salario, String horarioDeTrabalho) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.horarioDeTrabalho = horarioDeTrabalho;
    }

    public TipoDeCargo getCargo() {
        return cargo;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }
    public String getHorarioDeTrabalho() {
        return horarioDeTrabalho;
    }
}

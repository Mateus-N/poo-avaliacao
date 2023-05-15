package Models;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private String horarioDeTrabalho;

    public Funcionario(String nome, String cargo, double salario, String horarioDeTrabalho) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.horarioDeTrabalho = horarioDeTrabalho;
    }

    public String getCargo() {
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

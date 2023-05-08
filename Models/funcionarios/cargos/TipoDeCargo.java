package Models.funcionarios.cargos;

public abstract class TipoDeCargo {
    private String cargo;

    public TipoDeCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}

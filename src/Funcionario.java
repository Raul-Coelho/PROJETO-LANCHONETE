import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {

    private float salario;

    public Funcionario(String nome, String cpf, LocalDate nascimento, float salario) {
        super(nome, cpf, nascimento);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}

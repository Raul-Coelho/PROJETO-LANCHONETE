import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {

    private float salario;
    private int matricula;

    public Funcionario(String nome, String cpf, LocalDate nascimento, float salario, int matricula) {
        super(nome, cpf, nascimento);
        this.salario = salario;
        this.matricula = matricula;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}

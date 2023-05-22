import java.util.List;
import java.util.ArrayList;

// Criando listas individuais para cada caso de prioridade de fila.
public class GestaoHospitalar {
    private List<Paciente> filaSevero;
    private List<Paciente> filaModerado;
    private List<Paciente> filaNormal;
    private List<Paciente> filaLeve;

    // Convertendo cada lista previamente criada em ArrayList.
    public GestaoHospitalar() {
        filaSevero = new ArrayList<>();
        filaModerado = new ArrayList<>();
        filaNormal = new ArrayList<>();
        filaLeve = new ArrayList<>();
    }

    // Método de adição de pacientes pedindo nome, cpf e tipo de prioridade usando
    // switch para evitar vários "if" e "else".
    public void addPaciente(String nome, String cpf, int prioridade) {
        Paciente paciente = new Paciente(nome, cpf, prioridade);
        switch (prioridade) {
            case 3:
                filaSevero.add(paciente);
                break;

            case 2:
                filaModerado.add(paciente);
                break;

            case 1:
                filaNormal.add(paciente);
                break;

            default:
                filaLeve.add(paciente);
                break;
        }

        System.out.println("Paciente adicionado a lista com sucesso!");
    }

    // Método para verificar se há pacientes em alguma das filas. Caso não haja,
    // retornará uma mensagem retornando um valor nulo.
    public Paciente atenderProximoPaciente() {
        if (!filaSevero.isEmpty()) {
            return filaSevero.remove(0);
        } else if (!filaModerado.isEmpty()) {
            return filaModerado.remove(0);
        } else if (!filaNormal.isEmpty()) {
            return filaNormal.remove(0);
        } else if (!filaLeve.isEmpty()) {
            return filaLeve.remove(0);
        } else {
            System.out.println("Não há nenhum paciente na fila!");
            return null;
        }
    }

    // Método que retornará a soma da quantidade de pacientes em todas as filas.
    public int numPacientesNaFila() {
        return filaSevero.size() + filaModerado.size() + filaNormal.size() + filaLeve.size();
    }
}

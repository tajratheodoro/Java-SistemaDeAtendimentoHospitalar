import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestaoHospitalar sistemaHospitalar = new GestaoHospitalar();
        Scanner sc = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = lerOpcao(sc);

            switch (opcao) {
                case 1:
                    adicionarPaciente(sc, sistemaHospitalar);
                    break;
                case 2:
                    atenderProximoPaciente(sistemaHospitalar);
                    break;
                case 3:
                    exibirNumeroPacientesNaFila(sistemaHospitalar);
                    break;
                case 0:
                    System.out.println("Programa finalziado com sucesso!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n<--- Menu --->");
        System.out.println("1. Adicionar paciente na fila");
        System.out.println("2. Atender o próximo paciente");
        System.out.println("3. Exibir número total de pacientes na fila");
        System.out.println("0. Sair do Programa");
        System.out.print("Digite uma opção para continuar: ");
    }

    public static int lerOpcao(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Opção escolhida é inválida. Por favor, escolha uma opção válida.");
                sc.nextLine();
            }
        }
    }

    public static void adicionarPaciente(Scanner sc, GestaoHospitalar sistemaHospitalar) {
        sc.nextLine();
        System.out.print("Nome do paciente: ");
        String nome = sc.nextLine();
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        System.out.print("Prioridade do paciente (1 - leve, 2 - normal, 3 - moderado, 4 - severo): ");
        int prioridade = sc.nextInt();
        sistemaHospitalar.addPaciente(nome, cpf, prioridade);
    }

    public static void atenderProximoPaciente(GestaoHospitalar sistemaHospitalar) {
        Paciente paciente = sistemaHospitalar.atenderProximoPaciente();
        if (paciente != null) {
            System.out.println("<<< Próximo paciente a ser atendido >>>");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Prioridade: " + paciente.getPrioridade());
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    public static void exibirNumeroPacientesNaFila(GestaoHospitalar sistemaHospital) {
        int totalPacientes = sistemaHospital.numPacientesNaFila();
        System.out.printf("<<< Número de pacientes na fila: %d >>>%n", totalPacientes);
    }
}

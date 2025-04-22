import java.util.Scanner;

class Cliente {
    String nome;
    String sobrenome;
    String cpf;
    double saldo;

    // Construtor
    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    // Métodos
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Coleta dados do cliente
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = entrada.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = entrada.nextLine();

        // Criação do objeto cliente
        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        int opcao;
        do {
            // Exibe o menu
            System.out.println("\n====== Menu ======");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double deposito = entrada.nextDouble();
                    cliente.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: R$ ");
                    double saque = entrada.nextDouble();
                    cliente.sacar(saque);
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o sistema, " + cliente.nome + "! Até a próxima.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}

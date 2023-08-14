
package Programa;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaBancario {
    private Map<String, ContaBancaria> contas;

    public SistemaBancario() {
        contas = new HashMap<>();
    }

    public void criarConta(String numeroConta, String titularConta) {
        ContaBancaria conta = new ContaBancaria(numeroConta, titularConta);
        contas.put(numeroConta, conta);
        System.out.println("Conta criada para " + titularConta + " com número de conta " + numeroConta);
    }

    public ContaBancaria getConta(String numeroConta) {
        return contas.get(numeroConta);
    }
    public void realizarTransferencia(String numContaOrigem, String numContaDestino, double valor) {
        ContaBancaria contaOrigem = contas.get(numContaOrigem);
        ContaBancaria contaDestino = contas.get(numContaDestino);
        
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        } else {
            System.out.println("Conta(s) não encontrada(s).");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBancario sistemaBancario = new SistemaBancario();

        while (true) {
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. verificar saldo");
            System.out.println("5. transferir");
            System.out.println("6. encerrar");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    String numConta = scanner.nextLine();
                    System.out.print("Digite o nome do titular da conta: ");
                    String titularConta = scanner.nextLine();
                    sistemaBancario.criarConta(numConta, titularConta);
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    String numDepositoConta = scanner.nextLine();
                    ContaBancaria contaDeposito = sistemaBancario.getConta(numDepositoConta);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    String numSaqueConta = scanner.nextLine();
                    ContaBancaria contaSaque = sistemaBancario.getConta(numSaqueConta);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da conta: ");
                    String numVerificarSaldoConta = scanner.nextLine();
                    ContaBancaria contaVerificarSaldo = sistemaBancario.getConta(numVerificarSaldoConta);
                    if (contaVerificarSaldo != null) {
                        System.out.println("Saldo da conta: R$" + contaVerificarSaldo.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5: 
                    System.out.print("Digite o número da conta de origem: ");
                    String numContaOrigem = scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    String numContaDestino = scanner.nextLine();
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine(); 
                    sistemaBancario.realizarTransferencia(numContaOrigem, numContaDestino, valorTransferencia);
                    break;
                case 6: 
                    System.out.println("Encerrando o sistema bancário. Adeus!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Por favor, digite uma opção válida.");
            }
        }
    }
}


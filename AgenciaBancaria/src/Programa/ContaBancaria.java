package Programa;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ContaBancaria {
    private String numeroConta;
    private String titularConta;
    private double saldo;

    public ContaBancaria(String numeroConta, String titularConta) {
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente. Saldo atual: R$" + saldo);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso para a conta " + destino.numeroConta);
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
}
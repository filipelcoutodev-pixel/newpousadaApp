package br.com.senacead.pousadaappjpa.persistencia;


public class Caixa {

    

    private double entradas;
    private double gastos;
    private double saldo;

    public Caixa() {
    }

    public Caixa(double entradas, double gastos) {
        this.entradas = entradas;
        this.gastos = gastos;
        this.saldo = entradas - gastos;
    }

    // Getters e Setters
    public double getEntradas() {
        return entradas;
    }

    public void setEntradas(double entradas) {
        this.entradas = entradas;
        atualizarSaldo();
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
        atualizarSaldo();
    }

    public double getSaldo() {
        return saldo;
    }

    private void atualizarSaldo() {
        this.saldo = this.entradas - this.gastos;
    }
}

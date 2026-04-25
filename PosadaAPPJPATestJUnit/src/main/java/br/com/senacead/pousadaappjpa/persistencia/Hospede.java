
package br.com.senacead.pousadaappjpa.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "Hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String nome;
     private String cpf;
     private int idade;
     private String contato;
     private int numeroDeDias;
     private String identificacaoQuarto;
     private double saldo;

    public Hospede() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getNumeroDeDias() {
        return numeroDeDias;
    }

    public void setNumeroDeDias(int numeroDeDias) {
        this.numeroDeDias = numeroDeDias;
    }

    public String getIdentificacaoQuarto() {
        return identificacaoQuarto;
    }

    public void setIdentificacaoQuarto(String identificacaoQuarto) {
        this.identificacaoQuarto = identificacaoQuarto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}

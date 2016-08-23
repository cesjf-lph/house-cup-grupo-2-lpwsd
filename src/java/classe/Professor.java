/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aluno
 */
@Entity
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private String cpf;
    private int idade;
    private String capacitacao;
    private String areadeatuacao;

    public Professor() {
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

    public String getCapacitacao() {
        return capacitacao;
    }

    public void setCapacitacao(String capacitacao) {
        this.capacitacao = capacitacao;
    }

    public String getAreadeatuacao() {
        return areadeatuacao;
    }

    public void setAreadeatuacao(String areadeatuacao) {
        this.areadeatuacao = areadeatuacao;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", capacitacao=" + capacitacao + ", areadeatuacao=" + areadeatuacao + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author aluno
 */
public class Professor {
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

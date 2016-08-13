/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Grupo {
    private ArrayList<Aluno> alunos;
   //private Periodo periodo;
    private int pontosTotais;
    public Grupo(){
        
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    //public Periodo getPeriodo() {
    //    return periodo;
    //}

    //public void setPeriodo(Periodo periodo) {
    //    this.periodo = periodo;
    //}

    public int getPontosTotais() {
        return pontosTotais;
    }

    public void setPontosTotais(int pontosTotais) {
        this.pontosTotais = pontosTotais;
    }
    
}

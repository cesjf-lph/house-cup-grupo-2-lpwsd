/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Guilherme
 */
@Entity
public class Aluno extends Pessoa implements Serializable {

    private int pontos;
    //private Grupo grupo;
    //private Periodo periodo;
    private String evento;
    private int matricula;
    
    public Aluno(){
        
    }

   
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /*public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }*/

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
    
}

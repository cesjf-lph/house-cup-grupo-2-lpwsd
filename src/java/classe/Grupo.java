/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Guilherme
 */
@Entity
public class Grupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Aluno> alunos;
   //private Periodo periodo;
    //private int pontosTotais;
    public Grupo(){
        
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    //public Periodo getPeriodo() {
    //    return periodo;
    //}

    //public void setPeriodo(Periodo periodo) {
    //    this.periodo = periodo;
    //}

    //public int getPontosTotais() {
    //    return pontosTotais;
    //}

   // public void setPontosTotais(int pontosTotais) {
    //    this.pontosTotais = pontosTotais;
   // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

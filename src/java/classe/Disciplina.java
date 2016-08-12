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
public class Disciplina {

    private Float media;
    private String prequisito;
    private Periodo periodo;
    private String status;

    public Disciplina() {
    }
    
 
    
    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public String getPrequisito() {
        return prequisito;
    }

    public void setPrequisito(String prequisito) {
        this.prequisito = prequisito;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "media=" + media + ", prequisito=" + prequisito + ", periodo=" + periodo + ", status=" + status + '}';
    }
    
    
}

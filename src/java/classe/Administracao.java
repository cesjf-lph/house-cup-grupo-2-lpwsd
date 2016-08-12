
package classe;

/**
 *
 * @author denner
 */
public class Administracao {
    
    private String Nome;
    private String cpf;
    private String idade;
    private int pontos;
    private String Area;

    public Administracao() {
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    @Override
    public String toString() {
        return "Administracao{" + "Nome=" + Nome + ", cpf=" + cpf + ", idade=" + idade + ", pontos=" + pontos + ", Area=" + Area + '}';
    }
    
    
    
}

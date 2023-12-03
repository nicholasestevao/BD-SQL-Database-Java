
package sistemaplanetario;

public class BaseEspacial {
    private int planeta;
    
    private String nomePlaneta;
    
    private String nome;

    public BaseEspacial(int planeta, String nomePlaneta, String nome) {
        this.planeta = planeta;
        this.nomePlaneta = nomePlaneta;
        this.nome = nome;
    }

    

    public void setPlaneta(int planeta) {
        this.planeta = planeta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPlaneta() {
        return planeta;
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    public String toString() { 
        return nomePlaneta + " - " + nome;
    } 
}

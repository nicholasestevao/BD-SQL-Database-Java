
package trabalhobd;

public class SistemaPlanetario {
    private String nome;
    
    private String galaxia;

    public SistemaPlanetario(String nome, String galaxia) {
        this.nome = nome;
        this.galaxia = galaxia;
    }
    
    public String toString() { 
        return nome + " - " + galaxia;
    } 

    public String getNome() {
        return nome;
    }

    public String getGalaxia() {
        return galaxia;
    }
}

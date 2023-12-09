package sistemaplanetario;

/**
 * Classe que representa um sistema planetário.
 */
public class SistemaPlanetario {
    /**
     * O nome do sistema planetário.
     */
    private String nome;
    
    /**
     * A galáxia do sistema planetário.
     */
    private String galaxia;

    /**
     * Cria um novo sistema planetário com o nome e a galáxia especificados.
     *
     * @param nome o nome do sistema planetário.
     * @param galaxia a galáxia do sistema planetário.
     */
    public SistemaPlanetario(String nome, String galaxia) {
        this.nome = nome;
        this.galaxia = galaxia;
    }
    
    /**
     * Retorna uma representação em string deste sistema planetário.
     *
     * @return uma representação em string deste sistema planetário.
     */
    public String toString() { 
        return nome + " - " + galaxia;
    } 

    /**
     * Retorna o nome deste sistema planetário.
     *
     * @return o nome deste sistema planetário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a galáxia deste sistema planetário.
     *
     * @return a galáxia deste sistema planetário.
     */
    public String getGalaxia() {
        return galaxia;
    }
}


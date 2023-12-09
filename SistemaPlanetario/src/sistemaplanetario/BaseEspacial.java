package sistemaplanetario;

/**
 * Classe que representa uma base espacial.
 */
public class BaseEspacial {
    /**
     * O identificador do planeta ao qual esta base espacial pertence.
     */
    private int planeta;
    
    /**
     * O nome do planeta ao qual esta base espacial pertence.
     */
    private String nomePlaneta;
    
    /**
     * O nome desta base espacial.
     */
    private String nome;

    /**
     * Cria uma nova base espacial com o identificador do planeta, o nome do planeta e o nome especificados.
     *
     * @param planeta o identificador do planeta ao qual esta base espacial pertence.
     * @param nomePlaneta o nome do planeta ao qual esta base espacial pertence.
     * @param nome o nome desta base espacial.
     */
    public BaseEspacial(int planeta, String nomePlaneta, String nome) {
        this.planeta = planeta;
        this.nomePlaneta = nomePlaneta;
        this.nome = nome;
    }

    /**
     * Define o identificador do planeta ao qual esta base espacial pertence.
     *
     * @param planeta o identificador do planeta ao qual esta base espacial pertence.
     */
    public void setPlaneta(int planeta) {
        this.planeta = planeta;
    }

    /**
     * Define o nome desta base espacial.
     *
     * @param nome o nome desta base espacial.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o identificador do planeta ao qual esta base espacial pertence.
     *
     * @return o identificador do planeta ao qual esta base espacial pertence.
     */
    public int getPlaneta() {
        return planeta;
    }

    /**
     * Retorna o nome do planeta ao qual esta base espacial pertence.
     *
     * @return o nome do planeta ao qual esta base espacial pertence.
     */
    public String getNomePlaneta() {
        return nomePlaneta;
    }

    /**
     * Retorna o nome desta base espacial.
     *
     * @return o nome desta base espacial.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna uma representação em string desta base espacial.
     *
     * @return uma representação em string desta base espacial.
     */
    public String toString() { 
        return nomePlaneta + " - " + nome;
    } 
}
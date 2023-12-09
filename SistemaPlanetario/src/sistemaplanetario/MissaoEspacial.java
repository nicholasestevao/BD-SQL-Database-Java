package sistemaplanetario;

/**
 * Classe que representa uma missão espacial.
 */
public class MissaoEspacial {
    /**
     * O identificador da missão espacial.
     */
    private int id;
    
    /**
     * O identificador do planeta base da missão espacial.
     */
    private int idPlanetaBase;
    
    /**
     * O nome da base espacial da missão espacial.
     */
    private String nomeBase;
    
    /**
     * O nome da missão espacial.
     */
    private String nome;
    
    /**
     * A data de início da missão espacial.
     */
    private String dataInicio;
    
    /**
     * A data de término da missão espacial.
     */
    private String dataFim;
    
    /**
     * A descrição da missão espacial.
     */
    private String descricao;
    
    /**
     * O tamanho da tripulação da missão espacial.
     */
    private int tamTripulacao;
    
    /**
     * O objetivo da missão espacial.
     */
    private String objetivo;
    
    /**
     * A duração estimada da missão espacial.
     */
    private int duracao;
    
    /**
     * O nível de periculosidade da missão espacial.
     */
    private int nivelPerigo;

    /**
     * Cria uma nova missão espacial com o identificador, identificador do planeta base, nome da base espacial, nome, data de início, data de término, descrição, tamanho da tripulação, objetivo, duração estimada e nível de periculosidade especificados.
     *
     * @param id o identificador da missão espacial.
     * @param idPlanetaBase o identificador do planeta base da missão espacial.
     * @param nomeBase o nome da base espacial da missão espacial.
     * @param nome o nome da missão espacial.
     * @param dataInicio a data de início da missão espacial.
     * @param dataFim a data de término da missão espacial.
     * @param descricao a descrição da missão espacial.
     * @param tamTripulacao o tamanho da tripulação da missão espacial.
     * @param objetivo o objetivo da missão espacial.
     * @param duracao a duração estimada da missão espacial.
     * @param nivelPerigo o nível de periculosidade da missão espacial.
     */
    public MissaoEspacial(int id, int idPlanetaBase, String nomeBase, String nome, String dataInicio, String dataFim, String descricao, int tamTripulacao, String objetivo, int duracao, int nivelPerigo) {
        this.id = id;
        this.idPlanetaBase = idPlanetaBase;
        this.nomeBase = nomeBase;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.tamTripulacao = tamTripulacao;
        this.objetivo = objetivo;
        this.duracao = duracao;
        this.nivelPerigo = nivelPerigo;
    }

    /**
     * Retorna o identificador desta missão espacial.
     *
     * @return o identificador desta missão espacial.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador desta missão espacial.
     *
     * @param id o identificador desta missão espacial.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o identificador do planeta base desta missão espacial.
     *
     * @return o identificador do planeta base desta missão espacial.
     */
    public int getIdPlanetaBase() {
        return idPlanetaBase;
    }

    /**
     * Define o identificador do planeta base desta missão espacial.
     *
     * @param idPlanetaBase o identificador do planeta base desta missão espacial.
     */
    public void setIdPlanetaBase(int idPlanetaBase) {
        this.idPlanetaBase = idPlanetaBase;
    }

    /**
     * Retorna o nome da base espacial desta missão espacial.
     *
     * @return o nome da base espacial desta missão espacial.
     */
    public String getNomeBase() {
        return nomeBase;
    }

        /**
     * Define o nome da base espacial desta missão espacial.
     *
     * @param nomeBase o nome da base espacial desta missão espacial.
     */
    public void setNomeBase(String nomeBase) {
        this.nomeBase = nomeBase;
    }

    /**
     * Retorna o nome desta missão espacial.
     *
     * @return o nome desta missão espacial.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome desta missão espacial.
     *
     * @param nome o nome desta missão espacial.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a data de início desta missão espacial.
     *
     * @return a data de início desta missão espacial.
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * Define a data de início desta missão espacial.
     *
     * @param dataInicio a data de início desta missão espacial.
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Retorna a data de término desta missão espacial.
     *
     * @return a data de término desta missão espacial.
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * Define a data de término desta missão espacial.
     *
     * @param dataFim a data de término desta missão espacial.
     */
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Retorna a descrição desta missão espacial.
     *
     * @return a descrição desta missão espacial.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição desta missão espacial.
     *
     * @param descricao a descrição desta missão espacial.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o tamanho da tripulação desta missão espacial.
     *
     * @return o tamanho da tripulação desta missão espacial.
     */
    public int getTamTripulacao() {
        return tamTripulacao;
    }

    /**
     * Define o tamanho da tripulação desta missão espacial.
     *
     * @param tamTripulacao o tamanho da tripulação desta missão espacial.
     */
    public void setTamTripulacao(int tamTripulacao) {
        this.tamTripulacao = tamTripulacao;
    }

    /**
     * Retorna o objetivo desta missão espacial.
     *
     * @return o objetivo desta missão espacial.
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * Define o objetivo desta missão espacial.
     *
     * @param objetivo o objetivo desta missão espacial.
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Retorna a duração estimada desta missão espacial.
     *
     * @return a duração estimada desta missão espacial.
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Define a duração estimada desta missão espacial.
     *
     * @param duracao a duração estimada desta missão espacial.
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Retorna o nível de periculosidade desta missão espacial.
     *
     * @return o nível de periculosidade desta missão espacial.
     */
    public int getNivelPerigo() {
        return nivelPerigo;
    }

    /**
     * Define o nível de periculosidade desta missão espacial.
     *
     * @param nivelPerigo o nível de periculosidade desta missão espacial.
     */
    public void setNivelPerigo(int nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }   
}
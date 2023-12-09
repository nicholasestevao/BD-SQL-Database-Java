package sistemaplanetario;

/**
 * Classe que representa um planeta.
 */
public class Planeta {
    /**
     * O identificador do planeta.
     */
    int id;
    
    /**
     * O sistema planetário ao qual o planeta pertence.
     */
    String sistemaPlanetario;
    
    /**
     * A galáxia à qual o planeta pertence.
     */
    String galaxia;
    
    /**
     * O nome do planeta.
     */
    String nome;
    
    /**
     * A temperatura do planeta.
     */
    float temperatura;
    
    /**
     * A pressão do planeta.
     */
    float pressao;
    
    /**
     * O clima do planeta.
     */
    String clima;

    /**
     * Cria um novo planeta com o identificador, sistema planetário, galáxia, nome, temperatura, pressão e clima especificados.
     *
     * @param id o identificador do planeta.
     * @param sistemaPlanetario o sistema planetário ao qual o planeta pertence.
     * @param galaxia a galáxia à qual o planeta pertence.
     * @param nome o nome do planeta.
     * @param temperatura a temperatura do planeta.
     * @param pressao a pressão do planeta.
     * @param clima o clima do planeta.
     */
    public Planeta(int id, String sistemaPlanetario, String galaxia, String nome, float temperatura, float pressao, String clima){
        this.id = id;
        this.sistemaPlanetario = sistemaPlanetario;
        this.galaxia = galaxia;
        this.nome = nome;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.clima = clima;
    }

    /**
     * Define o identificador deste planeta.
     *
     * @param id o identificador deste planeta.
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Define o sistema planetário ao qual este planeta pertence.
     *
     * @param sistemaPlanetario o sistema planetário ao qual este planeta pertence.
     */
    public void setSistemaPlanetario(String sistemaPlanetario){
        this.sistemaPlanetario = sistemaPlanetario;
    }

    /**
     * Define o nome deste planeta.
     *
     * @param nome o nome deste planeta.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Define a temperatura deste planeta.
     *
     * @param temperatura a temperatura deste planeta.
     */
    public void setTemperatura(float temperatura){
        this.temperatura = temperatura;
    }

    /**
     * Define a pressão deste planeta.
     *
     * @param pressao a pressão deste planeta.
     */
    public void setPressao(float pressao){
        this.pressao = pressao;
    }

    /**
     * Define o clima deste planeta.
     *
     * @param clima o clima deste planeta.
     */
    public void setClima(String clima){
        this.clima = clima;
    }

    /**
     * Retorna o identificador deste planeta.
     *
     * @return o identificador deste planeta.
     */
    public int getId(){
        return id;
    }

    /**
     * Retorna o sistema planetário ao qual este planeta pertence.
     *
     * @return o sistema planetário ao qual este planeta pertence.
     */
    public String getSistemaPlanetario(){
        return sistemaPlanetario;
    }

    /**
     * Retorna a galáxia à qual este planeta pertence.
     *
     * @return a galáxia à qual este planeta pertence.
     */
    public String getGalaxia(){
        return galaxia;
    }

    /**
     * Retorna o nome deste planeta.
     *
     * @return o nome deste planeta.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna a temperatura deste planeta.
     *
     * @return a temperatura deste planeta.
     */
    public float getTemperatura(){
        return temperatura;
    }

    /**
     * Retorna a pressão deste planeta.
     *
     * @return a pressão deste planeta.
     */
    public float getPressao(){
        return pressao;
    }

    /**
     * Retorna o clima deste planeta.
     *
     * @return o clima deste planeta.
     */
    public String getClima(){
        return clima;
    }
}
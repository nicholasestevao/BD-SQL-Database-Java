package sistemaplanetario;

public class Planeta {
    private int id;
    private String sistemaPlanetario;
    private String galaxia;
    private String nome;
    private float temperatura;
    private float pressao;
    private String clima;

    public Planeta(int id, String sistemaPlanetario, String galaxia, String nome, float temperatura, float pressao, String clima){
        this.id = id;
        this.sistemaPlanetario = sistemaPlanetario;
        this.galaxia = galaxia;
        this.nome = nome;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.clima = clima;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setSistemaPlanetario(String sistemaPlanetario){
        this.sistemaPlanetario = sistemaPlanetario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTemperatura(float temperatura){
        this.temperatura = temperatura;
    }

    public void setPressao(float pressao){
        this.pressao = pressao;
    }

    public void setClima(String clima){
        this.clima = clima;
    }

    public int getId(){
        return id;
    }

    public String getSistemaPlanetario(){
        return sistemaPlanetario;
    }

    public String getGalaxia(){
        return galaxia;
    }

    public String getNome(){
        return nome;
    }

    public float getTemperatura(){
        return temperatura;
    }

    public float getPressao(){
        return pressao;
    }

    public String getClima(){
        return clima;
    }
}

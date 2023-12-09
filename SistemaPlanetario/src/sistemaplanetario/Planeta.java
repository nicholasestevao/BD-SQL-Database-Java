package sistemaplanetario;

public class Planeta {
    int id;
    String sistemaPlanetario;
    String galaxia;
    String nome;
    float temperatura;
    float pressao;
    String clima;

    public Planeta(int id, String sistemaPlanetario, String galaxia, String nome, float temperatura, float pressao, String clima){
        this.id = id;
        this.sistemaPlanetario = sistemaPlanetario;
        this.nome = nome;
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.clima = clima;
    }
}


package trabalhobd;

public class MissaoEspacial {
    //System.out.println(rs.getInt(1)+" "+ rs.getInt(2)+" "+ rs.getString(3)+" "+ rs.getString(4)+" "+ rs.getDate(5)+" "+ rs.getDate(6)+" "+ rs.getString(7)+" "+ rs.getInt(8)+" "+ rs.getString(9)+" "+ rs.getInt(10)+" "+ rs.getInt(11));  
    private int id;
    private int idPlanetaBase;
    private String nomeBase;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String descricao;
    private int tamTripulacao;
    private String objetivo;
    private int duracao;
    private int nivelPerigo;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlanetaBase() {
        return idPlanetaBase;
    }

    public void setIdPlanetaBase(int idPlanetaBase) {
        this.idPlanetaBase = idPlanetaBase;
    }

    public String getNomeBase() {
        return nomeBase;
    }

    public void setNomeBase(String nomeBase) {
        this.nomeBase = nomeBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTamTripulacao() {
        return tamTripulacao;
    }

    public void setTamTripulacao(int tamTripulacao) {
        this.tamTripulacao = tamTripulacao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(int nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }
    
    
    
}

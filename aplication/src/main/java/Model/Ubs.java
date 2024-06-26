package Model;

public class Ubs {
    private int id;
    private String nome;
    private String email;
    private String localizacao;
    private String telefone;

    // Construtor
    public Ubs(int id, String nome, String email, String localizacao, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

package Model;
import DAO.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String idade;
    private String sexo;
    private String endereco;
    private String telefone;
    private String cpf;
    private String sus;


    public Usuario(String nome, String email, String senha, String idade, String sexo, String endereco, String telefone, String cpf, String sus) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.sus = sus;
    }

    public Usuario() {
        //TODO Auto-generated constructor stub
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdade() {
        return idade;
    
    }
    public void  setIdade(String idade){
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }
}


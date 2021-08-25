/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Luis Gustavo
 */
public class Ajudante {

    private int Id;
    private String nome;
    private String sexo;
    private String dataInicio;
    private String cidade;
    private String estado;
    private int idade;

    public Ajudante(int Id, String Nome, String Sexo, String DataInicio, String Cidade, String Estado, int Idade) {

        this.Id = Id;
        this.nome = Nome;
        this.sexo = Sexo;
        this.dataInicio = DataInicio;
        this.cidade = Cidade;
        this.estado = Estado;
        this.idade = Idade;
    }
    
    public Ajudante(){};

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}

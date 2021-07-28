
package Model;


public class Usuario {
    private int Id;
    private String user;
    private String senha;
    private String nome;
    private String sexo;
    

    public int getId() {
        return Id;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }    
}

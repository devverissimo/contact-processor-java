package model;

public class Contato  {
    private String nome;
    private Integer idade;
    private String email;
    private String telefone;
    private boolean ativo;
    private String cidade;

    public Contato(){
    }

    public Contato(String nome, Integer idade, String email, String telefone,boolean ativo, String cidade){
        this.nome = nome;
        this.idade = idade;
        this.email =email;
        this.telefone = telefone;
        this.ativo = ativo;
        this.cidade = cidade;
    }

    //Getters
    public String getNome(){
        return nome;
    }
    public Integer getIdade(){
        return idade;
    }
    public String getEmail(){
        return email;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString(){
        return String.format("Contato{nome'%s', idade='%s', email='%s, telefone=%s, ativo=%s, cidade=%s}",
                nome,
                idade != null ? idade : "N/A",
                email,
                telefone != null ? telefone : "N/A",
                ativo ? "sim" : "nao",
                cidade != null ?  cidade : "N/A"
        );
    }
}

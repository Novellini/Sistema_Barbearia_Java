
package modelo;


public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String sexo;
    private String DtNascimento;
    
    //construtor vazio
    public Cliente(){}
    //construtor completo
    public Cliente(String nome, String cpf, String sexo, String DtNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.DtNascimento = DtNascimento;
    }
    
    //getters e setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    
    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    
    public String getDataNascimento() { return DtNascimento; }
    public void setDataNascimento(String d) { this.DtNascimento = d; }
    
    
}

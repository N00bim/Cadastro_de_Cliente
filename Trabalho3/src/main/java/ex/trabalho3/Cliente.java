package ex.trabalho3;

public class Cliente {
    private static int numerador;
    private int codigo;
    private String nome;
    private Endereco endereco;
    private String telefone;

    public Cliente(String nome, Endereco endereço, String telefone) {
        numerador++;
        codigo = numerador;
        this.nome = nome;
        this.endereco = endereço;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}

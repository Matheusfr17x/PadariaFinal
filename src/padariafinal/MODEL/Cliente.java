package padariafinal.MODEL;

public class Cliente {
    private int idCliente;
    private String nome;
    private String CPF;
    private String email;

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public Cliente(int idCliente, String nome, String CPF, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
    }

    public Cliente(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
    }
    
    
}

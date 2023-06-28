package padariafinal.MODEL;

public class Venda {
    private int idCliente;
    private int idProduto;
    private String data;
    private int quantidade;

    public Venda(int idCliente, int idProduto, String data, int quantidade) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Venda(int idCliente, int idProduto, int quantidade) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
       
        this.quantidade = quantidade;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getData() {
        return data;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    
    
}

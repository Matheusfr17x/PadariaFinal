
package padariafinal.DB;

import padariafinal.MODEL.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProdutoDB {
    public boolean hasVenda(int idProduto){
        boolean res = false;
        String sql = "SELECT * FROM venda where idproduto=" + idProduto;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                res=true;
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public Produto getProduto(int idProduto) {
        Produto produto = null;

        String sql = "SELECT * FROM produto where idproduto=" + idProduto;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                float preco = rs.getFloat("preco");
                produto = new Produto(idProduto, nome, descricao, preco);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        String sql = "SELECT * FROM produto";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                float preco = rs.getFloat("preco");
                Produto produto= new Produto(idProduto, nome, descricao, preco);
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB .class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    public boolean insert(Produto produto) {
        boolean res = false;

        //INSERT INTO cliente (nome,CPF,email) VALUES ('rodrigo', '1233433', 'rodrigo@gmail.com');
        String sql = "INSERT INTO produto (nome,descricao,preco) VALUES ('" + produto.getNome() + "', '" + produto.getDescricao() + "', '" + produto.getPreco() + "')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean delete(int idProduto) {
        boolean res = false;
        String sql = "DELETE FROM produto where (idProduto ='" + idProduto + "')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean update(Produto produto) {
        boolean res = false;
        
      
        String sql = "UPDATE produto SET nome='"+produto.getNome()+"',descricao='"+produto.getDescricao()+"', preco='"+produto.getPreco()+"' WHERE idproduto='"+produto.getIdProduto()+"';";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}

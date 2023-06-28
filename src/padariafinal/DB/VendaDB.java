package padariafinal.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import padariafinal.MODEL.Venda;

public class VendaDB {

    public ArrayList<Venda> getVendas() {
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        String sql = "SELECT * FROM venda";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                int idCliente = rs.getInt("idCliente");
                String data = rs.getString("data");
                int quantidade = rs.getInt("quantidade");
                Venda venda = new Venda(idCliente, idProduto, data, quantidade);

                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public boolean insert(Venda venda) {
        boolean res = false;

        //INSERT INTO cliente (nome,CPF,email) VALUES ('rodrigo', '1233433', 'rodrigo@gmail.com');
        String sql = "INSERT INTO venda (idCliente,idProduto,data,quantidade) VALUES ('" + venda.getIdCliente() + "', '" + venda.getIdProduto() + "',now(), '"+venda.getQuantidade()+"')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDB .class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean delete(int idCliente,int idProduto) {
        boolean res = false;
        String sql = "DELETE FROM venda where (idProduto ='" + idProduto + "') and (idCliente ='" + idCliente + "')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean update(Venda venda) {
        boolean res = false;

        String sql = "UPDATE venda SET data='" + venda.getData() + "',quantidade='" + venda.getQuantidade() + "' WHERE idProduto ='" + venda.getIdProduto() + "' and idCliente ='" + venda.getIdCliente() + "';";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}

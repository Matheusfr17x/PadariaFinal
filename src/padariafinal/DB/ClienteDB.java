package padariafinal.DB;

import padariafinal.MODEL.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDB {

    public boolean hasVenda(int idCliente){
        boolean res = false;
        String sql = "SELECT * FROM venda where idcliente=" + idCliente;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                res=true;
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public Cliente getCliente(int idCliente) {
        Cliente cliente = null;

        String sql = "SELECT * FROM cliente where idcliente=" + idCliente;
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String CPF = rs.getString("CPF");
                String email = rs.getString("email");
                cliente = new Cliente(idCliente, nome, CPF, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        String sql = "SELECT * FROM cliente";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String CPF = rs.getString("CPF");
                String email = rs.getString("email");
                Cliente cliente = new Cliente(idCliente, nome, CPF, email);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public boolean insert(Cliente cliente) {
        boolean res = false;

        //INSERT INTO cliente (nome,CPF,email) VALUES ('rodrigo', '1233433', 'rodrigo@gmail.com');
        String sql = "INSERT INTO cliente (nome,CPF,email) VALUES ('" + cliente.getNome() + "', '" + cliente.getCPF() + "', '" + cliente.getEmail() + "')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean delete(int idCliente) {
        boolean res = false;
        String sql = "DELETE FROM cliente where (idCliente ='" + idCliente + "')";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean update(Cliente cliente) {
        boolean res = false;
        
        //UPDATE cliente SET nome='MAria da Luz Sousa Paz2',CPF='2112220012', email='maria@ifsp.com.br2' WHERE idCliente=1;
        String sql = "UPDATE cliente SET nome='"+cliente.getNome()+"',CPF='"+cliente.getCPF()+"', email='"+cliente.getEmail()+"' WHERE idCliente='"+cliente.getIdCliente()+"';";
        System.out.println(sql);
        Connection conn = DBConnectionManager.getConnection();

        try {
            conn.createStatement().execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Clientes;
import br.com.projeto.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LucasVerly
 */
public class VendaDAO {

    private final Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarVenda(Venda venda) throws SQLException {
        String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, venda.getCliente().getId());
        statement.setString(2, venda.getDataVenda());
        statement.setString(3, String.valueOf(venda.getTotal_venda()));
        
        statement.execute();
        
    }

    public int retornaIdVenda() throws SQLException {
        int idVenda = 0;
        String sql = "select max(id) id from tb_vendas";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()){
            Venda venda = new Venda();
            venda.setId(result.getInt("id"));
            idVenda = venda.getId();
        }
        return idVenda;
        
    }

    public ArrayList<Venda> listarVendaPorPeriodo(String dataInicial, String dataFinal) throws SQLException {
        ArrayList lista = new ArrayList();
        
        String sql = "SELECT d.id, d.data_venda, c.nome, d.total_venda\n" +
                    "FROM tb_vendas as d\n" +
                    "INNER JOIN tb_clientes as c ON (d.cliente_id = c.id)\n" +
                    "WHERE STR_TO_DATE(d.data_venda, '%d/%m/%Y') BETWEEN STR_TO_DATE(?, '%d/%m/%Y') AND STR_TO_DATE(?, '%d/%m/%Y');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dataInicial);
        statement.setString(2, dataFinal);
        ResultSet result = statement.executeQuery();
        
        while (result.next()){
            Venda venda = new Venda();
            Clientes cliente = new Clientes();
            
            venda.setId(result.getInt("id"));
            venda.setDataVenda(result.getString("data_venda"));
            cliente.setNome(result.getString("nome"));
            venda.setCliente(cliente);
            venda.setTotal_venda(Double.parseDouble(result.getString("total_venda")));
            lista.add(venda);
        }
        return lista;
    }

    public ArrayList<Venda> listarVendas() throws SQLException {
        ArrayList lista = new ArrayList();
        
        String sql = "select d.id, d.data_venda, c.nome, d.total_venda from tb_vendas as d inner join tb_clientes as c on ( d.cliente_id = c.id) order by d.id ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        
        ResultSet result = statement.executeQuery();
        
        while (result.next()){
            Venda venda = new Venda();
            Clientes cliente = new Clientes();
            
            venda.setId(result.getInt("id"));
            venda.setDataVenda(result.getString("data_venda"));
            cliente.setNome(result.getString("nome"));
            venda.setCliente(cliente);
            venda.setTotal_venda(Double.parseDouble(result.getString("total_venda")));
            lista.add(venda);
        }
        return lista;
    }
    
    
    
}

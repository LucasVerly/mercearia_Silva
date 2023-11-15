/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    
    
}

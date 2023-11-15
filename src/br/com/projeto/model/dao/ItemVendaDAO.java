/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LucasVerly
 */
public class ItemVendaDAO {

    private final Connection connection;

    public ItemVendaDAO(Connection connection) {
        this.connection = connection;
    }
    
    

    public void cadastrarItem(ItemVenda item) throws SQLException {
        String sql = "insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal) values (?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, item.getVenda().getId());
        statement.setInt(2, item.getProduto().getId());
        statement.setString(3, String.valueOf(item.getQtd()));
        statement.setString(4, String.valueOf(item.getSubtotal()));
        
        statement.execute();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<ItemVenda> listaItensComprados(int idVenda) throws SQLException {
        
        ArrayList <ItemVenda> lista = new ArrayList();
        
        String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i inner join tb_produtos as p on i.produto_id = p.id where i.venda_id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idVenda);
        
        ResultSet result = statement.executeQuery();
        
        while (result.next()){
            ItemVenda item = new ItemVenda();
            Produto p = new Produto();
            p.setNomeProduto(result.getString("p.descricao"));
            p.setPreco(Double.parseDouble(result.getString("p.preco")));
            item.setProduto(p);
            item.setId(result.getInt("i.id"));
            item.setQtd(Integer.parseInt(result.getString("i.qtd")));
            item.setSubtotal(Double.parseDouble(result.getString("i.subtotal")));
            lista.add(item);
        }
        return lista;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author CSFXLAB
 */
public class ProdutoDAO {

    private final Connection connection;
    
    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }
    
    public void insertProduto (Produto produto) throws SQLException {
        String sql = "insert into tb_produtos (descricao,preco,qtd_estoque,ativo,for_id)"
                + "values (?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, produto.getNomeProduto());
        statement.setString(2, Double.toString(produto.getPreco()));
        statement.setString(3, Integer.toString(produto.getQtd_estoque()));
        statement.setString(4, produto.getAtivo());
        statement.setString(5, Integer.toString(produto.getFornecedor().getId()));
        
        statement.execute();
    }
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        statement.setInt(5, produto.getFornecedor().getId());
        
        statement.execute();
    }
    
    private ArrayList<Produto> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            Produto produtoComDadosDoBanco = new Produto();
            produtoComDadosDoBanco.setId(resultSet.getInt("id"));
            produtoComDadosDoBanco.setNomeProduto(resultSet.getString("descricao"));
            produtoComDadosDoBanco.setPreco(Double.parseDouble(resultSet.getString("preco")));
            produtoComDadosDoBanco.setQtd_estoque(Integer.parseInt(resultSet.getString("qtd_estoque")));
            produtoComDadosDoBanco.setAtivo(resultSet.getString("ativo"));
            Fornecedores fornecedor = new Fornecedores();
            fornecedor.setEmpresa(resultSet.getString("empresa"));
            produtoComDadosDoBanco.setFornecedor(fornecedor);
            
            produto.add(produtoComDadosDoBanco);
        }
        return produto;
    }

    public ArrayList<Produto> selectAll() throws SQLException {
        String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, p.ativo, f.empresa from tb_produtos as p inner join tb_fornecedores as f on p.for_id = f.id where p.ativo = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "true");
        return pesquisa(statement);
    }

    public void deleteProduto(int codigo) throws SQLException {
        String ativo = "false";
        String sql = "update tb_produtos set ativo = ? where id = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ativo);
        statement.setInt(2, codigo);
        statement.execute();
    }
    
   
}

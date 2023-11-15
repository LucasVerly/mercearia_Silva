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

    public Produto selectForCodigo(int codigo) throws SQLException {
        String ativo = "true";
        String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, p.ativo, f.empresa from tb_produtos as p inner join tb_fornecedores as f on p.for_id = f.id where p.ativo = ? and p.id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ativo);
        statement.setInt(2, codigo);
        
        
        
        return pesquisa(statement).get(0);
    }

    public void updateProduto(int codigo, String quantidade, String preco) throws SQLException {
        String sql = "update tb_produtos set qtd_estoque = ?, preco = ? where id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, quantidade);
        statement.setString(2, preco);
        statement.setInt(3, codigo);
        
        statement.executeUpdate();
        
    }

    public ArrayList<Produto> selectForName(String nome) throws SQLException {
        String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, p.ativo, f.empresa from tb_produtos as p inner join tb_fornecedores as f on p.for_id = f.id where p.ativo = ? and p.descricao like ?";
        String ativo = "true";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ativo);
        statement.setString(2, nome);
        
        return pesquisa(statement);
    }

    public int retornaEstoque(int id) throws SQLException {
        int qtdEstoque = 0;
        
        String sql = "select qtd_estoque from tb_produtos where id =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        
        ResultSet result = statement.executeQuery();
        
        while (result.next()){
            Produto p = new Produto();
            qtdEstoque = (result.getInt("qtd_estoque"));
        }
        return qtdEstoque;
    }

    public void baixaEstoque(int id, int qtdAtualizada) throws SQLException {
        String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, qtdAtualizada);
        statement.setInt(2, id);
        
        statement.execute();
    }
    
    
   
}

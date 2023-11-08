/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LucasVerly
 */
public class FornecedorDAO {
    
    private final Connection connection;
    
    public FornecedorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insertFornecedor (Fornecedores fornecedor) throws SQLException {
        String sql = "insert into tb_fornecedores (nome,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,ativo,empresa,cnpj)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getEmail());
            statement.setString(3, fornecedor.getTelefone());
            statement.setString(4, fornecedor.getCelular());
            statement.setString(5, fornecedor.getCep());
            statement.setString(6, fornecedor.getEndereco());
            statement.setString(7, fornecedor.getNumero());
            statement.setString(8, fornecedor.getComplemento());
            statement.setString(9, fornecedor.getBairro());
            statement.setString(10, fornecedor.getCidade());
            statement.setString(11, fornecedor.getEstado());
            statement.setString(12, fornecedor.getAtivo());
            statement.setString(13, fornecedor.getEmpresa());
            statement.setString(14, fornecedor.getCnpj());
            
            statement.execute();
    }
    
    public void updateFornecedor (Fornecedores fornecedor) throws SQLException{
        
        String sql = "update tb_fornecedores set nome = ?,email = ?, telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ?, ativo = ?, empresa = ?, cnpj = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getEmail());
            statement.setString(3, fornecedor.getTelefone());
            statement.setString(4, fornecedor.getCelular());
            statement.setString(5, fornecedor.getCep());
            statement.setString(6, fornecedor.getEndereco());
            statement.setString(7, fornecedor.getNumero());
            statement.setString(8, fornecedor.getComplemento());
            statement.setString(9, fornecedor.getBairro());
            statement.setString(10, fornecedor.getCidade());
            statement.setString(11, fornecedor.getEstado());
            statement.setString(12, fornecedor.getAtivo());
            statement.setString(13, fornecedor.getEmpresa());
            statement.setString(14, fornecedor.getCnpj());
            statement.setInt(15, fornecedor.getId());
            
            statement.executeUpdate();
    }
    
    public void deleteFornecedor (String cnpj) throws SQLException{
        String ativo = "false";
        String sql = "update tb_fornecedores set ativo = ? where cnpj = ? ";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ativo);
        statement.setString(2, cnpj);
        statement.execute();
    }
    
    private ArrayList<Fornecedores> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Fornecedores> fornecedores = new ArrayList<Fornecedores>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            Fornecedores fornecedorComDadosDoBanco = new Fornecedores();
            fornecedorComDadosDoBanco.setId(resultSet.getInt("id"));
            fornecedorComDadosDoBanco.setNome(resultSet.getString("nome"));
            fornecedorComDadosDoBanco.setEmpresa(resultSet.getString("empresa"));
            fornecedorComDadosDoBanco.setCnpj(resultSet.getString("cnpj"));
            fornecedorComDadosDoBanco.setEmail(resultSet.getString("email"));
            fornecedorComDadosDoBanco.setTelefone(resultSet.getString("telefone"));
            fornecedorComDadosDoBanco.setCelular(resultSet.getString("celular"));
            fornecedorComDadosDoBanco.setCep(resultSet.getString("cep"));
            fornecedorComDadosDoBanco.setEndereco(resultSet.getString("endereco"));
            fornecedorComDadosDoBanco.setNumero(resultSet.getString("numero"));
            fornecedorComDadosDoBanco.setComplemento(resultSet.getString("complemento"));
            fornecedorComDadosDoBanco.setBairro(resultSet.getString("bairro"));
            fornecedorComDadosDoBanco.setCidade(resultSet.getString("cidade"));
            fornecedorComDadosDoBanco.setEstado(resultSet.getString("estado"));
            fornecedorComDadosDoBanco.setAtivo(resultSet.getString("ativo"));
            
            fornecedores.add(fornecedorComDadosDoBanco);
        }
        return fornecedores;
    }
    
    public ArrayList<Fornecedores> selectAll () throws SQLException{
        String sql = "select * from tb_fornecedores where ativo = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "true");
        return pesquisa(statement);
    }
    
    public ArrayList<Fornecedores> selectForName (String nome) throws SQLException{
        String ativo = "true";
        String sql = "select * from tb_fornecedores where nome like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, ativo);
        
        return pesquisa(statement);
    }
    
    public Fornecedores selectForCnpj (String cnpj) throws SQLException {
        String ativo = "true";
        String sql = "select * from tb_fornecedores where cnpj like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cnpj);
        statement.setString(2, ativo);
        
        return pesquisa(statement).get(0);
    }
    
}

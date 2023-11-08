/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LucasVerly
 */
public class ClienteDAO {
    
    private final Connection connection;
    
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insertCliente (Clientes cliente) throws SQLException{
        String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,ativo, dataNascimento)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getRg());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getCelular());
            statement.setString(7, cliente.getCep());
            statement.setString(8, cliente.getEndereco());
            statement.setString(9, cliente.getNumero());
            statement.setString(10, cliente.getComplemento());
            statement.setString(11, cliente.getBairro());
            statement.setString(12, cliente.getCidade());
            statement.setString(13, cliente.getEstado());
            statement.setString(14, cliente.getAtivo());
            statement.setString(15, cliente.getDataNascimento());
            
            statement.execute();
    }

    public ArrayList<Clientes> selectAll() throws SQLException {
        String sql = "select * from tb_clientes where ativo = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "true");
        return pesquisa(statement);
    }

    private ArrayList<Clientes> pesquisa(PreparedStatement statement) throws SQLException {
        
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            Clientes clienteComDadosDoBanco = new Clientes();
            clienteComDadosDoBanco.setId(resultSet.getInt("id"));
            clienteComDadosDoBanco.setNome(resultSet.getString("nome"));
            clienteComDadosDoBanco.setRg(resultSet.getString("rg"));
            clienteComDadosDoBanco.setCpf(resultSet.getString("cpf"));
            clienteComDadosDoBanco.setEmail(resultSet.getString("email"));
            clienteComDadosDoBanco.setTelefone(resultSet.getString("telefone"));
            clienteComDadosDoBanco.setCelular(resultSet.getString("celular"));
            clienteComDadosDoBanco.setCep(resultSet.getString("cep"));
            clienteComDadosDoBanco.setEndereco(resultSet.getString("endereco"));
            clienteComDadosDoBanco.setNumero(resultSet.getString("numero"));
            clienteComDadosDoBanco.setComplemento(resultSet.getString("complemento"));
            clienteComDadosDoBanco.setBairro(resultSet.getString("bairro"));
            clienteComDadosDoBanco.setCidade(resultSet.getString("cidade"));
            clienteComDadosDoBanco.setEstado(resultSet.getString("estado"));
            clienteComDadosDoBanco.setAtivo(resultSet.getString("ativo"));
            clienteComDadosDoBanco.setDataNascimento(resultSet.getString("dataNascimento"));
            
            clientes.add(clienteComDadosDoBanco);
        }
        return clientes;
    }

    public ArrayList<Clientes> selectForName(String nome) throws SQLException {
        String ativo = "true";
        String sql = "select * from tb_clientes where nome like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, ativo);
        
        return pesquisa(statement);
    }

    public void deleteCliente(String cpf) throws SQLException {
        String ativo = "false";
        String sql = "update tb_clientes set ativo = ? where cpf = ? ";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ativo);
        statement.setString(2, cpf);
        statement.execute();
    }

    public Clientes selectForCpf(String cpf) throws SQLException {
        String ativo = "true";
        String sql = "select * from tb_clientes where cpf like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.setString(2, ativo);
        
        return pesquisa(statement).get(0);
    }

    public void updateCliente(Clientes cliente) throws SQLException {
        
        String sql = "update tb_clientes set nome = ?,rg = ?,cpf = ?,email = ?, telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ?, ativo = ?, dataNascimento = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getRg());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getCelular());
            statement.setString(7, cliente.getCep());
            statement.setString(8, cliente.getEndereco());
            statement.setString(9, cliente.getNumero());
            statement.setString(10, cliente.getComplemento());
            statement.setString(11, cliente.getBairro());
            statement.setString(12, cliente.getCidade());
            statement.setString(13, cliente.getEstado());
            statement.setString(14, cliente.getAtivo());
            statement.setString(15, cliente.getDataNascimento());
            statement.setInt(16, cliente.getId());
            
            
            statement.executeUpdate();
    }
}

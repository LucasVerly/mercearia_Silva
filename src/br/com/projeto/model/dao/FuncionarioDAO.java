/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao;

import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.dao.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LucasVerly
 */
public class FuncionarioDAO {
    
    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertFuncionario(Funcionarios funcionario) throws SQLException {
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,ativo,dataNascimento)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getRg());
            statement.setString(3, funcionario.getCpf());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getSenha());
            statement.setString(6, funcionario.getCargo());
            statement.setString(7, funcionario.getNivelAcesso());
            statement.setString(8, funcionario.getTelefone());
            statement.setString(9, funcionario.getCelular());
            statement.setString(10, funcionario.getCep());
            statement.setString(11, funcionario.getEndereco());
            statement.setString(12, funcionario.getNumero());
            statement.setString(13, funcionario.getComplemento());
            statement.setString(14, funcionario.getBairro());
            statement.setString(15, funcionario.getCidade());
            statement.setString(16, funcionario.getEstado());
            statement.setString(17, funcionario.getAtivo());
            statement.setString(18, funcionario.getDataNascimento());
            
            statement.execute();
    }

    public void updateFuncionario (Funcionarios funcionario) throws SQLException{
        
        String sql = "update tb_funcionarios set nome = ?,rg = ?,cpf = ?,email = ?,senha = ?,cargo = ?,nivel_acesso = ?, telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ?, ativo = ?, dataNascimento = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getRg());
            statement.setString(3, funcionario.getCpf());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getSenha());
            statement.setString(6, funcionario.getCargo());
            statement.setString(7, funcionario.getNivelAcesso());
            statement.setString(8, funcionario.getTelefone());
            statement.setString(9, funcionario.getCelular());
            statement.setString(10, funcionario.getCep());
            statement.setString(11, funcionario.getEndereco());
            statement.setString(12, funcionario.getNumero());
            statement.setString(13, funcionario.getComplemento());
            statement.setString(14, funcionario.getBairro());
            statement.setString(15, funcionario.getCidade());
            statement.setString(16, funcionario.getEstado());
            statement.setString(17, funcionario.getAtivo());
            statement.setString(18, funcionario.getDataNascimento());
            statement.setInt(19, funcionario.getId());
            
            statement.executeUpdate();
    }
    
    public void deleteFuncionario (String cpf) throws SQLException{
        String ativo = "false";
        String sql = "update tb_funcionarios set ativo = ? where cpf = ? ";

        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, ativo);
        statement.setString(2, cpf);
        statement.execute();
    }
    
    public ArrayList<Funcionarios> selectAll () throws SQLException{
        String sql = "select * from tb_funcionarios where ativo = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "true");
        return pesquisa(statement);
    }

    private ArrayList<Funcionarios> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            Funcionarios funcionarioComDadosDoBanco = new Funcionarios();
            funcionarioComDadosDoBanco.setId(resultSet.getInt("id"));
            funcionarioComDadosDoBanco.setNome(resultSet.getString("nome"));
            funcionarioComDadosDoBanco.setRg(resultSet.getString("rg"));
            funcionarioComDadosDoBanco.setCpf(resultSet.getString("cpf"));
            funcionarioComDadosDoBanco.setEmail(resultSet.getString("email"));
            funcionarioComDadosDoBanco.setSenha(resultSet.getString("senha"));
            funcionarioComDadosDoBanco.setCargo(resultSet.getString("cargo"));
            funcionarioComDadosDoBanco.setNivelAcesso(resultSet.getString("nivel_acesso"));
            funcionarioComDadosDoBanco.setTelefone(resultSet.getString("telefone"));
            funcionarioComDadosDoBanco.setCelular(resultSet.getString("celular"));
            funcionarioComDadosDoBanco.setCep(resultSet.getString("cep"));
            funcionarioComDadosDoBanco.setEndereco(resultSet.getString("endereco"));
            funcionarioComDadosDoBanco.setNumero(resultSet.getString("numero"));
            funcionarioComDadosDoBanco.setComplemento(resultSet.getString("complemento"));
            funcionarioComDadosDoBanco.setBairro(resultSet.getString("bairro"));
            funcionarioComDadosDoBanco.setCidade(resultSet.getString("cidade"));
            funcionarioComDadosDoBanco.setEstado(resultSet.getString("estado"));
            funcionarioComDadosDoBanco.setAtivo(resultSet.getString("ativo"));
            funcionarioComDadosDoBanco.setDataNascimento(resultSet.getString("dataNascimento"));
            
            funcionarios.add(funcionarioComDadosDoBanco);
        }
        return funcionarios;
    }
    
    public ArrayList<Funcionarios> selectForName (String nome) throws SQLException{
        String ativo = "true";
        String sql = "select * from tb_funcionarios where nome like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, ativo);
        
        return pesquisa(statement);
    }
    
    public Funcionarios selectForCpf (String cpf) throws SQLException{
        String ativo = "true";
        String sql = "select * from tb_funcionarios where cpf like ? and ativo like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.setString(2, ativo);
        
        return pesquisa(statement).get(0);
    }
    
    public boolean autenticarPorEmailESenha(String email, String senha) throws SQLException {
        String sql = "select * from tb_funcionarios where email=? and senha=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
    
    public Funcionarios nivelDeAcesso (String email, String senha) throws SQLException {
        String sql = "select * from tb_funcionarios where email=? and senha=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        Funcionarios func = new Funcionarios();
        if (resultSet.next()){
            func = pesquisa(statement).get(0);
        } else {
             func = new Funcionarios();
        }
        return func;
    }
    
    
}

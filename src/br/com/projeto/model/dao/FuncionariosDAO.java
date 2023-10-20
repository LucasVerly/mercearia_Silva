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
import javax.swing.JOptionPane;

/**
 *
 * @author LucasVerly
 */
public class FuncionariosDAO {
    
    private final Connection connection;

    public FuncionariosDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertFuncionario(Funcionarios funcionario) throws SQLException {
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values ('"+funcionario.getNome()+"','"+funcionario.getRg()+"','"+funcionario.getCpf()+"','"+funcionario.getEmail()+"','"+funcionario.getSenha()+"','"+funcionario.getCargo()+"','"+funcionario.getNivelAcesso()+"','"+funcionario.getTelefone()+"','"+funcionario.getCelular()+"','"+funcionario.getCep()+"','"+funcionario.getEndereco()+"','"+funcionario.getNumero()+"','"+funcionario.getComplemento()+"','"+funcionario.getBairro()+"','"+funcionario.getCidade()+"','"+funcionario.getEstado()+"')";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
    }

    /*public List<Funcionario> listarFuncionario() {
        try {

            List<Funcionario> lista = new ArrayList<>();
            String sql = "select * from tb_funcionarios";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário " + e);
            return null;
        }
    }

    public void excluirFuncionario(Funcionario obj) {
        try {

            String sql = "delete from tb_funcionarios where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário " + e);

        }

    }

    public void alterarFuncionario(Funcionario obj) {
        try {

            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionário " + e);

        }
    }

    public List<Funcionario> buscaFuncionarioNome(String nome) {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "select * from tb_funcionarios where nome like?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionário " + e);
            return null;
        }
    }
    public void efetuaLogin(String email, String senha){
        try {
             String sql =  "select * from tb_funcionarios where email=? and senha=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, email);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        
           if(rs.next()){
              if(rs.getString("nivel_acesso").equals("administrador")){
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema! " );
                FrmMenu tela = new FrmMenu();
                
                tela.usuarioLogado = rs.getString("nome");
                
                tela.setVisible(true);
              }
              
              else if(rs.getString("nivel_acesso").equals("usuario")){
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema! " );
                FrmMenu tela = new FrmMenu();
                
                tela.usuarioLogado = rs.getString("nome");
                
                tela.menu_posicao.setEnabled(false);
                tela.menu_controlevendas.setEnabled(false);
                tela.controlefunc.setEnabled(false);
                tela.fornecedor.setEnabled(false);
                
                tela.setVisible(true);
                  
              }
              
           }
        
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao realizar autenticação " + e);
             new FrmLogin().setVisible(true);
        }
    }*/

    public boolean autenticarPorEmailESenha(Funcionarios autenticarFuncionario) throws SQLException {
        String sql = "select * from tb_funcionarios where email='"+autenticarFuncionario.getEmail()+"' and senha='"+autenticarFuncionario.getSenha()+"'";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next(); 
        
        //Pra fazer autenticação do nivel do usuario
        //ResultSet resultSet = statement.executeQuery();
        //return resultSet.next();
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.dao.FuncionariosDAO;
import br.com.projeto.model.dao.conexao.Conexao;
import br.com.projeto.view.CadastroFuncionario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author LucasVerly
 */
public class CadastroController {
    
    private CadastroFuncionario view;

    public CadastroController(CadastroFuncionario view) {
        this.view = view;
    }
    
    public void insertFuncionario (){
        
        Funcionarios funcionario = new Funcionarios();
        funcionario.setNome(view.getTxtNome().getText().trim());
        funcionario.setBairro(view.getTxtBairro().getText().trim());
        funcionario.setCargo(view.getTxtCargo().getText().trim());
        funcionario.setCelular(view.getTxtCelular().getText().trim());
        funcionario.setCep(view.getTxtCep().getText().trim());
        funcionario.setCidade(view.getTxtCidade().getText().trim());
        funcionario.setComplemento(view.getTxtComplemento().getText().trim());
        funcionario.setCpf(view.getTxtCpf().getText().trim());
        funcionario.setDataNascimento(view.getTxtDataNascimento().getText().trim());
        funcionario.setEmail(view.getTxtEmail().getText().trim());
        funcionario.setEndereco(view.getTxtRua().getText().trim());
        funcionario.setEstado((String) view.getCbEstado().getSelectedItem());
        funcionario.setNivelAcesso((String) view.getCbNivel().getSelectedItem());
        funcionario.setNumero( view.getTxtNumeroCasa().getText().trim());
        funcionario.setRg(view.getTxtRG().getText().trim());
        funcionario.setSenha(view.getTxtSenha().getText().trim());
        funcionario.setTelefone(view.getTxtTelefoneFixo().getText().trim());
        
        try {
            Connection conexao = new Conexao().getConnection();
            FuncionariosDAO funcionarioDao = new FuncionariosDAO(conexao);
            funcionarioDao.insertFuncionario(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso !!!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar !!!");
        }
    }
    
}

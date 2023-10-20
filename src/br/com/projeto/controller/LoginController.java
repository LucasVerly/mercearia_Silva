/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.controller.helper.LoginHelper;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.dao.FuncionariosDAO;
import br.com.projeto.model.dao.conexao.Conexao;
import br.com.projeto.view.Login;
import br.com.projeto.view.MenuPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LucasVerly
 */
public class LoginController {

    private final Login view;
    //private LoginHelper helper; 
    
    public LoginController(Login view) {
        this.view = view;
        //this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema (){
        //Funcionarios funcionario = helper.obterModelo();
    }

    public void autenticar() throws SQLException {
        //Busca os dados inseridos na view de Login
        String email = view.getTxtEmail().getText().trim();
        String senha = view.getTxtSenha().getText().trim();
        
        Funcionarios autenticarFuncionario = new Funcionarios (email, senha);
        
        Connection conexao = new Conexao().getConnection();
        FuncionariosDAO funcionarioDao = new FuncionariosDAO(conexao);
        
        boolean existe = funcionarioDao.autenticarPorEmailESenha(autenticarFuncionario);
        
        if (existe){
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");
        }
        
    }
    
}

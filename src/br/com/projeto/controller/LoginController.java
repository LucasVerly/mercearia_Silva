/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.dao.FuncionarioDAO;
import br.com.projeto.model.dao.conexao.Conexao;
import br.com.projeto.view.Login;
import br.com.projeto.view.MenuPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }

    public void autenticar() {
        //Busca os dados inseridos na view de Login
        String email = view.getTxtEmail().getText().trim();
        String senha = view.getTxtSenha().getText().trim();
        try {
            Connection conexao;
            conexao = new Conexao().getConnection();
            FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
            Funcionarios funcionarioDoBanco = new Funcionarios ();
        
            boolean existeFuncionarioNoBanco = funcionarioDao.autenticarPorEmailESenha(email, senha);
            funcionarioDoBanco = funcionarioDao.nivelDeAcesso(email, senha);
        
            if (existeFuncionarioNoBanco){
             if(funcionarioDoBanco.getNivelAcesso().equals("Administrador")){
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setUserLogado(funcionarioDoBanco.getNome()); 
                menuPrincipal.setVisible(true);
                view.dispose();
             } else if(funcionarioDoBanco.getNivelAcesso().equals("Usuário")){
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setUserLogado(funcionarioDoBanco.getNome());
                menuPrincipal.menuUsuario(false);
                menuPrincipal.setVisible(true);
                view.dispose();
            }
        }else {
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, ex);
        }
        
        
    }
    
}

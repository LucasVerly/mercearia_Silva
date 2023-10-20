/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller.helper;

import br.com.projeto.model.Funcionarios;
import br.com.projeto.view.Login;

/**
 *
 * @author LucasVerly
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Funcionarios obterModelo (){
        String email = view.getTxtEmail().getText();
        String senha = view.getTxtSenha().getText();
        
        Funcionarios modelo = new Funcionarios (email, senha);
        return modelo;
    }
    
    public void setarModelo (Funcionarios modelo) {
        String email = modelo.getEmail();
        String senha = modelo.getSenha();
        
        view.getTxtEmail().setText(email);
        view.getTxtSenha().setText(senha);
    }
    
    public void limparTela (){
        view.getTxtEmail().setText("");
        view.getTxtSenha().setText("");
    }
}

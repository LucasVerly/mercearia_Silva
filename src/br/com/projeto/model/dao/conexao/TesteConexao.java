/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao.conexao;

import javax.swing.JOptionPane;

/**
 *
 * @author LucasVerly
 */
public class TesteConexao {
    public static void main(String[] args) {
        try {
            new Conexao().getConnection();
            JOptionPane.showMessageDialog(null, "conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: "+e);
        }
    }
}

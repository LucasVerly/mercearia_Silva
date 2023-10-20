/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LucasVerly
 */
public class Conexao {
    
    public Connection getConnection () throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas", "teste", "123");
        return conexao;
    }
}

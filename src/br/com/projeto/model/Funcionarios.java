/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasVerly
 */
public class Funcionarios extends Pessoa {
    private String senha;
    private String cargo;
    private String nivelAcesso;
    private String dataNascimento;
    private String rg;
    private String cpf;

    public Funcionarios() {
    }

    public Funcionarios(String email, String senha) {
        super(email);
        this.senha = senha;
    }

    public Funcionarios(String senha, String cargo, String nivel_acesso, String nome, String email, String telefone, String celular, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String ativo, String dataNascimento, String rg, String cpf) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado, ativo);
        this.senha = senha;
        this.cargo = cargo;
        this.nivelAcesso = nivel_acesso;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento; 
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivel_acesso) {
        this.nivelAcesso = nivel_acesso;
    }

}

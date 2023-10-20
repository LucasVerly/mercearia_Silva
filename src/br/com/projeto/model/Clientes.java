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
public class Clientes extends Pessoa{
  private String rg;
  private String cpf;
  private Date dataNascimento;
  

    public Clientes() {
    }

    public Clientes(String rg, String cpf, String nome, String email, String telefone, String celular, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String dataNascimento) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado);
        this.rg = rg;
        this.cpf = cpf;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

/**
 *
 * @author LucasVerly
 */
public class Fornecedores extends Pessoa{
  private String empresa;
  private String cnpj;

    public Fornecedores() {
    }

    public Fornecedores(String empresa, String cnpj, String nome, String email, String telefone, String celular, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado, String ativo) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado, ativo);
        this.empresa = empresa;
        this.cnpj = cnpj;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
  
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
 
}

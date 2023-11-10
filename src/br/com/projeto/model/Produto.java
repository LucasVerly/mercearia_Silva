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
public class Produto {
    private int id;
    private String nomeProduto;
    private double preco;
    private int qtd_estoque ;
    private Fornecedores fornecedor;
    private String ativo = "true";

    public Produto() {
        
    }

    public Produto(String nomeProduto, double preco, int qtd_estoque, Fornecedores fornecedor, String ativo) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
        this.fornecedor = fornecedor;
        this.ativo = ativo;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String descricao) {
        this.nomeProduto = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }
}

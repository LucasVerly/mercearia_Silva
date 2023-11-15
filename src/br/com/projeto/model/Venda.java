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
public class Venda {
    private int id;
    private Clientes cliente;
    private String dataVenda;
    private double total_venda;

    public Venda() {
        
    }

    public Venda(Clientes cliente, String dataVenda, double total_venda) {
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.total_venda = total_venda;
        
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String data_venda) {
        this.dataVenda = dataVenda;
    }

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }
}

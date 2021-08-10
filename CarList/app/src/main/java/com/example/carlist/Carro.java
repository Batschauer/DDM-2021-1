package com.example.carlist;

public class Carro {
    private int codigo, foto;
    private String modelo;
    double preco, precoVenda;

    public Carro(int codigo, String modelo, double preco, double precoVenda, int foto) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.preco = preco;
        this.precoVenda = precoVenda;
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

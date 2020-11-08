package br.ufes.model;

public final class Produto {

    private String nome;
    private double valorUnitario;
    private double valorUltimaCompra;
    private double quantidade;

    public Produto(String nome, double valorUnitario, double quantidade) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.valorUltimaCompra = valorUnitario;
        this.quantidade = quantidade;
    }

    public boolean estoqueDisponivel(double quantidadeNecessaria) {
        return this.quantidade >= quantidadeNecessaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorUltimaCompra() {
        return valorUltimaCompra;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new NullPointerException("O nome do produto não pode ser nulo.");
        }
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new IllegalArgumentException("O valor informado deve ser maior do que zero!");
        }
        this.valorUltimaCompra = this.valorUnitario;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Produto: " + nome
                + ", valor unitario: R$" + valorUnitario
                + ", valor da ultima compra: R$" + valorUltimaCompra
                + ", quantidade em estoque: " + quantidade;
    }

}

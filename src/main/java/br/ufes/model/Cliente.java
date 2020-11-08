package br.ufes.model;

public final class Cliente {

    private final String nome;
    private final String codigoPessoa;

    public Cliente(String nome, String codigo) {
        this.nome = nome;
        this.codigoPessoa = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPessoa() {
        return codigoPessoa;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + codigoPessoa;
    }

}

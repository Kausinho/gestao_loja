package com.loja.model;

/**
 * Superclasse que representa um estabelecimento genérico
 */
public class Estabelecimento {
    // Atributos genéricos para qualquer estabelecimento
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;
    private int quantidadeFuncionarios;
    
    // Construtor padrão
    public Estabelecimento() {
    }
    
    // Construtor com parâmetros
    public Estabelecimento(String nome, String endereco, String telefone, String cnpj, int quantidadeFuncionarios) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    
    // Métodos getters e setters para encapsulamento dos atributos
    // ENCAPSULAMENTO: Os atributos são privados e só podem ser acessados pelos métodos get e set
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }
    
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    
    // Método que verifica se o estabelecimento é grande
    public boolean isEstabelecimentoGrande() {
        // Exemplo de estrutura condicional
        if (quantidadeFuncionarios > 50) {
            return true;
        } else {
            return false;
        }
    }
    
    // Método para calcular impostos (será sobrescrito nas subclasses)
    // POLIMORFISMO: Método que será implementado de forma diferente nas subclasses
    public double calcularImpostos() {
        return 0.0;
    }
    
    // Método para exibir informações
    public String exibirInformacoes() {
        return "Estabelecimento: " + nome + 
               "\nEndereço: " + endereco +
               "\nTelefone: " + telefone +
               "\nCNPJ: " + cnpj +
               "\nQuantidade de Funcionários: " + quantidadeFuncionarios;
    }
} 
package com.loja.model;

/**
 * Classe que representa um Produto da loja
 */
public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private String fornecedor;
    
    // Construtor padrão
    public Produto() {
    }
    
    // Construtor com parâmetros
    public Produto(String codigo, String nome, String categoria, double preco, int quantidade, String fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }
    
    // Métodos getters e setters para encapsulamento dos atributos
    // ENCAPSULAMENTO: Os atributos são privados e só podem ser acessados pelos métodos get e set
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getFornecedor() {
        return fornecedor;
    }
    
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    // Método para calcular o valor total (preço * quantidade)
    public double calcularValorTotal() {
        return preco * quantidade;
    }
    
    // Método para verificar se o produto está em baixo estoque (menos de 10 unidades)
    public boolean emBaixoEstoque() {
        // Estrutura condicional
        if (quantidade < 10) {
            return true;
        } else {
            return false;
        }
    }
    
    // Método para incrementar a quantidade em estoque
    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            quantidade += qtd;
        }
    }
    
    // Método para decrementar a quantidade em estoque
    public boolean removerEstoque(int qtd) {
        // Estrutura condicional
        if (qtd <= 0) {
            return false;
        }
        
        if (quantidade >= qtd) {
            quantidade -= qtd;
            return true;
        } else {
            return false;
        }
    }
    
    // Método para exibir informações do produto
    @Override
    public String toString() {
        return "Código: " + codigo +
               ", Nome: " + nome +
               ", Categoria: " + categoria +
               ", Preço: R$ " + preco +
               ", Quantidade: " + quantidade +
               ", Fornecedor: " + fornecedor +
               ", Valor Total: R$ " + calcularValorTotal() +
               (emBaixoEstoque() ? " (BAIXO ESTOQUE)" : "");
    }
} 
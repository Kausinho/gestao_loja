package com.loja.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Loja, herda de Estabelecimento
 */
// HERANÇA: A classe Loja herda todos os atributos e métodos da classe Estabelecimento
public class Loja extends Estabelecimento {
    // Atributos específicos para a Loja
    private String segmento;
    private double faturamentoMensal;
    private int quantidadeProdutos;
    private double metaVendas;
    private List<Produto> estoque;
    
    // Construtor padrão
    public Loja() {
        super(); // Chama o construtor da superclasse
        this.estoque = new ArrayList<>();
    }
    
    // Construtor com parâmetros
    public Loja(String nome, String endereco, String telefone, String cnpj, int quantidadeFuncionarios,
                String segmento, double faturamentoMensal, int quantidadeProdutos, double metaVendas) {
        // HERANÇA: Chamada do construtor da superclasse
        super(nome, endereco, telefone, cnpj, quantidadeFuncionarios);
        this.segmento = segmento;
        this.faturamentoMensal = faturamentoMensal;
        this.quantidadeProdutos = quantidadeProdutos;
        this.metaVendas = metaVendas;
        this.estoque = new ArrayList<>();
    }
    
    // Métodos getters e setters para encapsulamento dos atributos
    // ENCAPSULAMENTO: Os atributos são privados e só podem ser acessados pelos métodos get e set
    public String getSegmento() {
        return segmento;
    }
    
    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }
    
    public double getFaturamentoMensal() {
        return faturamentoMensal;
    }
    
    public void setFaturamentoMensal(double faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }
    
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
    
    public double getMetaVendas() {
        return metaVendas;
    }
    
    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }
    
    public List<Produto> getEstoque() {
        return estoque;
    }
    
    public void setEstoque(List<Produto> estoque) {
        this.estoque = estoque;
    }
    
    // Método para adicionar produto ao estoque
    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
        quantidadeProdutos = estoque.size();
    }
    
    // Método para remover produto do estoque
    public boolean removerProduto(String codigo) {
        // Estrutura de repetição para encontrar o produto no estoque
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).getCodigo().equals(codigo)) {
                estoque.remove(i);
                quantidadeProdutos = estoque.size();
                return true;
            }
        }
        return false;
    }
    
    // Método para calcular o valor total do estoque
    public double calcularValorTotalEstoque() {
        double valorTotal = 0.0;
        // Estrutura de repetição para somar o valor de todos os produtos
        for (Produto produto : estoque) {
            valorTotal += produto.getPreco() * produto.getQuantidade();
        }
        return valorTotal;
    }
    
    // Método para verificar se a meta de vendas foi atingida
    public boolean metaAtingida() {
        // Estrutura condicional
        if (faturamentoMensal >= metaVendas) {
            return true;
        } else {
            return false;
        }
    }
    
    // POLIMORFISMO: Sobrescrita do método da superclasse
    @Override
    public double calcularImpostos() {
        // Taxa de imposto diferente dependendo do faturamento
        if (faturamentoMensal > 100000) {
            return faturamentoMensal * 0.15; // 15% de imposto para faturamento alto
        } else {
            return faturamentoMensal * 0.10; // 10% de imposto para faturamento menor
        }
    }
    
    // POLIMORFISMO: Sobrescrita do método da superclasse
    @Override
    public String exibirInformacoes() {
        // Chamada do método da superclasse usando super
        return super.exibirInformacoes() +
               "\nSegmento: " + segmento +
               "\nFaturamento Mensal: R$ " + faturamentoMensal +
               "\nQuantidade de Produtos: " + quantidadeProdutos +
               "\nMeta de Vendas: R$ " + metaVendas +
               "\nImpostos a pagar: R$ " + calcularImpostos() +
               "\nMeta atingida: " + (metaAtingida() ? "Sim" : "Não");
    }
    
    // Método para listar todos os produtos em estoque
    public String listarProdutos() {
        StringBuilder lista = new StringBuilder("Produtos em estoque:\n");
        
        // Estrutura de repetição para percorrer todos os produtos
        for (Produto produto : estoque) {
            lista.append(produto.toString()).append("\n");
        }
        
        return lista.toString();
    }
} 
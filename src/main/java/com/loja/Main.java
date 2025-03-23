package com.loja;

import com.loja.model.Estabelecimento;
import com.loja.model.Loja;
import com.loja.model.LojaDepartamento;
import com.loja.model.Produto;
import com.loja.ui.GestaoLojasUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal para testar as funcionalidades do sistema
 */
public class Main {
    
    public static void main(String[] args) {
        // Criar instâncias de teste
        Estabelecimento estabelecimento = criarEstabelecimentoExemplo();
        Loja loja = criarLojaExemplo();
        LojaDepartamento lojaDepartamento = criarLojaDepartamentoExemplo();
        
        // Criar lista de estabelecimentos para demonstrar polimorfismo
        List<Estabelecimento> estabelecimentos = new ArrayList<>();
        estabelecimentos.add(estabelecimento);
        estabelecimentos.add(loja);
        estabelecimentos.add(lojaDepartamento);
        
        // Criar e exibir a interface gráfica
        GestaoLojasUI ui = new GestaoLojasUI();
        ui.exibirEstabelecimento(estabelecimento);
        ui.exibirLoja(loja);
        ui.exibirLojaDepartamento(lojaDepartamento);
        ui.exibirRelatorioComparativo(estabelecimentos);
        ui.setVisible(true);
    }
    
    // Método para criar um estabelecimento de exemplo
    private static Estabelecimento criarEstabelecimentoExemplo() {
        return new Estabelecimento(
            "Empresa Genérica", 
            "Rua das Flores, 123", 
            "(11) 1234-5678", 
            "12.345.678/0001-90", 
            30
        );
    }
    
    // Método para criar uma loja de exemplo com produtos
    private static Loja criarLojaExemplo() {
        Loja loja = new Loja(
            "MegaStore", 
            "Avenida Principal, 1000", 
            "(11) 9876-5432", 
            "98.765.432/0001-10", 
            45,
            "Eletrônicos", 
            120000.0, 
            0, 
            100000.0
        );
        
        // Adicionar produtos ao estoque da loja
        List<Produto> produtos = criarProdutosExemplo();
        for (Produto produto : produtos) {
            loja.adicionarProduto(produto);
        }
        
        return loja;
    }
    
    // Método para criar uma loja de departamentos de exemplo
    private static LojaDepartamento criarLojaDepartamentoExemplo() {
        LojaDepartamento lojaDepartamento = new LojaDepartamento(
            "MegaStore Departamentos", 
            "Shopping Center, Loja 42", 
            "(11) 5555-9999", 
            "55.555.555/0001-55", 
            120,
            "Variedades", 
            350000.0, 
            0, 
            300000.0,
            0, 
            8000.0, 
            true
        );
        
        // Adicionar departamentos
        String[] departamentosNomes = {
            "Eletrônicos", "Informática", "Celulares", "Eletrodomésticos", 
            "Cama, Mesa e Banho", "Decoração", "Brinquedos", "Esportes"
        };
        
        for (String departamento : departamentosNomes) {
            lojaDepartamento.adicionarDepartamento(departamento);
        }
        
        // Adicionar produtos
        List<Produto> produtos = criarProdutosExemplo();
        for (Produto produto : produtos) {
            lojaDepartamento.adicionarProduto(produto);
        }
        
        return lojaDepartamento;
    }
    
    // Método para criar uma lista de produtos de exemplo
    private static List<Produto> criarProdutosExemplo() {
        List<Produto> produtos = new ArrayList<>();
        
        produtos.add(new Produto("001", "Smartphone XYZ", "Celulares", 1999.99, 15, "XYZ Eletrônicos"));
        produtos.add(new Produto("002", "Notebook ABC", "Informática", 3500.00, 8, "ABC Technology"));
        produtos.add(new Produto("003", "Smart TV 50\"", "Eletrônicos", 2799.90, 12, "XYZ Eletrônicos"));
        produtos.add(new Produto("004", "Fones de Ouvido Bluetooth", "Acessórios", 199.90, 30, "AudioTech"));
        produtos.add(new Produto("005", "Mouse sem Fio", "Informática", 89.90, 25, "ABC Technology"));
        
        return produtos;
    }
} 
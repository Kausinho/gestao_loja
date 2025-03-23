package com.loja.ui;

import com.loja.model.Estabelecimento;
import com.loja.model.Loja;
import com.loja.model.LojaDepartamento;
import com.loja.model.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestaoLojasUI extends JFrame {
    // Cores personalizadas para detalhes da interface
    private static final Color ACCENT_COLOR = new Color(87, 140, 212);
    private static final Color HIGHLIGHT_COLOR = new Color(100, 180, 255);
    
    private JTabbedPane tabbedPane;
    private JPanel estabelecimentoPanel;
    private JPanel lojaPanel;
    private JPanel lojaDepartamentoPanel;
    private JTextArea estabelecimentoInfo;
    private JTextArea lojaInfo;
    private JTextArea lojaDepartamentoInfo;
    private JTextArea produtosLoja;
    private JTextArea produtosLojaDepartamento;
    private JTextArea departamentosInfo;
    private JTextArea relatorioPolimorfismo;
    private JPanel relatorioPanel;

    public GestaoLojasUI() {
        // Configurar a janela principal
        setTitle("Sistema de Gestão de Lojas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null); // Centralizar na tela
        
        // Adicionar ícone da aplicação se disponível
        try {
            // Caso queira adicionar um ícone posteriormente
            // setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        } catch (Exception e) {
            // Ignorar se o ícone não estiver disponível
        }
        
        // Painel de abas
        tabbedPane = new JTabbedPane();
        
        // Inicializar painéis
        inicializarPainelEstabelecimento();
        inicializarPainelLoja();
        inicializarPainelLojaDepartamento();
        inicializarPainelRelatorio();
        
        // Adicionar abas com ícones
        tabbedPane.addTab("Estabelecimento", estabelecimentoPanel);
        tabbedPane.addTab("Loja", lojaPanel);
        tabbedPane.addTab("Loja de Departamento", lojaDepartamentoPanel);
        tabbedPane.addTab("Relatório Comparativo", relatorioPanel);
        
        // Personalizar bordas e margens
        ((JComponent)getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
        
        // Adicionar o painel de abas à janela
        add(tabbedPane);
    }
    
    private void inicializarPainelEstabelecimento() {
        estabelecimentoPanel = new JPanel(new BorderLayout(10, 10));
        estabelecimentoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Painel de cabeçalho
        JLabel headerLabel = new JLabel("Detalhes do Estabelecimento");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setForeground(ACCENT_COLOR);
        headerLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        estabelecimentoPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Painel de informações
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Informações do Estabelecimento",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        estabelecimentoInfo = new JTextArea();
        estabelecimentoInfo.setEditable(false);
        estabelecimentoInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(estabelecimentoInfo);
        infoPanel.add(scrollPane, BorderLayout.CENTER);
        
        estabelecimentoPanel.add(infoPanel, BorderLayout.CENTER);
    }
    
    private void inicializarPainelLoja() {
        lojaPanel = new JPanel(new BorderLayout(10, 10));
        lojaPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Painel de cabeçalho
        JLabel headerLabel = new JLabel("Gestão de Loja");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setForeground(ACCENT_COLOR);
        headerLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        lojaPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Painel de informações
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Informações da Loja",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        lojaInfo = new JTextArea();
        lojaInfo.setEditable(false);
        lojaInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(lojaInfo);
        infoPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Painel de produtos
        JPanel produtosPanel = new JPanel(new BorderLayout());
        produtosPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Produtos em Estoque",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        produtosLoja = new JTextArea();
        produtosLoja.setEditable(false);
        produtosLoja.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane produtosScrollPane = new JScrollPane(produtosLoja);
        produtosPanel.add(produtosScrollPane, BorderLayout.CENTER);
        
        // Dividir o painel em dois
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            infoPanel,
            produtosPanel
        );
        splitPane.setDividerLocation(250);
        splitPane.setResizeWeight(0.4);
        splitPane.setBorder(null);
        splitPane.setDividerSize(5);
        
        lojaPanel.add(splitPane, BorderLayout.CENTER);
    }
    
    private void inicializarPainelLojaDepartamento() {
        lojaDepartamentoPanel = new JPanel(new BorderLayout(10, 10));
        lojaDepartamentoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Painel de cabeçalho
        JLabel headerLabel = new JLabel("Gestão de Loja de Departamento");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setForeground(ACCENT_COLOR);
        headerLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        lojaDepartamentoPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Painel de informações
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Informações da Loja de Departamento",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        lojaDepartamentoInfo = new JTextArea();
        lojaDepartamentoInfo.setEditable(false);
        lojaDepartamentoInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(lojaDepartamentoInfo);
        infoPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Painel de departamentos
        JPanel deptoPanel = new JPanel(new BorderLayout());
        deptoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Departamentos",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        departamentosInfo = new JTextArea();
        departamentosInfo.setEditable(false);
        departamentosInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane deptoScrollPane = new JScrollPane(departamentosInfo);
        deptoPanel.add(deptoScrollPane, BorderLayout.CENTER);
        
        // Painel de produtos
        JPanel produtosPanel = new JPanel(new BorderLayout());
        produtosPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Produtos em Estoque",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        produtosLojaDepartamento = new JTextArea();
        produtosLojaDepartamento.setEditable(false);
        produtosLojaDepartamento.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane produtosScrollPane = new JScrollPane(produtosLojaDepartamento);
        produtosPanel.add(produtosScrollPane, BorderLayout.CENTER);
        
        // Dividir o painel em três partes
        JSplitPane topSplitPane = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            infoPanel,
            deptoPanel
        );
        topSplitPane.setDividerLocation(250);
        topSplitPane.setResizeWeight(0.6);
        topSplitPane.setBorder(null);
        topSplitPane.setDividerSize(5);
        
        JSplitPane mainSplitPane = new JSplitPane(
            JSplitPane.VERTICAL_SPLIT,
            topSplitPane,
            produtosPanel
        );
        mainSplitPane.setDividerLocation(400);
        mainSplitPane.setResizeWeight(0.7);
        mainSplitPane.setBorder(null);
        mainSplitPane.setDividerSize(5);
        
        lojaDepartamentoPanel.add(mainSplitPane, BorderLayout.CENTER);
    }
    
    private void inicializarPainelRelatorio() {
        relatorioPanel = new JPanel(new BorderLayout(10, 10));
        relatorioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Painel de cabeçalho
        JLabel headerLabel = new JLabel("Relatório Comparativo e Demonstração de Polimorfismo");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerLabel.setForeground(ACCENT_COLOR);
        headerLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        relatorioPanel.add(headerLabel, BorderLayout.NORTH);
        
        relatorioPolimorfismo = new JTextArea();
        relatorioPolimorfismo.setEditable(false);
        relatorioPolimorfismo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(relatorioPolimorfismo);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(ACCENT_COLOR, 1),
            "Demonstração de Polimorfismo - Cálculo de Impostos",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        relatorioPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    // Método para estilizar o texto
    private String formatarTexto(String texto) {
        // Adiciona formatação com caracteres Unicode para melhor legibilidade
        return texto.replace("R$", "R$ ");
    }
    
    // Método para exibir informações do estabelecimento
    public void exibirEstabelecimento(Estabelecimento estabelecimento) {
        StringBuilder sb = new StringBuilder();
        sb.append(estabelecimento.exibirInformacoes());
        sb.append("\n\nÉ um estabelecimento grande? ")
          .append(estabelecimento.isEstabelecimentoGrande() ? "Sim" : "Não")
          .append("\n\nImposto calculado: R$ ")
          .append(String.format("%.2f", estabelecimento.calcularImpostos()));
          
        estabelecimentoInfo.setText(formatarTexto(sb.toString()));
    }
    
    // Método para exibir informações da loja
    public void exibirLoja(Loja loja) {
        StringBuilder sb = new StringBuilder();
        sb.append(loja.exibirInformacoes());
        sb.append("\n\nMeta atingida? ")
          .append(loja.metaAtingida() ? "Sim" : "Não")
          .append("\n\nValor total do estoque: R$ ")
          .append(String.format("%.2f", loja.calcularValorTotalEstoque()))
          .append("\n\nImposto calculado: R$ ")
          .append(String.format("%.2f", loja.calcularImpostos()));
          
        lojaInfo.setText(formatarTexto(sb.toString()));
        
        // Exibir produtos
        produtosLoja.setText(formatarTexto(loja.listarProdutos()));
    }
    
    // Método para exibir informações da loja de departamento
    public void exibirLojaDepartamento(LojaDepartamento lojaDepartamento) {
        StringBuilder sb = new StringBuilder();
        sb.append(lojaDepartamento.exibirInformacoes());
        sb.append("\n\nÉ uma loja grande? ")
          .append(lojaDepartamento.isLojaGrande() ? "Sim" : "Não")
          .append("\n\nMeta atingida? ")
          .append(lojaDepartamento.metaAtingida() ? "Sim" : "Não")
          .append("\n\nPossui estacionamento? ")
          .append(lojaDepartamento.isTemEstacionamento() ? "Sim" : "Não")
          .append("\n\nValor total do estoque: R$ ")
          .append(String.format("%.2f", lojaDepartamento.calcularValorTotalEstoque()))
          .append("\n\nImposto calculado: R$ ")
          .append(String.format("%.2f", lojaDepartamento.calcularImpostos()));
          
        lojaDepartamentoInfo.setText(formatarTexto(sb.toString()));
        
        // Exibir departamentos
        StringBuilder deptoSb = new StringBuilder();
        for (String departamento : lojaDepartamento.getDepartamentos()) {
            deptoSb.append("• ").append(departamento).append("\n");
        }
        departamentosInfo.setText(deptoSb.toString());
        
        // Exibir produtos
        produtosLojaDepartamento.setText(formatarTexto(lojaDepartamento.listarProdutos()));
    }
    
    // Método para exibir o relatório comparativo
    public void exibirRelatorioComparativo(List<Estabelecimento> estabelecimentos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cálculo de impostos para diferentes tipos de estabelecimentos:\n\n");
        
        for (Estabelecimento e : estabelecimentos) {
            String tipo = "";
            
            if (e instanceof LojaDepartamento) {
                tipo = "Loja de Departamento";
            } else if (e instanceof Loja) {
                tipo = "Loja";
            } else {
                tipo = "Estabelecimento";
            }
            
            sb.append("--------------------------------------------------\n");
            sb.append(tipo)
              .append(": ")
              .append(e.getNome())
              .append("\n")
              .append("CNPJ: ")
              .append(e.getCnpj())
              .append("\n")
              .append("Imposto calculado: R$ ")
              .append(String.format("%.2f", e.calcularImpostos()))
              .append("\n\n");
        }
        
        relatorioPolimorfismo.setText(formatarTexto(sb.toString()));
    }
} 
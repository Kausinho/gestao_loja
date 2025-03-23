package com.loja.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de boas-vindas (splash screen) exibida quando o sistema inicia
 */
public class SplashScreen extends JWindow {
    private JProgressBar progressBar;
    private int duration;
    private static final Color BACKGROUND_COLOR = new Color(43, 43, 43);
    private static final Color ACCENT_COLOR = new Color(87, 140, 212);
    private static final Color TEXT_COLOR = new Color(220, 220, 220);
    
    /**
     * Cria uma nova tela de boas-vindas
     * @param duration Duração em milissegundos
     */
    public SplashScreen(int duration) {
        this.duration = duration;
        initialize();
    }
    
    private void initialize() {
        // Configurar layout
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR, 1));
        
        // Area de titulo
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);
        titlePanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        
        JLabel title = new JLabel("Sistema de Gestão de Lojas");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(ACCENT_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        
        // Area de informacoes
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        
        // Adicionar descrição
        JLabel desc = new JLabel("<html><div style='text-align: center;'>" +
                "Sistema desenvolvido para gerenciar estabelecimentos, lojas e lojas de departamento.<br><br>" +
                "Este aplicativo demonstra os conceitos de Orientação a Objetos:<br>" +
                "• Encapsulamento<br>• Herança<br>• Polimorfismo" +
                "</div></html>");
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        desc.setForeground(TEXT_COLOR);
        desc.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(desc, BorderLayout.CENTER);
        
        // Adicionar barra de progresso
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(ACCENT_COLOR);
        progressBar.setString("Carregando...");
        progressBar.setBorder(new EmptyBorder(0, 0, 0, 0));
        infoPanel.add(progressBar, BorderLayout.SOUTH);
        
        // Adicionar versão e informações de direitos autorais
        JLabel version = new JLabel("Versao 1.0 - (c) 2023 Todos os direitos reservados");
        version.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        version.setForeground(new Color(150, 150, 150));
        version.setHorizontalAlignment(SwingConstants.CENTER);
        version.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Montar painéis
        content.add(titlePanel, BorderLayout.NORTH);
        content.add(infoPanel, BorderLayout.CENTER);
        content.add(version, BorderLayout.SOUTH);
        
        setContentPane(content);
        setSize(500, 350);
        setLocationRelativeTo(null);
    }
    
    /**
     * Exibe a tela de boas-vindas por um tempo determinado
     */
    public void showSplash() {
        setVisible(true);
        
        // Simular carregamento
        try {
            int increment = 100 / (duration / 100);
            for (int i = 0; i <= 100; i += increment) {
                Thread.sleep(100);
                progressBar.setValue(i);
                
                if (i > 50) {
                    progressBar.setString("Iniciando aplicacao...");
                }
                
                if (i > 80) {
                    progressBar.setString("Quase pronto...");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        setVisible(false);
        dispose();
    }
} 
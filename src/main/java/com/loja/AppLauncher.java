package com.loja;

import com.loja.ui.SplashScreen;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.nio.charset.StandardCharsets;

/**
 * Classe responsável por iniciar a aplicação com configurações visuais adequadas
 */
public class AppLauncher {
    // Cores para o tema escuro
    private static final Color BACKGROUND_COLOR = new Color(43, 43, 43);
    private static final Color FOREGROUND_COLOR = new Color(220, 220, 220);
    private static final Color SELECTION_BACKGROUND = new Color(75, 110, 175);
    private static final Color ACCENT_COLOR = new Color(87, 140, 212);
    private static final Color PANEL_BACKGROUND = new Color(50, 50, 50);
    private static final Color SECONDARY_BACKGROUND = new Color(60, 60, 60);
    
    public static void main(String[] args) {
        // Configurar codificação UTF-8 para corrigir problemas com acentuação
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("sun.jnu.encoding", "UTF-8");
        
        // Garantir que o Java use UTF-8 para Strings
        if (!System.getProperty("file.encoding").equals("UTF-8")) {
            try {
                System.setProperty("file.encoding", "UTF-8");
                java.lang.reflect.Field charset = java.nio.charset.Charset.class.getDeclaredField("defaultCharset");
                charset.setAccessible(true);
                charset.set(null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // Configurar o tema visual da aplicação para um tema escuro moderno
        configurarTemaEscuro();
        
        // Mostrar a tela de boas-vindas
        SwingUtilities.invokeLater(() -> {
            // Exibir splash screen por 2 segundos (2000ms)
            SplashScreen splash = new SplashScreen(2000);
            
            // Cria uma nova thread para mostrar o splash screen enquanto o app carrega
            new Thread(() -> {
                splash.showSplash();
                
                // Após o splash screen, inicia a aplicação principal
                SwingUtilities.invokeLater(() -> {
                    try {
                        Main.main(args);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(
                            null,
                            "Erro ao iniciar a aplicação: " + e.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                });
            }).start();
        });
    }
    
    /**
     * Configura um tema escuro moderno para a aplicação
     */
    private static void configurarTemaEscuro() {
        try {
            // Tema base
            UIManager.put("control", BACKGROUND_COLOR);
            UIManager.put("info", PANEL_BACKGROUND);
            UIManager.put("nimbusBase", BACKGROUND_COLOR);
            UIManager.put("nimbusFocus", ACCENT_COLOR);
            UIManager.put("nimbusLightBackground", PANEL_BACKGROUND);
            UIManager.put("nimbusOrange", ACCENT_COLOR);
            UIManager.put("nimbusSelectedText", FOREGROUND_COLOR);
            UIManager.put("nimbusSelectionBackground", SELECTION_BACKGROUND);
            UIManager.put("text", FOREGROUND_COLOR);
            
            // Componentes específicos
            UIManager.put("Panel.background", PANEL_BACKGROUND);
            UIManager.put("Panel.foreground", FOREGROUND_COLOR);
            UIManager.put("Button.background", SECONDARY_BACKGROUND);
            UIManager.put("Button.foreground", FOREGROUND_COLOR);
            UIManager.put("Label.foreground", FOREGROUND_COLOR);
            UIManager.put("TextField.background", SECONDARY_BACKGROUND);
            UIManager.put("TextField.foreground", FOREGROUND_COLOR);
            UIManager.put("TextField.caretForeground", FOREGROUND_COLOR);
            UIManager.put("TextArea.background", SECONDARY_BACKGROUND);
            UIManager.put("TextArea.foreground", FOREGROUND_COLOR);
            UIManager.put("TextArea.caretForeground", FOREGROUND_COLOR);
            UIManager.put("ScrollPane.background", PANEL_BACKGROUND);
            UIManager.put("TabbedPane.background", BACKGROUND_COLOR);
            UIManager.put("TabbedPane.foreground", FOREGROUND_COLOR);
            UIManager.put("TabbedPane.selected", SECONDARY_BACKGROUND);
            UIManager.put("TabbedPane.contentAreaColor", PANEL_BACKGROUND);
            UIManager.put("TitledBorder.titleColor", FOREGROUND_COLOR);
            
            // Configurar Nimbus Look and Feel com tema escuro
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            // Configurar fontes para melhor legibilidade
            Font defaultFont = new Font("Segoe UI", Font.PLAIN, 13);
            Font titleFont = new Font("Segoe UI", Font.BOLD, 14);
            
            UIManager.put("Button.font", defaultFont);
            UIManager.put("Label.font", defaultFont);
            UIManager.put("TextField.font", defaultFont);
            UIManager.put("TextArea.font", new Font("Consolas", Font.PLAIN, 13));
            UIManager.put("ComboBox.font", defaultFont);
            UIManager.put("TabbedPane.font", titleFont);
            UIManager.put("TitledBorder.font", titleFont);
            
        } catch (Exception e) {
            System.out.println("Não foi possível configurar o tema visual: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 
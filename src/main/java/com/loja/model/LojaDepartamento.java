package com.loja.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe LojaDepartamento que herda da classe Loja
 */
// HERANÇA: A classe LojaDepartamento herda de Loja, que por sua vez herda de Estabelecimento
public class LojaDepartamento extends Loja {
    // Atributos específicos para LojaDepartamento
    private int quantidadeDepartamentos;
    private List<String> departamentos;
    private double areaTotal;
    private boolean temEstacionamento;
    
    // Construtor padrão
    public LojaDepartamento() {
        super(); // Chama o construtor da superclasse
        this.departamentos = new ArrayList<>();
    }
    
    // Construtor com parâmetros
    public LojaDepartamento(String nome, String endereco, String telefone, String cnpj, int quantidadeFuncionarios,
                           String segmento, double faturamentoMensal, int quantidadeProdutos, double metaVendas,
                           int quantidadeDepartamentos, double areaTotal, boolean temEstacionamento) {
        // Chama o construtor da superclasse (Loja)
        super(nome, endereco, telefone, cnpj, quantidadeFuncionarios, segmento, faturamentoMensal, quantidadeProdutos, metaVendas);
        this.quantidadeDepartamentos = quantidadeDepartamentos;
        this.areaTotal = areaTotal;
        this.temEstacionamento = temEstacionamento;
        this.departamentos = new ArrayList<>();
    }
    
    // Métodos getters e setters para encapsulamento dos atributos
    // ENCAPSULAMENTO: Os atributos são privados e só podem ser acessados pelos métodos get e set
    public int getQuantidadeDepartamentos() {
        return quantidadeDepartamentos;
    }
    
    public void setQuantidadeDepartamentos(int quantidadeDepartamentos) {
        this.quantidadeDepartamentos = quantidadeDepartamentos;
    }
    
    public List<String> getDepartamentos() {
        return departamentos;
    }
    
    public void setDepartamentos(List<String> departamentos) {
        this.departamentos = departamentos;
        this.quantidadeDepartamentos = departamentos.size();
    }
    
    public double getAreaTotal() {
        return areaTotal;
    }
    
    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }
    
    public boolean isTemEstacionamento() {
        return temEstacionamento;
    }
    
    public void setTemEstacionamento(boolean temEstacionamento) {
        this.temEstacionamento = temEstacionamento;
    }
    
    // Método para adicionar um departamento
    public void adicionarDepartamento(String departamento) {
        if (!departamentos.contains(departamento)) {
            departamentos.add(departamento);
            quantidadeDepartamentos = departamentos.size();
        }
    }
    
    // Método para remover um departamento
    public boolean removerDepartamento(String departamento) {
        boolean removido = departamentos.remove(departamento);
        if (removido) {
            quantidadeDepartamentos = departamentos.size();
        }
        return removido;
    }
    
    // Método para calcular a densidade da loja (funcionários por departamento)
    public double calcularDensidadeFuncionarios() {
        // Estrutura condicional para evitar divisão por zero
        if (quantidadeDepartamentos > 0) {
            return (double) getQuantidadeFuncionarios() / quantidadeDepartamentos;
        } else {
            return 0;
        }
    }
    
    // Método para calcular a área média por departamento
    public double calcularAreaMediaPorDepartamento() {
        // Estrutura condicional para evitar divisão por zero
        if (quantidadeDepartamentos > 0) {
            return areaTotal / quantidadeDepartamentos;
        } else {
            return 0;
        }
    }
    
    // POLIMORFISMO: Sobrescrita do método da superclasse (Loja)
    @Override
    public double calcularImpostos() {
        // Taxa de imposto específica para lojas de departamento
        double impostoBase = super.calcularImpostos(); // Chama o método da superclasse
        
        // Adicional de imposto para lojas de departamento com muitos departamentos
        if (quantidadeDepartamentos > 10) {
            return impostoBase * 1.1; // Adicional de 10% sobre o imposto base
        } else {
            return impostoBase;
        }
    }
    
    // POLIMORFISMO: Sobrescrita do método da superclasse
    @Override
    public String exibirInformacoes() {
        // Chamada do método da superclasse para exibir informações básicas
        String infoBase = super.exibirInformacoes();
        
        // Adiciona informações específicas da loja de departamento
        StringBuilder info = new StringBuilder(infoBase);
        info.append("\nQuantidade de Departamentos: ").append(quantidadeDepartamentos);
        info.append("\nArea Total: ").append(areaTotal).append(" m2");
        info.append("\nPossui Estacionamento: ").append(temEstacionamento ? "Sim" : "Não");
        info.append("\nDensidade de Funcionarios: ").append(calcularDensidadeFuncionarios()).append(" por departamento");
        info.append("\nArea Media por Departamento: ").append(calcularAreaMediaPorDepartamento()).append(" m2");
        
        // Adiciona a lista de departamentos
        info.append("\nDepartamentos:");
        if (departamentos.isEmpty()) {
            info.append(" Nenhum departamento cadastrado");
        } else {
            // Estrutura de repetição para listar todos os departamentos
            for (String departamento : departamentos) {
                info.append("\n  - ").append(departamento);
            }
        }
        
        return info.toString();
    }
    
    // Método para verificar se a loja é grande (baseado em área e departamentos)
    public boolean isLojaGrande() {
        // Estrutura condicional mais complexa
        if (areaTotal > 5000 && quantidadeDepartamentos > 15) {
            return true;
        } else if (areaTotal > 10000) {
            return true;
        } else {
            return false;
        }
    }
} 
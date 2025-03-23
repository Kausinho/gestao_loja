# Sistema de Gestão de Lojas

Este projeto implementa um sistema de gestão de lojas em Java, seguindo os conceitos de orientação a objetos como encapsulamento, herança e polimorfismo.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
src/
├── main/
│   └── java/
│       ├── com/
│       │   └── loja/
│       │       ├── AppLauncher.java (Classe para iniciar a aplicação gráfica)
│       │       ├── Main.java (Classe principal com lógica de negócios)
│       │       ├── ui/
│       │       │   ├── GestaoLojasUI.java (Interface gráfica do sistema)
│       │       │   └── SplashScreen.java (Tela de boas-vindas)
│       │       └── model/
│       │           ├── Estabelecimento.java (Superclasse)
│       │           ├── Loja.java (Classe principal do tema)
│       │           ├── LojaDepartamento.java (Subclasse de Loja)
│       │           └── Produto.java (Classe auxiliar)
```

## Conceitos Implementados

### Encapsulamento
- Todos os atributos nas classes são privados e acessados através de métodos getters e setters.
- Isso permite controlar o acesso e a modificação dos dados, garantindo integridade.

### Herança
- A classe `Loja` herda da superclasse `Estabelecimento`.
- A classe `LojaDepartamento` herda da classe `Loja`.
- Isso demonstra o reuso de código e a especialização de comportamentos.

### Polimorfismo
- O método `calcularImpostos()` é implementado de forma diferente em cada classe.
- O método `exibirInformacoes()` é sobrescrito nas subclasses para mostrar informações específicas.
- O programa principal usa uma lista de `Estabelecimento` que pode conter diferentes tipos (Estabelecimento, Loja, LojaDepartamento).

### Interface Gráfica
- A aplicação possui uma interface gráfica desenvolvida com Java Swing.
- Interface com tema escuro moderno para melhor visualização.
- Splash screen de boas-vindas ao iniciar a aplicação.
- A interface organiza as informações em abas para facilitar a navegação.
- Os dados são apresentados de forma organizada e estruturada.

## Configurando o Projeto

Este projeto pode ser importado e executado em diferentes IDEs:

### Configuração no VSCode
1. Instale a extensão "Extension Pack for Java"
2. Abra a pasta do projeto
3. O VSCode deve reconhecer automaticamente a estrutura do projeto graças aos arquivos `.vscode/settings.json` e `.classpath`
4. Caso apareça erro de "package does not match expected", verifique se a pasta `src/main/java` está configurada como pasta de origem

### Configuração no Eclipse
1. Use "File > Import > General > Existing Projects into Workspace"
2. Navegue até a pasta do projeto e selecione-a
3. Os arquivos `.project` e `.classpath` já estão configurados para o Eclipse

### Configuração no IntelliJ IDEA
1. Use "File > Open" e selecione a pasta do projeto
2. O IntelliJ deve detectar automaticamente a estrutura do projeto como um projeto Maven ou Gradle
3. Caso necessário, configure a pasta `src/main/java` como pasta de origem (source root)

### Configuração com Maven
O projeto inclui um arquivo `pom.xml` para ser usado com Maven:
```
mvn compile
mvn exec:java -Dexec.mainClass="com.loja.AppLauncher"
```

### Configuração com Gradle
O projeto inclui um arquivo `build.gradle` para ser usado com Gradle:
```
gradle build
gradle run
```

## Como Executar

Para executar o programa com interface gráfica:

1. Compile o projeto com encoding UTF-8:
```
javac -encoding UTF-8 -d out src/main/java/com/loja/*.java src/main/java/com/loja/model/*.java src/main/java/com/loja/ui/*.java
```

2. Execute a classe AppLauncher:
```
java -Dfile.encoding=UTF-8 -cp out com.loja.AppLauncher
```

## Funcionalidades da Interface Gráfica

A interface gráfica do sistema possui quatro abas principais:

1. **Estabelecimento**: Exibe informações básicas de um estabelecimento.

2. **Loja**: Mostra dados de uma loja, incluindo informações gerais e lista de produtos em estoque.

3. **Loja de Departamento**: Apresenta informações sobre uma loja de departamentos, incluindo seus departamentos e produtos.

4. **Relatório Comparativo**: Demonstra o polimorfismo com o cálculo de impostos para os diferentes tipos de estabelecimentos.

## Melhorias Visuais

- **Tema Escuro**: Interface com tema escuro moderno para melhor visualização e redução de fadiga visual.
- **Tipografia Melhorada**: Utilização de fontes otimizadas para leitura em tela.
- **Organização Visual**: Painéis com bordas e títulos bem definidos para melhor organização visual.
- **Tela de Boas-vindas**: Splash screen ao iniciar a aplicação com barra de progresso e informações sobre o sistema.

## Funcionalidades de Negócio

- Criação e gestão de estabelecimentos, lojas e lojas de departamento
- Gerenciamento de produtos em estoque
- Cálculo de impostos por tipo de estabelecimento
- Verificação de metas de vendas
- Gerenciamento de departamentos
- Cálculos diversos como valor total de estoque, densidade de funcionários, etc.

## Resolução de Problemas Comuns

### Erro "package does not match expected"
Se você estiver vendo este erro, é porque a IDE não está reconhecendo corretamente a estrutura de pacotes.
Solução: Configure a pasta `src/main/java` como a raiz dos códigos-fonte do projeto.

### Problemas com Caracteres Especiais
Alguns caracteres especiais podem não ser exibidos corretamente durante a compilação ou execução.
Solução: Compile e execute o projeto especificando a codificação UTF-8:
```
javac -encoding UTF-8 ...
java -Dfile.encoding=UTF-8 ...
``` 
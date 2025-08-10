# Para visualizar o funcionamento do sistema acesse o vídeo de demonstração disponibilizado abaixo  

- Vídeo de demonstração: [acesse aqui](https://youtu.be/QuOj2FnS7Ak?si=aR97ccJHYgDMfh6s)

# Documento de Especificação de Requisitos  
**Sistema de Botão de Pânico**  
Disciplina: Padrões e Projetos  
Professor: Dr. Katyusco Farias Santos  

Autores:  
- Euler Pereira Sobral ([euler.pereira@academico.ifpb.edu.br](mailto:eulersobral80@gmail.com))  
- Edriel José Pacífico Gama ([edriel.jose@academico.ifpb.edu.br](mailto:edriel.jose@academico.ifpb.edu.br))  

**Local:** Campina Grande, PB  
**Data:** 06 de Agosto de 2025  

---

## 1. Introdução

Situações de emergência podem ocorrer no ambiente acadêmico, como acidentes ou episódios de violência.  
O projeto consiste no **desenvolvimento de um botão de pânico** para professores do IFPB, capaz de alertar departamentos e servidores do campus em caso de crise.

Características principais:
- Dispositivo embarcado fixo em salas de aula ou laboratórios.
- Versão para dispositivos móveis e desktop.
- Alerta contendo: sala/laboratório e nome do professor.
- Integração com smartphone e computadores dos servidores.
- Possibilidade de acionar autoridades (polícia ou bombeiros).

---

## 2. Requisitos Não Funcionais

| ID       | Caso de Uso | Descrição |
|----------|-------------|-----------|
| **RNF01** | Professor   | Dispositivo discreto e de fácil acesso para acionar em caso de violência sem chamar atenção do agressor. |
| **RNF02** | Todos       | O sistema deve funcionar de forma eficiente e estável como site web. |
| **RNF03** | Todos       | Aplicativo e sistema devem ter bom tempo de resposta. |
| **RNF04** | Professor   | Uso do botão restrito ao professor. |
| **RNF05** | Servidores  | Aplicativo com boa usabilidade e desempenho em Android e iOS. |
| **RNF06** | Servidores  | Site com boa usabilidade e desempenho nos computadores da instituição. |

---

## 3. Requisitos Funcionais

### 3.1 Cadastro no Sistema  
**ID:** UC01  
**Atores:** Professor e Servidor  
**Descrição:** Cadastrar email, senha e matrícula para acessar funcionalidades.  
**Pré-condição:** Possuir smartphone ou desktop.  
**Pós-condição:** Acesso às funcionalidades.  
**Relacionados:** RNF02, RNF03, RNF05, RNF06  

---

### 3.2 Login no Sistema  
**ID:** UC02  
**Atores:** Professor e Servidor  
**Descrição:** Acessar com email e senha para usar funcionalidades.  
**Pré-condição:** Possuir smartphone e desktop.  
**Pós-condição:** Enviar alerta ou acionar autoridades.  
**Relacionados:** RNF02, RNF03, RNF05, RNF06  

---

### 3.3 Cadastrar Campus  
**ID:** UC03  
**Atores:** Professor e Servidor  
**Descrição:** Cadastrar o campus para instalação do botão físico.  
**Pré-condição:** Usuário logado.  
**Pós-condição:** Acesso ao cadastro de campus.  
**Relacionados:** RNF02, RNF03, RNF05, RNF06  

---

### 3.4 Cadastrar Botão de Sala de Aula  
**ID:** UC04  
**Atores:** Professor e Servidor  
**Descrição:** Cadastrar botão físico para uso em sala de aula.  
**Pré-condição:** Campus já cadastrado.  
**Pós-condição:** Cadastro do botão físico.  
**Relacionados:** RNF02, RNF03, RNF05, RNF06  

---

### 3.5 Acionamento do Dispositivo Embarcado  
**ID:** UC05  
**Atores:** Professor  
**Descrição:** Emitir alerta em situações de emergência.  
**Pré-condição:** Possuir dispositivo.  
**Pós-condição:** Alerta enviado para servidores e departamentos.  
**Relacionados:** RNF01, RNF04  

---

### 3.6 Acionamento do Botão no Celular ou Desktop  
**ID:** UC06  
**Atores:** Professor e Servidores  
**Descrição:**  
- Botão 1: Alerta para todos os funcionários.  
- Botão 2: Alerta + Bombeiros.  
- Botão 3: Alerta + Polícia.  
**Pré-condição:** Possuir acesso a internet em desktop ou celular.  
**Pós-condição:** Alerta enviado por diferentes canais (email, telefone).  
**Relacionados:** RNF02, RNF05, RNF06  

---

### 3.7 Recebimento de Alerta  
**ID:** UC07  
**Atores:** Servidores do IFPB  
**Descrição:** Receber alerta com informações da sala e professor.  
**Pré-condição:** Estar logado no sistema.  
**Pós-condição:** Seguir protocolos de segurança institucional.  
**Fluxo Principal:**  
1. Estar cadastrado e logado.  
2. Receber mensagem com sala e professor.  
**Relacionados:** RNF02, RNF03, RNF04, RNF06  

---


# Loja_Games

Esse projeto representa um código back-end para um programa que simula um banco de dados para uma loja de jogos e periféricos. Possui em suas definições as seguintes tabelas: clientes, pedidos, categorias, itens que já foram comprados e produtos oferecidos pela loja.

Para exemplificar o sistema, como padrão, alguns objetos já estão previamente cadastrados, demonstrando a utilização do CRUD para a classe Clientes(principal). Para as demais classes foi  utilizado o procedimento read, em sua versão ampla (findAll) e versão específica (findById), sendo relativamente rapido a inserção das demais funções do CRUD, caso necessário.

O projeto utiliza a linguagem Java, focada em back-end, com o uso de JPA/HIBERNATE, SPRING BOOT e banco de dados H2, podendo ser adaptado para outro banco de dados. Além disso, conta também com algumas outras ferramentas de desenvolvimento como: Tratamento de Erros e Condicionais.

Banco de dados H2
![Alt text](https://github.com/atilags/loja_games/blob/main/Imagens/Banco_H2.JPG "Banco H2")

Tabela Clientes

![Alt text](https://github.com/atilags/loja_games/blob/main/Imagens/Clientes_H2.JPG "Clientes H2")

Tabela Pedidos

![Alt text](https://github.com/atilags/loja_games/blob/main/Imagens/Pedidos_H2.JPG "Pedidos H2")

Metodo findById na tabela Pedidos, pelo Postman

![Alt text](https://github.com/atilags/loja_games/blob/main/Imagens/Pedidos_Postman.JPG "Pedidos Postman")

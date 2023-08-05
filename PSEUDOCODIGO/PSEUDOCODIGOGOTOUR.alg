Algoritmo "semnome"
//
//
// Descrição   : Progama para cadastro de clientes e destinos de uma agência de viagens
// Autor(a)    : Stéfany Marques
// Data atual  : 8/7/2023

Var

   dados_cliente: vetor[1..1, 1..7] de caractere
   dados_destino: vetor[1..2, 1..5] de caractere
   iniciar: caractere
   opcao, consulta: inteiro

Inicio

   REPITA
      limpatela
      escreval("---------- GOTOUR ----------")
      escreval("Selecione a opção desejada: ")
      escreval(" 1 - CADASTRAR CLIENTE")
      escreval(" 2 - CADASTRAR DESTINO")
      escreval(" 3 - CONSULTAR")
      escreval("----------------------------")
      leia(opcao)

      ESCOLHA opcao

      CASO 1
         limpatela
         escreval("1 - CADASTRAR CLIENTE")

         escreval("Nome Completo:")
         leia(dados_cliente[1,1])
         escreval("Data de Nascimento:")
         leia(dados_cliente[1,2])
         escreval("Endereço(Rua, nº, bairro e cidade):")
         leia(dados_cliente[1,3])
         escreval("CPF:")
         leia(dados_cliente[1,4])
         escreval("RG:")
         leia(dados_cliente[1,5])
         escreval("Telefone:")
         leia(dados_cliente[1,6])
         escreval("E-mail:")
         leia(dados_cliente[1,7])

         escreval("")
         escreval("CADASTRO REALIZADO COM SUCESSO!")
         escreval("")
         escreval("Pressione 'Enter' para voltar ao menu")
         leia(iniciar)

      CASO 2
         limpatela
         escreval("2 - CADASTRAR DESTINO")

         escreval("Nome do destino:")
         leia(dados_destino[1,1])
         escreval("Cidade:")
         leia(dados_destino[1,2])
         escreval("UF")
         leia(dados_destino[1,3])
         escreval("Tipo de transporte (Aéreo/Rodoviário):")
         leia(dados_destino[1,4])
         escreval("Local de Hospedagem:")
         leia(dados_destino[1,5])
         escreval("--------------------------------")
         escreval("DESTINO CADASTRADO COM SUCESSO!")
         escreval("--------------------------------")
         escreval("")
         escreval("Pressione 'Enter' para voltar ao menu")
         leia(iniciar)

      CASO 3
         limpatela
         escreval(" 3 - CONSULTAR REGISTROS ")
         escreval(" -------------------------")
         escreval("")
         escreval("O que deseja consultar?")
         escreval(" 1 - CLIENTE")
         escreval(" 2 - DESTINOS")
         leia(consulta)

         ESCOLHA consulta
         CASO 1
            limpatela
            escreval(" 3 - CONSULTAR REGISTROS: DADOS DO CLIENTE ")
            escreval(" -------------------------")
            escreval("Nome: ", dados_cliente[1,1])
            escreval("Data de Nascimento: ", dados_cliente[1,2])
            escreval("Endereço: ", dados_cliente[1,3])
            escreval("CPF: ", dados_cliente[1,4])
            escreval("RG: ", dados_cliente[1,5])
            escreval("Telefone: ", dados_cliente[1,6])
            escreval("E-mail: ", dados_cliente[1,7])
            escreval(" -------------------------")
            escreval("")
            escreval("Pressione 'Enter' para voltar ao menu ou 'n' para sair")
            leia(iniciar)

         CASO 2
            limpatela
            escreval(" 3 - CONSULTAR REGISTROS: DESTINO ")
            escreval("-------------------------")
            escreval("Nome do destino: ", dados_destino[1,1])
            escreval("Cidade: ", dados_destino[1,2])
            escreval("UF: ", dados_destino[1,3])
            escreval("Tipo de Transporte: ", dados_destino[1,4])
            escreval("Local de Hospedagem: ", dados_destino[1,5])
            escreval("-------------------------")
            escreval("")
            escreval("Pressione 'Enter' para voltar ao menu ou 'n' para sair")
            leia(iniciar)

         OUTROCASO
            escreval("DIGITE UMA OPÇÃO VÁLIDA!")
            leia(iniciar)
         fimEscolha

      OUTROCASO
         escreval("DIGITE UMA OPÇÃO VÁLIDA!")
         escreval("")
         escreval("Pressione 'Enter' para voltar ao menu ou 'n' para sair")
         leia(iniciar)

      fimEscolha
   ATE iniciar = "n"


Fimalgoritmo
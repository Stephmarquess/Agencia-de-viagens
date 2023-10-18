# BANCO DE DADOS - Agência GoTour 

Modelo Conceitual (relacionamentos e cardinalidades), Modelo Lógico, Modelo Físico, Diagrama de Classes (UML)

<h3> REGRAS DE NEGÓCIO </h3>
<ul>
<li> <strong> TABELA CLIENTE-RESERVA:</strong> para o cliente não é obrigatório realizar uma reserva no ato de cadastro no sistema e pode realizar quantas reserva desejar (0,n)</li>
<li> <strong> TABELA RESERVA-CLIENTE:</strong> é obrigatório estar associado a 01 e no máximo 01 Cliente por ocorrência (1,1) </li> 
<li> <strong> TABELA RESERVA - DESTINO: </strong> é obrigatório vincular 01 e no máximo 01 destino no ato do cadastro. Caso demandar outra reserva para mais de um destino, uma nova ocorrência de reserva deve ser feita. (1,1)
<li> <strong> TABELA DESTINO - RESERVA: </strong> não é necessário estar vinculada a um registro de reserva no ato do cadastro e pode se relacionar com quantas reservas for necessário (0,n)</li>
</ul>

<strong> MODELO CONCEITUAL </strong>
<img src="https://raw.githubusercontent.com/Stephmarquess/RECODE-PRO/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Modelo%20Conceitual%20-%20GoTour.png"/>

<strong> MODELO LÓGICO </srong>
<img src="https://raw.githubusercontent.com/Stephmarquess/RECODE-PRO/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Modelo%20L%C3%B3gico%20-%20GoTour.png"/>

<strong> DIAGRAMA DE CLASSES </strong>
<img src="https://github.com/Stephmarquess/RECODE-PRO/blob/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Diagrama%20UML%20-%20GoTour.png?raw=true)https://github.com/Stephmarquess/RECODE-PRO/blob/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Diagrama%20UML%20-%20GoTour.png?raw=true](https://raw.githubusercontent.com/Stephmarquess/RECODE-PRO/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Diagrama%20UML%20-%20GoTour.png)https://raw.githubusercontent.com/Stephmarquess/RECODE-PRO/main/BANCO%20DE%20DADOS/MODELOS%20DO%20BANCO/Diagrama%20UML%20-%20GoTour.png"/>

<strong> MODELO FÍSICO - SQL </strong> 

CREATE DATABASE agenciaGoTour;

<p> CREATE TABLE Cliente (
<br> idCliente INTEGER PRIMARY KEY AUTO_INCREMENT,
<br>nomeCliente VARCHAR(255) NOT NULL,
<br>cpf VARCHAR(13) UNIQUE NOT NULL,
<br>endereco TEXT,
<br>telefone VARCHAR(255) NOT NULL,
<br>email VARCHAR(255) 
<br>) </p>

<p> CREATE TABLE Destino (
<br>idDestino INTEGER PRIMARY KEY AUTO_INCREMENT,
<br>nomeDestino VARCHAR(255) NOT NULL,
<br>descricaoDestino VARCHAR(255) NOT NULL
<br>) </p>

<p> CREATE TABLE Reserva (
<br>idReserva INTEGER PRIMARY KEY AUTO_INCREMENT,
<br>descricaoReserva VARCHAR(255),
<br>valor DOUBLE NOT NULL,
<br>dataIda DATE NOT NULL,
<br>dataVolta DATE NOT NULL,
<br>tipoPagamento TEXT NOT NULL,
<br>idCliente INTEGER,
<br>idDestino INTEGER,
<br>FOREIGN KEY(idCliente) REFERENCES Cliente (idCliente),
<br>FOREIGN KEY(idDestino) REFERENCES Destino (idDestino)
<br>) </p>



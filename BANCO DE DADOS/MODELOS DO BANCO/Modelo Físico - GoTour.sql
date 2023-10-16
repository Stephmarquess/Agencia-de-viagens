CREATE TABLE Cliente (
idCliente INTEGER PRIMARY KEY AUTO_INCREMENT,
nomeCliente VARCHAR(255) NOT NULL,
cpf VARCHAR(13) UNIQUE NOT NULL,
endereco TEXT,
telefone VARCHAR(255) NOT NULL,
email VARCHAR(255) 
)

CREATE TABLE Destino (
idDestino INTEGER PRIMARY KEY AUTO_INCREMENT,
nomeDestino VARCHAR(255) NOT NULL,
descricaoDestino VARCHAR(255) NOT NULL
)

CREATE TABLE Reserva (
idReserva INTEGER PRIMARY KEY AUTO_INCREMENT,
descricaoReserva VARCHAR(255),
valor DOUBLE NOT NULL,
dataIda DATE NOT NULL,
dataVolta DATE NOT NULL,
tipoPagamento TEXT NOT NULL,
idCliente INTEGER,
idDestino INTEGER,
FOREIGN KEY(idCliente) REFERENCES Cliente (idCliente),
FOREIGN KEY(idDestino) REFERENCES Destino (idDestino)
)



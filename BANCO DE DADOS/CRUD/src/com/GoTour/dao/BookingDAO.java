package com.GoTour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Gotour.model.Booking;
import com.Gotour.model.Client;
import com.Gotour.model.Destination;

public class BookingDAO {

	private static String sql;

	private final Connection connection;

	public BookingDAO(Connection connection) {
		this.connection = connection;
	}

// CREATE 

	public void createBooking(Booking booking) {
		sql = "INSERT INTO Reserva (descricaoReserva, valor, dataVolta, dataIda, tipoPagamento, idCliente, idDestino) "
				+ "VALUES (?, ?, DATE ? , DAT	E ? , ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

//			Timestamp date = Timestamp.valueOf(booking.getDataIda().toString());

//			Timestamp sqlAtendimento = Timestamp.valueOf(atendimento.getHorarioAtendimento());
//			Timestamp sqlAgendamento = Timestamp.valueOf(atendimento.getHorarioAgendamento());
//			stmt.setTimestamp(1, sqlAtendimento);

			stmt.setString(1, booking.getDescricaoReserva());
			stmt.setDouble(2, booking.getValor());
			stmt.setString(3, booking.getDataVolta());
			stmt.setString(4, booking.getDataIda());
			stmt.setString(5, booking.getTipoPagamento());
			stmt.setInt(6, booking.getClient().getIdCliente());
			stmt.setInt(7, booking.getDestination().getIdDestino());

			stmt.executeUpdate();
			System.out.println("Reserva registrada com sucesso!" + booking.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

// READ 

	public void readAllBookings() {
		sql = "SELECT * FROM Reserva as r " + "INNER JOIN Cliente as c " + "ON r.idCliente = c.idCliente"
				+ " INNER JOIN Destino as d " + "ON r.idDestino = d.idDestino";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Booking booking = new Booking();

				booking.setIdReserva(r.getInt("idReserva"));
				booking.setDescricaoReserva(r.getString("descricaoReserva"));
				booking.setValor(r.getDouble("valor"));
				booking.setDataIda(r.getString("dataIda"));
				booking.setDataVolta(r.getString("dataVolta"));
				booking.setTipoPagamento(r.getString("tipoPagamento"));

				Client client = new Client();
				client.setIdCliente(r.getInt("idCliente"));
				client.setNomeCliente(r.getString("nomeCliente"));
				client.setCpf(r.getString("cpf"));
				client.setEndereco(r.getString("endereco"));
				client.setTelefone(r.getString("telefone"));
				client.setTelefone(r.getString("email"));

				Destination destination = new Destination();

				destination.setIdDestino(r.getInt("idDestino"));
				destination.setNomeDestino(r.getString("nomeDestino"));
				destination.setDescricaoDestino(r.getString("descricaoDestino"));

				System.out.println("ID Reserva:" + booking.getIdReserva() + "\n Descrição: "
						+ booking.getDescricaoReserva() + " \n Data de Ida: " + booking.getDataIda()
						+ " \n Data de VOLTA: " + booking.getDataVolta() + "\n Tipo de pagamento: "
						+ booking.getTipoPagamento() + " \n Id do Cliente: " + client.getIdCliente() + " \n ID Destino:"
						+ destination.getIdDestino());

			}

		} catch (SQLException e) {
			System.out.println("Não foi possível carregar as informações de Reserva");
			System.out.println("Mensagem" + e.getMessage());
		}

	}

// UPDATE 

	public void updateBooking(Booking booking) {
		sql = "UPDATE Reserva SET descricaoReserva = ?, valor = ?, dataIda = ?, dataVolta = ?, tipoPagamento = ?, idCliente = ?, idDestino = ? WHERE idReserva = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, booking.getIdReserva());
			stmt.setString(2, booking.getDescricaoReserva());
			stmt.setDouble(3, booking.getValor());
			stmt.setString(4, booking.getDataIda());
			stmt.setString(5, booking.getDataVolta());
			stmt.setString(6, booking.getTipoPagamento());
			stmt.setInt(7, booking.getClient().getIdCliente());
			stmt.setInt(8, booking.getDestination().getIdDestino());

			stmt.executeUpdate();

			System.out.println("Reserva atualizada com sucesso! \n" + "Descrição da reserva: "
					+ booking.getDescricaoReserva() + "\n Valor: " + booking.getValor() + "\n Data de IDA: "
					+ booking.getDataIda() + "\n Data de VOLTA: " + booking.getDataVolta() + "\n Tipo de pagamento: "
					+ booking.getTipoPagamento() + "\n Id Cliente: " + booking.getClient().getIdCliente()
					+ "\n Id do Destino: " + booking.getDestination().getIdDestino());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

// DELETE 

	public void deleteBooking(int id) {
		sql = "DELETE FROM Reserva WHERE idReserva = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();

			System.out.println("Reserva deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar a reserva especificada");
			System.out.println(e.getMessage());
		}
	}

}

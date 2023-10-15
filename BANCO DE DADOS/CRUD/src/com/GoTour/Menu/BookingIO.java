package com.GoTour.Menu;

import java.sql.Connection;
import java.util.Scanner;

import com.GoTour.dao.BookingDAO;
import com.Gotour.database.DatabaseConnection;
import com.Gotour.model.Booking;
import com.Gotour.model.Client;
import com.Gotour.model.Destination;

public class BookingIO {

	static Connection connection = DatabaseConnection.createConnection();
	static BookingDAO bookingDAO = new BookingDAO(connection);

	public static int SubMenuBooking(Scanner scanner) {
		int input = Integer.MAX_VALUE;

		do {
			System.out.println(" \n::::::::: ÁREA RESERVA ::::::::: \n ");
			System.out.println(" 1 - Cadastrar Reserva \n" + " 2 - Consultar Reserva \n" + " 3 - Atualizar Reserva \n"
					+ " 4 - Deletar Reserva" + "\n 0 - Voltar \n");
			System.out.println(":::::::::::::::::::::::::::::::: \n ");
			input = scanner.nextInt();

			switch (input) {
			case 1:
				scanner.nextLine();
				Booking booking = new Booking();
				Client clientBooking = new Client();
				Destination destinationBooking = new Destination();

				System.out.println("");
				System.out.println("--------------------------------------------");
				System.out.println("Reserva: CADASTRAR RESERVA");
				System.out.println("--------------------------------------------");

				System.out.println("Descrição da reserva");
				booking.setDescricaoReserva(scanner.nextLine());
				System.out.println("Valor: ");
				booking.setValor(scanner.nextDouble());
				scanner.nextLine();
				System.out.println("Data de IDA (DD/MM/YYY)");
				booking.setDataIda(scanner.nextLine());
				System.out.println("Data de VOLTA (DD/MM/YYY)");
				booking.setDataVolta(scanner.nextLine());
				System.out.println("Tipo de pagamento: ");
				booking.setTipoPagamento(scanner.nextLine());
				System.out.println("ID Cliente: ");
				clientBooking.setIdCliente(scanner.nextInt());
				booking.setClient(clientBooking);
				System.out.println("ID Destino: ");
				destinationBooking.setIdDestino(scanner.nextInt());
				booking.setDestination(destinationBooking);

				bookingDAO.createBooking(booking);

				break;
			case 2:
				System.out.println("");
				System.out.println("--------------------------------------------");
				System.out.println("Reserva: CONSULTAR RESERVA");
				System.out.println("--------------------------------------------");
				bookingDAO.readAllBookings();
				break;
			case 3:
				Booking updateBooking = new Booking();
				Client updateClient = new Client();
				Destination updateDestination = new Destination();

				System.out.println("");
				System.out.println("--------------------------------------------");
				System.out.println("Reserva: ATUALIZAR RESERVA");
				System.out.println("--------------------------------------------");
				
				System.out.println("Digite o ID da reserva a ser atualizado: ");
				updateBooking.setIdReserva(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Descrição do destino");
				updateBooking.setDescricaoReserva(scanner.nextLine());
				System.out.println("Valor: ");
				updateBooking.setValor(scanner.nextDouble());
				System.out.println("Data de IDA");
				scanner.nextLine();
				updateBooking.setDataIda(scanner.nextLine());
				System.out.println("Data de VOLTA");
				updateBooking.setDataVolta(scanner.nextLine());
				System.out.println("Tipo de pagamento: ");
				updateBooking.setTipoPagamento(scanner.nextLine());

				System.out.println("ID Cliente: ");
				updateClient.setIdCliente(scanner.nextInt());
				updateBooking.setClient(updateClient);

				System.out.println("ID Destino: ");
				updateDestination.setIdDestino(scanner.nextInt());
				updateBooking.setDestination(updateDestination);

				bookingDAO.updateBooking(updateBooking);

				break;
			case 4:
				System.out.println("Digite o ID da reserva a ser " + "DELETADO");
				int idReserva = scanner.nextInt();
				bookingDAO.deleteBooking(idReserva);

				break;
			default:


			}

		} while (input != 0);

		return input;
	}

}

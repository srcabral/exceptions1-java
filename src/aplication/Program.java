package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date enter = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date exit = sdf.parse(sc.next());
		
		if (!exit.after(enter)) {
			System.out.println("Error in reservation:"
					+ " Check-out date must be after check-in date!");
		}
		else {
			Reservation rs = new Reservation(room, enter, exit);
			System.out.println("Reservation: " + rs);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			enter = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			exit = sdf.parse(sc.next());
			
			Date now = new Date();
			if(enter.before(now) || exit.before(now))
			{
				System.out.println("Error in reservation: Reservation dates"
						+ "for update must be future");
			}
			else if (!exit.after(enter))
			{
				System.out.println("Erro in reservation: Check-out date"
						+ "must be after check-in date");
			}
			
			rs.updateDates(enter, exit);
		}
		
		sc.close();
	}

}

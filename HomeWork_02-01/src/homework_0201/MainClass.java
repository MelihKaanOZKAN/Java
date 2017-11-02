package homework_0201;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class MainClass {

	static myLinkedList linkedList = new myLinkedList();

	public static void main(String[] args) {
		MainMenu();
	}
	private static void PressEnter() {
		try {
			System.out.println("Press Enter for continue");
			System.in.read();
		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	private static void MainMenu() {
		try {
			Scanner input = new Scanner(System.in);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			int choose = 0;
			do {
				System.out.println("******** LinkedList Operations ********");
				System.out.println("1 - Addition Operations ");
				System.out.println("2 - Remove Operations ");
				System.out.println("3 - Count Elements ");
				System.out.println("4 - Search ");
				System.out.println("5 - Print");
				System.out.println("6 - Help");
				System.out.println("7 - Exit");
				System.out.print("-> ");
				choose = input.nextInt();
				switch (choose) {
				case 1: {
					System.out.println("***************");
					System.out.print("Name: ");
					String name = input.next();
					System.out.print("Surname: ");
					String surname = input.next();
					System.out.print("Birthdate: ");
					String birthDate = input.next();
					System.out.print("Phone Number: ");
					long phoneNumber = input.nextLong();
					Date thedate = format.parse(birthDate);
					linkedList.add(new Element(name, surname, thedate, phoneNumber));
					System.out.println("***************");
					break;
				}
				case 2: {
					MenuRemove();
					break;
				}
				case 3: {
					System.out.println("Element Count:");
					System.out.println(linkedList.getLength());
					PressEnter();
					break;
				}
				case 4: {
					MenuFind();
					PressEnter();
					break;
				}
				case 5: {
					linkedList.printData();
					break;
				}
				case 6: {
					System.out.println("Date Format is dd-MM-yyyy");
					PressEnter();
					break;
				}
				case 7: {
					System.out.println("Good Bye.. ");
					System.exit(0);
				}

				default: {
					System.out.println("Wrong Choose. Try Again");
					break;
				}
				}
			} while (choose != 7);

		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private static void MenuRemove() {
		try {
			Scanner input = new Scanner(System.in);
			int choose = 0;
			do {
				System.out.println("******** Remove Operations ********");
				System.out.println("1 - Remove for Name ");
				System.out.println("2 - Remove for BirthDate ");
				System.out.println("3 - Remove Phone Number ");
				System.out.println("4 - Print ");
				System.out.println("5 - Back ");
				System.out.print("-> ");
				choose = input.nextInt();
				switch (choose) {
				case 1: {
					System.out.print("Name: ");
					String name = input.next();
					linkedList.remove(name);
					break;
				}
				case 2: {
					System.out.print("Birthdate: ");
					String birthDate = input.next();
					Date thedate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(birthDate);
					linkedList.remove(thedate);
					break;
				}
				case 3: {
					System.out.print("Phone Number: ");
					long phoneNumber = input.nextLong();
					linkedList.remove(phoneNumber);
					break;
				}
				case 4: {
					linkedList.printData();
					break;
				}
				case 5: {
					break;
				}
				default: {
					System.out.println("Wrong Choose. Try Again");
					break;
				}
				}
			} while (choose != 5);

		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private static void MenuFind() {
		try {
			Scanner input = new Scanner(System.in);
			int choose = 0;
			do {
				System.out.println("******** Search Operations ********");
				System.out.println("1 - Search for Name ");
				System.out.println("2 - Search for BirthDate ");
				System.out.println("3 - Search for Phone Number ");
				System.out.println("4 - Print ");
				System.out.println("5 - Back ");
				System.out.print("-> ");
				choose = input.nextInt();
				switch (choose) {
				case 1: {
					System.out.print("Name: ");
					String name = input.next();
					System.out.println("Sequence: ");
					System.out.println(linkedList.Search(name));
					break;
				}
				case 2: {
					System.out.print("Birthdate: ");
					String birthDate = input.next();
					Date thedate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(birthDate);
					System.out.println("Sequence: ");
					System.out.println(linkedList.Search(thedate));
					break;
				}
				case 3: {
					System.out.print("Phone Number: ");
					long phoneNumber = input.nextLong();
					System.out.println("Sequence: ");
					System.out.println(linkedList.Search(phoneNumber));
					break;
				}
				case 4: {
					linkedList.printData();
					break;
				}
				case 5: {
					break;
				}
				default: {
					System.out.println("Wrong Choose. Try Again");
					break;
				}
				}
			} while (choose != 5);

		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}

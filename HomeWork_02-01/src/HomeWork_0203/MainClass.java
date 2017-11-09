package HomeWork_0203;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainClass {

	static StackLinkedList stack = new StackLinkedList();

	private static void Test(boolean mode) {
		if (mode) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			try {
				stack.push(new HomeWork_0203.Element("Melih", "Ozkan", format.parse("30-08-1998"),
						Long.parseLong("5448848144")));
				stack.push(new HomeWork_0203.Element("Ali", "Demir", format.parse("30-08-1997"),
						Long.parseLong("5448848145")));
				stack.push(new HomeWork_0203.Element("Burak", "Çit", format.parse("30-08-1996"),
						Long.parseLong("5448848146")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Test(true);
		MainMenu();
	}

	private static void PressEnter() {
		try {
			System.out.println("Press Enter for continue");
			System.in.read();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private static void MainMenu() {
		try {
			Scanner input = new Scanner(System.in);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			int choose = 0;
			do {
				System.out.println("******** Stack with LinkedList Operations ********");
				System.out.println("1 - Addition Operations ");
				System.out.println("2 - Remove Operations ");
				System.out.println("3 - Count of Elements ");
				System.out.println("4 - Search ");
				System.out.println("5 - Print");
				System.out.println("6 - Help");
				System.out.println("7 - Exit");
				System.out.print(">");
				choose = input.nextInt();
				switch (choose) {
				case 1: {
					try {
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
						stack.push(new Element(name, surname, thedate, phoneNumber));
						System.out.println("***************");
					} catch (java.text.ParseException err) {
						System.out.println("Wrong Date Format: Check Help");
					}
					break;
				}
				case 2: {
					stack.pop();
					PressEnter();
					break;
				}
				case 3: {
					System.out.println("Stack Count:");
					System.out.println(stack.Size());
					PressEnter();
					break;
				}
				case 4: {
					MenuFind();
					break;
				}
				case 5: {
					stack.printData();
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
					PressEnter();
					break;
				}
				}
			} while (choose != 7);

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
					int index = stack.search(name);
					if (index == -1) {
						System.out.println("Error: '" + name + "' Could not be found");
					} else {
						System.out.println("The serched name is " + index + " in the stack");
					}
					PressEnter();
					break;
				}
				case 2: {
					try {
						System.out.print("Birthdate: ");
						String birthDate = input.next();
						Date thedate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(birthDate);
						int index = stack.search(thedate);
						if (index == -1) {
							System.out.println("Error: '" + birthDate + "' Could not be found");
						} else {
							System.out.println("The serched birthdate is " + index + " in the stack");
						}
					} catch (java.text.ParseException err) {
						System.out.println("Wrong Date Format: Check Help");
					}
					PressEnter();
					break;
				}
				case 3: {
					System.out.print("Phone Number: ");
					long phoneNumber = input.nextLong();
					int index = stack.search(phoneNumber);
					if (index == -1) {
						System.out.println("Error: '" + phoneNumber + "' Could not be found");
					} else {
						System.out.println("The serched phone number is " + index + " in the stack");
					}
					PressEnter();
					break;
				}
				case 4: {
					stack.printData();
					break;
				}
				case 5: {
					break;
				}
				default: {
					System.out.println("Wrong Choose. Try Again");
					PressEnter();
					break;
				}
				}
			} while (choose != 5);

		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}

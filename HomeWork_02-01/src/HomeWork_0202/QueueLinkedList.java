package HomeWork_0202;

import java.util.Date;
import java.util.LinkedList;

public class QueueLinkedList {
	private LinkedList<Element> list = new LinkedList<Element>();

	public void add(Element element) {
		try {
			list.addLast(element);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove() {
		try {
			if (!list.isEmpty()) {
				Element element = list.getFirst();
				System.out.println("Deleted Data: ");
				System.out.println("Name / Surname / Birthdate / Phone number");
				printData(element);
				list.removeFirst();
				PressEnter();
			} else {
				System.out.println("Queue is EMPTY");
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void printData() {
		try {
			if (list.isEmpty()) {
				System.out.println("Error: Queue is EMPTY");
				PressEnter();
				return;
			}
			System.out.println("Name / Surname / Birthdate / Phone number");
			for (int i = 0; i < list.size(); i++) {
				printData(list.get(i));
			}
			PressEnter();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private static void PressEnter() {
		try {
			System.out.println("Press Enter for continue");
			System.in.read();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void printData(Element element) {
		try {
			System.out.println(element.getName() + " / " + element.getSurname() + " / " + element.getBirthDate() + " / "
					+ element.getPhoneNumber());
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int Size() {
		return list.size();
	}

	public int Search(String name) {
		int result = -1;
		try {
			if (!isEmpty()) {
				return result;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equalsIgnoreCase(name)) {
					result = i + 1;
					break;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int Search(Date birthDate) {
		int result = -1;
		try {
			if (!isEmpty()) {
				return result;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBirthDate().equals(birthDate)) {
					result = i + 1;
					break;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int Search(long phoneNumber) {
		int result = -1;
		try {
			if (!isEmpty()) {
				return result;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getPhoneNumber() == phoneNumber) {
					result = i + 1;
					break;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

}

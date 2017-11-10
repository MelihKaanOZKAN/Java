package HomeWork_0203;

import java.util.Date;
import java.util.LinkedList;

/****************************************************************************
 ** ÝNÖNÜ ÜNÝVERSÝTESÝ  MÜHENDÝSLÝK FAKÜLTESÝ  BÝLGÝSAYAR MÜHENDÝSLÝÐÝ BÖLÜMÜ
 ** VERÝ YAPILARI DERSÝ  2   NOLU ÖDEV   4   NOLU SORUNUN ÇÖZÜMÜ
 ** ÖÐRENCÝ ADI......: MELÝH KAAN ÖZKAN 
 ** ÖÐRENCÝ NUMARASI....:  02160001012 
 **
 ****************************************************************************/

public class StackLinkedList {
	private LinkedList<Element> list = new LinkedList<Element>();

	public void push(Element element) {
		try {
			list.addLast(element);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void pop() {
		try {
			if (!list.isEmpty()) {
				Element element = list.getLast();
				System.out.println("Deleted Data: ");
				System.out.println("Name / Surname / Birthdate / Phone number");
				printData(element);
				list.removeLast();
			} else {
				System.out.println("Stack is EMPTY");
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void printData() {
		try {
			if (list.isEmpty()) {
				System.out.println("Error: Stack is EMPTY");
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

	public int search(String name) {
		int result = -1;
		try {
			if (isEmpty()) {
				return result;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName() == name) {
					result = i + 1;
					break;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int search(Date birthDate) {
		int result = -1;
		try {
			if (isEmpty()) {
				return result;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBirthDate() == birthDate) {
					result = i + 1;
					break;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int search(long phoneNumber) {
		int result = -1;
		try {
			if (isEmpty()) {
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

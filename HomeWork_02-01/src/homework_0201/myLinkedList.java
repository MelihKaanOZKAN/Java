package homework_0201;

import java.util.Date;

/****************************************************************************
** ÝNÖNÜ ÜNÝVERSÝTESÝ 
** MÜHENDÝSLÝK FAKÜLTESÝ 
** BÝLGÝSAYAR MÜHENDÝSLÝÐÝ BÖLÜMÜ
** VERÝ YAPILARI DERSÝ 
** 2   NOLU ÖDEV   2   NOLU SORUNUN ÇÖZÜMÜ
**ÖÐRENCÝ ADI......: MELÝH KAAN ÖZKAN
** ÖDEV NUMARASI....:  02160001012
** ÖDEV KONUSU......:
**
****************************************************************************/

public class myLinkedList {

	private Element root = null;

	/**
	 * @param element
	 *            the element to add last
	 */
	public void add(Element element) {
		try {
			Element iter = root;
			if (root == null) {
				root = element;
				return;
			}
			while (iter.next != null) {
				iter = iter.next;
			}
			iter.next = element;
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private void PressEnter() {
		try {
			System.out.println("Press Enter for continue");
			System.in.read();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove(String name) {
		try {
			if (root == null) {
				System.out.println("Error: No DATA");
				return;
			}
			Element iter = root;
			if (iter.getName().equalsIgnoreCase(name)) {
				root = iter.next;
				System.out.println("Success!");
				return;
			}
			while (iter.next != null && !iter.next.getName().equalsIgnoreCase(name)) {
				iter = iter.next;
			}
			if (iter.next == null && !(iter.getName().equalsIgnoreCase(name))) {
				System.out.println("Error: '" + name + "' Could not be found");
			} else {
				if (iter.next.next == null) {
					iter.next = null;
					System.out.println("Success!");
					return;
				}
				iter.next = iter.next.next;
				System.out.println("Success!");
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove(Date birthDate) {
		try {
			if (root == null) {
				System.out.println("Error: No DATA");
				return;
			}
			Element iter = root;
			if (iter.getBirthDate().equals(birthDate)) {
				root = iter.next;
				System.out.println("Success!");
				return;
			}
			while (iter.next != null && !(iter.getBirthDate().equals(birthDate))) {
				iter = iter.next;
			}

			if (iter.next == null && !(iter.next.getBirthDate().equals(birthDate))) {
				System.out.println("Error: '" + birthDate + "' Could not be found");
			} else {
				if (iter.next.next == null) {
					iter.next = null;
					System.out.println("Success!");
					return;
				}
				iter.next = iter.next.next;
				System.out.println("Success!");
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove(long phoneNumber) {
		try {
			if (root == null) {
				System.out.println("Error: No DATA");
				return;
			}
			Element iter = root;
			if (iter.getPhoneNumber() == phoneNumber) {
				root = iter.next;
				System.out.println("Success!");
				return;
			}
			while (iter.next != null && !(iter.next.getPhoneNumber() == phoneNumber)) {
				iter = iter.next;
			}

			if (iter.next == null && !(iter.getPhoneNumber() == phoneNumber)) {
				System.out.println("Error: '" + phoneNumber + "' Could not be found");
			} else {
				if (iter.next.next == null) {
					iter.next = null;
					System.out.println("Success!");
					return;
				}
				iter.next = iter.next.next;
				System.out.println("Success!");
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public int getLength() {
		int result = 0;
		Element iter = root;
		try {
			if (iter == null) {
				return 0;
			}
			while (iter != null) {
				iter = iter.next;
				result++;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int Search(String name) {
		int result = 1;
		Element iter = root;
		try {
			if (iter.getName().equalsIgnoreCase(name)) {
				return result;
			}
			while (iter.next != null && !iter.next.getName().equalsIgnoreCase(name)) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getName().equalsIgnoreCase(name)) {
				System.out.println("Error: '" + name + "' Could not be found");
			} else {
				result++;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int Search(Date birthDate) {
		int result = 1;
		Element iter = root;
		try {
			if (iter.getBirthDate().equals(birthDate)) {
				return result;
			}
			while (iter.next != null && (!iter.next.getBirthDate().equals(birthDate))) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getBirthDate().equals(birthDate)) {
				System.out.println("Error: '" + birthDate + "' Could not be found");
			} else {
				result++;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public int Search(long phoneNumber) {
		int result = 1;
		Element iter = root;
		try {
			if (iter.getPhoneNumber() == phoneNumber) {
				return result;
			}
			while (iter.next != null && iter.next.getPhoneNumber() != phoneNumber) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getPhoneNumber() != phoneNumber) {
				System.out.println("Error: '" + phoneNumber + "' Could not be found");
			} else {
				result++;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		return result;
	}

	public void printData() {
		try {
			Element iter = root;
			if (root == null) {
				System.out.println("List is EMPTY");
				return;
			}
			System.out.println("Name / Surname / BirthDate / PhoneNumber");
			while (iter != null) {
				System.out.println(iter.getName() + " / " + iter.getSurname() + " / " + iter.getBirthDate() + " / "
						+ iter.getPhoneNumber());
				iter = iter.next;
			}
			PressEnter();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}

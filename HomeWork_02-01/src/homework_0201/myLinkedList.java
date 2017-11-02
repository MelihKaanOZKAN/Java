package homework_0201;

import java.util.Date;

public class myLinkedList {

	private Element root = null;

	/**
	 * @param element
	 *            the element to add last
	 */
	public void add(Element element) {
		try {
			Element iter = root;
			if(root == null)
			{
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
		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	public void remove(String name) {
		try {
			Element iter = root;
			while (iter.next != null && iter.next.getName() != name) {
				iter = iter.next;
			}
			if (iter.next == null && iter.getName() != name) {
				System.out.println("Error: '" + name + "' Could not be found");
			} else {
				iter.next = iter.next.next;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove(Date birthDate) {
		try {
			Element iter = root;
			while (iter.next != null && iter.next.getBirthDate() != birthDate) {
				iter = iter.next;
			}
			if (iter.next == null && iter.getBirthDate() != birthDate) {
				System.out.println("Error: '" + birthDate + "' Could not be found");
			} else {
				iter.next = iter.next.next;
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public void remove(long phoneNumber) {
		try {Element iter = root;
			while (iter.next != null && iter.next.getPhoneNumber() != phoneNumber) {
				iter = iter.next;
			}
			if (iter.next == null && iter.getPhoneNumber() != phoneNumber) {
				System.out.println("Error: '" + phoneNumber + "' Could not be found");
			} else {
				iter.next = iter.next.next;
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
		int result= 1;
		Element iter = root;
		try {
			while (iter.next != null && iter.next.getName() != name) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getName() != name) {
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
		int result= 1;
		Element iter = root;
		try {
			while (iter.next != null && iter.next.getBirthDate() != birthDate) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getBirthDate()!= birthDate) {
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
		int result= 1;
		Element iter = root;
		try {
			while (iter.next != null && iter.next.getPhoneNumber() != phoneNumber) {
				iter = iter.next;
				result++;
			}
			if (iter.next == null && iter.getPhoneNumber()!= phoneNumber) {
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
			if (root == null)
			{
				System.out.println("List is EMPTY");
				return;
			}
			System.out.println("Name / Surname / BirthDate / PhoneNumber");
				while(iter != null)
				{
					System.out.println(iter.getName() + " / " + iter.getSurname() + " / " + iter.getBirthDate() + " / " + iter.getPhoneNumber());
					iter = iter.next;
				}
				PressEnter();
		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}

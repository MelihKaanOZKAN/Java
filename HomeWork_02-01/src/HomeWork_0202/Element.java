package HomeWork_0202;

import java.util.Date;

/****************************************************************************
** ÝNÖNÜ ÜNÝVERSÝTESÝ 
** MÜHENDÝSLÝK FAKÜLTESÝ 
** BÝLGÝSAYAR MÜHENDÝSLÝÐÝ BÖLÜMÜ
** VERÝ YAPILARI DERSÝ 
** 2   NOLU ÖDEV   3   NOLU SORUNUN ÇÖZÜMÜ
**ÖÐRENCÝ ADI......: MELÝH KAAN ÖZKAN
** ÖDEV NUMARASI....:  02160001012
** ÖDEV KONUSU......:
**
****************************************************************************/

public class Element {
	private String name, surname;
	private Date birthDate;
	private long phoneNumber;
	public Element next;

	public Element(String name, String surname, Date birthDate, long phoneNumber) {
		try {
			this.setName(name);
			this.setSurname(surname);
			this.setBirthDate(birthDate);
			this.setPhoneNumber(phoneNumber);
			this.next = null;
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

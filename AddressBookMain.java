package com.BrigelabzAddressBook;
import java.util.Scanner;

public class AddressBookMain {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		AddressUC1 addressBook = new AddressUC1();
		while (true) {
			System.out.println("Enter what you have to do");
			System.out.println("" + " 1 Add Contact " + "\n 2 Edit Contact " + "\n 3 Delete Contact");

			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1:
				addressBook.addContact();
				break;

			case 2:
				System.out.println("Enter the FirstName");
				String firstName = scanner.next();
				addressBook.editContact(firstName);
				break;

			case 3:
				System.out.println("Enter the FirstName");
				String phoneNumberToDelete = scanner.next();
				addressBook.deleteContact(phoneNumberToDelete);
				break;

			default:
				System.out.println("Please Enter Proper Option");
			}
		}
	}

}

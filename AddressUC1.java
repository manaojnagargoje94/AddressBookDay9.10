package com.BrigelabzAddressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class AddressUC1 {
	HashMap<String, LinkedList<Contact>> addressBooks = new HashMap<>();
	Scanner scanner = new Scanner(System.in);
	public static final String FILE_PATH = "C:\\Users\\MY PC\\Desktop//addressBook.txt";

	public Contact addContact() {
		Contact contact = new Contact();
		LinkedList<Contact> allContacts = new LinkedList<Contact>();
		System.out.println("Enter First Name");
		contact.setFirstname(scanner.next());
		System.out.println("Enter last Name");
		contact.setLastname(scanner.next());
		System.out.println("Enter City");
		contact.setCity(scanner.next());
		System.out.println("Enter State");
		contact.setState(scanner.next());
		System.out.println("Enter Pincode");
		contact.setZipcode(scanner.nextInt());
		System.out.println("Enter Phone Number");
		contact.setPhonenumber(scanner.next());
		System.out.println("Enter Email");
		contact.setEmail(scanner.next());
		System.out.println("Enter Book name to which you have to add contact");
		String bookName = scanner.next();

		if (addressBooks.containsKey(bookName)) {
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			addContactToExsistingBook(contact, bookName, contactList);
		} else {
			allContacts.add(contact);
			addressBooks.put(bookName, allContacts);
			System.out.println("New book created and Contact Added Sucessfully");
		}

		return contact;
	}

	public void deleteContact(String firstName) {
		if (addressBooks.containsKey(firstName)) {
			LinkedList<Contact> contactList = addressBooks.get(firstName);
			for (Contact contact : contactList) {
				contactList.remove(contact);
				System.out.println("Deleted Sucessfully");
			}
		}else {
			System.out.println("Book record not found");
		}
	}

	public void editContact(String firstName) {
		if (addressBooks.containsKey(firstName)) {
			LinkedList<Contact> contactList = addressBooks.get(firstName);
			for (Contact contact : contactList) {
					System.out.println("Enter last Name");
					String lastName = scanner.next();
					System.out.println("Enter address");
					String address = scanner.next();
					System.out.println("Enter City");
					String city = scanner.next();
					System.out.println("Enter State");
					String state = scanner.next();
					System.out.println("Enter zip");
					String zip = scanner.next();
					contact.setFirstname(firstName);
					contact.setLastname(lastName);
					contact.setCity(city);
					contact.setState(state);
					contact.setState(zip);
					System.out.println("Edit details Sucessfully");
			}
		}else {
			System.out.println("Record not found");
		}
		
	}

   // add multiple person in address book.
	private void addContactToExsistingBook(Contact contact, String bookName, LinkedList<Contact> contactList) {
		boolean isAlreadyExsist = contactList.stream()
				.anyMatch(contactsInlist -> contactsInlist.getFirstname() == contact.getFirstname());
		if (!(isAlreadyExsist)) {
			contactList.add(contact);
			addressBooks.put(bookName, contactList);
			System.out.println("New Contact Added Sucessfully");
		} else {
			System.out.println("Contact already exsists");
		}
	}

}

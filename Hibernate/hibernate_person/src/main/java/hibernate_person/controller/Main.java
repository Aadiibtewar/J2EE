package hibernate_person.controller;

import java.util.Scanner;



import hibernate_person.dao.PersonDao;
import hibernate_person.dto.Person;



public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		Person person =new Person();
		PersonDao dao = new PersonDao();
		
		
		System.out.println("Press \n1.Signup\n2.Login");
		
		switch (scanner.nextInt()) {
		case 1:
		{
			System.out.println("Enter the ID ");
			person.setId(scanner.nextInt());
			
			System.out.println("enter the name");
			person.setName(scanner.next());
			
			System.out.println("Enter the phone number");
			person.setPhone(scanner.nextLong());
			
			System.out.println("Enter the email");
			person.setEmail(scanner.next());
			
			System.out.println("enter the password");
			person.setPassword(scanner.next());
			
			dao.savePerson(person);
		}
			break;
			
		case 2:
		{
			System.out.println("Enter the email");
			String email=scanner.next();
			
			System.out.println("enter the password");
			String password =scanner.next();
			
			Person dbPassword = dao.getPerson(email);
		
			if (dbPassword!=null) {
				if (password.equals(dbPassword.getPassword())) {
					System.out.println("login Successful!");
					
					System.out.println("Press \n1.find\n2.delete\n3.update");
					
					switch (scanner.nextInt()) {
					case 1://find
					{
						System.out.println("press \n1. by Id\n2. by phone \n3.by name");
						switch (scanner.nextInt()) {
						case 1://by id
						{
							System.out.println("Enter the id");
							System.out.println(dao.findById(scanner.nextInt()));
						}
							break;
							
						case 2://by phone
						{
							System.out.println("Enter the Phone Number");
							System.out.println(dao.findByPhone(scanner.nextLong()));
						}
						break;

						case 3 ://By name
						{
							System.out.println("Enter the Name ");
							System.out.println(dao.findByName(scanner.next()));
							
						}
							break;
						default:
						{
							System.out.println("Choose proper option");
							
						}
							break;
						}
					}
						break;
						
					case 2://delete
					{
						System.out.println("press \n1.delete by Id\n2.delete by phone\n3.delete by email ");
						switch (scanner.nextInt()) {
						case 1://by id
						{
							System.out.println("Enter the Id");
							dao.deleteById(scanner.nextInt());
							
						}
							break;
						case 2://by phone
						{
							System.out.println("Enter the number");
							dao.deleteByPhone(scanner.nextLong());
						}
						
						break;
						case 3://by email
						{

							System.out.println("Enter the Email");
							dao.deleteByEmail(scanner.next());
						}
						break;
						default:
						{
							System.out.println("Choose proper option");
						}
							break;
						}
						
						
					}
					break;
					case 3://update
					{
						System.out.println("Enter the ID ");
						person.setId(scanner.nextInt());
						Person id=dao.findById(person.getId());
						
						if (id!=null) {
							System.out.println("enter the name");
							person.setName(scanner.next());
							
							System.out.println("Enter the phone number");
							person.setPhone(scanner.nextLong());
							
							System.out.println("Enter the email");
							person.setEmail(scanner.next());
							
							System.out.println("enter the password");
							person.setPassword(scanner.next());
							
							dao.updatePerson(person);
						}
						else {
							System.out.println("Id not found");
						}
					}
					
						break;
					default:
					{
						System.out.println("Choose proper option");
					}
						break;
					}
					
				}
				else {
					System.out.println("invalid password");
				}
			}
			else {
				System.out.println("person not found");
			}
		}
		break;

		default:{
			System.out.println("Choose proper option");
		}
			break;
		
		}
	}
}

package jdbc_person;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

public class PersonMain {

	public PersonMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PersonCRUD crud = new PersonCRUD();

		System.out.println("-----------Welcome--------- \n1.SignUp \n2.Login \n3.Exit");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the id");
			int id = scanner.nextInt();

			System.out.println("Enter the name");
			String name = scanner.next();

			System.out.println("Enter the phone");
			long phone = scanner.nextLong();

			System.out.println("Enter the email");
			String email = scanner.next();

			System.out.println("Enter the password");
			String password = scanner.next();

			Person person = new Person();
			person.setId(id);
			person.setName(name);
			person.setEmail(email);
			person.setPhone(phone);
			person.setPassword(password);

			int result = crud.signUpPerson(person);

			if (result != 0) {
				System.out.println("Sign up Successfully!");
			} else {
				System.out.println("Sign up failed");
			}
		}

			break;
			
			//------------login switch----------
		case 2: {

			System.out.println("Enter your email");
			String email = scanner.next();

			System.out.println("Enter your password");
			String password = scanner.next();
			boolean flag = false;

			String dbPassword = crud.getPassword(email);
			// boolean loggedIn = false;

			if (dbPassword != null) {
				if (password.equals(dbPassword)) {
					System.out.println("login successful");
					
					//--------After login process--------
					System.out.println("1.DisplayInfo \n2.Update Password \n3.Delete account");

					int newChoice = scanner.nextInt();

					switch (newChoice) {
					case 1: {

						crud.getInfo(email);
						break;
					}
					
					case 2: {
						System.out.println("enter old password");
						String oldPassword = scanner.next();

						System.out.println("enter new password");
						String newPassword = scanner.next();
						int result = crud.updatePassword(oldPassword, newPassword);

						if (result != 0) {
							System.out.println("Password changed!");
						} else {
							System.out.println("Enter correct Old password");
						} //
					} // case 2 end here...

					case 3: {
						System.out.println("Enter password to delete account");
						String delPassword = scanner.next();
						System.out.println("Are you sure to delete account \ny/n");
						char ch = scanner.next().charAt(0);
						if (ch == 'y') {
							int result = crud.deleteAccount(delPassword);
							if (result != 0) {
								System.out.println("Account deleted!!");
								break;
							} else {
								System.out.println("something went wrong");
							}
						} else {
							break;
						}
					} // case 3 end of login

					}
				} else {
					System.out.println("invalid password");
				}

			} else {
				System.out.println("person not register");

			}

			break;
		}
		// case 3 exit starts here...
		case 3:
			System.out.println("Thank you !!!\nVisit again.....");
			return;

		default:
			System.out.println("choose proper option.....");
			break;
		}

	}

}

package com.contactinfo;

public class Contactmanager {
	Contact[] myFriends = new Contact[5];
	int i = 0;
	boolean updateFlag = false;
	boolean foundFlag = false; 
	boolean deleteFlag = false;

	public static void main(String[] args) {
		System.out.println("Welcome you can now store your contacts");
		Contactmanager conM = new Contactmanager();
		Contact con1;
		con1 = new Contact();
		con1.name = "sankalp";
		con1.mobile = "9008756884";
		con1.email = "sankalp@tc.com";

		conM.addContact(con1);

		Contact con2;
		con2= new Contact();
		con2.name = "jonny";
		con2.mobile = "9876423452";
		con2.email = "jonny@gmail.com";
		conM.addContact(con2);
		conM.modifyContact("jonny","9876423433");
		try{
		Contact c3 = conM.searchContact("sankalp");
		System.out.println(c3.mobile);
		System.out.println(c3.email);
		}
		catch(NullPointerException e){
			System.out.println("contact does not exist in the contact list");
	}
		conM.deleteContact("sankalp");
	}

	public void addContact(Contact con) {
		myFriends[i] = con;
		i++;
		System.out.println("contact added:" + con.name);
	}

	public void modifyContact(String name, String mobile) {
		for (i = 0; i < myFriends.length; i++) {
			try {
				if (myFriends[i].name == name) {
					myFriends[i].mobile = mobile;
					updateFlag = true;
					System.out.println("the contact modified: " + name + " modified mobile number is" + mobile);
					break;
				}
			} catch (NullPointerException e) {
				updateFlag = false;
			}
		}
		if (updateFlag == false) {
			System.out.println("the contact you are searching for(" + name + ")does not exist");
		}
	}

	public Contact searchContact(String name) {
		Contact con = null;
		for (int i = 0; i <= myFriends.length - 1; i++) {
			if (myFriends[i].name.equals(name)) {
				foundFlag = true;
				System.out.println("the mobile number is" + myFriends[i].mobile);
			 con=myFriends[i];
			 break;
			}
		}
		if (foundFlag == false) {
			System.out.println("the contact" + name + "does not exist");
		}
		return con;

	}
	public void deleteContact(String name){
		for( i=0;i<myFriends.length;i++){
			try{
			if(myFriends[i].name.equals(name)){
				deleteFlag = true;
				System.out.println("the deleted contact is " +name);
				break;
				
			}
		}catch(NullPointerException e)
			{
				deleteFlag = false;
			}
		}
		if(deleteFlag == false) {
			System.out.println("the contact"+name+" does not exist");
		}
	}

}

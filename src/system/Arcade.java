package system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import people.*;

public class Arcade {
	private ArrayList<User> userList;
	
	public Arcade() {
		userList = new ArrayList<User>();
	}
	
	public ArrayList<User> getUserList(){
		return userList;
	}
	
	public void setUserList(ArrayList<User> list) {
		userList = list;
	}
	
	public void addUser(User u) {
		userList.add(u);
		if (u.getIsGuest() == true) {
			System.out.println("Guest is added to the database");
		} else if (u.getIsGuest() == false) {
			System.out.println("Player " + u.getName() + " is added to the database");
		}
		
	}
	
	public void saveArcadeState(Arcade this) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream("Arcade.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(this);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }		
 	}
	
	public Arcade loadArcadeState() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Arcade arc=null;
			
		try {
			fileIn = new FileInputStream("Arcade.ser");
			objIn = new ObjectInputStream(fileIn);
			arc = (Arcade) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		return arc;
	}
}

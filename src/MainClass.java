import business.*;
import presentation.*;

public class MainClass {
	public static void main(String[] args){
		View v = new View();
		UserService us = new UserService();
		BookService bs = new BookService();
		Controller c = new Controller(v,bs,us);
	}
}

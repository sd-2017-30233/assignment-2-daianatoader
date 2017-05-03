package report;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.BookService;
import model.Book;

public class GenerateCSV implements Report{
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "title,author,genre,price";

	@Override
	public void generate(String username) {
		
		BookService bs = new BookService();
		ArrayList<Book> b = bs.getAll();
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter("books.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (int i = 0; i<b.size(); i++) {
				if(b.get(i).getQuantity()==0){
					fileWriter.append(b.get(i).getTitle());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(b.get(i).getAuthor());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(b.get(i).getGenre());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(b.get(i).getPrice()));
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
			}

			
			
			JOptionPane.showMessageDialog(null,"Raport csv creat cu succes!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
                e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args){
		GenerateCSV g = new GenerateCSV();
		g.generate("daia");
	}

}

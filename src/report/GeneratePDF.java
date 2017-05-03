package report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Book;
import model.User;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import business.*;

public class GeneratePDF implements Report{

	@Override
	public void generate(String username) {
		UserService us = new UserService();
		BookService bs = new BookService();
		User u = us.getUser(username);
		ArrayList<Book> b = bs.getAll();
		 Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		  try {
		   PdfWriter.getInstance(document , new FileOutputStream("books.pdf"));
		   
		   document.addAuthor(u.getName()); 
		   document.addSubject("Out of stock books"); 
		   
		   document.open(); 
		   for(int i=0; i<b.size();i++){
			   if(b.get(i).getQuantity()==0){ 
				   document.add(new Paragraph("					BOOK"));
				   document.add(new Paragraph("Title: "+b.get(i).getTitle()));
				   document.add(new Paragraph("Author: "+b.get(i).getAuthor()));
				   document.add(new Paragraph("Genre: "+b.get(i).getGenre()));
				   document.add(new Paragraph("Price: "+b.get(i).getPrice()));
			   }
		   }
		   JOptionPane.showMessageDialog(null, "Raport pdf generat cu succes!");
		  
		  } catch(DocumentException de) {
		   System.err.println(de.getMessage());
		  } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  document.close();
	}
	public static void main(String[] args){
		GeneratePDF p = new GeneratePDF();
		p.generate("daia");
	}
		
	}



package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.*;
import model.*;
import report.GenerateReport;
import report.Report;

public class Controller {
	private View v;
	private BookService bs;
	private UserService us;
	
	public static String username = "unknown";
	public static String password = "unknown";
	
	public static String usernameTable = "unknown";
	
	
	public Controller(View v, BookService bs, UserService us){
		this.v = v;
		this.bs = bs;
		this.us = us;
		v.logIn(new LogInListener());
		v.addBookLogOut(new AddBLogOutListener());
		v.addBook(new AddBookListener());
		v.addUser(new AddUserListener());
		v.addUserLogOut(new AddUserLogOutListener());
		v.AuthorSearch(new AuthorSearchListener());
		v.SearchTitle(new TitleSearchListener());
		v.FictionSearch(new FictionListener());
		v.NonFictionSearch(new NonFictionListener());
		v.BuyBook(new BuyListener());
		v.UpdatePrice(new UpdatePriceListener());
		v.UpdateQuantity(new UpdateQuantityListener());
		v.ViewBookLogOut(new ViewBookLogOutListener());
		v.GenerateReport(new GenerateReportListener());
		v.Update(new UL());
		v.Select(new SL());
		v.Delete(new DL());
		v.LogOut(new LOL());
	}
	
	public class UL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int row = v.getTable().getSelectedRow();
			int column = v.getTable().getColumnCount();
			for(int i = 0; i < column; i++) {
				
				v.getTable().setValueAt(v.getTable().getValueAt(row, i), row, i);
				v.getModel().fireTableDataChanged();
				
			}
			us.update(usernameTable, v.getTable().getValueAt(row, 0).toString(),  v.getTable().getValueAt(row, 1).toString(),  v.getTable().getValueAt(row, 2).toString(), Integer.parseInt( v.getTable().getValueAt(row, 3).toString()));
			
			v.getModel().setRowCount(0);
			ArrayList<User> u = us.getAll();
			for(int i=0; i<u.size(); i++){
				v.getModel().addRow(new Object[]{u.get(i).getName(),u.get(i).getUsername(),u.get(i).getPassword(),u.get(i).getType()});
			}
			v.getModel().fireTableDataChanged();
			v.getTable().clearSelection();
		}
	}
	public class SL implements ActionListener{
		public void actionPerformed(ActionEvent e){

			int row = v.getTable().getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "Select user!");
				return;
			}
			 usernameTable = v.getTable().getValueAt(row, 1).toString();
			 
		}
	}
	public class DL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int row = v.getTable().getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "Select user!");
				return;
			}
			us.delete(v.getTableB().getValueAt(row, 1).toString());
			v.getModel().setRowCount(0);
			ArrayList<User> u = us.getAll();
			for(int i=0; i<u.size(); i++){
				v.getModel().addRow(new Object[]{u.get(i).getName(),u.get(i).getUsername(),u.get(i).getPassword(),u.get(i).getType()});
			}
			v.getModel().fireTableDataChanged();
			v.getTable().clearSelection();
		}
	}
	
	public class LOL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			v.getTabbedPane().setSelectedIndex(0);
			v.getTabbedPane().setEnabledAt(1,false);
			v.getTabbedPane().setEnabledAt(2,false);
			v.getTabbedPane().setEnabledAt(3,false);
			v.getTabbedPane().setEnabledAt(4,false);
			
		}
	}
	public class GenerateReportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			GenerateReport r = new GenerateReport();
			if(v.getPdf().isSelected()){
				Report rep = r.getReport("PDF");
				rep.generate(username);
				v.getPdf().setSelected(false);
			}
			
			if(v.getCsv().isSelected()){
				Report rep2 = r.getReport("CSV");
				rep2.generate(username);
				v.getCsv().setSelected(false);
			}
			
			if(v.getPdf().isSelected() && v.getCsv().isSelected()){
				Report rep = r.getReport("PDF");
				rep.generate(username);
				Report rep2 = r.getReport("CSV");
				rep2.generate(username);
				v.getCsv().setSelected(false);
				v.getPdf().setSelected(false);
			}
			
		}
	}
	public class AuthorSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(v.getAuthorSearch().equals(null)){
				JOptionPane.showMessageDialog(null, "Camp obligatoriu!");
				v.setAuthorSearch("");
				return;
			}
			ArrayList<Book> b = bs.getByAuthor(v.getAuthorSearch());
			v.getModelB().setRowCount(0);
			for(int i = 0; i<b.size();i++){
				v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
			}
			v.getModelB().fireTableDataChanged();
			v.setAuthorSearch("");
		}
		}
	public class TitleSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(v.getAuthorSearch().equals(null)){
				JOptionPane.showMessageDialog(null, "Camp obligatoriu!");
				v.setTitleSearch("");
				return;
			}
			Book b = bs.getBook(v.getTitleSearch());
			v.getModelB().setRowCount(0);
		
				v.getModelB().addRow(new Object[]{b.getTitle(),b.getAuthor(),b.getGenre(),b.getQuantity(),b.getPrice()});
			
			v.getModelB().fireTableDataChanged();
			v.setTitleSearch("");
		}
		}
	public class FictionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<Book> b = bs.getByGenre("Fiction");
			v.getModelB().setRowCount(0);
			for(int i = 0; i<b.size();i++){
				v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
			}
			v.getModelB().fireTableDataChanged();
		}
		}
	public class NonFictionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<Book> b = bs.getByGenre("Non-Fiction");
			v.getModelB().setRowCount(0);
			for(int i = 0; i<b.size();i++){
				v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
			}
			v.getModelB().fireTableDataChanged();
		}
		}
	public class BuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try
			{
				v.getQBook();
			}
			catch(NumberFormatException ex)
			{
			  JOptionPane.showMessageDialog(null, "Cantitate invalida!");
			  v.setQBook("");
			  return;
			}
			if(v.getQBook()<0){
				JOptionPane.showMessageDialog(null, "Cantitate invalida!");
				  v.setQBook("");
				  return;
			}
			int row = v.getTableB().getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "Select book!");
				v.setQBook("");
				return;
			}
			 bs.sell(username, v.getTableB().getValueAt(row, 0).toString(), v.getQBook());
			 ArrayList<Book> b = bs.getAll();
			v.getModelB().setRowCount(0);
			for(int i = 0; i<b.size();i++){
				v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
			}
			v.getModelB().fireTableDataChanged();
			v.setQBook("");
			v.getTableB().clearSelection();
		}
		}
	public class UpdatePriceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int row = v.getTableB().getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "Select book!");
				return;
			}
				
			try
			{
				Float.parseFloat(v.getTableB().getValueAt(row, 4).toString());
			}
			catch(NumberFormatException ex)
			{
			  JOptionPane.showMessageDialog(null, "Pret invalid!");
			  return;
			}
			
			bs.updatePrice(v.getTableB().getValueAt(row, 0).toString(), Float.parseFloat(v.getTableB().getValueAt(row, 4).toString()));
			
				
			v.getTableB().setValueAt(v.getTableB().getValueAt(row, 4), row, 4);
			v.getModelB().fireTableDataChanged();
			 ArrayList<Book> b = bs.getAll();
				v.getModelB().setRowCount(0);
				for(int i = 0; i<b.size();i++){
					v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
				}

				v.getTableB().clearSelection();
		}
		}
	
	public class UpdateQuantityListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int row = v.getTableB().getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(null, "Select book!");
				return;
			}
				
			try
			{
				Integer.parseInt(v.getTableB().getValueAt(row, 3).toString());
			}
			catch(NumberFormatException ex)
			{
			  JOptionPane.showMessageDialog(null, "Cantitate invalida!");
			  return;
			}
			
			bs.updateQuantity(v.getTableB().getValueAt(row, 0).toString(), Integer.parseInt(v.getTableB().getValueAt(row, 3).toString()));
			
				
			v.getTableB().setValueAt(v.getTableB().getValueAt(row, 3), row, 3);
			v.getModelB().fireTableDataChanged();
			 ArrayList<Book> b = bs.getAll();
				v.getModelB().setRowCount(0);
				for(int i = 0; i<b.size();i++){
					v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
				}

				v.getTableB().clearSelection();
		}
		}
	
	public class ViewBookLogOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			v.getTabbedPane().setSelectedIndex(0);
			v.getTabbedPane().setEnabledAt(1,false);
			v.getTabbedPane().setEnabledAt(2,false);
			v.getTabbedPane().setEnabledAt(3,false);
			v.getTabbedPane().setEnabledAt(4,false);
		}
	}
	
	public class LogInListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(us.getUser(v.getUsername())!=null && us.getUser(v.getUsername()).getPassword().equals(v.getPassword())){
				username = v.getUsername();
				password = v.getPassword();
				v.setUsername("");
				v.setPassword("");
			}
			else{
				JOptionPane.showMessageDialog(null,"Username/Parola incorecta!");
				v.setUsername("");
				v.setPassword("");
				return;
			}
			if(us.getUser(username).getType()==0){
				v.getAddBookPanel().setVisible(true);
				v.getAddUserPanel().setVisible(true);
				v.getViewBooksPanel().setVisible(true);
				v.getViewUsersPanel().setVisible(true);
				v.getTabbedPane().setEnabledAt(1,true);
				v.getTabbedPane().setEnabledAt(2,true);
				v.getTabbedPane().setEnabledAt(3,true);
				v.getTabbedPane().setEnabledAt(4,true);
			}
			
			if(us.getUser(username).getType()==1){
				v.getAddBookPanel().setVisible(true);
				v.getAddUserPanel().setVisible(false);
				v.getViewBooksPanel().setVisible(true);
				v.getViewUsersPanel().setVisible(false);
				v.getTabbedPane().setEnabledAt(1,true);
				v.getTabbedPane().setEnabledAt(2,true);
				v.getTabbedPane().setEnabledAt(3,false);
				v.getTabbedPane().setEnabledAt(4,false);
			}
			v.getTabbedPane().setSelectedIndex(1);
			v.getTabbedPane().setEnabledAt(0,false);
			
			ArrayList<Book> b = bs.getAll();
			for(int i=0; i<b.size(); i++){
				v.getModelB().addRow(new Object[]{b.get(i).getTitle(),b.get(i).getAuthor(),b.get(i).getGenre(),b.get(i).getQuantity(),b.get(i).getPrice()});
			}
			
			ArrayList<User> u = us.getAll();
			for(int i=0; i<u.size(); i++){
				System.out.println(u.get(i).toString());
				v.getModel().addRow(new Object[]{u.get(i).getName(),u.get(i).getUsername(),u.get(i).getPassword(),u.get(i).getType()});
			}
		}
	}
	
	public class AddBLogOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			v.getTabbedPane().setSelectedIndex(0);
			v.getTabbedPane().setEnabledAt(1,false);
			v.getTabbedPane().setEnabledAt(2,false);
			v.getTabbedPane().setEnabledAt(3,false);
			v.getTabbedPane().setEnabledAt(4,false);
		}
		}
	
	public class AddUserLogOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			v.getTabbedPane().setSelectedIndex(0);
			v.getTabbedPane().setEnabledAt(1,false);
			v.getTabbedPane().setEnabledAt(2,false);
			v.getTabbedPane().setEnabledAt(3,false);
			v.getTabbedPane().setEnabledAt(4,false);
		}
		}
	
	public class AddBookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try
			{
				v.getQuantity();
			}
			catch(NumberFormatException ex)
			{
			  JOptionPane.showMessageDialog(null, "Cantitate invalida!");
			  return;
			}
			
			try
			{
				v.getPrice();
			}
			catch(NumberFormatException ex)
			{
			  JOptionPane.showMessageDialog(null, "Pret invalid!");
			  return;
			}
			
			if(v.getTitle().equals(null) || v.getAuthor().equals(null) || (v.getChckbxFiction().isSelected()==true && v.getChckbxNonfiction().isSelected()==true) || (v.getChckbxFiction().isSelected()==false && v.getChckbxNonfiction().isSelected()==false)){
				JOptionPane.showMessageDialog(null, "Adaugare invalida!");
				v.setTitle("");
				v.setAuthor("");
				v.setPrice("");
				v.setQuantity("");
				v.getChckbxFiction().setSelected(false);
				v.getChckbxNonfiction().setSelected(false);
				return;
			}
			if(v.getChckbxFiction().isSelected()==true){
				Book b = bs.createBook(v.getTitle(), v.getAuthor(), "Fiction", v.getQuantity(), v.getPrice());
				bs.add(b);
			}
			if(v.getChckbxNonfiction().isSelected()==true){
				Book b = bs.createBook(v.getTitle(), v.getAuthor(), "Non-Fiction", v.getQuantity(), v.getPrice());
				bs.add(b);
			}
			v.setTitle("");
			v.setAuthor("");
			v.setPrice("");
			v.setQuantity("");
			v.getChckbxFiction().setSelected(false);
			v.getChckbxNonfiction().setSelected(false);
			}
		}
	
	public class AddUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(v.getName().equals(null) || v.getNewUsername().equals(null) || v.getPassword1().equals(null) || v.getPassword2().equals(null) || !v.getPassword1().equals(v.getPassword2()) || (v.getAdmin().isSelected()==true && v.getEmployee().isSelected()==true) || (v.getAdmin().isSelected()==false && v.getEmployee().isSelected()==false)){
				JOptionPane.showMessageDialog(null,"Campuri invalide!");
				v.setName("");
				v.setNewUsername("");
				v.setPassword1("");
				v.setPassword2("");
				v.getAdmin().setSelected(false);
				v.getEmployee().setSelected(false);
				return;
		}
			if(v.getAdmin().isSelected()==true){
				User u = us.createUser(v.getName(), v.getNewUsername(), v.getPassword1(), 0);
				us.add(u);
			}
			if(v.getEmployee().isSelected()==true){
				User u = us.createUser(v.getName(), v.getNewUsername(), v.getPassword1(), 1);
				us.add(u);
			}
			v.setName("");
			v.setNewUsername("");
			v.setPassword1("");
			v.setPassword2("");
			v.getAdmin().setSelected(false);
			v.getEmployee().setSelected(false);
	}
		}
}

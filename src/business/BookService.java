package business;

import java.util.*;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;

import model.*;


public class BookService {
	
	public BookService(){		
	}
	public Book createBook(String title,String author,String genre,int quantity, float price){
		return new Book(title,author,genre,quantity,price);
	}
	
	public void add(Book u){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
			
			XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/bookstore/book[title='"+u.getTitle()+"']/title/text()");
            
            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);

            if(nodes==null){
            	 Node node = doc.getDocumentElement();

            	 Element book = doc.createElement("book");
                 node.appendChild(book);
                 
    			Element title = doc.createElement("title");
    			title.appendChild(doc.createTextNode(u.getTitle()));
    			book.appendChild(title);

    		
    			Element author = doc.createElement("author");
    			author.appendChild(doc.createTextNode(u.getAuthor()));
    			book.appendChild(author);

    			
    			Element genre = doc.createElement("genre");
    			genre.appendChild(doc.createTextNode(u.getGenre()));
    			book.appendChild(genre);
    			
    			Element quantity = doc.createElement("quantity");
    			quantity.appendChild(doc.createTextNode(Integer.toString(u.getQuantity())));
    			book.appendChild(quantity);
    			
    			Element price = doc.createElement("price");
    			price.appendChild(doc.createTextNode(Float.toString(u.getPrice())));
    			book.appendChild(price);
    			
    			TransformerFactory tff  = TransformerFactory.newInstance();
                Transformer transformer = tff.newTransformer();

                DOMSource xmlSource = new DOMSource(doc);
                StreamResult outputTarget = new StreamResult("books.xml");
                transformer.transform(xmlSource, outputTarget);
    			
    			JOptionPane.showMessageDialog(null, "Carte adaugata cu succes!");
            }
            else{
            	JOptionPane.showMessageDialog(null, "Carte deja existenta!");
            	return;
            }
            
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public Book getBook(String title){
		Element el = null;
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/book[title='"+title+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if (node!=null && node.getNodeType() == Node.ELEMENT_NODE) {
		        	 el = (Element) node;
		         }
		         else{
		        	 return null;
		         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Book(el.getElementsByTagName("title").item(0).getTextContent(),
						el.getElementsByTagName("author").item(0).getTextContent(),
						el.getElementsByTagName("genre").item(0).getTextContent(),
						Integer.parseInt(el.getElementsByTagName("quantity").item(0).getTextContent()),
						Float.parseFloat(el.getElementsByTagName("price").item(0).getTextContent()));
	}
	
	public ArrayList<Book> getAll(){
		ArrayList<Book> u =new ArrayList<Book>();
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         NodeList nodeList = doc.getElementsByTagName("book");
		         for (int i = 0; i < nodeList.getLength(); i++) {
		            Node nNode = nodeList.item(i);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element el = (Element) nNode;
		                u.add(new Book(el.getElementsByTagName("title").item(0).getTextContent(),
								el.getElementsByTagName("author").item(0).getTextContent(),
								el.getElementsByTagName("genre").item(0).getTextContent(),
								Integer.parseInt(el.getElementsByTagName("quantity").item(0).getTextContent()),
								Float.parseFloat(el.getElementsByTagName("price").item(0).getTextContent())));
		            }
		         }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
	
	public ArrayList<Book> getByAuthor(String author){
		ArrayList<Book> u =new ArrayList<Book>();
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         NodeList nodeList = doc.getElementsByTagName("book");
		         for (int i = 0; i < nodeList.getLength(); i++) {
		            Node nNode = nodeList.item(i);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element el = (Element) nNode;
		                if(el.getElementsByTagName("author").item(0).getTextContent().equals(author)){
		                	u.add(new Book(el.getElementsByTagName("title").item(0).getTextContent(),
									el.getElementsByTagName("author").item(0).getTextContent(),
									el.getElementsByTagName("genre").item(0).getTextContent(),
									Integer.parseInt(el.getElementsByTagName("quantity").item(0).getTextContent()),
									Float.parseFloat(el.getElementsByTagName("price").item(0).getTextContent())));
		                }

		            }
		         }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if(u.isEmpty()){
			JOptionPane.showMessageDialog(null, "Autor inexistent");
		}
		return u;
	}
	
	public ArrayList<Book> getByGenre(String genre){
		ArrayList<Book> u =new ArrayList<Book>();
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         NodeList nodeList = doc.getElementsByTagName("book");
		         for (int i = 0; i < nodeList.getLength(); i++) {
		            Node nNode = nodeList.item(i);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element el = (Element) nNode;
		                if(el.getElementsByTagName("genre").item(0).getTextContent().equals(genre)){
		                	u.add(new Book(el.getElementsByTagName("title").item(0).getTextContent(),
									el.getElementsByTagName("author").item(0).getTextContent(),
									el.getElementsByTagName("genre").item(0).getTextContent(),
									Integer.parseInt(el.getElementsByTagName("quantity").item(0).getTextContent()),
									Float.parseFloat(el.getElementsByTagName("price").item(0).getTextContent())));
		                }
		            }
		         }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if(u.isEmpty()){
			JOptionPane.showMessageDialog(null, "Gen inexistent");
		}
		return u;
	}
	
	public void delete(String title){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/book[title='"+title+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if(node!=null){

		         node.getParentNode().removeChild(node);

				JOptionPane.showMessageDialog(null, "Stergerea a fost facuta cu succes!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Carte inexistenta!");
				return;
			}
			  TransformerFactory tff  = TransformerFactory.newInstance();
              Transformer transformer = tff.newTransformer();

              DOMSource xmlSource = new DOMSource(doc);
              StreamResult outputTarget = new StreamResult("books.xml");
              transformer.transform(xmlSource, outputTarget);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateQuantity(String title,int quantity){
		Element e = null;
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/book[title='"+title+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if (node!=null && node.getNodeType() == Node.ELEMENT_NODE) {
		        	 e = (Element) node;
		         }
			
			if(e!=null && title!=null){
				
					e.getElementsByTagName("quantity").item(0).setTextContent(Integer.toString(quantity));
				
				JOptionPane.showMessageDialog(null, "Stoc actualizat cu succes!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Carte inexistenta!");
				return;
			}
			  TransformerFactory tff  = TransformerFactory.newInstance();
              Transformer transformer = tff.newTransformer();

              DOMSource xmlSource = new DOMSource(doc);
              StreamResult outputTarget = new StreamResult("books.xml");
              transformer.transform(xmlSource, outputTarget);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updatePrice(String title,float price){
		Element e = null;
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("books.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/book[title='"+title+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if (node!=null && node.getNodeType() == Node.ELEMENT_NODE) {
		        	 e = (Element) node;
		         }
			
			if(e!=null && title!=null){
				
					e.getElementsByTagName("price").item(0).setTextContent(Float.toString(price));
				
				JOptionPane.showMessageDialog(null, "Pret actualizat cu succes!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Carte inexistenta!");
				return;
			}
			  TransformerFactory tff  = TransformerFactory.newInstance();
              Transformer transformer = tff.newTransformer();

              DOMSource xmlSource = new DOMSource(doc);
              StreamResult outputTarget = new StreamResult("books.xml");
              transformer.transform(xmlSource, outputTarget);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sell(String username,String title,int quantity){
		Book b = this.getBook(title);
		if(b==null){
			JOptionPane.showMessageDialog(null, "Carte inexistenta!");
			return;
		}
		if(quantity<b.getQuantity()){
			int newQuantity = b.getQuantity()-quantity;
			this.updateQuantity(b.getTitle(), newQuantity);
			try{
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				
				Document doc = docBuilder.parse("sells.xml");
				
				XPathFactory xpathFactory = XPathFactory.newInstance();
	            XPath xpath = xpathFactory.newXPath();
	            XPathExpression expr =xpath.compile("/bookstore/sell[user='"+username+"']/user/text()");
	            
	            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);

	            if(nodes==null){
	            	 Node node = doc.getDocumentElement();

	            	 Element sell = doc.createElement("sell");
	                 node.appendChild(sell);
	                 
	    			Element user = doc.createElement("user");
	    			user.appendChild(doc.createTextNode(username));
	    			sell.appendChild(user);

	    		
	    			Element bookTitle = doc.createElement("book");
	    			bookTitle.appendChild(doc.createTextNode(b.getTitle()));
	    			sell.appendChild(bookTitle);

	    			
	    			Element author = doc.createElement("author");
	    			author.appendChild(doc.createTextNode(b.getAuthor()));
	    			sell.appendChild(author);
	    			
	    			Element q = doc.createElement("quantity");
	    			q.appendChild(doc.createTextNode(Integer.toString(quantity)));
	    			sell.appendChild(q);
	    			
	    			Element price = doc.createElement("price");
	    			price.appendChild(doc.createTextNode(Float.toString(b.getPrice())));
	    			sell.appendChild(price);
	    			
	    			TransformerFactory tff  = TransformerFactory.newInstance();
	                Transformer transformer = tff.newTransformer();

	                DOMSource xmlSource = new DOMSource(doc);
	                StreamResult outputTarget = new StreamResult("sells.xml");
	                transformer.transform(xmlSource, outputTarget);
	    			
	    			JOptionPane.showMessageDialog(null, "Vanzare facuta cu succes!");
	            }
			}
	            catch (Exception ex) {
	    			ex.printStackTrace();
	    		}
			}
		
		else{
			JOptionPane.showMessageDialog(null, "Stoc insuficient!");
			return;
		}
		
	}
	
	public static void main(String[] args){
		Book b = new Book("La Medeleni","Ionel Teodoreanu","Beletristica",10,60);
		BookService bs = new BookService();
		//bs.add(b);
		//System.out.println(bs.getByGenre("e"));
		bs.updateQuantity("Lorelei",0);
		//bs.sell("daia", "La Medeleni", 2);
	}
}

package business;

import java.util.*;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;

import model.User;

public class UserService {

	
	public UserService(){
	}
	
	
	
	public User createUser(String name, String username, String password, int type){
		return new User(name,username,password,type);
	}
	
	public void add(User u){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("users.xml");
			
			XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("/bookstore/user[username='"+u.getUsername()+"']/username/text()");
            
            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);

            if(nodes==null){
            	 Node node = doc.getDocumentElement();

            	 Element users = doc.createElement("user");
                 node.appendChild(users);
                 
    			Element name = doc.createElement("name");
    			name.appendChild(doc.createTextNode(u.getName()));
    			users.appendChild(name);

    		
    			Element username = doc.createElement("username");
    			username.appendChild(doc.createTextNode(u.getUsername()));
    			users.appendChild(username);

    			
    			Element password = doc.createElement("password");
    			password.appendChild(doc.createTextNode(u.getPassword()));
    			users.appendChild(password);
    			
    			Element type = doc.createElement("type");
    			type.appendChild(doc.createTextNode(Integer.toString(u.getType())));
    			users.appendChild(type);
    			
    			TransformerFactory tff  = TransformerFactory.newInstance();
                Transformer transformer = tff.newTransformer();

                DOMSource xmlSource = new DOMSource(doc);
                StreamResult outputTarget = new StreamResult("users.xml");
                transformer.transform(xmlSource, outputTarget);
    			
    			JOptionPane.showMessageDialog(null, "User adaugat cu succes!");
            }
            else{
            	JOptionPane.showMessageDialog(null, "User deja existent!");
            	return;
            }
            
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public User getUser(String username){
		Element el = null;
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("users.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/user[username='"+username+"']";
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
		return new User(el.getElementsByTagName("name").item(0).getTextContent(),
						el.getElementsByTagName("username").item(0).getTextContent(),
						el.getElementsByTagName("password").item(0).getTextContent(),
						Integer.parseInt(el.getElementsByTagName("type").item(0).getTextContent()));
	}
	
	public void update(String username,String newUN,String newName, String newPass, int newType){
		Element e = null;
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("users.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/user[username='"+username+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if (node!=null && node.getNodeType() == Node.ELEMENT_NODE) {
		        	 e = (Element) node;
		         }
			
			if(e!=null && username!=null){
				if(newUN!=null){
					e.getElementsByTagName("username").item(0).setTextContent(newName);
				}
				if(newName!=null){
					e.getElementsByTagName("name").item(0).setTextContent(newUN);
				}
				
				if(newPass!=null){
					e.getElementsByTagName("password").item(0).setTextContent(newPass);
				}
				
				if(newType==0 || newType == 1){
					e.getElementsByTagName("type").item(0).setTextContent(Integer.toString(newType));
				}
				else{
					JOptionPane.showMessageDialog(null, "Valori incorecte!");
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Inf. au fost actualizate cu succes!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Username inexistent!");
				return;
			}
			  TransformerFactory tff  = TransformerFactory.newInstance();
              Transformer transformer = tff.newTransformer();

              DOMSource xmlSource = new DOMSource(doc);
              StreamResult outputTarget = new StreamResult("users.xml");
              transformer.transform(xmlSource, outputTarget);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete(String username){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("users.xml");
		       doc.getDocumentElement().normalize();

		         XPath xPath =  XPathFactory.newInstance().newXPath();

		         String expression = "/bookstore/user[username='"+username+"']";
		         Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		         if(node!=null){

		         node.getParentNode().removeChild(node);

				JOptionPane.showMessageDialog(null, "Stergerea a fost facuta cu succes!");
			}
			else{
				JOptionPane.showMessageDialog(null, "Username inexistent!");
				return;
			}
			  TransformerFactory tff  = TransformerFactory.newInstance();
              Transformer transformer = tff.newTransformer();

              DOMSource xmlSource = new DOMSource(doc);
              StreamResult outputTarget = new StreamResult("users.xml");
              transformer.transform(xmlSource, outputTarget);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<User> getAll(){
		ArrayList<User> u =new ArrayList<User>();
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.parse("users.xml");
		       doc.getDocumentElement().normalize();

		         NodeList nodeList = doc.getElementsByTagName("user");
		         for (int i = 0; i < nodeList.getLength(); i++) {
		            Node nNode = nodeList.item(i);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element e = (Element) nNode;
		                u.add(new User(e.getElementsByTagName("name").item(0).getTextContent(),
		                		e.getElementsByTagName("username").item(0).getTextContent(),
		                		e.getElementsByTagName("password").item(0).getTextContent(),
		                		Integer.parseInt(e.getElementsByTagName("type").item(0).getTextContent())));
		            }
		         }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
	
	
	public static void main(String[] args){
	User u1 = new User("Toader Daiana","daia","pass",1);
	User u2 = new User("Pop Ana","ana","pass",0);
		UserService us = new UserService();
		//System.out.println(us.getUser("sd").toString());
		ArrayList<User> u = us.getAll();
		System.out.println(u.toString());
		
	}
	
	

}

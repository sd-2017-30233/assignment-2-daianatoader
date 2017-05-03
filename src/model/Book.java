package model;


public class Book {
	private String title;
	private String author;
	private String genre;
	private int quantity;
	private float price;
	
	public Book(String title, String author, String genre, int quantity, float price){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.quantity = quantity;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}

package java_concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Book {
	String title;
	String author;
	int price;
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
}

public class Lambda3 {
	
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Let Us C", "YPK", 750));
		books.add(new Book("modern c++", "herblt schield", 1899));
		books.add(new Book("Learn Java Collections", "nithin", 990));
		books.add(new Book("learn python", "aravind", 399));
		
		for(Book book : books)
			System.out.println(book);
		
		Collections.sort(books, (b1, b2) -> b1.price - b2.price);
		System.out.println("\n After Sorting: ");
		for(Book book : books)
			System.out.println(book);
		// System.out.println(books);
	}
}

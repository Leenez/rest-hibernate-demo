package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {
		@Id
		private int publisherID;
		private String name;
		@OneToMany(fetch=FetchType.EAGER)
		private List<Book> books = new ArrayList<>();
		//@Transient
		//private String notStoredToDb;
		
		public Publisher() {}

		public int getPublisherID() {
			return publisherID;
		}

		public void setPublisherID(int publisherID) {
			this.publisherID = publisherID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}		

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}
}

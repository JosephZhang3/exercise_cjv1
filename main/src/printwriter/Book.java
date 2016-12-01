package printwriter;

public class Book implements java.io.Serializable{
        private String bookName;
        private String author;
        private int price;
        
		public Book() {
			super();
		}
		public Book(String bookName, String author, int price) {
			super();
			this.bookName = bookName;
			this.author = author;
			this.price = price;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
        
}

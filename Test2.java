public class Test2 {
    public static void main(String[] args) {
        Library library = new Library();
        Author tolkien = new Author("J.R.R. Tolkien", "English writer, poet, philologist");
        Book lotr = new Book("The Lord of the Rings", tolkien, 1954);

        library.addBook(lotr);
        library.registerUser(new User("user1", "pass123"));

        System.out.println("Books by Tolkien: " + library.searchByAuthor("J.R.R. Tolkien").size());
        System.out.println("Authentication success: " + library.authenticateUser("user1", "pass123"));
    }
}

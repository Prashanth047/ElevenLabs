import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("book addedd: "+book.getTitle());
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User added: "+user.getName());
    }

    public void issueBook(String title,int id){
        Book book=findBook(title);
        User user=findUser(id);

        if(book==null){
            System.out.println("no such book found");
        }
        else if(user==null){
            System.out.println("No such User found");
        }
        else if(book.isIssued()){
            System.out.println("Book already issued");
        }
        else{
            book.issue();
            System.out.println("Book "+title+" is issued to "+user.getName());
        }
    }

    public void returnBook(String title){
        Book book=findBook(title);
        if(book ==null){
            System.out.println("no such book found");
        }
        else if(!book.isIssued()){
            System.out.println("Book is not issued");
        }
        else{
            book.returnBook();
            System.out.println("Book "+title+" returned");
        }
    }
    public void showAllBooks(){
        System.out.println("...........Books List............");

        for(Book b:books){
            System.out.println(b);
        }
    }

    public void showAllUsers(){
        System.out.println("...........Users List............");

        for(User b:users){
            System.out.println(b);
        }
    }

    private Book findBook(String title){
        for(Book b:books){
            if(b.getTitle().equalsIgnoreCase(title))
                    return b;
        }
        return null;
    }

    private User findUser(int id){
        for(User b:users){
            if(b.getId()==id)
                return b;
        }
        return null;
    }
}

package com.example.fajrinurwanto.challange2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FictionBookLibrary fictionBookLibrary = new FictionBookLibrary();

        Book harryPotterAndTheSorcerersStone = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        Book harryPotterAndChamberOfSecrets = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling");
        Book theFellowshipOfTheRing = new Book("The Fellowship of the Ring", "J.R.R. Tolkien");
        Book theTwoTowers = new Book("The Two Towers", "J.R.R. Tolkien");
        Book theAdventuresOfSherlockHolmes = new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle");
        Book aStudyInScarlet = new Book("A Study in Scarlet", "Arthur Conan Doyle");

        fictionBookLibrary.addCollection(harryPotterAndTheSorcerersStone, 2);
        fictionBookLibrary.addCollection(harryPotterAndChamberOfSecrets, 3);
        fictionBookLibrary.addCollection(theFellowshipOfTheRing, 1);
        fictionBookLibrary.addCollection(theTwoTowers, 2);
        fictionBookLibrary.addCollection(theAdventuresOfSherlockHolmes, 20);
        fictionBookLibrary.addCollection(aStudyInScarlet, 10);

        java.util.List<Book> availableBooks = fictionBookLibrary.listAvailableBooks();

        System.out.println("1  : " + availableBooks.contains(harryPotterAndTheSorcerersStone));
        System.out.println("2  : " + availableBooks.contains(theFellowshipOfTheRing));
        System.out.println("3  : " + availableBooks.contains(theAdventuresOfSherlockHolmes));

        java.util.List<Book> booksByArthurConanDoyle = fictionBookLibrary.listBooksAuthoredBy("Arthur Conan Doyle");

        System.out.println("4  : " + booksByArthurConanDoyle.contains(theAdventuresOfSherlockHolmes));
        System.out.println("5  : " + booksByArthurConanDoyle.contains(aStudyInScarlet));

    }

    //setters and getters

    /**
     * Two users are equal if their firstName, lastName and email address is same.
     */

}

class FictionBookLibrary
{
    List<Book> addCollect = new ArrayList<>();
    List<Book> listAvailable = new ArrayList<>();

    public void addCollection(Book book, int count) {
        String title1 = book.getJudul1();
        String title2 = book.getJudul2();

        listAvailable.add(new Book(title1, title2));
        addCollect.add(new Book(title1, title2, count));
        //Log.d("collect", title1+","+title2+","+String.valueOf(count));
    }

    public List<Book> listAvailableBooks() {
        return listAvailable;
    }

    public List<Book> listBooksAuthoredBy(String author) {
        List<Book> listByAuthor = new ArrayList<>();

        // get collection with author "Arthur Conan Doyle"
        for(int a=0; a<listAvailable.size(); a++){
            if(listAvailable.get(a).getJudul2() == author){
                listByAuthor.add(new Book(listAvailable.get(a).getJudul1(), listAvailable.get(a).getJudul2()));
            }
        }

        return listByAuthor;
    }
    // PLACE YOUR CODE HERE
}

class Book
{
    private String judul1;
    private String judul2;
    private int jumlah;

    public Book(String title1, String title2) {
        super();
        this.judul1 = title1;
        this.judul2 = title2;
    }

    public Book(String title1, String title2, int count) {
        super();
        this.judul1 = title1;
        this.judul2 = title2;
        this.jumlah = count;
    }

    public String getJudul1(){
        return judul1;
    }

    public void setJudul1(String title1){
        judul1 = title1;
    }

    public String getJudul2(){
        return judul2;
    }

    public void setJudul2(String title2){
        judul2 = title2;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int count){
        jumlah = count;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.judul1.equals(((Book) obj).judul1)
                && this.judul2.equals(((Book) obj).judul2) );
    }
    // PLACE YOUR CODE HERE
}

class Member
{
    // PLACE YOUR CODE HERE
}


class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //setters and getters

    @Override
    public boolean equals(Object obj) {
        return (this.firstName.equals(((User) obj).firstName)
                && this.lastName.equals(((User) obj).lastName) && this.email
                .equals(((User) obj).email));
    }

}

package roomexercise.splayer.com.roomdemo;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import roomexercise.splayer.com.roomdemo.db.AppDatabase;
import roomexercise.splayer.com.roomdemo.db.Book;
import roomexercise.splayer.com.roomdemo.db.User;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myDb.db").allowMainThreadQueries().build();

        generateDummyData();

        fetchData();
    }


    private void generateDummyData() {

        User user1 = addUser(1, "Nguyen Van ", "A");
        User user2 = addUser(2, "Nguyen Thi ", "B");
        User user3 = addUser(3, "Tran Thi ", "C");

        Book book1 = addBook(1, "Sach A", user1);
        Book book2 = addBook(2, "Sach B", user3);
        Book book3 = addBook(3, "Sach C", user2);
    }

    private User addUser(final int id, final String firstName, final String lastName) {
        User user = new User();
        user.id = id;
        user.firstName = firstName;
        user.lastName = lastName;
        mDB.getUserDao().insertUser(user);

        return user;
    }

    private Book addBook(final int id, final String title, final User user) {
        Book book = new Book();
        book.bookId = id;
        book.title = title;
        book.userId = user.id;
        mDB.getBookDao().insertBook(book);

        return book;
    }

    private void fetchData(){
        StringBuilder sb = new StringBuilder();
        List<Book> books = mDB.getBookDao().loadAllBooks();
        for (Book book:books){
            User user = mDB.getUserDao().findUserById(book.userId);
            sb.append(String.format(Locale.US,"%s borrowed by %s \n",book.title,user.firstName+ " " + user));
        }
        ((TextView) findViewById(R.id.bookList)).setText(sb);
    }
}

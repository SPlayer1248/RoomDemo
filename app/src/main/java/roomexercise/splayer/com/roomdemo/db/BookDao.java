package roomexercise.splayer.com.roomdemo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by SPlayer on 10/12/2017.
 */

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBook(Book book);

    @Update
    public void updateBook(Book book);

    @Delete
    public void deleteBook(Book book);

    @Query("SELECT * FROM Book WHERE Book.bookId = :bookId")
    public Book findBookById(int bookId);

    @Query("SELECT * FROM Book")
    public List<Book> loadAllBooks();

    @Query("SELECT * FROM Book WHERE Book.title LIKE :title")
    public Book findBookByTitle(String title);

    @Query("SELECT * FROM Book WHERE Book.user_id = :userId")
    public List<Book> findBookByUserId(int userId);
}

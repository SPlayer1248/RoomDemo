package roomexercise.splayer.com.roomdemo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by SPlayer on 10/12/2017.
 */

@Database(entities = {User.class, Book.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract BookDao getBookDao();
}

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
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);

    @Query("SELECT * FROM user")
    public User[] loadAllUser();

    @Query("SELECT * FROM user WHERE User.id = :userId")
    public User findUserById(int userId);

    @Query("SELECT * FROM user WHERE User.firstName LIKE :userFName")
    public List<User> findUserByName(String userFName);
}

package roomexercise.splayer.com.roomdemo.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by SPlayer on 10/12/2017.
 */

@Entity
public class User {
    @PrimaryKey
    public int id;

    public String firstName;
    public String lastName;
    public String avatarUrl;
}

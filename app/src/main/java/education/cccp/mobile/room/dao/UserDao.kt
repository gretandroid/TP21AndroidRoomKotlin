package education.cccp.mobile.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import education.cccp.mobile.room.model.User

@Dao
interface UserDao {
    @Query(value = "SELECT * FROM user u WHERE lower(u.login)=lower(:login)")
    fun findAllByLogin(login: String): LiveData<List<User?>?>?

    @Query(value = "SELECT * FROM user WHERE LOWER(email) = LOWER(:email)")
    fun findOneByEmail(email: String): User?

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Insert(onConflict = REPLACE)
    fun saveAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query(value = "DELETE FROM user WHERE user_id = :userId")
    fun deleteById(userId: Long)

    @Query(value = "DELETE FROM user")
    fun deleteAll()

    @Query(value = "SELECT count(*) FROM user")
    fun count(): Int

    @Query(value = "SELECT * FROM user")
    fun findAll(): List<User?>?
}
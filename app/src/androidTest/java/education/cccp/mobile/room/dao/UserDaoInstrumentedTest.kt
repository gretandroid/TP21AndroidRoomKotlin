package education.cccp.mobile.room.dao


import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import education.cccp.mobile.room.Data
import education.cccp.mobile.room.Data.DATA_USERS_SIZE
import education.cccp.mobile.room.Data.EMPTY_COLLECTION_SIZE
import education.cccp.mobile.room.Data.formatter
import education.cccp.mobile.room.Data.getAllDataUsers
import education.cccp.mobile.room.dao.database.AppDb
import education.cccp.mobile.room.model.User
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class UserDaoInstrumentedTest {
    private lateinit var db: AppDb
    private lateinit var userDao: UserDao
    private val user: User = User(
        login = "user",
        email = "user@acme.com",
        firstName = "User",
        lastName = "Lambda",
        dob = formatter.parse("10/02/2016") as Date,
        password = "password"
    )

    @Before
    fun setUp() {
        db = inMemoryDatabaseBuilder(
            getInstrumentation().targetContext,
            AppDb::class.java
        ).build()
        userDao = db.userDao()!!
    }

    @After
    fun destroy() = db.close()
    //TODO:test save with user without id using "user"
    @Test
    fun test_save_with_correct_user() {
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
        userDao.save(getAllDataUsers().first())
        assertEquals(EMPTY_COLLECTION_SIZE + 1, userDao.count())
    }

    @Test
    fun test_save_all() {
        assertEquals(DATA_USERS_SIZE, getAllDataUsers().size)
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
        userDao.saveAll(getAllDataUsers())
        assertEquals(getAllDataUsers().size, userDao.count())
    }

    @Test
    fun test_delete() {
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
        userDao.saveAll(getAllDataUsers())
        assertEquals(DATA_USERS_SIZE, userDao.count())
        userDao.delete(getAllDataUsers().first())
        assertEquals(getAllDataUsers().size - 1, userDao.count())
    }

    @Test
    fun test_delete_all() {
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
        userDao.saveAll(getAllDataUsers())
        assertEquals(getAllDataUsers().size, userDao.count())
        userDao.deleteAll()
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
    }

    @Test
    fun test_find_all() {
        assertEquals(EMPTY_COLLECTION_SIZE, userDao.count())
        userDao.saveAll(getAllDataUsers())
        assertEquals(getAllDataUsers().size, userDao.count())
        userDao.findAll()!!.forEachIndexed { index, user ->
            assertEquals(getAllDataUsers()[index], user)
        }
    }
}
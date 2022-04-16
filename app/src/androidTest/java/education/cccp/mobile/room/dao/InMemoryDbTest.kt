package education.cccp.mobile.room.dao


import education.cccp.mobile.room.Data.findAll

import education.cccp.mobile.room.dao.database.AppDb
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import education.cccp.mobile.room.Data.DATA_USERS_SIZE
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InMemoryDbTest {
    private lateinit var db: AppDb
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation()
            .targetContext
        db = Room.inMemoryDatabaseBuilder(
            context,
            AppDb::class.java
        )
            .build()
        userDao = db.userDao()!!
    }

    @After
    fun destroy() {
        db.close()
    }

    @Test
    fun canary() {
    }

    @Test
    fun test_save_with_correct_user() {
        assertEquals(0, userDao.count().toLong())
        userDao.save(findAll()[0])
        assertEquals(1, userDao.count().toLong())
    }

    @Test
    fun test_save_all() {

        assertEquals(findAll().size, DATA_USERS_SIZE)
        assertEquals(0, userDao.count().toLong())
        userDao.saveAll(findAll())
        println(userDao.count())
        assertEquals(findAll().size.toLong(), userDao.count().toLong())
    }

    @Test
    fun test_delete() {
        assertEquals(0, userDao.count().toLong())
        userDao.saveAll(findAll())
        assertEquals(findAll().size.toLong(), userDao.count().toLong())
        userDao.delete(findAll()[0])
        assertEquals((findAll().size - 1).toLong(), userDao.count().toLong())
    }

    @Test
    fun test_delete_all() {
        assertEquals(0, userDao.count().toLong())
        userDao.saveAll(findAll())
        assertEquals(findAll().size.toLong(), userDao.count().toLong())
        userDao.deleteAll()
        assertEquals(0, userDao.count().toLong())
    }

    @Test
    fun test_find_all() {
        assertEquals(0, userDao.count().toLong())
        userDao.saveAll(findAll())
        assertEquals(findAll().size.toLong(), userDao.count().toLong())
        userDao.findAll()!!.forEachIndexed { index, user ->
            assertEquals(findAll()[index], user)
        }
    }
}
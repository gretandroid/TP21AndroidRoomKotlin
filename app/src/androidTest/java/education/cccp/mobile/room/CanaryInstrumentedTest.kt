package education.cccp.mobile.room

import androidx.room.Room.inMemoryDatabaseBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import education.cccp.mobile.room.dao.database.AppDb
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CanaryInstrumentedTest {
    private lateinit var db: AppDb

    @Before
    fun setUp() {
        db = inMemoryDatabaseBuilder(
            getInstrumentation()
                .targetContext,
            AppDb::class.java
        ).build()
    }

    @After
    fun destroy() = db.close()

    @Test
    fun canary_test() {
        assertEquals(
            "education.cccp.mobile.room",
            getInstrumentation().targetContext.packageName
        )
    }
}
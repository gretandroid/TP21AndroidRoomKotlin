package education.cccp.mobile.room.dao.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import education.cccp.mobile.room.dao.UserDao
import education.cccp.mobile.room.dao.converter.JavaUtilDateConverter
import education.cccp.mobile.room.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(value = [JavaUtilDateConverter::class])
abstract class AppDb : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {
        private const val DB_NAME = "application.db"

        @Volatile
        private var instance: AppDb? = null
        private val LOCK = Any()
        fun getInstance(context: Context): AppDb? {
            if (instance == null) synchronized(LOCK) {
                if (instance == null) instance = databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    DB_NAME
                ).build()
            }
            return instance
        }
    }
}
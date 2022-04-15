package education.cccp.mobile.room.dao.converter

import androidx.room.TypeConverter
import java.util.*

internal object JavaUtilDateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? =
        if (value == null) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? =
        date?.time
}
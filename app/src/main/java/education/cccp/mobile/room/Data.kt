package education.cccp.mobile.room

import education.cccp.mobile.room.model.User
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.getDefault


object Data {
    @Suppress("MemberVisibilityCanBePrivate")
    const val DATE_FORMATTER_PATTERN: String = "dd/mm/yyyy"
    const val DATA_USERS_SIZE: Int = 5
    const val EMPTY_COLLECTION_SIZE = 0

    @JvmStatic
    private val formatter by lazy {
        SimpleDateFormat(
            DATE_FORMATTER_PATTERN,
            getDefault()
        )
    }

    @JvmStatic
    private var users: MutableList<User> = mutableListOf(
        User(
            1L,
            "jdoe",
            "john.doe@acme.com",
            "John",
            "Doe",
            formatter.parse("10/02/2021") as Date,
            "password"
        ),
        User(
            2L,
            "jdoe",
            "jane.doe@acme.com",
            "Jane",
            "Doe",
            formatter.parse("10/02/2020") as Date,
            "password"
        ),
        User(
            3L,
            "jbloggs",
            "joe.bloggs@acme.com",
            "Joe",
            "Bloggs",
            formatter.parse("10/02/2019") as Date,
            "password"
        ),
        User(
            4L,
            "jschmoe",
            "joe.schmoe@acme.com",
            "Joe",
            "Schmoe",
            formatter.parse("10/02/2018") as Date,
            "password"
        ),
        User(
            5L,
            "dharry",
            "dick.harry@acme.com",
            "Dick",
            "Harry",
            formatter.parse("10/02/2017") as Date,
            "password"
        )
    )

    @JvmStatic
    fun getAllDataUsers(): List<User> = users
}
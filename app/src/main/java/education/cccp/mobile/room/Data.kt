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
    val formatter by lazy {
        SimpleDateFormat(
            DATE_FORMATTER_PATTERN,
            getDefault()
        )
    }

    @JvmStatic
    private var users: MutableList<User> = mutableListOf(
        User(
            id = 1L,
            login = "john.doe",
            email = "john.doe@acme.com",
            firstName = "John",
            lastName = "Doe",
            dob = formatter.parse("10/02/1971") as Date,
            password = "password"
        ),
        User(
            id = 2L,
            login = "jane.doe",
            email = "jane.doe@acme.com",
            firstName = "Jane",
            lastName = "Doe",
            dob = formatter.parse("11/03/1972") as Date,
            password = "password"
        ),
        User(
            id = 3L,
            login = "joe.bloggs",
            email = "joe.bloggs@acme.com",
            firstName = "Joe",
            lastName = "Bloggs",
            dob = formatter.parse("12/04/1973") as Date,
            password = "password"
        ),
        User(
            id = 4L,
            login = "joe.schmoe",
            email = "joe.schmoe@acme.com",
            firstName = "Joe",
            lastName = "Schmoe",
            dob = formatter.parse("13/05/1974") as Date,
            password = "password"
        ),
        User(
            id = 5L,
            login = "dick.harry",
            email = "dick.harry@acme.com",
            firstName = "Dick",
            lastName = "Harry",
            dob = formatter.parse("14/06/1975") as Date,
            password = "password"
        )
    )

    @JvmStatic
    fun getAllDataUsers(): List<User> = users
}
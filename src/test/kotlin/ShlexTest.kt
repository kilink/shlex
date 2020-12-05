import net.kilink.shlex.quote
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShlexTest {
    @Test
    fun testQuoteEmptyString() {
        assertEquals("''", quote(""))
    }

    @Test
    fun testQuoteSpaces() {
        assertEquals("'test file name'", quote("test file name"))
    }

    @Test
    fun testQuoteSafeUnquoted() {
        val safeUnquoted = ('a'..'Z').toString() +
            ('1'..'9').toString() +
            "@%_-+=:,./"
        assertEquals(safeUnquoted, quote(safeUnquoted))
    }

    @Test
    fun testUnsafe() {
        val unsafe = "\"`$\\!éàß"
        for (ch in unsafe) {
            assertEquals("'test${ch}name'", quote("test${ch}name"))
            assertEquals("""'test$ch'"'"'name'"'"''""", quote("test$ch'name'"))
        }
    }
}

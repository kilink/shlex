package net.kilink.shlex

private val unsafe = "[^\\w@%+=:,./-]".toRegex()

/**
 * Return a shell-escaped version of the String [s].
 */
public fun quote(s: String): String {
    if (s.isEmpty()) {
        return "''"
    }
    if (!unsafe.containsMatchIn(s)) {
        return s
    }
    return "'" + s.replace("'", "'\"'\"'") + "'"
}

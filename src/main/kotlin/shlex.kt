package net.kilink.shlex

private val unsafe = "[^\\w@%+=:,./-]".toRegex()
private val singleQuote = "'".toRegex()

/**
 * Return a shell-escaped version of the String [s].
 */
public fun quote(s: CharSequence): String {
    if (s.isEmpty()) {
        return "''"
    }
    if (!unsafe.containsMatchIn(s)) {
        return s.toString()
    }
    return "'" + s.replace(singleQuote, "'\"'\"'") + "'"
}

/**
 * Return a shell-escaped string from [splitCommand].
 */
public fun join(splitCommand: Iterable<CharSequence>): String {
    return join(splitCommand.asSequence())
}

/**
 * Return a shell-escaped string from [splitCommand].
 */
public fun join(splitCommand: Sequence<CharSequence>): String {
    return splitCommand.joinToString(separator = " ") { arg -> quote(arg) }
}

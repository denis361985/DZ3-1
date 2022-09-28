fun main () {
    val timeAgo = 130

    fun minText(timeAgo: Int): String {
        var minAgo = timeAgo/60
        return when(minAgo) {
            1, 21, 31, 41, 51 -> "$minAgo минуту"
            in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minAgo минуты"
            in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "$minAgo минут"
            else -> ""
        }
    }

    fun hourText(timeAgo: Int): String {
        var hourAgo = timeAgo/60/60
        return when(hourAgo) {
            1, 21 -> "$hourAgo час"
            in 2..4, in 22..24 -> "$hourAgo часа"
            in 5..20 -> "$hourAgo часов"
            else -> ""
        }
    }

    fun agoToText(timeAgo: Int): String {
         return  when (timeAgo) {
            in 0..60 -> "был(а) в сети только что"
            in 61..60 * 60 -> "был(а) в сети ${minText(timeAgo)} назад"
            in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${hourText(timeAgo)} назад"
            in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети вчера"
            in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети позавчера"
            else -> "был(а) в сети давно"
        }
    }

    println(agoToText(timeAgo))
}
const val HOUR = 3600
const val DAY = 86400

fun main() {
    print("Сколько секунд назад пользователь был в сети? Введите:")
    val timeInn: String = readLine() ?: return
    val time: Int = timeInn.toInt()
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    return when {
        time in 0..60 -> "Пользователь был(а) в сети только что"
        time in 61..HOUR -> (minutesToText(time))
        time in HOUR + 1..DAY -> (hoursToText(time))
        time in DAY + 1..2 * DAY -> "Пользователь был(а) в сети сегодня"
        time in 2 * DAY + 1..3 * DAY -> "Пользователь был(а) в сети вчера"
        time > 3 * DAY -> "Пользователь был(а) в сети давно"
        else -> "Вы ввели некорректное количество секунд"
    }
}

fun minutesToText(time: Int): String {
    val timeToMinutes: Int = time / 60
    return when {
        timeToMinutes % 10 == 1 && timeToMinutes % 100 != 11 -> "Пользователь был(а) в сети $timeToMinutes минуту назад"
        timeToMinutes % 10 in 2..4 -> "Пользователь был(а) в сети $timeToMinutes минуты назад"
        else -> "Пользователь был(а) в сети $timeToMinutes минут назад"
    }
}

fun hoursToText(time: Int): String {
    val timeToHours: Int = time / 3600
    return when {
        timeToHours % 10 == 1 && timeToHours % 100 != 11 -> "Пользователь был(а) в сети $timeToHours час назад"
        timeToHours % 10 in 2..4 -> "Пользователь был(а) в сети $timeToHours часа назад"
        else -> "Пользователь был(а) в сети $timeToHours часов назад"
    }
}


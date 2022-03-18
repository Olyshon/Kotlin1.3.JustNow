const val HOUR = 3600
const val DAY = 86400

fun main() {
    print("Сколько секунд назад пользователь был в сети? Введите:")
    val timeInn: String = readLine() ?: return
    val time: Int = timeInn.toInt()
    when {
        time in 0..60 ->  println("Пользователь был(а) в сети только что")
        time in 61..HOUR -> println(minutesToText(time))
        time in HOUR + 1..DAY -> println(hoursToText(time))
        time in DAY + 1..2 * DAY -> println("Пользователь был(а) в сети сегодня")
        time in 2 * DAY + 1..3 * DAY -> println("Пользователь был(а) в сети вчера")
        time > 3 * DAY -> println("Пользователь был(а) в сети давно")
        else -> println("Вы ввели некорректное количество секунд")
    }
}
fun minutesToText(time: Int): String {
    val timeToMinutes: Int = time / 60
    return if (timeToMinutes % 10 == 1 && timeToMinutes % 100 != 11) "Пользователь был(а) в сети $timeToMinutes минуту назад"
    else  if (timeToMinutes % 10 in 2..4) "Пользователь был(а) в сети $timeToMinutes минуты назад"
    else "Пользователь был(а) в сети $timeToMinutes минут назад"
}

fun hoursToText(time: Int): String {
    val timeToHours: Int = time / 3600
    return if (timeToHours % 10 == 1 && timeToHours % 100 != 11) "Пользователь был(а) в сети $timeToHours час назад"
    else  if (timeToHours % 10 in 2..4) "Пользователь был(а) в сети $timeToHours часа назад"
    else "Пользователь был(а) в сети $timeToHours часов назад"
}
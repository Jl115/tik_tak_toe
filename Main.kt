package tictactoe

fun main() {
    val row = MutableList(9) { " " }
    val line = "-".repeat(9)

    println(line)
    println("| ${row[0]} ${row[1]} ${row[2]} |")
    println("| ${row[3]} ${row[4]} ${row[5]} |")
    println("| ${row[6]} ${row[7]} ${row[8]} |")
    println(line)

    var sumX = 0
    var sumO = 0
    val u = " "

    fun chekWin(rows: List<List<String>>): Boolean {
        for (row in rows) {
            if (row == listOf("X", "X", "X") || row == listOf("O", "O", "O")) {
                return true
            }
        }
        return false
    }

    while (true) {
        var stop = true
        while (stop) {
            print("Enter a Number (with a Space): ")
            val (a, b) = readln().split(" ")
            if (a.toIntOrNull() !is Int || b.toIntOrNull() !is Int) {
                println("You should enter numbers!")
            } else if (a.toInt() !in 1..3 || b.toInt() !in 1..3) {
                println("Coordinates should be from 1 to 3!")
            } else {
                val index = (a.toInt() - 1) * 3 + (b.toInt() - 1)
                if (row[index] == u) {
                    row[index] = if (sumX == sumO) "X" else "O"
                    stop = false
                } else {
                    println("This cell is occupied! Choose another one!")
                }
            }
        }
        println(line)
        println("| ${row[0]} ${row[1]} ${row[2]} |")
        println("| ${row[3]} ${row[4]} ${row[5]} |")
        println("| ${row[6]} ${row[7]} ${row[8]} |")
        println(line)

        val rows = listOf(
                listOf(row[0], row[1], row[2]),
                listOf(row[3], row[4], row[5]),
                listOf(row[6], row[7], row[8]),
                listOf(row[0], row[3], row[6]),
                listOf(row[1], row[4], row[7]),
                listOf(row[2], row[5], row[8]),
                listOf(row[0], row[4], row[8]),
                listOf(row[2], row[4], row[6])
        )

        if (chekWin(rows)) {
            if (sumX == sumO) {
                println("X wins")
                break
            } else {
                println("O wins")
                break
            }
        } else if (!row.contains(u)) {
            println("Draw")
            break
        } else {
            if (sumX == sumO) {
                sumX++
            } else {
                sumO++
            }
        }
    }
}
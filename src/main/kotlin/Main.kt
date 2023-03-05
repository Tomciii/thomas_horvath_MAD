fun main() {
    playGame()
}

fun generateRandomNumber(): List<Int> {
    val result = mutableListOf<Int>()
    while (result.size < 4) {
        val digit = (0..9).random()
        if (digit !in result) {
            result.add(digit)
        }
    }
    return result
}

fun getInput(): List<Int?>? {

    print("Enter a 4 digit number: ")
    val guess = readLine()?.trim()?.toList()?.map { input -> input.toString().toIntOrNull() }
    if (guess == null || guess.size != 4 || guess.toSet().size != 4) {
        println("Invalid input!")
        return null
    }
    return guess
}

fun calculateScore(number: List<Int>, guess: List<Int>): List<Int> {
    var n = 0
    var m = 0
    for ((i, digit) in guess.withIndex()) {
        if (digit == number[i]) {
            m++
        } else if (digit in number) {
            n++
        }
    }
    return listOf(n, m)
}

fun playGame() {
    println("Starting puzzle game!")
    val number = generateRandomNumber()
    println("Generated the number")

    while (true) {
        val guess = getInput()

        if (guess == null) {
            continue
        }
        val (n, m) = calculateScore(number, guess as List<Int>)

        println("$n:$m")

        if (m == 4) {
            println("You guessed correctly!")
            break
        }
    }
}
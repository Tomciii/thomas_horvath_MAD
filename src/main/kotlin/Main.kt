fun main() {
    playPuzzle()
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

    if (isValidInput(guess as List<Int>)) {
        println("Invalid input!")
        return null
    }

    return guess
}

fun isValidInput(guess: List<Int>) : Boolean {
    return guess == null || guess.size != 4 || guess.toSet().size != 4
}

fun calculateScore(number: List<Int>, guess: List<Int>): List<Int> {
    var n = 0 // amount of digits correctly guessed from the number
    var m = 0 // amount of digits correctly guessed from the number and in the correct position

    for ((i, digit) in guess.withIndex()) {
        if (digit == number[i]) {
            m++
        } else if (digit in number) {
            n++
        }
    }
    return listOf(n, m)
}

fun playPuzzle() {
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
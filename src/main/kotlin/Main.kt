fun main() {
    playPuzzle()
}

fun generateRandomFourDigitNumber(): List<Int> {
    val result = mutableListOf<Int>()
    while (result.size < 4) {
        val digit = (0..9).random()
        if (digit !in result) {
            result.add(digit)
        }
    }
    return result
}

fun getUserInput(): List<Int?>? {

    print("Enter a 4 digit number: ")
    val userInput = readLine()?.trim()?.toList()?.map { input -> input.toString().toIntOrNull() }

    if (isValidInput(userInput as List<Int>)) {
        println("Invalid input!")
        return null
    }

    return userInput
}

fun isValidInput(input: List<Int>) : Boolean {
    return input == null || input.size != 4 || input.toSet().size != 4
}

fun countDigitMatches(number: List<Int>, guess: List<Int>): Int {
    var count = 0
    for (digit in guess) {
        if (digit in number) {
            count++
        }
    }
    return count
}

fun countDigitPositionMatches(number: List<Int>, guess: List<Int>): Int {
    var result = 0
    for (i in number.indices) {
        if (guess[i] == number[i]) {
            result++
        }
    }
    return result
}

fun playPuzzle() {
    println("Starting puzzle game!")
    val number = generateRandomFourDigitNumber()
    println("Generated the number")

    while (true) {
        val input = getUserInput()

        if (input == null) {
            continue
        }

        val n = countDigitMatches(number, input as List<Int>)
        val m = countDigitPositionMatches(number, input)

        println("$n:$m")

        if (m == 4) {
            println("You guessed correctly!")
            println("Ending puzzle")
            break
        }
    }
}
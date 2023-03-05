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

fun calculateScore(number: List<Int>, input: List<Int>): List<Int> {
    var n = 0 // amount of digits correctly guessed from the number
    var m = 0 // amount of digits correctly guessed from the number and in the correct position

    for (i in 0 until number.size) {
        if (input[i] == number[i]) {
            m++
        } else if (input[i] in number) {
            n++
        }
    }

    return listOf(n, m)
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

        val (n, m) = calculateScore(number, input as List<Int>)

        println("$n:$m")

        if (m == 4) {
            println("You guessed correctly!")
            println("Ending puzzle")
            break
        }
    }
}
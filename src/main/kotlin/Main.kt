package tictactoe

var result = true
var result2 = true

var flag = 2

var firstCoordinate = 0
var secondCoordinate = 0

fun check() {

    val yourCoordinates = readln()

    result = yourCoordinates[0].isDigit() && yourCoordinates[2].isDigit()
    if (!result) {
        println("You should enter numbers!")
    }
    if (result) {
        firstCoordinate = yourCoordinates[0].digitToInt()
        secondCoordinate = yourCoordinates[2].digitToInt()

        result2 = if (firstCoordinate > 3 || secondCoordinate > 3) {
            println("Coordinates should be from 1 to 3!")
            false
        } else {
            true
        }
    }
}

const val dashes = "---------"
fun main() {

    val yourString = "         ".toMutableList()

    var counterO = 0
    for (i in yourString) {
        if (i == 'O') {
            counterO++
        }
    }

    var counterX = 0
    for (i in yourString) {
        if (i == 'X') {
            counterX++
        }
    }

    println(dashes)

    val stars = mutableListOf(
        mutableListOf('0'),
        mutableListOf('0'),
        mutableListOf('0')
    )

    stars[0].clear()
    stars[1].clear()
    stars[2].clear()

    for ((index, j) in yourString.withIndex()) {
        if (index < 3) {
            stars[0].add(j)
        }
        if (index in 3..5) {
            stars[1].add(j)
        }
        if (index in 6..8) {
            stars[2].add(j)
        }
    }

    var counterDash2 = 0
    for (j in yourString) {
        if (j == '_') {
            counterDash2++
        }
    }

    // Paint outside box
    for ((kIndex, k) in stars.withIndex()) {

        if (kIndex == 0) {
            print("| ")
            print(k.joinToString().replace(",", ""))
            println(" |")
        }

        if (kIndex == 1) {
            print("| ")
            print(k.joinToString().replace(",", ""))
            println(" |")
        }

        if (kIndex == 2) {
            print("| ")
            print(k.joinToString().replace(",", ""))
            println(" |")
        }
    }

    fun printSecondGrid() {
        println(dashes)

        for ((kIndex2, k) in stars.withIndex()) {

            if (kIndex2 == 0) {
                print("| ")
                print(k.joinToString().replace(",", ""))
                println(" |")
            }

            if (kIndex2 == 1) {
                print("| ")
                print(k.joinToString().replace(",", ""))
                println(" |")
            }

            if (kIndex2 == 2) {
                print("| ")
                print(k.joinToString().replace(",", ""))
                println(" |")
            }

        }
        println(dashes)
    }

    var checkOccupation = true

    fun checkOccupied() {

        if (firstCoordinate in 1..3 && secondCoordinate in 1..3) {
            if (stars[firstCoordinate - 1][secondCoordinate - 1] == 'O' || stars[firstCoordinate - 1][secondCoordinate - 1] == 'X') {
                println("This cell is occupied! Choose another one!")
                checkOccupation = false
            } else {
                checkOccupation = true
                flag++
                if (flag % 2 != 0) {
                    stars[firstCoordinate - 1][secondCoordinate - 1] = 'X'
                } else {
                    stars[firstCoordinate - 1][secondCoordinate - 1] = 'O'
                }
            }
        }
    }

    var resultAnalysis = false

    fun analysis() {

        // Analysis horizontal
        for (i in stars) {

            if (stars[0].contains(' ')) {
                resultAnalysis = false
            } else {
                if (stars[0][0] == stars[0][1] && stars[0][0] == stars[0][2]) {
                    resultAnalysis = true
                    println("${stars[0][0]} wins")
                    break
                }
            }

            if (stars[1].contains(' ')) {
                resultAnalysis = false
            } else {
                if (stars[1][0] == stars[1][1] && stars[1][0] == stars[1][2]) {
                    resultAnalysis = true
                    println("${stars[1][0]} wins")
                    break
                }
            }

            if (stars[2].contains(' ')) {
                resultAnalysis = false
            } else {
                if (stars[2][0] == stars[2][1] && stars[2][0] == stars[2][2]) {
                    resultAnalysis = true
                    println("${stars[2][0]} wins")
                    break
                }
            }

        }

        // Analysis vertical
        for (j in stars) {

            if (stars[0][0] == ' ' && stars[1][0] == ' ' && stars[2][0] == ' ') {
                resultAnalysis = false
            } else {
                if (stars[0][0] == stars[1][0] && stars[0][0] == stars[2][0]) {
                    resultAnalysis = true
                    println("${stars[0][0]} wins")
                    break
                }
            }

            if (stars[0][1] == ' ' && stars[1][1] == ' ' && stars[2][1] == ' ') {
                resultAnalysis = false
            } else {
                if (stars[0][1] == stars[1][1] && stars[0][1] == stars[2][1]) {
                    resultAnalysis = true
                    println("${stars[0][1]} wins")
                    break
                }
            }

            if (stars[0][2] == ' ' && stars[1][2] == ' ' && stars[2][2] == ' ') {
                resultAnalysis = false
            } else {
                if (stars[0][2] == stars[1][2] && stars[0][2] == stars[2][2]) {
                    resultAnalysis = true
                    println("${stars[0][2]} wins")
                    break
                }
            }
        }

        // Analysis diagonal
        for (k in stars) {

            if (stars[0][0] == ' ' && stars[1][1] == ' ' && stars[2][2] == ' ') {
                resultAnalysis = false
            } else {
                if (stars[0][0] == stars[1][1] && stars[0][0] == stars[2][2]) {
                    resultAnalysis = true
                    println("${stars[0][0]} wins")
                    break
                }
            }

            if (stars[0][2] == ' ' && stars[1][1] == ' ' && stars[2][0] == ' ') {
                resultAnalysis = false
            } else {
                if (stars[0][2] == stars[1][1] && stars[0][2] == stars[2][0]) {
                    resultAnalysis = true
                    println("${stars[0][2]} wins")
                    break
                }
            }
        }

        // Analysis draw
        var counterEmpty = 0

        for (l in stars) {
            if (stars[0].contains(' ')) {
                counterEmpty++
            }
            if (stars[1].contains(' ')) {
                counterEmpty++
            }
            if (stars[2].contains(' ')) {
                counterEmpty++
            }
        }

        if (counterEmpty == 0 && !resultAnalysis) {
            println("Draw")
            resultAnalysis = true
        }
    }

    println(dashes)

    // Check input and change coordinate.
    do {
        check()

        if (result && result2) {
            checkOccupied()
        }

        if (checkOccupation) {
            if (result && result2) {
                printSecondGrid()
                analysis()
            }
        }

    } while (!resultAnalysis)
}
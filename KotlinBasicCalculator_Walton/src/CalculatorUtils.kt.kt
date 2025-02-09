import java.util.Scanner

data class Calculation(val num1: Double, val num2: Double, val operator: Char, val result: String)

fun getValidNumber(scanner: Scanner): Double {
    while (true) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble()
        } else {
            println("Invalid input. Please enter a valid number.")
            scanner.nextLine() // Clear the invalid input
        }
    }
}


fun getValidOperator(scanner: Scanner): Char {
    val validOperators = setOf('+', '-', '*', '/', '%', '^', 'r')
    while (true) {
        val operator = scanner.next()[0]
        if (operator in validOperators) {
            return operator
        }
        println("Invalid operator. Please enter one of +, -, *, /, %, ^ (power), r (square root).")
    }
}

fun calculate(num1: Double, num2: Double, operator: Char): Any {
    return when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> if (num2 != 0.0) num1 / num2 else "Error: Division by zero"
        '%' -> if (num2 != 0.0) num1 % num2 else "Error: Modulo by zero"
        '^' -> Math.pow(num1, num2)
        'r' -> if (num1 >= 0) Math.sqrt(num1) else "Error: Cannot calculate square root of a negative number"
        else -> "Error: Invalid operator"
    }
}

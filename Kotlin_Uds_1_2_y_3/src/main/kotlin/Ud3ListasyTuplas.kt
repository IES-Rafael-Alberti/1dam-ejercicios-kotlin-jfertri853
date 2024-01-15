import kotlin.math.abs
import kotlin.math.pow


/*Escribir un programa que pregunte al usuario los números ganadores de la lotería primitiva,
los almacene en una lista y los muestre por pantalla ordenados de menor a mayor.*/

fun enterLotteryNumber(ticket: List<Int>): Int {
    /**
     *
     */
    print("Introduce un número de lotería (1-49)")
    val num = askForNumber()

    if (num < 1 || num > 49) {
        throw NumberFormatException("El número de lotería debe estar entre 1 y 49.")
    } else if (num in ticket) {
        throw NumberFormatException("Un mismo boleto no puede tener números repetidos.")
    }

    return num
}

fun enterRefundNumber(): Int {
    /**
     *
     */
    print("Introduce el número de reintegro (0-9): ")
    val num = askForNumber()

    if (num < 0 || num > 9) {
        throw NumberFormatException("El número de reintegro debe estar entre 0 y 9.")
    }

    return num
}

fun createTicket(): MutableList<Int> {
    /**
     *
     */
    val ticket = mutableListOf<Int>()
    var counter = 0

    while (counter < 6) {
        try {
            ticket.add(enterLotteryNumber(ticket))
            counter++
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    var refund = false
    while (!refund) {
        try {
            ticket.add(enterRefundNumber())
            refund = true
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    return ticket
}

fun orderTicket(ticket: MutableList<Int>): List<Int> {
    /**
     *
     */
    var total = ticket.size - 2
    var exchanges: Int? = null
    var counter = 0

    while (counter != ticket.size && exchanges != 0) {
        exchanges = 0

        for (i in 0 until total) {
            if (ticket[i] > ticket[i + 1]) {
                val higher = ticket[i]
                ticket[i] = ticket[i + 1]
                ticket[i + 1] = higher
                exchanges++
            }
        }

        total--
        counter++
    }

    return ticket
}

fun showTicket(ticket: List<Int>) {
    /**
     *
     */
    println("Tu boleto:")
    for ((position, num) in ticket.withIndex()) {
        if (position < 5) {
            print("$num - ")
        } else {
            println(num)
        }
    }
    println("Reintegro: ${ticket[6]}")
}

fun ud3ListasyTuplasEj4() {
    val boletoGanador = orderTicket(createTicket())
    showTicket(boletoGanador)
}


/*Escribir un programa que almacene las asignaturas de un curso
(por ejemplo Matemáticas, Física, Química, Historia y Lengua) en una lista,
pregunte al usuario la nota que ha sacado en cada asignatura y elimine de la lista las asignaturas aprobadas.
Al final el programa debe mostrar por pantalla las asignaturas que el usuario tiene que repetir.*/

fun askForGrade(subject: String): Double {
    /**
     *
     */
    print("Introduce la nota de $subject: ")
    return readln().toDouble()
}


fun validateGrade(nota: Double): Boolean {
    /**
     *
     */
    return nota in 0.0..10.0
}


fun putGrades(subjects: List<String>): List<Double> {
    /**
     *
     */
    val grades = mutableListOf<Double>()
    for (pos in subjects.indices) {
        val nota = askForGrade(subjects[pos])
        if (validateGrade(nota)) {
            grades.add(nota)
        } else {
            throw IllegalArgumentException("Alguna de las notas introducidas no es válida.")
        }
    }
    return grades
}


fun showList(subjects: List<String>) {
    /**
     *
     */
    for (pos in subjects.indices) {
        print(if (pos != subjects.size - 1) "${subjects[pos]}, " else subjects[pos])
    }
}


fun deletePassedSubjects(subjects: MutableList<String>, grades: List<Double>): MutableList<String> {
    /**
     *
     */
    val indicesToDelete = mutableListOf<Int>()

    for (pos in subjects.indices) {
        if (grades[pos] >= 5) {
            indicesToDelete.add(pos)
        }
    }

    for (i in indicesToDelete.reversed()) {
        subjects.removeAt(i)
    }

    return subjects
}


fun ud3ListasyTuplasEj6() {
    var subjects = listOf("Matemáticas", "Química", "Historia", "Lengua")
    var grades = emptyList<Double>()

    var notasEvaluadas = false
    while (!notasEvaluadas) {
        try {
            grades = putGrades(subjects)
            notasEvaluadas = true
        } catch (e: IllegalArgumentException) {
            println("**ERROR** - ${e.message}")
        }
    }

    subjects = deletePassedSubjects(subjects.toMutableList(), grades)
    println("Tienes que recuperar:")
    showList(subjects)
}


/*Escribir un programa que pida al usuario una palabra y muestre por pantalla si es un palíndromo.*/

fun askForWord(): List<Char> {
    /**
     *
     */
    print("Introduce una palabra: ")
    val word = readln()
    return word.toList()
}


fun isPalindrome(word: List<Char>, reversedWord: List<Char>): Boolean {
    /**
     *
     */
    return word == reversedWord
}


fun ud3ListasyTuplasEj8() {
    val word = askForWord()
    val reversedWord = word.reversed()

    if (isPalindrome(word, reversedWord)) {
        println("Es palíndromo")
    } else {
        println("No es palíndromo")
    }
}


/*Escribir un programa que pida al usuario una palabra
y muestre por pantalla el número de veces que contiene cada vocal.*/

fun countVowelRepetition(letters: List<Char>, word: String): ArrayList<String> {
    /**
     *
     */
    val vowelsCounting: ArrayList<String> = ArrayList()

    for (letter in letters) {
        val count = word.count {it == letter}
        if (count == 1) {
            vowelsCounting.add("$letter se repite $count vez en la palabra $word")
        } else if (count > 1) {
            vowelsCounting.add("$letter se repite $count veces en la palabra $word")
        }
    }

    return vowelsCounting
}


fun ud3ListasyTuplasEj9() {
    print("Introduce una palabra: ")
    val word = readln().lowercase()

    val vowelCount = countVowelRepetition(letters = listOf('a', 'e', 'i', 'o', 'u'), word)

    for (i in vowelCount) {
        println(i)
    }
}


/*Escribir un programa que almacene en una lista los siguientes precios: 50, 75, 46, 22, 80, 65, 8
y muestre por pantalla el menor y el mayor de los precios.*/

fun orderNums(nums: Array<Int>, operation: (Array<Int>) -> Array<Int>): Array<Int> {
    /**
     *
     */
    return operation(nums)
}


fun showIntArray(myArray: Array<Int>) {
    /**
     *
     */
    for (element in myArray) {
        print("$element, ")
    }

    println()
}


fun ud3ListasyTuplasEj10() {
    val prices = arrayOf(50, 75, 46, 22 , 80, 65, 8)

    val lowestToHighest: (Array<Int>) -> Array<Int> = {it.sortedArray()}
    val highestToLowest: (Array<Int>) -> Array<Int> = {it.sortedArrayDescending()}

    print("Precios ordenados de menor a mayor -> ")
    showIntArray(orderNums(prices, lowestToHighest))

    print("Precios ordenados de mayor a menor -> ")
    showIntArray(orderNums(prices, highestToLowest))

    val orderedPrices = orderNums(prices, lowestToHighest)
    println("El precio más bajo es -> ${orderedPrices.first()}")
    println("El precio más alto es -> ${orderedPrices.last()}")
}


/*Escribir un programa que pregunte por una muestra de números, separados por comas,
los guarde en una lista y muestre por pantalla su media y desviación típica.*/

fun askForDoubleList(): DoubleArray {
    /**
     *
     */
    val nums = arrayListOf<Double>()

    print("Introduce numeros separados por coma: ")
    val numsString = readln().replace(" ", "").split(",")

    for (num in numsString) {
        try {
            nums.add(num.toDouble())
        } catch (e: NumberFormatException) {
            print("** ERROR ** - $num no puede ser convertido a Double\n")
            Thread.sleep(1000)
        }
    }

    return nums.toDoubleArray()
}


fun summation(nums: DoubleArray): Double {
    /**
     *
     */
    var summ = 0.0
    for (num in nums) {
        summ += num
    }

    return summ
}


fun calculateAverage(nums:DoubleArray): Double {
    /**
     *
     */
    return summation(nums) / nums.size
}


fun calculateDistanceBetweenNums(num: Double, average: Double): Double {
    /**
     *
     */
    return abs(average - num)
}


fun raiseDoubleToDouble(num: Double, raiseNum: Double): Double {
    /**
     *
     */
    return num.pow(raiseNum)
}


fun calculateStandardDeviation(nums: DoubleArray, average: Double): Double {
    /**
     *
     */
    val distances = DoubleArray(size = nums.size) {
        raiseDoubleToDouble(calculateDistanceBetweenNums(nums[it], average), 2.0)
    }

    val summDistances = summation(distances)
    val deviation = raiseDoubleToDouble((summDistances / distances.size), 0.5)
    return deviation
}


fun showInfo(nums: DoubleArray, average: Double, deviation: Double) {
    /**
     *
     */
    println("Lista -> ${nums.joinToString()}")
    println("MEDIA -> %.2f".format(average))
    println("DESVIACIÓN TÍPICA -> %.2f".format(deviation))
}


fun ud3ListasyTuplasEj13() {
    val numList = askForDoubleList()

    if (numList.isNotEmpty()) {
        val average = calculateAverage(numList)
        val standardDeviation = calculateStandardDeviation(numList, average)

        showInfo(numList, average, standardDeviation)
    } else {
        println("No has introducido ningún número")
    }
}
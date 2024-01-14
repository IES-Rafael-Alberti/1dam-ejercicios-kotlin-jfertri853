/*Escribir un programa que pregunte al usuario su edad y muestre por pantalla todos los años que ha cumplido
(desde 1 hasta su edad).*/

fun verifyAge (min: Int, max: Int, age: Int): Int {
    /**
     *
     */
    when {
        age < min -> {throw NumberFormatException("No puedes tener menos de $min años")}
        age > max -> {throw NumberFormatException("No tienes más de $max años, no mientas")}
        else -> return age
    }
}


fun askForNumber (): Int {
    /**
     *
     */
    print(": ")
    return readln().toInt()
}


fun ageCount(age: Int) {
    /**
     *
     */
    val count = Array(size = age + 1){it}
    for (number in count) {
        when (number) {
            age -> print("$number.")
            else -> print("$number - ")
        }
    }
}


fun ud2IterativasEj2() {
    var age: Int?

    do {
        print("Introduce tu edad (1 - 125)")
        try {
            age = askForNumber()
            verifyAge(min = 0, max = 125, age)
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            age = null
        }
    } while (age == null)

    ageCount(age)
}


/*Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla la cuenta atrás
desde ese número hasta cero separados por comas.*/

fun isPositive(number: Int): Boolean {
    /**
     *
     */
    return number >= 0
}


fun countdown(number: Int) {
    /**
     *
     */
    val count = Array(size = number + 1){number - it}
    for (i in count.indices) {
        when (count[i]) {
             0 -> print("${count[i]}.")
            else -> print("${count[i]}, ")
        }
    }
}


fun ud2IterativasEj4() {
    var num: Int

    do {
        print("Introduce un entero positivo")
        try {
            num = askForNumber()
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            num = -1
        }
    } while (!isPositive(num))

    countdown(num)
}


/*Escribir un programa que pida al usuario un número entero y muestre por pantalla un triángulo rectángulo como
el de más abajo, de altura el número introducido.
*
**
***
**** */

fun createPyramidLayer(layerNum: Int): String {
    /**
     *
     */
    var layer = ""
    for (i in 1..layerNum) {
        layer += "*"
    }
    layer += "\n"

    return layer
}


fun createPyramid(height: Int): String {
    /**
     *
     */
    var pyramid = ""

    for (i in 1..height) {
        pyramid += createPyramidLayer(i)
    }

    return pyramid
}


fun ud2IterativasEj6() {
    var num: Int

    do {
        print("Introduce un entero positivo")
        try {
            num = askForNumber()
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            num = -1
        }
    } while (!isPositive(num))

    println(createPyramid(num))

}


/*Escribir un programa que muestre por pantalla la tabla de multiplicar del 1 al 10.*/

fun showTable(table: Array<Int>) {
    /**
     *
     */
    for (i in table.indices) {
        when (i + 1) {
            table.size -> print("${table[i]}.\n")
            else -> print("${table[i]}, ")
        }
    }
}


fun ud2IterativasEj7() {
    for (num in 1..10) {
        print("Tabla del $num -> ")
        val table = Array(size = 10){num * (it + 1)}
        showTable(table)
    }
}


/*Escribir un programa que pida al usuario un número entero y muestre por pantalla un triángulo
rectángulo como el de más abajo.
1
3 1
5 3 1
7 5 3 1
9 7 5 3 1*/

fun createPyramLayerWithLambdaExpression(num: Int, operation: (Int) -> String): String {
    /**
     *
     */
    return operation(num)
}


val layerOfOddNums: (Int) -> String = {
    buildString {
        var oddNum = (it * 2) -1
        while (oddNum >= 1) {
            append("$oddNum ")
            oddNum -= 2
        }
        append("\n")
    }
}


fun createOddPyramid(num: Int): String {
    /**
     *
     */
    var pyramid = ""

    for (i in 1..num) {
        pyramid += createPyramLayerWithLambdaExpression(i, layerOfOddNums)
    }

    return pyramid
}


fun ud2IterativasEj8() {
    var number = 0

    do {
        try {
            print("Introduce un numero")
            number = askForNumber()
            if (number < 1) {
                throw NumberFormatException("el numero debe ser mayor que 0")
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (number < 1)

    print(createOddPyramid(number))
}


/*Escribir un programa que muestre el eco de tod-o lo que el usuario introduzca hasta que el usuario escriba
“salir” que terminará.*/

fun writeDown() {
    /**
     *
     */
    println("Escribe lo que quieras, escribe salir para salir")
    var text = ""

    while (text.uppercase().trim() != "SALIR") {
        print("--> ")
        text = readln()
        if (text.uppercase().trim() != "SALIR") {
            println(text)
        }
    }
}


fun ud2IterativasEj13() {
    writeDown()
}


/*Leer números enteros de teclado, hasta que el usuario ingrese el 0. Finalmente, mostrar la sumatoria
de todos los números positivos ingresados.*/

fun endlessNumberInput(cutCondition: Int): MutableList<Int> {
    /**
     *
     */
    var num = -100
    val nums = mutableListOf<Int>()

    do {
        print("Introduce un numero positivo")
        try {
            num = askForNumber()
            if (num < cutCondition) {
                throw NumberFormatException("he dicho numeros positivos -___-")
            } else {
                nums.add(num)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (num != cutCondition)

    return nums
}


fun summation (nums: MutableList<Int>): Int {
    /**
     *
     */
    var summation = 0

    for (num in nums) {
        summation += num
    }

    return summation
}


fun ud2IterativasEj15() {
    val sum = summation(endlessNumberInput(0))
    println("sumatorio = $sum")
}


/*Solicitar al usuario que ingrese números enteros positivos y, por cada uno,
imprimir la suma de los dígitos que lo componen. La condición de corte es que se ingrese el número -1.
Al finalizar, mostrar cuántos de los números ingresados por el usuario fueron números pares.*/

fun isEven (num: Int): Boolean {
    /**
     *
     */
    return num % 2 == 0
}


fun countEvenNumbers (nums: MutableList<Int>): Int {
    /**
     *
     */
    var evenNums = 0

    for (num in nums) {
        if (isEven(num)) {
            evenNums += 1
        }
    }

    return evenNums
}


fun ud2IterativasEj18 () {
    val nums = endlessNumberInput(-1)
    println("Has introducido ${countEvenNumbers(nums)} numeros pares")
}


/*Mostrar un menú con tres opciones: 1- comenzar programa, 2- imprimir listado, 3-finalizar programa.
A continuación, el usuario debe poder seleccionar una opción (1, 2 ó 3). Si elige una opción incorrecta,
informarle del error. El menú se debe volver a mostrar luego de ejecutada cada opción, permitiendo volver a elegir.
Si elige las opciones 1 ó 2 se imprimirá un texto. Si elige la opción 3,
se interrumpirá la impresión del menú y el programa finalizará.*/

val myGrades = mutableListOf<Int>()


fun showMenu() {
    /**
     *
     */
    println("1 - Introduzca una nota")
    println("2 - Imprimir listado")
    println("3 - Finalizar programa")
    print("Seleccione una opción")
    var option = 0

    do {
        try {
            option = askForNumber()
            if (option < 1 || option > 3) {
                throw NumberFormatException("$option no es una opción")
            } else {
                selectOption(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
            print("Seleccione una opción (1, 2 o 3)")
        }
    } while (option != 3)
}


fun setNotas(grade: Int) {
    /**
     *
     */
    myGrades.add(grade)
}


fun getNotas() {
    /**
     *
     */
    print("Notas = ")
    for (grade in myGrades) {
        print("$grade - ")
    }
    println()
}


fun gradeInput(): Int {
    /**
     *
     */
    var nota: Int
    do {
        print("Introduce una nota (0-10)")
        nota = askForNumber()
    } while (nota < 0 || nota > 10)
    return nota
}


fun selectOption(option: Int) {
    /**
     *
     */
    when (option) {
        1 -> {
            setNotas(gradeInput())
            showMenu()
        }
        2 -> {
            getNotas()
            showMenu()
        }
        3 -> println("Cerrando el programa...")
    }
}


fun ud2IterativasEj19() {
    showMenu()
}


/*Solicitar al usuario que ingrese una frase y luego informar cuál fue la palabra más larga
(en caso de haber más de una, mostrar la primera) y cuántas palabras había. Precondición:
se tomará como separador de palabras al carácter “ “ (espacio), ya sea uno o más.*/

fun modifyPhrase(phrase: String): List<String> {
    /**
     *
     */
    val fraseModificada = phrase
        .replace(",", "")
        .replace(".", "")
        .replace("?", "")
        .replace("¿", "")
        .replace("!", "")
        .replace("¡", "")
        .replace(":", "")
        .replace(";", "")
        .split(" ")
        .filter { it.isNotBlank() }

    return fraseModificada
}

fun searchLongestWord(enlistedPhrase: List<String>): Pair<String, Int> {
    /**
     *
     */
    var mayor = 0
    var longestWord = ""

    for (word in enlistedPhrase) {
        val wordLen = word.length
        if (wordLen > mayor) {
            mayor = wordLen
            longestWord = word
        }
    }

    return Pair(longestWord, mayor)
}

fun ud2IterativasEj25() {
    print("Introduce una frase: ")
    val paragraph = readln()
    val modifiedParagraph = modifyPhrase(paragraph)
    val result = searchLongestWord(modifiedParagraph)

    println("La palabra más larga es '${result.first}' con ${result.second} letras.")
}
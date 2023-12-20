import java.math.BigDecimal
import java.math.RoundingMode


/** Ejercicio 4
 * Escribe un programa que le pida al usuario una temperatura en grados Celsius,
 * la convierta a grados Fahrenheite imprima por pantalla la temperatura convertida.
 */


fun askForDouble(): Double {
    /**
     *
     */
    return readln().toDouble()
}


fun roundTo2Decimals(num: Double): Double {
    /**
     *
     */
    return BigDecimal(num).setScale(2, RoundingMode.HALF_UP).toDouble()
}


fun celsiusToFahrenheit(celsius: Double): Double {
    /**
     *
     */
    return (celsius * 1.8) + 32
}


fun ud1Ejercicio4() {
    print("Introduce la temperatura: ")
    val celsius = roundTo2Decimals(askForDouble())
    val fahrenheit = roundTo2Decimals(celsiusToFahrenheit(celsius))
    println("$celsius grados Celsius son $fahrenheit grados Fahrenheit")
}


/** Ejercicio 6
 * Escribe un programa que pida el importe final de un artículo y calcule e imprima
 * por pantalla el IVA que se ha pagado y el importe sin IVA
 * (suponiendo que se ha aplicado un tipo de IVA del 10%).
 */
const val VAT = 0.1


fun calculateVATlessAmount(amount: Double): Double {
    /**
     *
     */
    return amount / (1 + VAT)
}


fun ud1Ejercicio6() {
    print("Introduce el precio del articulo: ")
    val finalAmount = roundTo2Decimals(askForDouble())
    val vatLessAmount = roundTo2Decimals(calculateVATlessAmount(finalAmount))
    val vatExpenses = roundTo2Decimals(finalAmount - vatLessAmount)
    println("El artículo sin IVA cuesta: $vatLessAmount, has pagado $vatExpenses en IVA")
}


/** Ejercicio 12
 * Escribir un programa que pida al usuario su peso (en kg) y estatura (en metros),
 * calcule el índice de masa corporal y lo almacene en una variable,
 * y muestre por pantalla la frase Tu índice de masa corporal calculado redondeado
 * con dos decimales.
 */


fun raiseTo(num: Double, exponent: Int): Double {
    /**
     *
     */
    var raisedNum = 1.0
    for (i in 1..exponent) {
        raisedNum *= num
    }
    return raisedNum
}


fun calculateBMI(weight: Double, height: Double): Double {
    /**
     *
     */
    return weight / (raiseTo(height/100, 2))
}


fun ud1Ejercicio12() {
    print("Introduce tu peso en kg: ")
    val weight = roundTo2Decimals(askForDouble())

    print("Introduce tu altura en centimetros: ")
    val height = roundTo2Decimals(askForDouble())

    val bmi = calculateBMI(weight, height)
    println("Tu indice de masa corporal es ${roundTo2Decimals(bmi)}")
}


/** Ejercicio 15
 * Imagina que acabas de abrir una nueva cuenta de ahorros que te ofrece el 4% de interés al año.
 * Estos ahorros debido a intereses, que no se cobran hasta finales de año,
 * se te añaden al balance final de tu cuenta de ahorros.
 * Escribir un programa que comience leyendo la cantidad de dinero depositada
 * en la cuenta de ahorro, introducida por el usuario.
 * Después el programa debe calcular y mostrar por pantalla la cantidad de ahorros tras el primer,
 * segundo y tercer años.
 * Redondear cada cantidad a dos decimales.
 */


const val INTEREST = 0.04


fun showMoneyAfterInterest(initialCapital: Double, years: Int) {
    /**
     *
     */
    var capital = initialCapital

    for (i in 1..years) {
        capital *= (1 + INTEREST)
        if (i == 1) {
            println("Tras $i año tu capital será de ${roundTo2Decimals(capital)}")
        } else {
            println("Tras $i años tu capital será de ${roundTo2Decimals(capital)}")
        }
    }
}


fun ud1Ejercicio15() {
    print("Introduce la cantidad de dinero que tienes en la cuenta: ")
    val money = roundTo2Decimals(askForDouble())
    showMoneyAfterInterest(money, 3)
}


/** Ejercicio 18
 * Escribir un programa que pregunte el nombre completo del usuario en la consola y después
 * muestre por pantalla el nombre completo del usuario tres veces,
 * una con todas las letras minúsculas, otra con todas las letras mayúsculas
 * y otra solo con la primera letra del nombre y de los apellidos en mayúscula.
 * El usuario puede introducir su nombre combinando mayúsculas y minúsculas como quiera.
 */


fun askForString(): String {
    /**
     *
     */
    return readln()
}


fun capitalize(initialPhrase: String): String {
    /**
     *
     */
    var finalPhrase = ""
    var capNext = true
    for (i in initialPhrase) {
        finalPhrase += if (capNext) i.uppercase() else i.lowercase()
        capNext = i.isWhitespace()
    }
    return finalPhrase
}


fun ud1Ejercicio18() {
    print("Introduce tu nombre completo: ")
    val name = askForString()
    println(name.lowercase())
    println(name.uppercase())
    println(capitalize(name))
}


/** Ejercicio 20
 * Los teléfonos de una empresa tienen el siguiente formato prefijo-número-extension
 * donde el prefijo es el código del país +34, y la extensión tiene dos dígitos
 * (por ejemplo +34-913724710-56). Escribir un programa que pregunte por un
 * número de teléfono con este formato y muestre por pantalla el número de teléfono
 * sin el prefijo y la extensión.
 */


fun isolatePhoneNumber(phoneNumber: String): String {
    /**
     *
     */
    return phoneNumber.split("-")[1]
}


fun ud1Ejercicio20() {
    print("Introduce un numero de telefono con prefijo y sufijo (+34-123456789-75): ")
    val phone = askForString()
    println("El numero sin prefijo ni sufijo es ${isolatePhoneNumber(phone)}")
}


/** Ejercicio 21
 * Escribir un programa que pida al usuario que introduzca una frase en la consola
 * y muestre por pantalla la frase invertida.
 */


fun ud1Ejercicio21() {
    print("Introduce una palabra: ")
    val word = askForString()
    println(word.reversed())
}


/** Ejercicio 22
 * Escribir un programa que pida al usuario que introduzca una frase en la consola y una vocal,
 * y después muestre por pantalla la misma frase pero con la vocal introducida en mayúscula.
 */


val VOWELS = listOf('a', 'e', 'i', 'o', 'u')


fun ud1Ejercicio22() {
    print("Introduce una palabra: ")
    val word = askForString()

    print("Introduce una vocal: ")
    val vowel = askForString()

    println(word.replace(vowel, vowel.uppercase()))
}


/** Ejercicio 24
 * Escribir un programa que pregunte por consola el precio de un producto en euros con dos decimales
 * y muestre por pantalla el número de euros y el número de céntimos del precio introducido.
 */


fun ud1Ejercicio24() {
    println("Introduce el precio de un producto: ")
    val price = roundTo2Decimals(askForDouble()).toString()
    println("El producto cuesta ${price.split('.')[0]} euros y ${price.split('.')[1]} céntimos")
}


/** Ejercicio 25
 * Escribir un programa que pregunte al usuario la fecha de su nacimiento en formato dd/mm/aaaa
 * y muestra por pantalla, el día, el mes y el año. Adaptar el programa anterior para que
 * también funcione cuando el día o el mes se introduzcan con un solo carácter.
 */


fun ud1Ejercicio25() {
    print("Introduce tu fecha de nacimiento en formato dd/mm/aaaa: ")
    val birthdate = askForString().split("/")
    print("Day ${birthdate[0]}, Month ${birthdate[1]}, Year ${birthdate[2]}")
}


/** Ejercicio 26
 * Escribir un programa que pregunte por consola por los productos de una cesta de la compra,
 * separados por comas y muestre por pantalla cada uno de los productos en una línea distinta.
 */


fun ud1Ejercicio26() {
    println("Introduce los productos de la lista de la compra separados por coma y espacio")
    print("--> ")
    val shoppingList = askForString().replace(", ", "\n")
    println(shoppingList)
}


/** Ejercicio 27
 * Escribir un programa que pregunte el nombre el un producto, su precio y un número de unidades
 * y muestre por pantalla una cadena con el nombre del producto seguido de su precio unitario
 * con 6 dígitos enteros y 2 decimales, el número de unidades con tres dígitos y el coste total
 * con 8 dígitos enteros y 2 decimales.
 */


fun askForInt(): Int {
    /**
     *
     */
    return readln().toInt()
}


fun ud1Ejercicio27() {
    print("Introduce el nombre del producto: ")
    val product = askForString()

    print("Introduce el precio del producto: ")
    val price = roundTo2Decimals(askForDouble())

    print("Introduce la cantidad de productos: ")
    val units = askForInt()

    val finalCost = price * units

    println("%s %09.2f %03d %011.2f".format(product, price, units, finalCost))
}
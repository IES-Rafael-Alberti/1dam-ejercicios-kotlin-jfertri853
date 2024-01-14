/*Escribir un programa que guarde en un diccionario los precios de las frutas de la tabla,
pregunte al usuario por una fruta, un número de kilos y muestre por pantalla el precio de ese número
de kilos de fruta. Si la fruta no está en el diccionario debe mostrar un mensaje informando de ello.
Fruta	Precio
Plátano	1.35
Manzana	0.80
Pera	0.85
Naranja	0.70*/

fun calculatePrice(fruits: Map<String, Double>, fruit: String, weight: Double): Any {
    return if (fruit in fruits) {
        (fruits[fruit]!! * weight)
    } else {
        println("No tenemos $fruit")
    }
}


fun ud3DiccionariosEj3() {
    val fruits = mapOf("platano" to 1.35,
        "manzana" to 0.80,
        "pera" to 0.85,
        "naranja" to 0.70)

    print("Qué fruta quieres? ")
    val fruit = readln().lowercase()

    print("Cuántos kilos de $fruit quieres? ")
    var kilograms = 1.0
    try {
        kilograms = readln().toDouble()
        if (kilograms < 0.0) {
            throw NumberFormatException("no puedes llevarte kilos negativos de fruta")
        }
    } catch (e: NumberFormatException) {
        println("No has introducido un número válido, te llevas 1kg por defecto")
        kilograms = 1.0
    }

    val price = calculatePrice(fruits, fruit, kilograms)
    if (price !is Unit) {
        println("${kilograms}kg de $fruit te saldrá a $price euros")
    }
}
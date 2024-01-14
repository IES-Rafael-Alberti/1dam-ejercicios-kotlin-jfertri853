fun showCompleteMenu() {
    println("Unidad 1 -> 1\nUnidad 2 -> 2\nUnidad 3 -> 3\nSalir -> 0\n")
}


fun completeMenu(option: Int) {
    when (option) {
        1 -> ud1Menu()
        2 -> ud2Menu()
        3 -> ud3Menu()
        else -> println("Cerrando aplicación...")
    }
}


fun ud1Menu() {
    println("Ejercicios: 4, 6 ,12, 15, 18, 20, 21, 22, 24, 25, 26, 27")

}


fun main() {
    val uds = listOf(0, 1, 2, 3)
    var option = -1

    do {
        showCompleteMenu()
        print("Opción -> ")
        try {
            option = askForNumber()
            if (option !in uds) {
                throw NumberFormatException("El tema introducido no existe")
            } else {
                completeMenu(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)

//    ud1Ejercicio4()
//    ud1Ejercicio6()
//    ud1Ejercicio12()
//    ud1Ejercicio15()
//    ud1Ejercicio18()
//    ud1Ejercicio20()
//    ud1Ejercicio21()
//    ud1Ejercicio22()
//    ud1Ejercicio24()
//    ud1Ejercicio25()
//    ud1Ejercicio26()
//    ud1Ejercicio27()
//    ud2CondicionesEj2()
//    ud2CondicionesEj3()
//    ud2CondicionesEj6()
//    ud2CondicionesEj8()
//    ud2CondicionesEj10()
//    ud2IterativasEj2()
//    ud2IterativasEj4()
//    ud2IterativasEj6()
//    ud2IterativasEj7()
//    ud2IterativasEj8()
//    ud2IterativasEj13()
//    ud2IterativasEj15()
//    ud2IterativasEj18()
//    ud2IterativasEj19()
//    ud2IterativasEj25()
//    ud2ExcepcionesEj2()
//    ud2ExcepcionesEj3()
//    ud2ExcepcionesEj4()
//    ud3ListasyTuplasEj4()
//    ud3ListasyTuplasEj6()
//    ud3ListasyTuplasEj8()
//    ud3DiccionariosEj3()
}
/*Este menú es temporal, evidentemente este código se puede mejorar muchísimo pero me está
 costando programar en Kotlin y quería tener el menú hecho rápido sin comerme mucho la cabeza.
 Ah y además esto está fuera de plazo, lo voy a subir igual aunque no cuente para la nota*/


fun showCompleteMenu() {
    println("1 -> Unidad 1\n2 -> Unidad 2\n3 -> Unidad 3\n0 -> Salir\n")
}


fun pickUd(option: Int) {
    when (option) {
        1 -> ud1Menu()
        2 -> ud2Menu()
        3 -> ud3Menu()
        else -> println("Cerrando aplicación...")
    }
}


fun ud1Menu() {
    val exercises = listOf(0, 4, 6, 12, 15, 18, 20, 21, 22, 24, 25, 26, 27)
    var option = -1

    do {
        println("0 -> Volver\n4 -> Ejercicio 4\n6 -> Ejercicio 6\n12 -> Ejercicio 12\n" +
                "15 -> Ejercicio 15\n18 -> Ejercicio 18\n20 -> Ejercicio 20\n" +
                "21 -> Ejercicio 21\n22 -> Ejercicio 22\n24 -> Ejercicio 24\n" +
                "25 -> Ejercicio 25\n26 -> Ejercicio 26\n27 -> Ejercicio 27\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud1Option(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud1Option(option: Int) {
    when (option) {
        4 -> ud1Ejercicio4()
        6 -> ud1Ejercicio6()
        12 -> ud1Ejercicio12()
        15 -> ud1Ejercicio12()
        18 -> ud1Ejercicio18()
        20 -> ud1Ejercicio20()
        21 -> ud1Ejercicio21()
        22 -> ud1Ejercicio22()
        24 -> ud1Ejercicio24()
        25 -> ud1Ejercicio25()
        26 -> ud1Ejercicio26()
        27 -> ud1Ejercicio27()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud2Menu() {
    val parts = listOf(0, 1, 2, 3)
    var option = -1

    do {
        println("0 -> Volver\n1 -> Condiciones\n2 -> Estructuras iterativas\n3 -> Excepciones")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in parts) {
                throw NumberFormatException("El tema introducido no existe")
            } else {
                ud2PartSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud2PartSelection(option: Int) {
    when (option) {
        1 -> ud2CondicionesMenu()
        2 -> ud2IterativasMenu()
        3 -> ud2ExcepcionesMenu()
        else -> println("\n\n")
    }
}


fun ud2CondicionesMenu() {
    val exercises = listOf(0, 2, 3, 6, 8, 10)
    var option = -1

    do {
        println("0 -> Volver\n2 -> Ejercicio 2\n3 -> Ejercicio 3\n6 -> Ejercicio 6\n" +
                "8 -> Ejercicio 8\n10 -> Ejercicio 10")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud2CondicionesSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud2CondicionesSelection(option: Int) {
    when (option) {
        2 -> ud2CondicionesEj2()
        3 -> ud2CondicionesEj3()
        6 -> ud2CondicionesEj6()
        8 -> ud2CondicionesEj8()
        10 -> ud2CondicionesEj10()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud2IterativasMenu() {
    val exercises = listOf(0, 2, 4, 6, 7, 8, 13, 15, 18, 19, 25)
    var option = -1

    do {
        println("0 -> Volver\n2 -> Ejercicio 2\n4 -> Ejercicio 4\n6 -> Ejercicio 6\n" +
                "7 -> Ejercicio 7\n8 -> Ejercicio 8\n13 -> Ejercicio 13\n" +
                "15 -> Ejercicio 15\n18 -> Ejercicio 18\n19 -> Ejercicio 19\n" +
                "25 -> Ejercicio 25\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud2IterativasSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud2IterativasSelection(option: Int) {
    when (option) {
        2 -> ud2IterativasEj2()
        4 -> ud2IterativasEj4()
        6 -> ud2IterativasEj6()
        7 -> ud2IterativasEj7()
        8 -> ud2IterativasEj8()
        13 -> ud2IterativasEj13()
        15 -> ud2IterativasEj15()
        18 -> ud2IterativasEj18()
        19 -> ud2IterativasEj19()
        25 -> ud2IterativasEj25()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud2ExcepcionesMenu() {
    val exercises = listOf(0, 2, 3, 4)
    var option = -1

    do {
        println("0 -> Volver\n2 -> Ejercicio 2\n3 -> Ejercicio 3\n4 -> Ejercicio 4\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud2ExcepcionesSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud2ExcepcionesSelection(option: Int) {
    when (option) {
        2 -> ud2ExcepcionesEj2()
        3 -> ud2ExcepcionesEj3()
        4 -> ud2ExcepcionesEj4()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud3Menu() {
    val parts = listOf(0, 1, 2, 3)
    var option = -1

    do {
        println("0 -> Volver\n1 -> Listas y tuplas\n2 -> Diccionario\n3 -> Conjuntos\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in parts) {
                throw NumberFormatException("El tema introducido no existe")
            } else {
                ud3PartSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud3PartSelection(option: Int) {
    when (option) {
        1 -> ud3ListasyTuplasMenu()
        2 -> ud3DiccionariosMenu()
        3 -> ud3ConjuntosMenu()
        else -> println("\n\n")
    }
}


fun ud3ListasyTuplasMenu() {
    val exercises = listOf(0, 4, 6, 8, 9, 10, 13)
    var option = -1

    do {
        println("0 -> Volver\n4 -> Ejercicio 4\n6 -> Ejercicio 6\n8 -> Ejercicio 8\n" +
                "9 -> Ejercicio 9\n10 -> Ejercicio 10\n13 -> Ejercicio 13\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud3ListasyTuplasSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud3ListasyTuplasSelection(option: Int) {
    when (option) {
        4 -> ud3ListasyTuplasEj4()
        6 -> ud3ListasyTuplasEj6()
        8 -> ud3ListasyTuplasEj8()
        9 -> ud3ListasyTuplasEj9()
        10 -> ud3ListasyTuplasEj10()
        13 -> ud3ListasyTuplasEj13()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud3DiccionariosMenu() {
    val exercises = listOf(0, 3, 5, 6, 7, 8, 10, 11)
    var option = -1

    do {
        println("0 -> Volver\n3 -> Ejercicio 3\n5 -> Ejercicio 5\n6 -> Ejercicio 6\n" +
                "7 -> Ejercicio 7\n8 -> Ejercicio 8\n10 -> Ejercicio 10\n11 -> Ejercicio 11\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud3DiccionariosSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud3DiccionariosSelection(option: Int) {
    when (option) {
        3 -> ud3DiccionariosEj3()
//        5 -> ud3DiccionariosEj5()
//        6 -> ud3DiccionariosEj6()
//        7 -> ud3DiccionariosEj7()
//        8 -> ud3DiccionariosEj8()
//        10 -> ud3DiccionariosEj10()
//        11 -> ud3DiccionariosEj11()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun ud3ConjuntosMenu() {
    val exercises = listOf(0, 1, 2, 3, 4, 5, 6)
    var option = -1

    do {
        println("0 -> Volver\n1 -> Ejercicio 1\n2 -> Ejercicio 2\n3 -> Ejercicio 3\n" +
                "4 -> Ejercicio 4\n5 -> Ejercicio 5\n6 -> Ejercicio 6\n")
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in exercises) {
                throw NumberFormatException("El ejercicio introducido no existe")
            } else {
                ud3ConjuntosSelection(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}


fun ud3ConjuntosSelection(option: Int) {
    when (option) {
//        1 -> ud3ConjuntosEj1()
//        2 -> ud3ConjuntosEj2()
//        3 -> ud3ConjuntosEj3()
//        4 -> ud3ConjuntosEj4()
//        5 -> ud3ConjuntosEj5()
//        6 -> ud3ConjuntosEj6()
        else -> println("\n\n")
    }

    Thread.sleep(3000)
}


fun main() {
    val uds = listOf(0, 1, 2, 3)
    var option = -1

    do {
        showCompleteMenu()
        print("Introduce una opción")
        try {
            option = askForNumber()
            if (option !in uds) {
                throw NumberFormatException("El tema introducido no existe")
            } else {
                pickUd(option)
            }
        } catch (e: NumberFormatException) {
            println("** ERROR ** - $e")
        }
    } while (option != 0)
}
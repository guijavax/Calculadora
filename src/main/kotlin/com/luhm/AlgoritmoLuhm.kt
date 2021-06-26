package com.luhm

@ExperimentalStdlibApi
fun main() {
    val numberCard = readLine()
    var numbers = inverterNumbers(numberCard)?.let {
        result -> sumPairNumbers(result)
    }

    numbers?.forEach {  println(it)}
     numbers = numbers?.let { mountAnotherArray(it) }

    val res = sumNumbers(numbers?:IntArray(0))
    if (res % 10 == 0) {
        println("Válido")
    } else {
        println("Inválido")
    }
}

fun sumNumbers(numbers: IntArray) : Int {
    var  res = 0
    numbers.forEach {
        res += it
    }
    return res
}

@ExperimentalStdlibApi
private fun mountAnotherArray(numbers: IntArray) : IntArray {
    for(i in 0 .. numbers.size) {
        if(i == numbers.size) break
        if(numbers[i] > 9) {
            val number = numbers[i].toString().toCharArray().toTypedArray()
            numbers[i]= number[0].digitToInt() + number[1].digitToInt()
        }
    }
    return numbers
}

private fun sumPairNumbers(numbers : IntArray) : IntArray {
    for (i in 1 until numbers.size step 2) {
        numbers[i] *= 2
    }
    return numbers
}

private fun inverterNumbers(numberCard: String?) : IntArray? {
    val numbersCard = numberCard?.split(",".toRegex())?.toTypedArray()
    var inverseNumberCard : IntArray? = null
    if (numbersCard != null) {
        inverseNumberCard= IntArray(numbersCard.size)
        for ((i, n) in (numbersCard.size downTo 0).withIndex()) {
            if (n == 0) {
                inverseNumberCard[i - 1] = numbersCard[n].toInt()
            } else
                inverseNumberCard[i] = numbersCard[n - 1].toInt()
        }
        }
    return  inverseNumberCard
}
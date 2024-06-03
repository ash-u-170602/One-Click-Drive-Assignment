package com.example.oneclickdriveassignment.utils

class NumberCalculator {
    fun calculate(
        input1: List<Int>,
        input2: List<Int>,
        input3: List<Int>
    ): Triple<List<Int>, List<Int>, Int> {
        val intersect = findIntersect(input1, input2, input3)
        val union = findUnion(input1, input2, input3)
        val highest = findHighest(input1, input2, input3)
        return Triple(intersect, union, highest)
    }

    private fun findIntersect(arr1: List<Int>, arr2: List<Int>, arr3: List<Int>): List<Int> {
        val set1 = arr1.toSet()
        val set2 = arr2.toSet()
        val set3 = arr3.toSet()
        return set1.intersect(set2).intersect(set3).toList()
    }

    private fun findUnion(arr1: List<Int>, arr2: List<Int>, arr3: List<Int>): List<Int> {
        val set1 = arr1.toSet()
        val set2 = arr2.toSet()
        val set3 = arr3.toSet()
        return (set1 + set2 + set3).toList()
    }

    private fun findHighest(arr1: List<Int>, arr2: List<Int>, arr3: List<Int>): Int {
        val max1 = arr1.maxOrNull() ?: Int.MIN_VALUE
        val max2 = arr2.maxOrNull() ?: Int.MIN_VALUE
        val max3 = arr3.maxOrNull() ?: Int.MIN_VALUE
        return maxOf(max1, maxOf(max2, max3))
    }
}
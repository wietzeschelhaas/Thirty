package com.example.thirty

class Score {
        // variation of subset sum problem where all found subsets are returned
        private fun findSubsetSums(
            numbers: ArrayList<Int>,
            target: Int,
            partial: ArrayList<Int>,
            res: ArrayList<ArrayList<Int>>
        ) {
            var s = 0
            for (x in partial) {
                s += x
            }
            if (s == target) {
                if (!res.contains(partial)) res.add(partial)
            }
            if (s >= target) return
            for (i in 0 until numbers.size) {
                val remaining = ArrayList<Int>()
                val n = numbers[i]
                for (j in i + 1 until numbers.size) {
                    remaining.add(numbers[j])
                }
                val partial_rec = ArrayList(partial)
                partial_rec.add(n)
                findSubsetSums(remaining, target, partial_rec, res)
            }
        }

        fun max(a: Int, b: Int): Int {
            return if (a > b) a else b
        }

        //removes elements from b in a once
        private fun removeFromList(a: ArrayList<Int>, b: ArrayList<Int>) {
            for (i in b) {
                a.remove(i)
            }
        }

        private fun knapSack(
            diceThrow: ArrayList<Int>,
            possibleCombs: ArrayList<ArrayList<Int>>,
            n: Int
        ): Int {
            // Base Case
            if (n == -1) {
                return 0
            }
            var a = 0
            val notRemoved = ArrayList(diceThrow)
            if (diceThrow.containsAll(possibleCombs[n])) {
                removeFromList(diceThrow, possibleCombs[n])
                a = 1
            }

            // If weight of the nth item is
            // more than Knapsack capacity W,
            // then this item cannot be included
            // in the optimal solution
            //if (wt[n - 1] > W)
            //return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return max(
                a + knapSack(diceThrow, possibleCombs, n - 1),
                knapSack(notRemoved, possibleCombs, n - 1)
            )
        }
    fun calcScore(numbers:ArrayList<Int>, target:Int):Int{
        val result = ArrayList<ArrayList<Int>>()
        findSubsetSums(numbers, target, ArrayList(), result)
        val res = knapSack(numbers, result, result.size - 1)
        return res
    }

}
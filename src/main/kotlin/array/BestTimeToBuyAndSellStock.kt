package array

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {

        //We Assume Max Profit is 0
        var maxProfit = 0

        //We Assume Minimum Price is the First Element
        var minimum = prices[0]

        //Traverse the Array
        for (i in prices.indices) {
            //Check if the current element is less than the minimum
            if (prices[i] < minimum) {
                minimum = prices[i]
            }
            //Check if the difference between the current element and the minimum is greater than the maxProfit
            if (prices[i] - minimum > maxProfit) {
                maxProfit = prices[i] - minimum
            }
        }
        //Return the Max Profit
        return maxProfit
    }
}
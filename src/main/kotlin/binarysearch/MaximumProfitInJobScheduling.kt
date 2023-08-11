package binarysearch

class MaximumProfitInJobScheduling {


    //We make a data class to store the start time, end time and profit
    data class Job(val startTime: Int, val endTime: Int, val profit: Int)



    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {

        //We create an array of jobs and sort them by their end time
        val jobs = Array(startTime.size) {
            Job(startTime[it], endTime[it], profit[it])
        }.apply {
            sortBy { it.endTime }
        }

        //We create a variable to store the max profit
        var maxProfit = jobs[0].profit

        //We create an array to store the max profit associated with each job
        val maxProfitAssociatedWithJob = IntArray(jobs.size) {
            0
        }

        //We iterate through the jobs
        for (i in jobs.indices) {

            //We set the max profit associated with the job to the profit of the job
            maxProfitAssociatedWithJob[i] = jobs[i].profit

            //We iterate through the jobs before the current job
            for (j in 0 until i) {

                //If the end time of the job is less than or equal to the start time of the current job means the jobs are compatible and non overlapping
                if (jobs[j].endTime <= jobs[i].startTime) {

                    //We update the max profit associated with the job
                    maxProfitAssociatedWithJob[i] =

                        //We take the max of the current max profit associated with the job and the max profit associated with the job before the current job plus the profit of the current job
                        maxOf(maxProfitAssociatedWithJob[i], maxProfitAssociatedWithJob[j] + jobs[i].profit)

                }
            }
            //We update the max profit
            maxProfit = maxOf(maxProfit, maxProfitAssociatedWithJob[i])
        }

        //We return the max profit
        return maxProfit
    }
}
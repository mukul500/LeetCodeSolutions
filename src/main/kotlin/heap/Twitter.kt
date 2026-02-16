package heap

import java.util.*

class Twitter() {

    private val k = 10
    private var currentTime = 0
    private var userTweets: MutableMap<Int, MutableList<Tweet>> = mutableMapOf()
    private var followersMap: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

    fun postTweet(userId: Int, tweetId: Int) {
        val tweetsList = userTweets[userId] ?: mutableListOf()
        val newTweet = Tweet(userId = userId, tweetId = tweetId, timeStamp = currentTime)
        tweetsList.add(newTweet)
        userTweets[userId] = tweetsList
        currentTime++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val newsFeed = PriorityQueue<Tweet>(compareBy { it.timeStamp })
        val followersList = followersMap[userId] ?: emptySet()
        val newListWithHimself = followersList + userId
        for (follower in newListWithHimself) {
            val tweets = userTweets[follower] ?: emptyList()
            for (i in tweets.size - 1 downTo 0) {
                val currentTweet = tweets[i]
                if (newsFeed.size == k && newsFeed.peek().timeStamp > currentTweet.timeStamp) {
                    break
                }
                newsFeed.add(currentTweet)
                if (newsFeed.size > k) {
                    newsFeed.poll()
                }

            }
        }


        val result = mutableListOf<Int>()

        while (newsFeed.isNotEmpty()) {
            result.add(newsFeed.poll().tweetId)  // this gives oldest → newest
        }

        return result.reversed()
    }


    fun follow(followerId: Int, followeeId: Int) {
        val followers = followersMap[followerId] ?: mutableSetOf<Int>()
        followers.add(followeeId)
        followersMap[followerId] = followers
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val followers = followersMap[followerId] ?: mutableSetOf<Int>()
        followers.remove(followeeId)
        followersMap[followerId] = followers
    }

    data class Tweet(
        val userId: Int, val tweetId: Int, val timeStamp: Int
    )

}
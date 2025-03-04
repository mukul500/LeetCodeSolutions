package linkedlist

class IntersectionOfList {

    //With Extra Space O(N)
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {

        val existingMap = mutableMapOf<Int, ListNode>()

        var firstList = headA
        while (firstList != null) {
            existingMap.put(firstList.hashCode(), firstList)
            firstList = firstList.next
        }
        var secondList = headB
        while (secondList != null) {
            if (existingMap.containsKey(secondList.hashCode())) {
                return existingMap.get(secondList.hashCode())
            }
            secondList = secondList.next
        }
        return null
    }

    //Without Extra Space O(1)

    fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {

        val existingMap = mutableMapOf<Int, ListNode>()

        var firstList = headA
        while (firstList != null) {
            existingMap.put(firstList.hashCode(), firstList)
            firstList = firstList.next
        }
        var secondList = headB
        while (secondList != null) {
            if (existingMap.containsKey(secondList.hashCode())) {
                return existingMap.get(secondList.hashCode())
            }
            secondList = secondList.next
        }
        return null
    }
}
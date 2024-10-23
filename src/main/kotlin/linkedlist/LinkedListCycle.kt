package linkedlist

class LinkedListCycle {

//
//    //1st Solution with the Hashset
//    fun hasCycle(head: ListNode?): Boolean {
//
//        //We create a hashset to store the visited nodes
//        val visitedNodes: HashSet<Int> = hashSetOf()
//
//        //We check if the head is null we return false
//        if (head == null) {
//            return false
//        }
//        var currentNode = head
//        //We iterate through the list
//        while (currentNode != null) {
//            //We check if the current node is in the hashset
//            if (visitedNodes.contains(currentNode.hashCode())) {
//                return true
//            }
//            //We add the current node to the hashset
//            visitedNodes.add(currentNode.hashCode())
//            currentNode = currentNode.next
//        }
//        //We return false
//        return false
//    }


    //2nd Solution with the two pointers Hare and Tortoise Algorithm
    fun hasCycle(head: ListNode?): Boolean {


        //We check if the head is null we return false
        if (head == null) {
            return false
        }
        var tortoise = head.next
        var hare = head.next?.next
        //We iterate through the list
        while (hare != null && tortoise != null) {
            //We check if the hare and tortoise are equal
            if (hare == tortoise) {
                return true
            }
            //We move the tortoise one step
            tortoise = tortoise.next
            //We move the hare two steps
            hare = hare.next?.next
        }
        //We return false
        return false
    }


    fun hasCycle2(head: ListNode?): Boolean {

        if (head == null) return false
        var runner = head.next?.next
        var walker = head.next

        while (runner != null) {
            if (walker == runner) return true
            walker = walker?.next
            runner = runner.next?.next

        }
        return false
    }
}
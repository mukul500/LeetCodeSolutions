package linkedlist

class MiddleOfTheLinkedList {

    fun middleNode(head: ListNode?): ListNode? {


        //We check if the head is null we return null
        if (head == null) {
            return null
        }

        //We make two pointers walker and runner
        var walker = head
        var runner = head

        //We iterate through the list when the runner reaches the end of the list the walker will be at the middle of the list
        while (runner?.next != null) {
            //we move the runner two steps
            runner = runner.next?.next
            //we move the walker one step
            walker = walker?.next
        }

        //We return the walker
        return walker
    }
}
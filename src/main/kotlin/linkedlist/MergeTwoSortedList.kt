package linkedlist

class MergeTwoSortedList {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {


        //We check if the list1 is null we return list2
        if (list1 == null) {
            return list2
        }

        //We check if the list2 is null we return list1
        if (list2 == null) {
            return list1
        }

        //We create two pointers for the two lists
        var firstListPointer = list1
        var secondListPointer = list2

        //We create a dummy node to store the sorted list
        val sortedList = ListNode(0)
        //We create a pointer to the sorted list
        var sortedListPointer = sortedList

        //We iterate through the lists
        while (firstListPointer != null && secondListPointer != null) {

            //We compare the values of the two pointers and add the smaller value to the sorted list
            if (firstListPointer.`val` > secondListPointer.`val`) {
                sortedListPointer.next = secondListPointer
                secondListPointer = secondListPointer.next
            } else {
                sortedListPointer.next = firstListPointer
                firstListPointer = firstListPointer.next
            }
            //We move the sorted list pointer to the next node
            sortedListPointer = sortedListPointer.next!!


            //We check if the first list pointer is null we add the second list pointer to the sorted list
            if (firstListPointer == null) {
                sortedListPointer.next = secondListPointer
            }
            //We check if the second list pointer is null we add the first list pointer to the sorted list
            if (secondListPointer == null) {
                sortedListPointer.next = firstListPointer
            }

        }
        //We return the sorted listl
        return sortedList.next
    }
}
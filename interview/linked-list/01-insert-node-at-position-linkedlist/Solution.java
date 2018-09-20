    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode trav = head;
        for(int i = 0; i < position - 1; i++) {
            trav = trav.next;
        }
        SinglyLinkedListNode temp = trav.next;
        trav.next = new SinglyLinkedListNode(data);
        trav.next.next = temp;
        return head;
    }

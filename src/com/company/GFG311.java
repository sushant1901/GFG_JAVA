class Solution {
    public static void rearrange(Node odd) {
        if (odd == null || odd.next == null || odd.next.next == null) {
            return;
        }

        // Extract alternative nodes starting from second node
        Node even = odd.next;
        Node evenStart = even;
        Node oddStart = odd;
        while (odd != null && even != null && odd.next != null) {
            odd.next = odd.next.next;
            if (even.next != null) {
                even.next = even.next.next;
            }
            odd = odd.next;
            even = even.next;
        }

        // Reverse the extracted list
        Node prev = null;
        Node current = evenStart;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        evenStart = prev;

        // Append the extracted list at the end of the original list
        odd = oddStart;
        while (odd.next != null) {
            odd = odd.next;
        }
        odd.next = evenStart;
    }
}

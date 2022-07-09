package com.company;

// https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
// Clone a linked list with next and random pointer
// You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. The second pointer however CAN point to any node in the list and not just the previous node. Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.
//
// In front of each node add a new node A -> A` -> B -> B` -> C -> C` -> D -> `D
// so that next node from each node is the newly added node which will become the cloned node
// now clone all the random connection from A to A`
// disconnect the new nodes
public class CopyLinkedListWithRandomPointers {
    public Node copyRandomList(Node head) {
        Node thead = head, clone_of_thead = null, real_next_of_thead = null, real_next_of_clone = null, random_of_thead = null, thead_of_cloned = null;;
        // this will add a new copy nodes in front of each
        while(thead != null){
            Node n = new Node(thead.val);
            n.next = thead.next;
            thead.next = n;
            thead = n.next;
        }

        // connect the randoms
        thead = head;
        while(thead != null){
            clone_of_thead = thead.next;
            random_of_thead = thead.random;
            if(random_of_thead != null){
                clone_of_thead.random = random_of_thead.next;
            }else{
                clone_of_thead.random = null;
            }
            thead = clone_of_thead.next;
        }

        // disconnect the new ones from old list
        thead = head;
        if(thead != null){
            thead_of_cloned = thead.next;
        }

        while(thead != null){
            // clone of the node will always exist
            clone_of_thead = thead.next;

            real_next_of_thead = clone_of_thead.next; // this could exist of could be null

            if(real_next_of_thead != null){
                real_next_of_clone =  real_next_of_thead.next;
            }else{
                real_next_of_clone = null;
            }

            thead.next = real_next_of_thead;
            clone_of_thead.next = real_next_of_clone;


            thead = thead.next;
        }

        return thead_of_cloned;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

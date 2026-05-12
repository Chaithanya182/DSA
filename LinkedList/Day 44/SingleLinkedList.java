/*
 * KEY NOTE: SINGLY LINKED LIST OPERATIONS
 *
 * A singly linked list is a linear data structure where each node points to the next node.
 * Each node contains data and a reference to the next node.
 *
 * Key Operations:
 * - Convert Array to Linked List: O(n)
 * - Traverse/Print: O(n)
 * - Find Length: O(n)
 * - Search Element: O(n)
 * - Insert at Head/Tail: O(1) / O(n)
 * - Insert at Position: O(n)
 * - Delete Head/Tail: O(1) / O(n)
 * - Delete at Position: O(n)
 *
 * Golden Rule: To insert/delete a node, usually stop at the previous node.
 *
 * Time Complexity: Most operations are O(n) due to traversal.
 * Space Complexity: O(n) for storing nodes.
 */

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(int data,Node next)
    {
        this.data = data;
        this.next = next;
    }

}

// // Linked List Fundamentals

// 1. Convert Array to Linked List
// 2. Traverse (Print) Linked List
// 3. Find Length of Linked List
// 4. Search an Element in Linked List

// // Insertion
// 5. Insert at Head
// 6. Insert at Tail
// 7. Insert at Position (Kth Position)
// 8. Insert Before a Value

// // Deletion
// 9. Delete Head
// 10. Delete Tail
// 11. Delete Kth Position
// 12. Delete by Value

// // Golden Rule
// // To insert/delete a node, usually stop at the previous node.

public class SingleLinkedList{

    public static Node convertArrayToLL(int[] arr)
    {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<n;i++)
        {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        return head;

    }


    public static void traversalOfLL(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int lengthOfLL(Node head)
    {
        Node temp = head;
        int length = 0;
        while (temp!=null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static boolean checkEleInLL(Node head , int ele)
    {
        Node temp = head;
        while (temp!=null)
        {
            if(temp.data == ele)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //insetions and deletetion top edge cases
    // 1.If head is null
    //  2.If it has a single element

    public static Node insertAtHead(Node head,int ele)
    {
        return new Node(ele,head);
        //no need any edge cases as it works even if it is empty or hace any elements
    }

    public static Node insertAtTail(Node head,int ele)
    {
        //goto tail and add element by conbecting the next of it new eleent
        //edge case if we have a null head ni insert at tail is nothing but returinh the head
        if(head == null)
        {
            return new Node(ele);
        }

        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        //on tail
        Node x = new Node(ele);
        temp.next = x;
        return head;
    }

    public static Node insertAtPosition(Node head,int ele,int pos)
    {
        //as we thouhgt go just beofore the element of the postiton
        //edge cases if head is null return null only if pos!= 1 and if 1 return new node

        if(pos <=0)
        {
            return head;
        }

        if(head == null)
        {
            if(pos==1)
            {
                return new Node(ele);
            }
            else{
                return null;
            }
        }

        //for pos=1
        if(pos==1)
        {
            return insertAtHead(head,ele);

        }

        //Go just before element of pos;
        Node temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if(temp == null)
        {
            return head;
        }

        Node x = new Node(ele);
        x.next = temp.next;
        temp.next = x;
        return head;



    }


    public static Node insertBeforeValue(Node head,int ele,int val)
    {
        if(head == null) return head;

        if(head.data == val)
        {
            return  insertAtHead(head,ele);
        }

        //just be before the val
        Node temp = head;
        while(temp.next != null && temp.next.data != val)
        {
            temp = temp.next;
        }

        //we are just before element of it, but check if found
        if(temp.next != null)
        {
            Node x = new Node(ele);
            x.next = temp.next;
            temp.next = x;
        }
        return head;


    }


    //Now see for deletion also
    //2 main edge cases ie if head is null and has single ele
    public static Node deleteHead(Node head)
    {
        if(head == null || head.next==null) return head;

        //for this also go just before eleemnt of it
        head = head.next;
        return head;
        //just point head to next element
    }

    public  static Node deleteTail(Node head)
    {
        if(head == null || head.next==null) return null;

        //go to tail before element

        Node temp = head;
        while(temp.next.next !=null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteAtPos(Node head,int pos)
    {
        //edge cases if pos<=0 and head is null or pos==1
        if(pos<=0)
        {
            return head;
        }
        if(head == null) return head;
        if(pos == 1) return head.next;

        Node temp = head;
        int count = 1;
        while(temp!=null && count < pos-1)
        {
            temp=temp.next;
            count++;
        }
        if(temp == null || temp.next == null) return head;

        temp.next = temp.next.next;
        return head;

    }


    public static Node deleteAtVal(Node head,int val)
    {
        //edge cases if head is null and val is at first pos
        if(head == null) return head;
        if(val == head.data) return head.next;

        Node temp = head;
        while(temp.next != null && temp.next.data != val)
        {
            temp=temp.next;
        }
        if(temp.next == null) return head;

        temp.next = temp.next.next;
        return head;
    }



    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node head = convertArrayToLL(arr);
        int n = lengthOfLL(head);
        boolean isElementExists = checkEleInLL(head,10);

        head = insertBeforeValue(head,10,10);


        traversalOfLL(head);


    }

}
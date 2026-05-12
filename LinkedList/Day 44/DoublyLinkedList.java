public class DllNode{
    int data;
    DllNode next;
    DllNode prev;

    public DllNode(int data,DllNode prev,DllNode next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DllNode(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}

//Node structure
//Convert array to DLL
//Traverse forward
//Length
// Search
//Insert at head
//Delete head
//Insert at tail
//Delete tail
//Insert at position
//Delete at position
//Insert before value
//Delete by value
//Reverse DLL


public class DoublyLinkedList {
    public static DllNode convertArrToDll(int[] arr)
    {
        if(arr.length == 0) return null;

        DllNode head = new DllNode(arr[0]);
        DllNode temp = head;
        for(int i=1;i<arr.length;i++)
        {
            DllNode x = new DllNode(arr[i]);
            temp.next = x;
            x.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void forwardTraversal(DllNode head)
    {
        if(head == null) return;

        DllNode temp = head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }
    public static void backwardTraversal(DllNode head)
    {
        if(head == null) return;
        //go to tail and come back
        DllNode temp = head;
        while (temp.next!=null)
        {
            temp = temp.next;
        }

        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }

        System.out.println();

    }

    public static DllNode insertAtHead(DllNode head,int ele)
    {
        //edge cases if empty
        if(head == null)
        {
            return new DllNode(ele);
        }
        DllNode x = new DllNode(ele);
        head.prev = x;
        x.next = head;
        head = x;
        return head;
    }

    public static DllNode insertAtTail(DllNode head,int ele)
    {
        //go to last elemet before it check for edge cases
        if(head == null) return new DllNode(ele);

        DllNode temp = head;
        while (temp.next!=null)
        {
            temp = temp.next;
        }

        //on last node
        DllNode x = new DllNode(ele);
        temp.next = x;
        x.prev = temp;
        return  head;

    }

    public static DllNode insertAtPosition(DllNode head,int ele,int pos)
    {

        if(pos <= 0) return head;
        if(head == null)
        {
            if(pos == 1)
            {
                return new DllNode(ele);
            }
            else{
                return null;
            }
        }

        if(pos == 1)
        {
            DllNode x = new DllNode(ele);
            x.next = head;
            head.prev = x;
            return x;
        }
        //go to the that element
        int count = 1;
        DllNode temp = head;
        while(temp!=null && count < pos)
        {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            return insertAtTail(head, ele);
        }

        DllNode x = new DllNode(ele);
        DllNode prev = temp.prev;
        x.prev = prev;
        x.next = temp;

        prev.next = x;
        temp.prev = x;

        return head;
    }

    public static DllNode insertAtVal(DllNode head,int ele,int val)
    {

        if(head == null)
        {
            return null;
        }

        if(head.data == val)
        {
            DllNode x = new DllNode(ele);
            x.next = head;
            head.prev = x;
            return x;
        }
        //go to the that element
        DllNode temp = head;
        while(temp!=null && temp.data != val)
        {
            temp = temp.next;
        }
        if(temp == null) return head;

        DllNode x = new DllNode(ele);
        DllNode prev = temp.prev;
        x.prev = prev;
        x.next = temp;

        prev.next = x;
        temp.prev = x;

        return head;
    }


    //Now deletion operations

    public static DllNode deleleAtHead(DllNode head)
    {
        if(head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }

    public static DllNode deleteAtTail(DllNode head)
    {
        if(head == null || head.next == null) return null;

        //go to that element
        DllNode temp = head;

        while (temp.next != null)
        {
            temp = temp.next;
        }

        DllNode prev = temp.prev;
        prev.next = null;
        temp.prev = null;

        return head;
    }

    public static DllNode deleteAtPos(DllNode head,int pos)
    {
        if(pos <=0) return head;
        if(head == null || (head.next == null && pos ==1)) return null;

        if (pos == 1) return deleleAtHead(head);

        DllNode temp = head;
        int count = 1;
        while (temp!=null && count < pos)
        {
            count++;
            temp = temp.next;
        }

        DllNode prev = temp.prev;
        DllNode front = temp.next;

        prev.next = front;

        if (front != null) {
            front.prev = prev;
        }

        temp.prev = null;
        temp.next = null;

        return head;
        
    }

    public static DllNode deleteAtVal(DllNode head,int val)
    {

        if(head == null || (head.next == null && head.data ==val)) return null;
        if (head.data == val) return deleleAtHead(head);

        DllNode temp = head;
        while (temp!=null && temp.data != val)
        {
            temp = temp.next;
        }

        DllNode prev = temp.prev;
        prev.next = temp.next;
        temp.prev = null;

        return head;


    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        DllNode head = convertArrToDll(arr);

        head = insertAtPosition(head,10,16);


        forwardTraversal(head);


    }
}
 {
    
}

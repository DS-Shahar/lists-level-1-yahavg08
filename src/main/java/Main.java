package lists;
import java.util.Scanner;

public class Main {
public static void main(String[]args) {	
int [] arr= {1,2,3,4};
System.out.println(ex1(arr));
Node<Integer> head= ex1(arr);
printList(head);
prinList2(head);
prinList3(head);
System.out.print(inputList());
zoogi(head);
System.out.print(ex5(head,4));
System.out.print(ex5B(head,4));
System.out.print(deleteNode(head, 3);
System.out.print(deleteNodeIndex(head, 3);
}

public static Node<Integer> ex1 (int []arr) {
	Node<Integer> head = new Node<>(arr[0]);
	Node<Integer> prev = head;
	for(int i=1; i<arr.length; i++) {
		Node<Integer>p=new Node <Integer>(arr[i]);
		prev.setNext(p);
		prev=p;	
	}
	return head;
	}
	
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.println(current.getValue()); 
            current = current.getNext(); 
        }
    }
  
    public static void prinList2(Node<Integer> head) {
    	if(head==null) {
    		return;
    	}
    	System.out.println(head.getValue()); 
    	prinList2(head.getNext());
   
}
    

    public static void prinList3(Node<Integer> head) {
    	if(head==null) {
    		return;
    	}
    	prinList3(head.getNext());
    	System.out.println(head.getValue()); 
   
}
    public static Node<Integer> inputList() {
    	 Scanner reader = new Scanner(System.in);
        Node<Integer> head = null; 
        Node<Integer> current = null; 
       System.out.println("Enter number:");
        int num = reader.nextInt();
        while (num != -1) {
            Node<Integer> newNode = new Node<>(num); 
            if (head == null) {
                head = newNode; 
            } else {
                current.setNext(newNode); 
            }
            current = newNode; 
            System.out.println("Enter number:");
            num = reader.nextInt();
        }
        return head; 
    }
    
    public static void zoogi(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
        	if(current.getValue()%2==0) {
        		 System.out.println(current.getValue());
        }
            current = current.getNext(); 
        }
    }
    
    public static boolean ex5(Node<Integer> head, int x) {
        Node<Integer> current = head;
        while (current != null) {
        	if(current.getValue()==x) {
        		 return true;
        }
            current = current.getNext(); 
        }
        return false;
    }
    
    public static boolean ex5B(Node<Integer> head, int x) {
        if (current == null) {
            return false; 
        }
        if (current.getValue() == x) {
            return true;
        }
        return ex5B(current.getNext(), x);
    }

  public  Node<Integer> deleteNode (Node <Integer> head, int x) {
  Node <Integer> p = new Node <Integer> (-1, head);
  head = p;
  while (p.hasNext()) {
	Node <Integer> t;
	if (p.getNext().getValue() == x) {
		t = p.getNext();
		p.setNext(p.getNext().getNext());
		t.setNext(null);
		return head.getNext();
	}
	p = p.getNext();
}
return head.getNext();
}

  public Node<Integer> deleteNodeIndex(Node<Integer> head, int index) {
    if (index < 0 || head == null) {
        return head;
    }
    if (index == 0) {
        return head.getNext();
    }
    Node<Integer> p = head;
    int currentIndex = 0;
    while (p.hasNext() && currentIndex < index - 1) {
        p = p.getNext();
        currentIndex++;
    }
    if (p.hasNext() && currentIndex == index - 1) {
        p.setNext(p.getNext().getNext());
    }
    return head;
}
}

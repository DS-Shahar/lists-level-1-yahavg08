import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        int[] arr = {1, 2, 5, 3};
        int[] arr2 = {1, 5,2,8,4};
        System.out.println("ex1: " + ex1(arr));
        Node<Integer> head = ex1(arr);
        Node<Integer> head2 = ex1(arr2);
        Node<Integer> head3 = null;
        System.out.println("printList:");
        printList(head);
        System.out.println("prinList2:");
        prinList2(head);
        System.out.println("prinList3:");
        prinList3(head);
        System.out.println("ex3: " + inputList());
        System.out.println("zoogi:");
        zoogi(head);
        System.out.println("ex5A: " + ex5(head, 2));
        System.out.println("ex5B: " + ex5B(head, 4));
        //System.out.println("ex6: " + deleteNode(head, 3));
        //System.out.println("ex7: " + deleteNodeIndex(head, 1));
        System.out.println("ex8: " + ex8(head, head2,head2));
        System.out.println("ex9:");
        ex9(head, head2,head2);
        System.out.println("ex10: " + ex10(head, head2, head3, head2 ));
    }

    public static Node<Integer> ex1(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node<Integer> p = new Node<>(arr[i]);
            prev.setNext(p);
            prev = p;
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
        if (head == null) {
            return;
        }
        System.out.println(head.getValue());
        prinList2(head.getNext());
    }

    public static void prinList3(Node<Integer> head) {
        if (head == null) {
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
        reader.close();
        return head;
    }

    public static void zoogi(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() % 2 == 0) {
                System.out.println(current.getValue());
            }
            current = current.getNext();
        }
    }

    public static boolean ex5(Node<Integer> head, int x) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == x) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static boolean ex5B(Node<Integer> head, int x) {
        if (head == null) {
            return false;
        }
        if (head.getValue() == x) {
            return true;
        }
        return ex5B(head.getNext(), x);
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int x) {
        if (head == null) {
            return null;
        }
        if (head.getValue() == x) {
            return head.getNext();
        }
        Node<Integer> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == x) {
                current.setNext(current.getNext().getNext());
                return head;
            }
            current = current.getNext();
        }
        return head;
    }

    public static Node<Integer> deleteNodeIndex(Node<Integer> head, int index) {
        if (index < 0 || head == null) {
            return head;
        }
        if (index == 0) {
            return head.getNext();
        }
        Node<Integer> current = head;
        int currentIndex = 0;
        while (current.getNext() != null && currentIndex < index - 1) {
            current = current.getNext();
            currentIndex++;
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public static boolean ex8(Node<Integer> head, Node<Integer> head2,Node<Integer> p2) {
    	        if ( head== null) {
    	            return true;
    	        }
    	        if ( head2== null) {
    	            return false;
    	        }
    	        if ( head.getValue() != head2.getValue()) {
    	        return ex8(head, head2.getNext(),p2);
    	    }
    	        return ex8(head.getNext(),p2, p2);
    }
    public static void ex9(Node<Integer> head, Node<Integer> head2,Node<Integer> p2) {
    	while(head != null && head2 != null) {
        if ( head.getValue() == head2.getValue()) {
        	System.out.println(head.getValue());
        	head= head.getNext();
        	head2=p2;
        }
        	head2=head2.getNext();
    	}
    }
    
    public static Node<Integer> ex10(Node<Integer> head, Node<Integer> head2, Node<Integer> head3, Node<Integer> p2) {
        Node<Integer> current = head3; 

        while (head != null) {
            head2 = p2; 
            while (head2 != null) {
                if (head.getValue().equals(head2.getValue())) {
                    current.setNext(new Node<>(head.getValue()));
                    current = current.getNext(); 
                }
                head2 = head2.getNext(); 
                }
            head = head.getNext(); 
        }

        return head3.getNext(); 
    }

}

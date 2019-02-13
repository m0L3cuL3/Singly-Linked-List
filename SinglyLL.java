/*

Name: Sean Myko C. Baang
Section: CC13 CCB
Date submitted: 12/1/2018

Description: Singly Linked List.

*/

import java.util.Scanner;

/* Node class */
class Node 
{
	public int info;
	public Node next;
	
	/* Given ADT Node */
	public Node()
	{
		next = null;
		info = 0;
	}
	
	/* Given ADT Node */
	public Node(int i, Node n)
	{
		info = i;
		next = n;
	}
	
	/* Sets pointer to the next Node */
	public void setNext(Node n)
	{
		next = n;
	}
	
	/* Sets pointer info to the current Node */
	public void setInfo(int i)
	{
		info = i;
	}
	
	/* Grabs the next pointer to next Node */
	public Node getNext()
	{
		return next;
	}
	
	/* Grabs the pointer info from the current Node */
	public int getInfo()
	{
		return info;
	}
}

/* Linked List Class */
class SLL
{
	public Node start; 	// starting node
	public Node end; 	// ending node
	public int size; 	// size of the node
	
	/* SLL Constructor */
	public SLL()
	{
		start = null;
		end = null;
		size = 0;
	}
	
	/* isEmpty() Function (checks if empty) */
	public boolean isEmpty()
	{
		return start == null; // returns to null if true.
	}
	
	/* addToHead(int) Function (adds element at the starting node) */
	public void addToHead(int i)
	{
		Node add = new Node(i, null);
		size++;
		
		// checks if the list is empty, then adds element to head/start.
		if(start == null)
		{
			start = add;
			end = start;
		}
		else // if the list has more values inside.
		{
			add.setNext(start);
			start = add;
		}
	}
	
	/* addToTail(int) Function (adds element at the ending/final node) */
	public void addToTail(int i)
	{
		Node add = new Node(i, null);
		
		// checks if the list is empty then adds value to tail.
		if(start == null)
		{
			start = add;
		}
		
		// checks if the last value is null then adds value to tail.
		if(end == null)
		{
			end = add;
			return;
		}
		
		// if there are more values in SLL.
		end.next = add;
		end = add;
	}
	/* deleteFromHead() Function */
	public void deleteFromHead()
	{
		// checks if the list is empty.
		if(start == null)
		{
			return;
		}
		else
		{
			// checks if the starting node and ending node are the same which results in empty list
			if(start == end)
			{
				start = null;
				end = null;
			}
			else
			{
				// starting node is being replaced by the next neighboring node (to the right).
				start = start.getNext();
			}
		}
	}
	
	/* deleteFromTail() Function */
	public void deleteFromTail()
	{
		// checks if the list is empty.
		if(end == null)
		{
			return;
		}
		else
		{
			// checks if the starting node and ending node are the same which results in empty list
			if(start == end)
			{
				start = null;
				end = null;
			}
			else
			{
				Node getPrevTail = start; 					// previous tail reference.
				while(getPrevTail.next != end) 				// loops until the next value is equal to the ending value.
				{
					getPrevTail = getPrevTail.getNext(); 
				}
				end = getPrevTail;
				end.next = null;
			}
		
		}
	}
	
	/* deleteValue() Function ( reference to Node() ) */
	public Node deleteValue(int val)
	{
		/*
			POINTERS:
			
			prevNode.next should point to the currNode.next
			continue until current is not null.
			
		*/
		
		Node prevNode = start;
		Node currNode = start;
		
		// if list is empty.
		if(start == null)
		{
			return null;
		}
		
		/* checks if starting element is equal to the given value */
		while(start.getInfo() == val)
		{
			
			if(start.getNext() == null)
			{
				return null;
			}
			
			start = start.getNext();
			currNode = start;
			prevNode = start;
		}
		
		// iterates through the current node then obtains the data/element inside of 'that' node.
		while(currNode != null)
		{
			
			/* if the value is on the currNode */
			if(currNode.getInfo() == val)
			{
				prevNode.next = currNode.next;
				currNode = currNode.next;
			}
			else
			{
				/* if the value is not on the currNode */
				prevNode = currNode;
				currNode = currNode.next;
			}	
			
		}
		return start;
		
	}
	
	/* printAll() Function */
	public void printAll()
	{
		System.out.print("\nSingly Linked List: ");
		if(size == 0)
		{
			System.out.print("List is empty!\n");
			return;
		}
		if(start.getNext() == null)
		{
			System.out.println(start.getInfo());
			return;
		}
		
		Node pointer = start;
		System.out.print(start.getInfo() + " ");
		pointer = start.getNext();
		
		while(pointer.getNext() != null)
		{
			System.out.print(pointer.getInfo() + " ");
			pointer = pointer.getNext();
		}
		System.out.print(pointer.getInfo() + "\n");
		
	}	
	
	/* isInList() Function */
	public boolean isInList(int val)
	{
		
		Node checkValue = start;
		
		/* loops when checkValue is not equal to null */
		while(checkValue != null)
		{
			/* grabs and checks data/element to value given by the user*/
			if(checkValue.getInfo() == val)
			{
				System.out.println(checkValue.getInfo() + " is IN the list!");
			}
			checkValue = checkValue.getNext();
		}
		return false;
	}
}

/* MAIN MENU (MAIN FUNCTION) */
public class SinglyLL
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		/* SLL Object */
		SLL list = new SLL();
		
		System.out.println("\n Singly Linked List (FINAL)\n");
		char a;
		
		/* menu operations */
		do
		{
			System.out.println(" |====== Main Menu ======|");
			System.out.println(" |                       |");
			System.out.println(" | [0] Exit              |");
			System.out.println(" | [1] Add to Head       |");
			System.out.println(" | [2] Add to Tail       |");
			System.out.println(" | [3] Delete from Head  |");
			System.out.println(" | [4] Delete from Tail  |");
			System.out.println(" | [5] Delete a value    |");
			System.out.println(" | [6] Is in List        |");
			System.out.println(" | [7] Print All         |");
			System.out.println(" |                       |");
			System.out.println(" |=======================|\n");
			System.out.print(" [User]: ");
			int option = in.nextInt();
			switch(option)
			{
				case 0: 															// Exit
					System.exit(0);
					break;
				case 1: 															// Add to Head
					System.out.print("Enter element to Head: ");
					list.addToHead(in.nextInt());
					break;
				case 2: 															// Add to Tail
					System.out.print("Enter element to Tail: ");
					list.addToTail(in.nextInt());
					break;
				case 3: 															// Delete from Head
					System.out.print("Delete element Head");
					list.deleteFromHead();
					System.out.print(" [DELETED]\n");
					break;
				case 4: 															// Delete from Tail
					System.out.print("Delete element Tail");
					list.deleteFromTail();
					System.out.print(" [DELETED]\n");
					break;
				case 5: 															// Delete a value
					System.out.print("\nEnter value to be deleted: ");
					int valueDelete = in.nextInt();
					list.deleteValue(valueDelete); 
					break;
				case 6: 															// Is in List
					System.out.print("\nIs in List: ");
					list.isInList(in.nextInt());
					break;
				case 7: 															// Print All
					System.out.print("\nAll value in Singly Linked List: ");
					list.printAll();
					break;
				default: 															// Invalid Option.
					System.out.println("Invalid option, please try again!\n");
					break;
			}
			System.out.print("\nDo you want to continue? (y / n): "); 
			a = in.next().charAt(0);
		}
		while(a == 'Y' || a == 'y');
	}
}


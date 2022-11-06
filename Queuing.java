import java.util.Arrays;


interface IQueuable {
  //adds value to queue and returns new queue
  String[] enqueue(String value);
  
  //removes item from queue, and returns the item removed
  String dequeue();
  
  //returns a list of all the items in the queue
  String[] getQueue();
  
  //returns the number of items in the queue
  int size();
}

class Node {
  String data;
  Node next;
}

class QUEUE implements IQueuable {
  private int queueSize;
  private Node front, rear;

  public QUEUE() {
    queueSize = 0;
    front = null;
    rear = null;
  }
  
  @Override
  public String[] enqueue(String value) {
    Node oldRear = rear;
    rear = new Node();
    rear.data = value;
    rear.next = null;
    if (size() == 0) {
      front = rear;
    } else {
      oldRear.next = rear;
    }
    queueSize++;
    return getQueue();
  }

  @Override
  public String dequeue() {
    if (size() == 0) {
      return null;
    }
    String removed = front.data;
    front = front.next;
    queueSize--;
    if (size() == 0) {
      rear = null;
    }
    return removed;
  }

  @Override
  public String[] getQueue() {
    String[] arrayQueue = new String[size()];
    Node item = front;
    int i;
    for (i = 0; i < size(); i++) {
      arrayQueue[i] = item.data;
      item = item.next;
    }
    return arrayQueue;
  }

  @Override
  public int size() {
    return queueSize;
  }
}

class STACK implements IQueuable {
  private int stackSize;
  private Node top;

  public STACK() {
    stackSize = 0;
    top = null;
  }
  
  @Override
  public String[] enqueue(String value) {
    Node oldTop = top;
    top = new Node();
    top.data = value;
    top.next = oldTop;
    stackSize++;
    return getQueue();
  }

  @Override
  public String dequeue() {
    if (size() == 0) {
      return null;
    }
    String removed = top.data;
    top = top.next;
    stackSize--;
    return removed;
  }

  @Override
  public String[] getQueue() {
    String[] arrayQueue = new String[size()];
    Node item = top;
    int i;
    for (i = 0; i < size(); i++) {
      arrayQueue[i] = item.data;
      item = item.next;
    }
    return arrayQueue;
  }

  @Override
  public int size() {
    return stackSize;
  }
}

class Queuing {
  public static void main(String[] args) {
    System.out.println("FIFOQUEUE / QUEUE");
    QUEUE queue = new QUEUE();
    
    queue.enqueue("a");
    queue.enqueue("b");
    System.out.println(Arrays.toString(queue.getQueue()));
    queue.dequeue();
    System.out.println(Arrays.toString(queue.getQueue()));
    queue.enqueue("c");
    System.out.println(Arrays.toString(queue.getQueue()));
    queue.dequeue();
    System.out.println(Arrays.toString(queue.getQueue()));
    queue.dequeue();
    System.out.println(Arrays.toString(queue.getQueue()));
    queue.dequeue();
    System.out.println(Arrays.toString(queue.getQueue()));

    System.out.println("");
    System.out.println("LIFOQUEUE / STACK");
    STACK stack = new STACK();

    stack.enqueue("a");
    stack.enqueue("b");
    System.out.println(Arrays.toString(stack.getQueue()));
    stack.dequeue();
    System.out.println(Arrays.toString(stack.getQueue()));
    stack.enqueue("c");
    System.out.println(Arrays.toString(stack.getQueue()));
    stack.dequeue();
    System.out.println(Arrays.toString(stack.getQueue()));
    stack.dequeue();
    System.out.println(Arrays.toString(stack.getQueue()));
    stack.dequeue();
    System.out.println(Arrays.toString(stack.getQueue()));
  }
}
package ocean;

/**
 *  A DListNode is a node in a DList (doubly-linked list).
 */

public class DListNode<TypeAndSize> {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   */

  public TypeAndSize item;
  public DListNode<TypeAndSize> prev;
  public DListNode<TypeAndSize> next;
  public DList<TypeAndSize> lst;

  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   */
  DListNode(TypeAndSize i, DListNode<TypeAndSize> p, DListNode<TypeAndSize> n) {
    this(i, p, n, null);
  }

  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   *  @param l the list node belongs to.
   */
  DListNode(TypeAndSize i, DListNode<TypeAndSize> p, DListNode<TypeAndSize> n, DList<TypeAndSize> l) {
    item = i;
    prev = p;
    next = n;
    lst = l;
  }
}

  


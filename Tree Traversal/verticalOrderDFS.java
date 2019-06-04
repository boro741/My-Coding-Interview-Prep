import java.util.*;

class TreeNode {
  char val;
  TreeNode left;
  TreeNode right;

  TreeNode(char x) {
    val = x;
  }
};

class verticalOrderDFS {
  public static TreeMap<Integer,List<Character>> traverse(TreeNode root) {
    if(root == null)
        return null;

    TreeMap<Integer,List<Character>> hm = new TreeMap<>();
    int hd = 0;
    hm.put(0, new ArrayList<>());
    
    verticalOrder(hm,root,hd);
    
    return hm;
  }

  static void verticalOrder(TreeMap<Integer,List<Character>> hm, TreeNode node,int hd){
    if(node == null)
        return;
    
    if(!hm.containsKey(hd)){
        hm.put(hd, new ArrayList<>());
    }
    hm.get(hd).add(node.val);

    verticalOrder(hm, node.left,hd-1);
    verticalOrder(hm, node.right,hd+1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode('a');
    root.left = new TreeNode('b');
    root.right = new TreeNode('c');
    
    root.left.left = new TreeNode('d');
    root.left.right = new TreeNode('e');
    root.right.left = new TreeNode('f');
    root.right.right = new TreeNode('g');

    root.left.right.left = new TreeNode('j');
    root.left.right.right = new TreeNode('k');

    root.left.left.left = new TreeNode('h');
    root.left.left.right = new TreeNode('i');
    root.right.right.left = new TreeNode('l');
    root.right.right.right = new TreeNode('m');

    TreeMap<Integer,List<Character>> result = traverse(root);
    System.out.println("Vertical order traversal: " + result);
  }
}


/*
LEVLE ORDER TRAVERSAL  Algorithm:
============================

void LevelOrder(Node *root){
    Node *temp;
    Queue *Q = createQueue();

    if(!root)
        return;
    
    EnQueue( Q, root );

    while(!isEmptyQueue(Q)){
        temp = DeQueue(Q);

        1. Print( temp->data );
        2. if( temp->left )
                EnQueue( Q , temp->left );
        3. if( temp->right )
                EnQueue( Q , temp->right );
    }
} */
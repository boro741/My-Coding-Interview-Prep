import java.util.*;

class TreeNode {
  char val;
  int hd;
  TreeNode left;
  TreeNode right;

  TreeNode(char x) {
    val = x;
  }
};

class TopBottomView {
  public static TreeMap<Integer,List<Character>> traverse(TreeNode root) {
    if(root == null)
        return null;

    Queue<TreeNode> queue = new LinkedList<>();
    TreeMap<Integer,List<Character>> hm = new TreeMap<>();
    int hd = 0;

    queue.offer(root);
    hm.put(0, new ArrayList<>());
    

    while(!queue.isEmpty()){
        TreeNode currentNode = queue.poll();
        hd = currentNode.hd;
        hm.get(currentNode.hd).add(currentNode.val);

        if(currentNode.left != null){
            queue.offer(currentNode.left);
            currentNode.left.hd = hd - 1;
            if(!hm.containsKey(hd-1))
                hm.put(hd-1, new ArrayList<>());
        }

        if(currentNode.right != null){
            queue.offer(currentNode.right);
            currentNode.right.hd = hd + 1;
            if(!hm.containsKey(hd+1))
                hm.put(hd+1, new ArrayList<>());
        }
    }

    return hm;
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
    System.out.println("Top View: ");
    result.forEach((K,V)->{
        System.out.println(K+" "+V.get(0));
    });

    System.out.println("Bottom View: ");
    result.forEach((K,V)->{
        System.out.println(K+" "+V.get(V.size() - 1));
    });
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
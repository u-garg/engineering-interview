### is BST?

Given a binary tree, check if it is a binary search tree (BST). A valid BST does not have to be complete or balanced.

Consider this definition of a BST:

All nodes values of left subtree are less than or equal to parent node value.
All nodes values of right subtree are greater than or equal to parent node value.
Both left subtree and right subtree must be BSTs.
NULL tree is a BST.
Single node trees (including leaf nodes of any tree) are BSTs.

Solution: Perform in-order traversal... it should produce sorted array if BST. check for prev value in the order and it should be always less for BST.

```java
 static Boolean is_bst(BinaryTreeNode root) {
        
        return helper(root, new int[]{Integer.MIN_VALUE});
    }
    
    static Boolean helper(BinaryTreeNode node, int[] prev){
        if (node == null) return true;
        
        if (!helper(node.left, prev)) return false;
        if (prev[0] > node.value) return false;
        prev[0] = node.value;
        
        return helper(node.right, prev);
        
    }

```

### Print All Paths Of A Tree

Given a binary tree, return all paths from root to leaf.


```java
    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       helper(root, new ArrayList<Integer>(), result);
       
        return result;
    }
    
    static void helper(BinaryTreeNode node,ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result){
        if (node == null) return;
        if (node.left==null && node.right == null){
            slate.add(node.value);
            result.add(new ArrayList<>(slate));
            slate.remove(slate.size()-1);
        }
        
        slate.add(node.value);
        helper(node.left, slate, result);
        helper(node.right, slate, result);
        
        slate.remove(slate.size()-1);

    }
```

### Single Value Tree

Given a binary tree, find the number of unival subtrees. An unival (single value) tree is a tree that has the same value in every node.

```java
static Integer find_single_value_trees(BinaryTreeNode root) {
        int[] count = new int[]{0};
        isUnivalTree(root, count);
        return count[0];
    }

    static boolean isUnivalTree(BinaryTreeNode node, int[] count){
        if (node == null) return true;
        if (node.left == null && node.right == null){
            count[0]++;
            return true;
        }
        
        boolean leftUnival = isUnivalTree(node.left, count);
        boolean rightUnival = isUnivalTree(node.right, count);
        
        if (leftUnival && rightUnival && 
        (node.left == null || node.value == node.left.value) && 
        (node.right == null || node.value == node.right.value)){
            count[0]++;
            return true;
        }
        return false;
        
    }
```

### upside tree
Given a binary tree where every node has either 0 or 2 children and every right node is a leaf node, flip it upside down turning it into a binary tree where all left nodes are leafs.

```java
    static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        
        BinaryTreeNode newRoot =  flip_upside_down(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
        
    }

    ```


    ### 
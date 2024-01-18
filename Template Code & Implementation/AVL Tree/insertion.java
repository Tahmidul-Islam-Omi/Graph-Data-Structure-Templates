// problem link gfg - https://www.geeksforgeeks.org/problems/avl-tree-insertion/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution
{
    public  Node insertToAVL(Node node, int data)
    {
        //code here
        if(node == null) {
            node = new Node(data);
            return node;
        }

        if(data < node.data) {
            node.left = insertToAVL(node.left, data);     
        }

        if(data > node.data) {
            node.right = insertToAVL(node.right, data);
        }

        node.height = Math.max( getHeight(node.left), getHeight(node.right)) + 1;

        //return inorder(rotate(node));
        return rotate(node);
    }

    private Node rotate(Node node) {

        if( getHeight(node.left) - getHeight(node.right) > 1) {
            // left heavy
            if( getHeight(node.left.left) - getHeight(node.left.right) > 0 ) {
                // left - left case
                return rightRotate(node);
            }
 
            if( getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // left - right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if( getHeight(node.left) - getHeight(node.right) < -1) {
            // right heavy

            if(  getHeight(node.right.right) - getHeight(node.right.left) > 0) {
                // right - right case
                return leftRotate(node);
            }

            if( getHeight(node.right.right) - getHeight(node.right.left) < 0) {
                // right - left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max( getHeight(p.left), getHeight(p.right) ) + 1;
        c.height = Math.max( getHeight(c.left) , getHeight(c.right)) + 1;

        return c;

    }

    private Node rightRotate(Node p) {

        Node c= p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max( getHeight(p.left) , getHeight(p.right) ) + 1;
        c.height = Math.max( getHeight(c.left) , getHeight(c.right) ) + 1;

        return c;
    }
    
    private int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        
        return node.height;
        
    }
    
} 
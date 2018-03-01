package houseware.learn.j8.concurrency.threadpool;


import java.util.HashSet;
import java.util.Set;

public class TreeNode {

    private int value;

    private Set<TreeNode> children;

    TreeNode(int value, TreeNode... children) {
        this.value = value;
        this.children = new HashSet<>();
        if(children!=null){
            for (TreeNode child : children) {
                this.children.addAll(child.getChildren());
            }
        }
    }

    public int getValue() {
        return value;
    }

    public Set<TreeNode> getChildren() {
        return children;
    }
}
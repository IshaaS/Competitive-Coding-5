// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//I have solved it using bfs and dfs.
//bfs:
//1. pop until i=size of queue starting from 0(simbolises nodes in a level)
//2. do this until queue is not empty, and at each level add the largest element

//dfs:
//1. maintain level parameter.
//2. traverse through every node by using dfs and add maximum val to the result by comparing with result.get(level-1) everytime.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//bfs
// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q= new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             int max=Integer.MIN_VALUE;
//             for(int i=0; i<size;i++){
//                 TreeNode current = q.poll();
//                 max=Math.max(current.val,max);
//                 if(current.left!=null) q.add(current.left);
//                 if(current.right!=null) q.add(current.right);
//             }
//             result.add(max);
//         }
//         return result;
//     }
// }
//dfs
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root,1);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root==null) return;
        if(result.size()<level) result.add(root.val);
        else result.set(level-1, Math.max(result.get(level-1), root.val));
        helper(root.left,level+1);
        helper(root.right, level+1);
        return;
    }
}
package com.anktech.pwjproject.node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeService {
    private StringBuilder sb;
    public String serializeDFS(TreeNode root) {
        if (root == null) return null;
        sb = new StringBuilder();
        serializeNode(root);
        return sb.toString();
    }

    private void serializeNode(TreeNode node) {
        if (node == null) {
            sb.append("-;");
        } else {
            sb.append(node.value).append(";");
            serializeNode(node.left);
            serializeNode(node.right);
        }
    }

    public String serializeBFS( TreeNode root) {
        if (root == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                stringBuilder.append("-;");
            } else {
                stringBuilder.append(node.value).append(";");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return  stringBuilder.toString();
    }
}

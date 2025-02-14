package com.anktech.pwjproject.node;

public class TreeNodeService {
    private StringBuilder sb;
    public String serialize(TreeNode root) {
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
}

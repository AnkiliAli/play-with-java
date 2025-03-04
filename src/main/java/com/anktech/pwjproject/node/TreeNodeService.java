package com.anktech.pwjproject.node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.List;

public class TreeNodeService {
    private StringBuilder sb;

    public String serializeDFS(TreeNode root) {
        if (root == null)
            return null;
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

    public String serializeBFS(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append("-;");
            } else {
                stringBuilder.append(node.value).append(";");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return stringBuilder.toString();
    }

    public TreeNode deserializeNodeFromString(String nodeStringValues) {
        List<Integer> nodeValues = Arrays.stream(nodeStringValues.split(";"))
                .map(v -> {
                    if (v.equals("-")) {
                        return null;
                    } else {
                        return Integer.parseInt(v);
                    }
                }).collect(Collectors.toList());
        TreeNode root = new TreeNode(nodeValues.get(0), null, null);
        int i = 1;
        createNodes(root, nodeValues, i);
        return root;
    }

    private void createNodes(TreeNode rootNode, List<Integer> nodeValues, int i) {
        if (rootNode.getValue() != null) {
            Integer rightValue, leftValue;
            if (nodeValues.get(i) != null) {
                leftValue = nodeValues.get(i);
                rootNode.left = new TreeNode(leftValue, null, null);
                createNodes(rootNode.left, nodeValues, ++i);
            }
            if (nodeValues.get(i) != null) {
                rightValue = nodeValues.get(i);
                rootNode.right = new TreeNode(rightValue, null, null);
                createNodes(rootNode.right, nodeValues, ++i);
            }
        }
    }

}

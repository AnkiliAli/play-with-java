package com.anktech.pwjproject.node;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeServiceTest {
        TreeNode root;
        TreeNodeService treeNodeService;

        @BeforeEach
        void setRoot() {
                root = new TreeNode(1,
                                new TreeNode(2, null, null),
                                new TreeNode(3, null, null));
                root.getLeft().setLeft(
                                new TreeNode(4, null, null));
                root.getLeft().setRight(
                                new TreeNode(5,
                                                new TreeNode(0,
                                                                new TreeNode(6, null, null), null),
                                                new TreeNode(4, null, null)));
                root.getRight().setLeft(new TreeNode(9, null, null));
                root.getRight().setRight(
                                new TreeNode(18,
                                                new TreeNode(5,
                                                                new TreeNode(9, null, null),
                                                                new TreeNode(7, null, null)),
                                                new TreeNode(17, null, null)));
                treeNodeService = new TreeNodeService();
        }

        @Test
        void shouldTestSerializeBFSNode() {
                String expected = "1;2;3;4;5;9;18;-;-;0;4;-;-;5;17;6;-;-;-;9;7;-;-;-;-;-;-;-;-;";
                // Do
                String result = treeNodeService.serializeBFS(root);
                Assertions.assertEquals(expected, result, "wrong serialization");
        }

        @Test
        void shouldTestSerializeDFSNode() {
                String expected = "1;2;4;-;-;5;0;6;-;-;-;4;-;-;3;9;-;-;18;5;9;-;-;7;-;-;17;-;-;";
                // Do
                String result = treeNodeService.serializeDFS(root);
                Assertions.assertEquals(expected, result, "wrong serialization");
        }
}
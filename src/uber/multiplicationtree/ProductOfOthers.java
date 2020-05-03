package uber.multiplicationtree;

import java.util.*;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class ProductOfOthers {

    public static int[] getProductOfOthers(int[] array) {
        if(array == null) return null;

        List<MultiplicationTreeNode> nodeList = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
            nodeList.add(new MultiplicationTreeNode(Collections.singletonList(i), array[i], null, null));
        }

        //Fill up the multiplication (binary) tree
        while(nodeList.size() > 1) {
            List<MultiplicationTreeNode> newNodeList = new LinkedList<>();
            for(int i = 0; i < nodeList.size(); i+=2) {
                if(i+1 == nodeList.size()) newNodeList.add(nodeList.get(i));
                else {
                    MultiplicationTreeNode leftChild = nodeList.get(i);
                    MultiplicationTreeNode rightChild = nodeList.get(i+1);
                    List<Integer> productOfIndexes = new LinkedList<>(leftChild.productOfIndexes);
                    productOfIndexes.addAll(rightChild.productOfIndexes);
                    newNodeList.add(new MultiplicationTreeNode(
                            productOfIndexes, leftChild.value * rightChild.value, leftChild, rightChild));
                }
            }
            nodeList = newNodeList;
        }

        //Fill up the return array. (Here nodeList.get(0) is the root)
        int[] productOfOthers = new int[array.length];
        for(int i = 0; i < productOfOthers.length; i++) {
            int product = 1;
            MultiplicationTreeNode actualNode = nodeList.get(0);
            while(actualNode.leftChild != null) {
                if(actualNode.leftChild.productOfIndexes.contains(i)) {
                    product *= actualNode.rightChild.value;
                    actualNode = actualNode.leftChild;
                } else {
                    product *= actualNode.leftChild.value;
                    actualNode = actualNode.rightChild;
                }
            }
            productOfOthers[i] = product;
        }

        return productOfOthers;
    }

    static class MultiplicationTreeNode {
        final List<Integer> productOfIndexes;
        final Integer value;
        final MultiplicationTreeNode leftChild;
        final MultiplicationTreeNode rightChild;

        public MultiplicationTreeNode(List<Integer> productOfIndexes, Integer value, MultiplicationTreeNode leftChild,
                                      MultiplicationTreeNode rightChild) {
            this.productOfIndexes = productOfIndexes;
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

}

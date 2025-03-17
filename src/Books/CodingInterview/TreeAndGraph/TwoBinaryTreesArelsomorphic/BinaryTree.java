package src.Books.CodingInterview.TreeAndGraph.TwoBinaryTreesArelsomorphic;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class BinaryTree {
    /*
        동형의 정의
        1. 자식을 여러번 교환해서 같은 형태가 될수 있으면 동형
        2. 정보손실 없이 같은 형태 만들수 있으면 동형
        3. 구조가 같으면 동형(AAB -> XXY)

        element 가 null일 경우 동형으로 간주
        하위트리가 있다면 왼쪽/왼쪽, 오른쪽/오른쪽, 왼쪽/오른쪽, 오른쪽/왼쪽 비교해야함
     */

    private Node rootOne = null;
    private Node rootTwo = null;

    private boolean isIsomorphic(Node treeOne, Node treeTwo) {
        if (treeOne == null && treeTwo == null) {
            return true;
        }

        if ((treeOne == null) || (treeTwo == null)) {
            return false;
        }

        return (
                // 왼&오, 오&왼 같거나 왼&왼, 오&오 같으면
                isIsomorphic(treeOne.left, treeTwo.right) && isIsomorphic(treeOne.right, treeTwo.left) ||
                isIsomorphic(treeOne.left, treeTwo.left) && isIsomorphic(treeOne.right, treeTwo.right)
        );
    }

    public Node getRootOne() {
        return rootOne;
    }

    public void setRootOne(Node rootOne) {
        this.rootOne = rootOne;
    }

    public Node getRootTwo() {
        return rootTwo;
    }

    public void setRootTwo(Node rootTwo) {
        this.rootTwo = rootTwo;
    }
}

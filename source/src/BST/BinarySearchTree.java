package BST;

public class BinarySearchTree implements IndexInterface<TreeNode> {

    // 노드를 만들고 생성자로 null 값 할당
    private TreeNode root;
    public BinarySearchTree() {
        root = null;
    }

    // 데이터 찾기(파라미터로 들어온 값)
    @Override
    public TreeNode search(Comparable searchValue) {
        return searchItem(root, searchValue);
    }

    private TreeNode searchItem(TreeNode root, Comparable searchValue) {

        if (root == null) {
            return null;
        }
        else if (searchValue.compareTo(root.key) == 0) {
            System.out.println(searchValue + " 의 값을 찾았습니다. " );
            return root;
        } else if (searchValue.compareTo(root.key) < 0) {
            return searchItem(root.left, searchValue);
        } else {
            return searchItem(root.right, searchValue);
        }
    }

    // 데이터 삽입하기
    @Override
    public void insert(Comparable newValue) {
        root = insertItem(root, newValue);
    }
    // root 노드부터 시작해서 들어온 파라미터로 값을 비교하여 null값이 나오면 새로운 노드 생성
    private TreeNode insertItem(TreeNode root, Comparable newValue) {
        if (root == null) {
            root = new TreeNode(newValue);
        }
        else if (newValue.compareTo(root.key) < 0) {
            root.left = insertItem(root.left, newValue);
        }
        else {
            root.right = insertItem(root.right, newValue);
        }
        return root;
    }

    // 데이터 삭제
    @Override
    public void delete(Comparable searchValue) {
        root = deleteItem(root, searchValue);
    }
    // root 노드부터 해당 데이터를 찾아가면서 삭제할 데이터 탐색
    private TreeNode deleteItem(TreeNode root, Comparable searchValue) {
        // 아직 객체 생성이 안된 경우
        if (root == null) {
            return null;
        // 트리가 있음
        } else {

            if (searchValue.compareTo(root.key) == 0) {
                root = deleteNode(root);
            }
            else if (searchValue.compareTo(root.key) < 0) {
                root.left = deleteItem(root.left, searchValue);
            }
            else {
                root.right = deleteItem(root.right, searchValue);
            }
            return root;
        }
    }
    // 데이터를 찾은 경우 삭제 경우의 수에 따른 로직
    private TreeNode deleteNode(TreeNode root) {
        // 3가지 경우가 있다. (파라미터 노드는 제거해야 하는 노드)
        // 1. 파라미터 노드가 리프 노드
        // 2. 파라미터 노드의 자식이 하나만 있음
        // 3. 파라미터 노드의 자식이 두 개가 있음
        if((root.left == null) && (root.right == null)) {
            return null;
        }
        else if(root.left == null) {
            return root.right;
        }
        else if(root.right == null) {
            return root.left;
        }
        // 제거해야 하는 노드의 자식이 양쪽에 다 있는 경우
        else {

            returnPair rPair = deletedMinItem(root.right);
            root.key = rPair.key;
            root.right = rPair.node;
            return root;
        }
    }

    private returnPair deletedMinItem(TreeNode rightNode) {
        // 더 작은 값이 더 이상 없음
        if(rightNode.left == null) {
            return new returnPair(rightNode.key, rightNode);
        }
        else {
            // 왼쪽 노드(더 작은 값)에 값이 계속 있는 경우
            returnPair rPair = deletedMinItem(rightNode.left);
            rightNode.left = rPair.node;
            rPair.node = rightNode;
            return rPair;
        }
    }

    // 노드의 값을 복사하기 위한 클래스
    private class returnPair {
        private Comparable key;
        private TreeNode node;
        private returnPair(Comparable key, TreeNode node) {
            this.key = key;
            this.node = node;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }
}

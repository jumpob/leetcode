public class HeapSort_1 {

  public int[] heapSort(int[] nums) {
    int n = nums.length;

    // リーフノードの検査は無駄なので、子がある最後の親ノードからスタートする
    for (int i = (n / 2 - 1); i >= 0; i--) {
      heapify(nums, n, i);
    }

    // swapして位置を切り替えるため、j=0の場合は見なくてOK
    // j=1で(必要なら)入れ替えが発生する
    for (int j = n - 1; j >= 0; j--) {
      swap(nums, j, 0);

      heapify(nums, n, 0);
    }

    return nums;
  }

  private void heapify(int[] nums, int length, int parent) {
    int largest = parent;
    int leftChild = parent * 2 + 1;
    int rightChild = parent * 2 + 2;

    if (leftChild < length && nums[leftChild] > nums[largest]) {
      largest = leftChild;
    }
    // 親 < 左子 < 右子のケースがあるので、else ifにしない
    if (rightChild < length && nums[rightChild] > nums[largest]) {
      largest = rightChild;
    }

    if (largest != parent) {
      swap(nums, largest, parent);

      // 入れ替えた先の子で再検査
      heapify(nums, length, largest);
    }

  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}

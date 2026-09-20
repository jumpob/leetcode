public class HeapSort_2 {
  public void heapSort(int[] nums) {
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
      heapify(nums, nums.length - 1, i);
    }

    // 任意: swap
    // 【改善】j=0の回は自分自身とのswap+無意味なheapify呼び出しになるだけ。j > 0で十分。
    for (int j = nums.length - 1; j >= 0; j--) {
      int temp = nums[0];
      nums[0] = nums[j];
      nums[j] = temp;

      heapify(nums, j-1, 0);
    }
  }

  private void heapify(int[] nums, int last, int parent) {
    int largest = parent;
    int leftChild = parent * 2 + 1;
    int rightChild = parent * 2 + 2;

    // ここはまずい！親-左子-右子 内の最大を求めるのだから、常にparentと比較するのではない
    if (last >= leftChild && nums[leftChild] > nums[parent]) {
      largest = leftChild;
    }
    // 同様
    // 【バグ】nums[parent]でなくnums[largest]と比較すべき。leftChildが既にlargestの場合、
    // parentとの比較では左右どちらが真に大きいか判定できず不正なheapifyになる（要修正）。
    if (last >= rightChild && nums[rightChild] > nums[parent]) {
      largest = rightChild;
    }

    if (largest != parent) {
      int temp = nums[parent];
      nums[parent] = nums[largest];
      nums[largest] = temp;

      // ここで躓いた！
      heapify(nums, last, largest);
    }
  }
}

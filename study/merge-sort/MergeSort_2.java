public class MergeSort_2 {
  public void mergeSort(int[] nums) {
    mergeSortHelper(nums, 0, nums.length - 1);
  }

  private void mergeSortHelper(int[] nums, int left, int right) {
    if (left == right) {
      return;
    }

    int mid = (left + right) / 2;

    mergeSortHelper(nums, left, mid);
    mergeSortHelper(nums, mid + 1, right);

    private void merge(nums)
  }

  private void merge() {
    
  }

}

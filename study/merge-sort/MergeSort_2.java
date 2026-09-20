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

    merge(nums, left, mid, right);
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int leftStart = left;
    int leftEnd = mid;
    int rightStart = mid + 1;

    int[] sorted = new int[right - left + 1];
    int i = 0;

    while (leftStart <= leftEnd && rightStart <= right ) {
      if (nums[leftStart] <= nums[rightStart]) {
        sorted[i] = nums[leftStart];
        leftStart++;
      } else {
        sorted[i] = nums[rightStart];
        rightStart++;
      }
      i++;
    }
    while (leftStart <= leftEnd) {
     sorted[i] = nums[leftStart];
     leftStart++; 
     i++;
    }

    while (rightStart <= right) {
     sorted[i] = nums[rightStart];
     rightStart++; 
     i++;
    }

    for (int j = 0; j < sorted.length; j++) {
      nums[left] = sorted[j];
      left++;
    }
  }

}

public class QuickSort_2 {
  public void quickSort(int[] nums) {
    quichSortHelper(nums, 0, nums.length - 1);
  }
  private void quichSortHelper(int[] nums, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivot = nums[right];
    int boundary = left;
    for (int i = left; i < right; i++) {
      if (nums[i] < pivot) {
        int temp = nums[i];
        nums[i] = nums[boundary];
        nums[boundary] = temp;
        boundary++;
      }
    }
    int temp = nums[right];
    nums[right] = nums[boundary];
    nums[boundary] = temp;

    quichSortHelper(nums, left, boundary - 1);
    quichSortHelper(nums, boundary, right);
  }

  
  public static void main(String[] args) {
    QuickSort_2 qs = new QuickSort_2();

    // 1. バラバラの一般的な配列
    int[] case1 = {5, 2, 9, 1, 5, 6};
    System.out.print("検証1 (通常): " + java.util.Arrays.toString(case1));
    qs.quickSort(case1);
    System.out.println(" ➔ " + java.util.Arrays.toString(case1));

    // 2. 先ほど話題に出た「すでにソート済みの配列」
    int[] case2 = {1, 2, 3, 4, 5};
    System.out.print("検証2 (ソート済み): " + java.util.Arrays.toString(case2));
    qs.quickSort(case2);
    System.out.println(" ➔ " + java.util.Arrays.toString(case2));

    // 3. 逆順に並んでいる配列
    int[] case3 = {5, 4, 3, 2, 1};
    System.out.print("検証3 (逆順): " + java.util.Arrays.toString(case3));
    qs.quickSort(case3);
    System.out.println(" ➔ " + java.util.Arrays.toString(case3));

    // 4. 空っぽ、または要素が1つだけの境界値
    int[] case4 = {42};
    System.out.print("検証4 (要素1つ): " + java.util.Arrays.toString(case4));
    qs.quickSort(case4);
    System.out.println(" ➔ " + java.util.Arrays.toString(case4));
  }
}

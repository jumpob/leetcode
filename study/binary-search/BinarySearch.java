public class BinarySearch {
  /**
   * 
   * @param nums: ソート済み配列。ここではnullや空配列はないものとする
   * @param target
   * @return targetのインデックス。存在しない場合は-1
   */
  public int search(int[] nums, int target) {
    
    int left = 0;
    int right = nums.length -1;

    // もともとの右端・左端の数値がtargetと一致する場合に対応するため
    // L=Rまで必要
    while(left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] == target) {
        return mid;
        
        // Mより小さい場合→Rをずらす
        // RはM未満であることは確定なので、M-1
      } else if (nums[mid] > target) {
        right = mid -1;
       
        // Mより大きい場合は、次回ループでは「Mより上」でR以下。
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        try {
            // ケース1: 配列の中央付近に要素が存在する場合
            int[] nums1 = {2, 4, 6, 8, 10, 12, 14};
            assertEquals(2, bs.search(nums1, 6), "ケース1-1（中央付近）");
            assertEquals(5, bs.search(nums1, 12), "ケース1-2（中央付近）");

            // ケース2: 配列の端（最初、最後）に要素が存在する場合
            assertEquals(0, bs.search(nums1, 2), "ケース2-1（先頭）");
            assertEquals(6, bs.search(nums1, 14), "ケース2-2（末尾）");

            // ケース3: 要素が存在しない場合
            assertEquals(-1, bs.search(nums1, 5), "ケース3-1（存在しない）");
            assertEquals(-1, bs.search(nums1, 1), "ケース3-2（範囲外の最小値）");
            assertEquals(-1, bs.search(nums1, 20), "ケース3-3（範囲外の最大値）");


            System.out.println("すべてのテストケースに成功しました！🎉");

        } catch (AssertionError e) {
            System.err.println("検証失敗: " + e.getMessage());
        }
    }

    // 簡易的なアサーションメソッド
    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " -> [期待値: " + expected + ", 実際の値: " + actual + "]");
        }
    }
}

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        if (args.length < 1) {
            System.out.println("Usage: java BinarySearch <target>");
            return;
        }
        int target = Integer.parseInt(args[0]);
        boolean result = binarySearch(arr, target);
        if (result) {
            System.out.println("Target is present in the array.");
        } else {
            System.out.println("Target is not present in the array.");
        }
    }
}
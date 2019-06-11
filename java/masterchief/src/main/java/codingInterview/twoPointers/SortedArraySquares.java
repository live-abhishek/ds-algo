package codingInterview.twoPointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int resultPos = arr.length - 1;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (Math.abs(arr[l]) > Math.abs(arr[r])) {
                squares[resultPos] = arr[l] * arr[l];
                l++;
            } else {
                squares[resultPos] = arr[r] * arr[r];
                r--;
            }
            resultPos--;
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}

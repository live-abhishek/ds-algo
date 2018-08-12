package algo;

public class BinarySearch {
    public static int binarySearch(int[] arr, int fromIndex, int toIndex, int key){
        int low = fromIndex;
        int high = toIndex;
        int found = -1;

        while( low <= high ){
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if(midVal < key){
                low = mid + 1;
            } else if(midVal > key) {
                high = mid - 1;
            } else {
                found = mid;
                // For last occurance
                low = mid + 1;
                // For first occurance
                // high = mid - 1;
            }
        }
        return found;
    }

    public static int binarySearch(int[] arr, int key){
        return binarySearch(arr,  0, arr.length, key);
    }
}

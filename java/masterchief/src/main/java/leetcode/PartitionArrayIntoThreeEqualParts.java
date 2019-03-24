package leetcode;

public class PartitionArrayIntoThreeEqualParts {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        boolean firstSplitExist = false;
        int splitsum = sum / 3;
        int runningSum = 0;
        int firstIndex = 0;
        for (int i = 0; i < A.length; i++) {
            runningSum += A[i];
            if (runningSum == splitsum) {
                firstIndex = i;
                firstSplitExist = true;
                break;
            }
        }
        if (!firstSplitExist) {
            return false;
        }
        runningSum = 0;
        for (int i = firstIndex + 1; i < A.length; i++) {
            runningSum += A[i];
            if (runningSum == splitsum) {
                return true;
            }
        }
        return false;
    }
}

package fi.joni.smallestgap;


import java.util.Arrays;

public class SmallestGap {

    public static int findSmallestGap(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return 0;
        }
        
        Arrays.sort(numbers);

        int smallestGap = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            int gap;
            if(numbers[i] == numbers[i - 1]){
                gap = 0;
            }
            // this next else if is out of the spec
            // Math.abs is used for the negative number cases
            else if (numbers[i] < 0) {
                gap = Math.abs(numbers[i] - numbers[i - 1] + 1);
            } else {
                gap = Math.abs(numbers[i] - numbers[i - 1] - 1);
            }
            smallestGap = Math.min(smallestGap, gap);
        }

        return smallestGap;
    }
}
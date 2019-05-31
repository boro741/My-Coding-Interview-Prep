import java.util.Arrays;

class avgOfSubArrayK {

   // 1. Brute Force Method
   public static double[] findAverages(int K, int[] arr) {
        double[] res = new double[arr.length - K + 1];

        for(int i=0;i <= arr.length - K;i++){
            double sum = 0;

            for(int j = i;j < i+K;j++){
                sum += arr[j];
            }

            res[i] = sum / K;
        }

        return res;
    }

    // 2. Sliding Window
    public static double[] findAveragesSlidingWindow(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
          windowSum += arr[windowEnd]; // add the next element
          // slide the window, we don't need to slide if we've not hit the required window size of 'k'
          if (windowEnd >= K - 1) {
            result[windowStart] = windowSum / K; // calculate the average
            windowSum -= arr[windowStart]; // subtract the element going out
            windowStart++; // slide the window ahead
          }
        }
    
        return result;
      }


    public static void main(String[] args) {
        double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
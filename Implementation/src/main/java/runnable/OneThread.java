package runnable;

import java.util.Arrays;

public class OneThread {
    public static void main(String[] args) {
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("OneThread : " + (System.currentTimeMillis() - startTime + " ms"));
    }
}

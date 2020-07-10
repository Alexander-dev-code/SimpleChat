package runnable;

import java.util.Arrays;

public class TwoThread {
    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] one = new  float[h];
        float[] two = new  float[h];
        System.arraycopy(arr, 0, one, 0, h);
        System.arraycopy(arr, h, two, 0, h);

        Thread t1 = new Thread( () ->{
            for (int i = 0; i < one.length ; i++) {
                one[i] = (float)(one[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread( () ->{
            for (int i = 0; i < two.length ; i++) {
                two[i] = (float)(two[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(one, 0, arr, 0, h);
        System.arraycopy(two, 0, arr, h, h);

        System.out.println("TwoThread : " + (System.currentTimeMillis() - startTime + " ms"));
    }

}

package Arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0;

        int start = 0, end = height.length - 1;

        while(start < end){
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));

            if(height[start] < height[end]){
                start++;
            }else if(height[start] > height[end]){
                end --;
            }else{
                start++;
                end--;
            }
        }

        return maxArea;


    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

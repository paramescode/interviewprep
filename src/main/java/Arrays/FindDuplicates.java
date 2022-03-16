package Arrays;

public class FindDuplicates {

    static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;

        printRepeating(arr, arr_size);

        System.out.println();
        //so supprts only numeers 0 to n-1
        int ar[] = {-1, -2, -3, -1, -3, -6, -6};
         arr_size = ar.length;

        printRepeating(ar, arr_size);
    }
}

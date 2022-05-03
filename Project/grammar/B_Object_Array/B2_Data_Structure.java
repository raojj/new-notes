package grammar.B_Object_Array;

public class B2_Data_Structure {
    public static void main(String[] args){
        int[] nums = new int[]{14,56,48,86,78,59,12,44,36};
        int[] nums1 = quickSort(nums,0,nums.length-1);
        B1_Object_Array.printArray(nums1);
    }


    public static int[] bubbleSort(int[] array){
        for (int i = 0; i<array.length ; i++){
            for (int j = 0; j< array.length-1-i; j++){
                if (array[j]>array[j+1]){
                    int tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                }
            }
        }
        return array;
    }


    public static int[] quickSort(int array[],int left,int right) {
        int pivot = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] > pivot) {
                j--;
            }
            while (i < j && array[i] < pivot) {
                i++;
            }
            if (array[i] == array[j] && i < j) {
                i++;
            } else {//交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        if (i-1 > left) {
            array=quickSort(array,left,i-1);
        }
        if (j+1 < right) {
            array=quickSort(array,j+1,right);
        }
        return array;
    }


        public static void mergeSort(int[] Array,int[] temp,int left,int right){
            if(left<right){
                int middle=(right+left)/2;
                mergeSort(Array,temp,left,middle);
                mergeSort(Array,temp,middle+1,right);
                //开始合并两个数组
                mergeGet(Array,temp,left,right,middle);
            }
        }

        public static void mergeGet(int[] Array,int[] temp,int left,int right,int middle){
            int i=left;
            int j=middle+1;
            int t=0;
            while (i<=middle&&j<=right){
                if(Array[i]<Array[j]){
                    temp[t++]=Array[i++];
                }else {
                    temp[t++]=Array[j++];
                }
            }
            while (j<=right){
                temp[t++]=Array[j++];
            }
            while (i<=middle){
                temp[t++]=Array[i++];
            }
            t=0;
            while (left<=right){
                Array[left++]=temp[t++];
            }
        }
}

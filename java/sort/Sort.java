import java.util.Arrays;

/* 
十大排序算法
*/

public class Sort{

    // 交换
    public static void swap(int a,int b){
        int temp = 0;
        temp=a;
        a=b;
        b=temp;
    }
    //冒泡排序
    public static void bubbleSort(int [] arr){
        for(int i=0;i<arr.length;i++){
            boolean flag = false;//提前退出标志位
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag) {
                break;//没有交换提前退出
            }
        }
    }
    //改进冒泡排序。记录最后一次交换的位置作为下次比较的边界
    public static void bubbleSort2(int[] arr){
        //最后一次交换位置
        int lastSwap=0;
        int sortBorder=arr.length-1;
        for(int i=0;i<arr.length;i++){
            boolean flag = false;//提前退出标志位
            for(int j=0;j<sortBorder;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                    lastSwap = j;//最后一次交换位置
                }
            }
            sortBorder = lastSwap;
            if(!flag) {
                break;//没有数据交换退出
            }      
        }
    }
    /*
    插入排序
    把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
    从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。(需要移动数组中已排序元素的位置)
    重复上述过程直到最后一个元素被插入有序子数组中。
    */
    public static void instertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int value = arr[i];
            int position = i;
            while(position>0 && arr[position-1]>value){
                arr[position] =arr[position-1];
                position--;
            }
            arr[position] = value;
        }
    }
    /*
    选择排序 
    两层循环
    在未排序序列中找到最小（大）元素，存放到排序序列的起始位置(第一个元素与最小元素交换位置)
    从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。(当前位置与剩下元素中最小元素的位置交换)
    重复第二步，直到所有元素均排序完毕。
    */
    public static void selectionSort(int[] arr){
        int minIndex,temp=0;
        for(int i=0;i<arr.length-1;i++){
            minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    /*
    归并排序
    分治+递归
    3个函数，一个排序，一个递归，一个合并
    合并函数：循环判断两个子数组中元素的大小，将小的放入临时数组中。
    再判断两个数组中是否还有剩余元素，将剩余元素放入临时数组，然后将临时数组的元素拷贝到原数组中
    */
    public static void mergeSort(int[] arr){
        mergeSortInternally(arr, 0, arr.length-1);
    }
    //递归
    public static void mergeSortInternally(int a[],int low,int high){
        //递归终止条件
        if(low>=high) return;

        int mid = low+(high-low)/2;

        //分治
        mergeSortInternally(a, low, mid);
        mergeSortInternally(a, mid+1, high);
        //合并
        merge(a, low, mid, high);
    }
    // 合并
    public static void merge(int[] arr,int low,int mid,int high ){
        int i = low;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[high-low+1];

        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        //判断哪个数组是还有元素
        int start = i;
        int end = mid;
        if(j<=high){
            start = j;
            end = high;
        }
        while(start<=end){
            temp[k++] = arr[start++];
        }

        //拷贝到原数组中
        for(int x=0;x<=high-low;x++){
            arr[low+x] = temp[x];
        }

    }
    /*
    快排
    分治+递归
    3个函数：一个排序；一个递归、一个分区
    分区主要是返回基准点，并将小于这个基准的数都放到基准点的左边，大于基准的数都放到基准的右边
    这样就形成了基准点左边的数都小于基准右边的数都大于基准
    */
    public static void quickSort(int[] arr){
        quickSortInternally(arr, 0, arr.length-1);
    }
    public static void quickSortInternally(int[] arr,int p,int q){
        if(p>=q) return;

        int mid = partition(arr, p, q);
        quickSortInternally(arr, p, mid-1);
        quickSortInternally(arr, mid+1, q);
    }
    public static int partition(int arr[],int p,int q){
        int pivot = arr[q];
        int i = p;
        for(int j=p;j<q;++j){
            if(arr[j]<pivot){
                if(i==j){
                    i++;
                }else{
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int tmp = arr[q];
        arr[q] = arr[i];
        arr[i] = tmp;

        return i;
    }
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
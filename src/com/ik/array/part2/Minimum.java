package com.ik.array.part2;

class Minimum
{
    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];
 
        // If there is only one element left
        if (high == low) return arr[low];
 
        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/
 
        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];
 
        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
 
        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }
    public static void main(String[] args)
    {
    	int arr1[] =  {5, 6, 1, 2, 3, 4};
    	int arr2[] =  {3, 4, 5, 6, 1};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMin1(arr1, 0, n1-1));
        System.out.println("The minimum element is "+ findMin1(arr2, 0, arr2.length-1));
        
        int arr10[]={5,4,3,2,1};
        System.out.println("The minimum element is "+ findMin1(arr10, 0, arr10.length-1));
        
        int arr11[]={1,2,3,4,5};
        //System.out.println("The minimum element is "+ findMin1(arr11, 0, arr10.length-1));
        
        int arr9[] =  {2, 1};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMin(arr9, 0, n9-1));
    }
    
    // Driver Program
    public static void main1(String[] args)
    {
    	System.out.println(1/2);
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMin(arr1, 0, n1-1));
 
        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMin(arr2, 0, n2-1));
 
        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ findMin(arr3, 0, n3-1));
 
        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMin(arr4, 0, n4-1));
 
        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMin(arr5, 0, n5-1));
 
        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMin(arr6, 0, n1-1));
 
        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMin(arr7, 0, n7-1));
 
        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMin(arr8, 0, n8-1));
 
        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMin(arr9, 0, n9-1));
        
        
        int arr10[]={5,4,3,2,1};
        int n10 = arr10.length;
        System.out.println("The minimum element is "+ findMin(arr10, 0, n10-1));
    }
    
    static int findMin1(int a[], int low, int high){
    	
    	int mid = (low+high)/2;
    	
    	//if(a[low] < a[high])
    	
    	if (low < mid && mid < high && a[mid-1] > a[mid] ){
    		return a[mid];
    	}
    	
    	if((mid == low && low < high) && a[mid+1] < a[mid]){
    		return a[mid+1];
    	}
    	
    	if(a[low] > a[mid] && a[mid] < a[high]){
    		return findMin1(a, low, mid);
    	}
    	return findMin1(a, mid, high);
    }
    
}

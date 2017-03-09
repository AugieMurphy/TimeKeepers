/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * Sorts below and above pivot points by pivoting smaller and smaller sections until the sections are only 1 in size.
 * 2a. Worst pivot choice / array state and associated runtime: 
First element, consecutive elements, Last element, or reverse-consecutive elements are at the pvtPos
 *
 * 2b. Best pivot choice / array state and associated runtime:
 * The pvtVal is the median value of the array of elements
 *
 * 3. Approach to handling duplicate values in array:
 * Same approach. It'll be pivoted to the greater than side, but it will eventually end up in the first slot of that section, next to the original value.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
        sort( d,0,d.length-1);
    }

    public static void sort( int[] d, int left, int right){
	if( left < right ){
	    int s = partition(d,left,right,(left+right)/2);
	    sort( d,left,s-1); 
	    sort( d,s+1,right);
	}
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.

    public static int partition( int[] arr, int left, int right, int pvtPoint ){
	
	int pvtVal = arr[pvtPoint];
	arr[pvtPoint] = arr[right];
	arr[right] = pvtVal;
	int s = left;
	
	for( int i = left; i < right; i++ ){
	    if( arr[i] < pvtVal ){
		int l = arr[i];
		arr[i] = arr[s];
		arr[s] = l;
		s++;
	    }
	}
	
	arr[right] = arr[s];
	arr[s] = pvtVal;
	return s;
	
    }

    //main method for testing
    public static void main( String[] args ) 
    {


	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
       
	System.out.println("arrN after sort: " );
	printArr(arrN);




	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);


    }//end main

}//end class QuickSort

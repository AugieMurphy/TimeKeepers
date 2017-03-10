public class QuickSortTesterv2 {
    //generate random test cases for performance
    public static int[] randomArray(int length, int nums) {
        int[] arr =  new int[length];
        //populate array in range [0,nums)
        for (int i = 0; i < length; i++) {
            arr[i]=(int) (Math.random()*nums);
        }
        return arr;
    }
    public static int[] randomArray(int length) {
        //since the length of specific elements doesnt matter, limit it to 3 digits max
        return randomArray(length,1000);
    }



    /**************************************************************/
    /**************************************************************/
    /************   Code below for convenience   ******************/
    /**************************************************************/
    /**************************************************************/
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

	
    //returns run time as an array with a certain amount of tries
    public static double[] runTime(int length, int tries) {
        int[] arr; //array to be sorted, changed every time
        int[] ans;
        long startTime;
        long endTime;
        double time;
        //create an array that is as long as the specified length
        arr = randomArray(length);
        //array controlling runtime of each try
        double[] times = new double[tries];
        //define start time and end time:
        for (int i=0; i < tries; i++) {
            //rescramble the array and try again
            shuffle(arr);
            startTime = System.nanoTime();
            qsort(arr);
            endTime = System.nanoTime();
            times[i] = ((double)(endTime-startTime))/1000000000.0; //add the time it took to run in seconds
        }
        return times;
    }
    
    public static double avgTime (int length, int tries) {
        double[] times = runTime(length, tries);
        double total = 0;
        //add the totals together in a for loop
        for (int i = 0; i < times.length; i++) {
            total+=times[i];
        }
        //return the arithmetic average:
        return total/times.length;
    }
    
    //returns avg time for 10K tests
    public static double avgTime (int length) {
        return avgTime(length, 10000);
    }

    //main method for testing
    public static void main( String [] args ) {
        System.out.println("Generating times for given array lengths:");
        //lengths that you wish to try out.
        int[] testcases = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600,1700,1800,1900,2000};
	System.out.println("Length\tTime");
	for (int test: testcases) {
	    System.out.println(""+test+","+avgTime(test));
	}

    }//end main()
}

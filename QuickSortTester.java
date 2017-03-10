/* Team TimeKeepers -- Jeffrey Lin, Augie Murphy, Gabi Newman
 * APCS2 period 03
 * LAB01 -- What Does the Data Say?
 * 2017-03-09
 */

/** QuickSortTester.
 *
 * Timing Mechanism:
 *  One run of qsort() is considered a round. ROUNDS rounds are performed per data size. At the end
 *  of the test, the average is calculated (time / ROUNDS) and printed to stdout in a CSV format.
 */

public class QuickSortTester {
  private static final long ROUNDS = 100;
  private static       int  size   = 100;

  public static void main( String[] args ) {
    System.out.format("Running %s rounds of testing with initial size %s.\n", ROUNDS, size);
    System.out.format("%s,%s\n", "size", "average");

    long s = 0;
    long time = 0;

    while ( size > 0 ) {
      int[] data = new int[size];

      for ( long rounds = ROUNDS; rounds > 0; rounds-- ) {
        for ( int i = 0; i < data.length; i++ ) {
          data[i] = (int) ( 1000 * Math.random() );
        }

        s = System.nanoTime();
        QuickSort.qsort(data);
        time += (System.nanoTime() - s);
      }

      System.out.format("%s,%s\n", data.length, time / ROUNDS);
      time = 0;
      size *= 10;
    }
  }
}


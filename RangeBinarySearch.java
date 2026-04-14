
import java.util.Comparator;

public class RangeBinarySearch {

    // Returns the index of the *first* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        /* TODO */
             if (terms == null || comparator == null || key == null) return -1; 
        int low = 0;
        int high = terms.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(terms[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1; // continue searching left
            }
        }
        return result;    
    }

    // Returns the index of the *last* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        /* TODO */
             if (terms == null || comparator == null || key == null) return -1;
        int low = 0;
        int high = terms.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(terms[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1; // continue searching right
            }
        }
        return result;
    

    }

}

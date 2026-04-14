import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {
    private Term[] dictionary;
    

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N), where N is the number of terms
    private void sortDictionary() {
        /* TODO */
        if (this.dictionary == null) return;
        Arrays.sort(this.dictionary, Term.byLexicographicOrder());
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        /* TODO */
        if (prefix == null) throw new IllegalArgumentException("prefix is null");
        if (this.dictionary == null || this.dictionary.length == 0) return new Term[0];

        Comparator<Term> prefixComp = Term.byPrefixOrder(prefix.length());
        Term key = new Term(prefix, 0L);

        int first = RangeBinarySearch.firstIndexOf(this.dictionary, key, prefixComp);
        if (first == -1) return new Term[0];
        int last = RangeBinarySearch.lastIndexOf(this.dictionary, key, prefixComp);

        Term[] matches = Arrays.copyOfRange(this.dictionary, first, last + 1);
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix) {
        /* TODO */
    if (prefix == null) throw new IllegalArgumentException("prefix is null");
        if (this.dictionary == null || this.dictionary.length == 0) return 0;

        Comparator<Term> prefixComp = Term.byPrefixOrder(prefix.length());
        Term key = new Term(prefix, 0L);

        int first = RangeBinarySearch.firstIndexOf(this.dictionary, key, prefixComp);
        if (first == -1) return 0;
        int last = RangeBinarySearch.lastIndexOf(this.dictionary, key, prefixComp);
        return last - first + 1;
    }

}

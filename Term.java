
import java.util.Comparator;
public class Term {
    private String word;
    private long weight;
    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    // Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    public String getPrefix(int len) {
        /* TODO */
        if (len < 0) {
            throw new IllegalArgumentException("len must be non-negative");
        }
        if (word == null) return "";
        if (len >= word.length()) {
            return word;
        }
        return word.substring(0, len);
    }

    // Compares the two terms in case-insensitive lexicographic order.
    public static Comparator<Term> byLexicographicOrder() {
        /* TODO */
        return new Comparator<Term>() {
            @Override
            public int compare(Term a, Term b) {
                if (a == b) return 0;
                if (a == null) return -1;
                if (b == null) return 1;
                return a.getWord().compareToIgnoreCase(b.getWord());
            }
        };
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        /* TODO */
         return new Comparator<Term>() {
            @Override
            public int compare(Term a, Term b) {
                // Descending: larger weight first
                return Long.compare(b.getWeight(), a.getWeight());
            }
        };
    }

    // Compares the two terms in case-insensitive lexicographic order,
    // but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k) {
        /* TODO */
         if (k < 0) throw new IllegalArgumentException("k must be non-negative");
        return new Comparator<Term>() {
            @Override
            public int compare(Term a, Term b) {
                if (a == b) return 0;
                if (a == null) return -1;
                if (b == null) return 1;
                String pa = a.getPrefix(k);
                String pb = b.getPrefix(k);
                return pa.compareToIgnoreCase(pb);
            }
        };
        
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }

}

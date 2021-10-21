package quotes1;

public class ApiQuote {
    private String quoteAuthor ;
    private String quoteText ;

    public ApiQuote(String quoteAuthor, String quoteText) {
        this.quoteAuthor = quoteAuthor;
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return "ApiQuote{" +
                "quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteText='" + quoteText + '\'' +
                '}';
    }
}

package solution;

/**
 * 
 * @author Reece Pollard
 * @version 3/30/20
 *
 */
public class Book implements Comparable<Book>
{
    private String author;
    private String title;
    private int numberOfPages;
    
    /**
     * Constructor for Book.
     * @param author author
     * @param title title
     * @param numberOfPages numberOfPages
     */
    public Book(String author, String title, int numberOfPages)
    {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }
    
    /**
     * method getAuthor.
     * @return title
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * method getTitle.
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * method getNumberOfPages.
     * @return numberOfPages
     */
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    /**
     * Compare books.
     * @param b b
     * @return result result 
     */
    @Override
    public int compareTo(Book b)
    {
        int result = author.compareTo(b.getAuthor());
        if (result == 0)
        {
            return title.compareTo(b.getTitle());
        }
        return result;
    }
    
    /**
     * Compare books to see if they are equal.
     * @param b other book to compare
     * @return boolean books are equal
     */
    public boolean equals(Book b)
    {
        if (author.equals(b.getAuthor()) && title.equals(b.getTitle()))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Print books to string.
     * @return string string
     */
    public String toString()
    {
        return author + ", " + title + ", " + numberOfPages;
    }
}

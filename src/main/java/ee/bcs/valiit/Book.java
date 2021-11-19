package ee.bcs.valiit;

public class Book {
    private String name;
    private String author;
    private int year;
    private int hinnang;

    public int getHinnang() {
        return hinnang;
    }

    public void setHinnang(int hinnang) {
        this.hinnang = hinnang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

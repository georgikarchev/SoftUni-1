package BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.trim().length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        if (author.trim().split("\\s+").length > 1) {
            if ((Character.isDigit(author.trim().split("\\s+")[1].charAt(0)))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if ((price <= 0)) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}

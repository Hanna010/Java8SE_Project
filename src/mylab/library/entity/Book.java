package mylab.library.entity;

public class Book {

    // 도서 정보
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;


    // 기본 생성자
    public Book() {
        this.isAvailable = true;
    }


    // 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }


    // 제목 Getter
    public String getTitle() {
        return title;
    }


    // 제목 Setter
    public void setTitle(String title) {
        this.title = title;
    }


    // 저자 Getter
    public String getAuthor() {
        return author;
    }


    // 저자 Setter
    public void setAuthor(String author) {
        this.author = author;
    }


    // ISBN Getter
    public String getIsbn() {
        return isbn;
    }


    // ISBN Setter
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    // 출판년도 Getter
    public int getPublishYear() {
        return publishYear;
    }


    // 출판년도 Setter
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }


    // 대출 가능 여부 확인
    public boolean isAvailable() {
        return isAvailable;
    }


    // 대출 가능 여부 변경
    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    // 도서 대출
    public boolean checkOut() {

        if (isAvailable) {

            isAvailable = false;

            return true;
        }

        return false;
    }


    // 도서 반납
    public void returnBook() {

        isAvailable = true;
    }


    // 도서 정보 출력
    @Override
    public String toString() {

        String status;

        if (isAvailable) {
            status = "가능";
        } else {
            status = "대출 중";
        }

        return "책 제목: " + title
                + "\t저자: " + author
                + "\tISBN: " + isbn
                + "\t출판년도: " + publishYear
                + "\t대출 가능 여부: " + status;
    }
}
package hyhung.docbaotonghop;

public class Item {
    private String title;
    private String imageUrlOrLink; // Image URL từ RSS
    private String timeUp;
    private String articleLink; // Link đến bài báo

    // Constructor cũ (để duy trì tương thích)
    public Item(String title, String imageUrlOrLink, String timeUp) {
        this.title = title;
        this.imageUrlOrLink = imageUrlOrLink;
        this.timeUp = timeUp;
        this.articleLink = "";
    }

    // Constructor mới có link
    public Item(String title, String imageUrlOrLink, String timeUp, String articleLink) {
        this.title = title;
        this.imageUrlOrLink = imageUrlOrLink;
        this.timeUp = timeUp;
        this.articleLink = articleLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlAvata() {
        return imageUrlOrLink;
    }

    public void setUrlAvata(String imageUrlOrLink) {
        this.imageUrlOrLink = imageUrlOrLink;
    }

    public String getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(String timeUp) {
        this.timeUp = timeUp;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }
}

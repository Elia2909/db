package mate.academy.literaryformate;

public class LiteraryFormat {
    private String title;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LiteraryFormat{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}

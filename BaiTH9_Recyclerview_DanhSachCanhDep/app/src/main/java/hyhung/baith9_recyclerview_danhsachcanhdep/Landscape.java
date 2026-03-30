package hyhung.baith9_recyclerview_danhsachcanhdep;

public class Landscape {
    private String name;
    private int imageResId;
    private String description;

    public Landscape(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
}

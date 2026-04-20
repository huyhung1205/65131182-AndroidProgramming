package thigk2.phanhuyhung.kiemtragk_65131182;

public class Attraction {
    private String name;
    private String address;
    private int imageResId;

    public Attraction(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}

package hyhung.baith8_tuychinhlv;

/**
 * Food Model - Lưu thông tin một món ăn
 */
public class Food {
    private String tenMonAn; // Tên món ăn
    private int giaBan; // Giá bán (VNĐ)
    private String moTa; // Mô tả món ăn
    private int anhResId; // Resource ID của ảnh

    public Food(String tenMonAn, int giaBan, String moTa, int anhResId) {
        this.tenMonAn = tenMonAn;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.anhResId = anhResId;
    }

    // Getter methods
    public String getTenMonAn() {
        return tenMonAn;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getAnhResId() {
        return anhResId;
    }
}

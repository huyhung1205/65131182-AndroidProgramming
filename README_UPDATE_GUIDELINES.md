# 📋 Quy Tắc Cập Nhật README

Hướng dẫn chi tiết để cập nhật README cho các dự án trong Kho Lưu Trữ Khóa Học Android Programming.

---

## 📌 Cấu Trúc Tệp README Chính

### 1. **Thứ Tự Dự Án**
Các dự án được liệt kê **từ cao đến thấp**:

### 2. **Bộ Cấu Trúc Mỗi Dự Án**

```markdown
### [SỐ THỨ TỰ]. **[TÊN DỰ ÁN]**
[Chi tiết]([Đường dẫn tới file/folder])
![Hình ảnh](imageProject/[TÊN DỰ ÁN]/image.png)
- **Mục Đích:** [Mô tả ngắn gọn]
- **Khái Niệm Chính:** [Các khái niệm tính năng chính]
- **Tính Năng:** 
  - Tính năng 1
  - Tính năng 2
  - Tính năng 3
- **Trọng Tâm Học Tập:** [Các điểm học tập chính]
```

Lưu ý: Số thứ tự phải được cập nhật chính xác khi thêm dự án mới. Theo thứ tự giảm dần, mới nhất ở trên cùng.

---

## ✅ Quy Tắc Chi Tiết

### Quy Tắc 1: Thêm Dự Án Mới

**Khi thêm một dự án mới:**

1. **Xác định vị trí**: Xếp dự án vào vị trí trên cùng của danh sách (số thứ tự cao nhất).
2. **Cập nhật số thứ tự**: Điều chỉnh số thứ tự của tất cả các dự án hiện có để đảm bảo thứ tự giảm dần.
3. **Thêm thông tin đầy đủ**: Mục đích, khái niệm, tính năng, trọng tâm học tập
4. **Thêm hình ảnh**: Tạo thư mục trong `imageProject/` có tên dự án
5. **Thêm liên kết "Chi tiết"**: Liên kết đến MainActivity.java hoặc activity_main.xml tùy thuộc vào dự án. 

**Ví dụ:**
```markdown
### 10. **BaiTH7_ListView_DanhSachTinhThanh**
[Chi tiết](./BaiTH7_ListView_DanhSachTinhThanh/app/src/main/java/hyhung/baith7_listview_danhsachtinhthanh/MainActivity.java)
![BaiTH7_ListView_DanhSachTinhThanh](imageProject/BaiTH7_ListView_DanhSachTinhThanh/image.png)
- **Mục Đích:** Minh họa cách sử dụng ListView để hiển thị danh sách các tỉnh thành của Việt Nam
```

### Quy Tắc 2: Tên Các Trường (Fields)

Luôn sử dụng các trường này theo thứ tự:

1. **Mục Đích** - Giải thích mục đích chính của dự án
2. **Khái Niệm Chính** - Liệt kê các khái niệm kỹ thuật được dạy
3. **Tính Năng** - Liệt kê chi tiết các tính năng (dùng bullet points)
4. **Trọng Tâm Học Tập** - Tóm tắt điểm học tập chính

### Quy Tắc 3: Định Dạng Văn Bản

- **Tên dự án**: `**Tên Dự Án**` (in đậm)
- **Tên trường**: `**Tên Trường:**` (in đậm + dấu hai chấm)
- **Giá trị trường**: Văn bản thường
- **Bullet points tính năng**: Dùng `- ` hoặc `  - ` (khoảng cách 2)

### Quy Tắc 4: Liên Kết (Links)

#### Liên Kết Chi Tiết Dự Án:
- **Dự án có README riêng**: `[Chi tiết](./[FOLDER]/README.md)`
- **Dự án chỉ có layout**: `[Chi tiết](./[FOLDER]/app/src/main/res/layout/activity_main.xml)`
- **Dự án có MainActivity**: `[Chi tiết](./[FOLDER]/app/src/main/java/[PACKAGE]/MainActivity.java)`
Lưu ý: Ưu tiên liên kết đến MainActivity.java nếu có, nếu không thì đến layout, cuối cùng mới đến README.md

#### Liên Kết Hình Ảnh:
- **Định dạng**: `![TênDự Án](imageProject/[TênDựÁn]/image.png)`
- **Lưu ý**: Tên folder hình ảnh phải khớp với tên dự án
- **Khi có nhiều ảnh**: Ưu tiên chèn bằng thẻ HTML `<img>` trên cùng một dòng để hiển thị gọn và đồng đều hơn: <img src="./imageProject/<nameProject>/image.png" width="200">


## 🎨 Template Chuẩn

Sử dụng template này để thêm dự án mới:

```markdown
### [SỐ]. **[TÊN DỰ ÁN]**
[Chi tiết]([ĐỘ LL])
![TênDựÁn](imageProject/[TênDựÁn]/image.png)
- **Mục Đích:** [MÔ TẢ]
- **Khái Niệm Chính:** [KHÁI NIỆM 1], [KHÁI NIỆM 2], [KHÁI NIỆM 3]
- **Tính Năng:** 
  - [TÍNH NĂNG 1]
  - [TÍNH NĂNG 2]
  - [TÍNH NĂNG 3]
- **Trọng Tâm Học Tập:** [ĐIỂM 1], [ĐIỂM 2]
```

---

## 📞 Mẹo & Lưu Ý

✅ **Những điều nên làm:**
- Giữ mô tả ngắn gọn, dễ hiểu
- Sử dụng emoticons thích hợp (📱, 🎯, 📋, v.v.)
- Kiểm tra chính tả tiếng Việt
- Cập nhật "Cập Nhật Lần Cuối" ở cuối README
- Luôn kèm **text commit** sau khi cập nhật README (xem Quy Tắc 5)

❌ **Những điều không nên làm:**
- Không dùng số thứ tự bị lặp hoặc bị nhảy
- Để liên kết bị mất hoặc sai
- Bỏ qua các trường bắt buộc
- Sử dụng khoảng trắng không nhất quán

---

## ✅ Quy Tắc 5: Luôn đưa text commit sau khi cập nhật

Sau mỗi lần bạn (hoặc Codex) cập nhật `README.md`, **phải trả về** một đoạn “text commit” để bạn copy dán nhanh khi commit Git.

### 🧾 Template commit (khuyến nghị)

Trường hợp chỉ cập nhật README (thêm/sửa mục dự án):
```text
docs: add README <TEN_DU_AN>

- Add <TEN_DU_AN> to `README.md`
```

Trường hợp vừa cập nhật README vừa thêm ảnh minh hoạ:
```text
docs: update README <TEN_DU_AN>

- Add <TEN_DU_AN> into `README.md`
- Add picture `imageProject/<TEN_DU_AN>/image.png`
```

Trường hợp cập nhật nhiều dự án trong 1 lần:
```text
docs: update README (and add multiple projects)

- Add <TEN_DU_AN_1>, <TEN_DU_AN_2> into `README.md`
```

---

**Phiên Bản:** 1.0  
**Cập Nhật Lần Cuối:** Tháng 3 năm 2026  
**Tác Giả:** Hướng dẫn chung cho Kho Lưu Trữ

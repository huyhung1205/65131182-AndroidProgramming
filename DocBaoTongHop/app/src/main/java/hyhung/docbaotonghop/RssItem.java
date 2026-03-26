package hyhung.docbaotonghop;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class RssItem {
    @Element(name = "title", required = false)
    private String title;

    @Element(name = "link", required = false)
    private String link;

    @Element(name = "description", required = false)
    private String description;

    @Element(name = "pubDate", required = false)
    private String pubDate;

    public RssItem() {
    }

    public String getTitle() {
        return title != null ? title : "Không có tiêu đề";
    }

    public String getLink() {
        return link != null ? link : "";
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public String getPubDate() {
        return pubDate != null ? pubDate : "";
    }

    /**
     * Extract image URL từ HTML description
     * VNExpress thường đặt ảnh trong thẻ <img> với src attribute
     */
    public String getImageUrl() {
        if (description == null || description.isEmpty()) {
            return "";
        }

        try {
            // Tìm <img src="...">
            int imgStart = description.indexOf("<img");
            if (imgStart == -1)
                return "";

            int srcStart = description.indexOf("src=\"", imgStart);
            if (srcStart == -1)
                return "";

            srcStart += 5; // Dài của "src=\""
            int srcEnd = description.indexOf("\"", srcStart);
            if (srcEnd == -1)
                return "";

            String imageUrl = description.substring(srcStart, srcEnd);

            // Đảm bảo URL là hợp lệ
            if (imageUrl.startsWith("http")) {
                return imageUrl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}

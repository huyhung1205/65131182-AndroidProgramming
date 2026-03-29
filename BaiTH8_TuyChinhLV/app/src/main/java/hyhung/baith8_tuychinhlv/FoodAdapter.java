package hyhung.baith8_tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * FoodAdapter - Custom Adapter để hiển thị danh sách món ăn trong ListView
 * - Extends BaseAdapter
 * - Dùng ViewHolder pattern để tối ưu hiệu năng
 * - Chuyển dữ liệu Food object thành UI view trên ListView
 */
public class FoodAdapter extends BaseAdapter {
    private Context context; // Để inflate layout
    private ArrayList<Food> list; // Danh sách dữ liệu cần hiển thị
    private LayoutInflater inflater; // Tool để chuyển XML layout → Java View object

    /**
     * Constructor - gọi lúc khởi tạo adapter
     * 
     * @param context: Context của Activity (this)
     * @param list:    ArrayList chứa tất cả Food cần hiển thị
     */
    public FoodAdapter(Context context, ArrayList<Food> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * getCount() - Bắt buộc override
     * 
     * @return: Số lượng item cần hiển thị trong ListView
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * getItem() - Bắt buộc override
     * 
     * @param position: Vị trí của item (0, 1, 2, ...)
     * @return: Object tại vị trí đó
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /**
     * getItemId() - Bắt buộc override
     * 
     * @param position: Vị trí của item
     * @return: ID duy nhất của item
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * getView() - PHẦN QUAN TRỌNG NHẤT!
     * Phương thức này gọi cho MỖI item khi ListView cần hiển thị
     * Dùng ViewHolder pattern để tối ưu (tái sử dụng view cũ)
     *
     * @param position:    Vị trí item cần hiển thị (0, 1, 2, ...)
     * @param convertView: View cũ từ row trước (có thể null nếu là row đầu)
     * @param parent:      ListView container
     * @return: View đã setup xong, sẵn sàng hiển thị
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Nếu không có view cũ: Tạo mới
            // 1. Inflate: Chuyển item.xml → convertView object
            convertView = inflater.inflate(R.layout.item, parent, false);

            // 2. Tạo ViewHolder object (lưu references của các widget)
            holder = new ViewHolder();

            // 3. Tìm tất cả widget con trong convertView XML
            // PHẢI MATCH với id trong item.xml
            holder.itemAnh = convertView.findViewById(R.id.itemAnh);
            holder.itemTenMonAn = convertView.findViewById(R.id.itemTenMonAn);
            holder.itemGiaBan = convertView.findViewById(R.id.itemGiaBan);
            holder.itemMoTa = convertView.findViewById(R.id.itemMoTa);

            // 4. Lưu holder vào convertView.setTag()
            convertView.setTag(holder);
        } else {
            // Nếu có view cũ: Tái sử dụng
            holder = (ViewHolder) convertView.getTag();
        }

        /**
         * BƯỚC 2: Cập nhật dữ liệu
         * - Lấy Food object từ list tại vị trí position
         * - Gán dữ liệu vào holder widgets
         */
        Food food = list.get(position);
        holder.itemTenMonAn.setText(food.getTenMonAn());
        holder.itemGiaBan.setText(String.format("%,d VNĐ", food.getGiaBan()));
        holder.itemMoTa.setText(food.getMoTa());
        holder.itemAnh.setImageResource(food.getAnhResId());

        return convertView;
    }

    /**
     * ViewHolder Pattern - Tối ưu hiệu năng
     * Lưu references của các widget để không cần gọi findViewById mỗi lần
     */
    private static class ViewHolder {
        ImageView itemAnh; // Để set food photo
        TextView itemTenMonAn; // Để set food name
        TextView itemGiaBan; // Để set food price
        TextView itemMoTa; // Để set food description
    }
}

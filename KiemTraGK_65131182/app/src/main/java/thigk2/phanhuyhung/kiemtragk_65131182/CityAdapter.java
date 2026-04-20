package thigk2.phanhuyhung.kiemtragk_65131182;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class CityAdapter extends ArrayAdapter<String> {

    private List<String> cities;
    private Context context;

    public CityAdapter(Context context, List<String> cities) {
        super(context, R.layout.list_item_city, cities);
        this.context = context;
        this.cities = cities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_item_city, parent, false);
        }

        String cityName = cities.get(position);
        TextView tvCityName = view.findViewById(R.id.tv_city_name);
        tvCityName.setText(cityName);

        // Kiểm tra xem có phải "Phan Huy Hùng" không để highlight
        if (cityName.equals("Phan Huy Hùng")) {
            tvCityName.setTextColor(ContextCompat.getColor(context, R.color.orange_600));
            tvCityName.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 18);
            tvCityName.setTypeface(null, android.graphics.Typeface.BOLD);
        } else {
            tvCityName.setTextColor(ContextCompat.getColor(context, R.color.orange_900));
            tvCityName.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 16);
            tvCityName.setTypeface(null, android.graphics.Typeface.NORMAL);
        }

        return view;
    }
}

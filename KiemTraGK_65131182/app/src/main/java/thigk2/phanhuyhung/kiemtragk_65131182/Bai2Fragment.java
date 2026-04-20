package thigk2.phanhuyhung.kiemtragk_65131182;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Bai2Fragment extends Fragment {

    private ListView listviewCities;
    private CityAdapter cityAdapter;

    public Bai2Fragment() {
        super(R.layout.fragment_bai2);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Ánh xạ ListView từ XML
        listviewCities = view.findViewById(R.id.listview_cities);

        // Tạo danh sách thành phố (10 thành phố)
        List<String> cities = new ArrayList<>();
        cities.add("Hà Nội");
        cities.add("Thành phố Hồ Chí Minh");
        cities.add("Đà Nẵng");
        cities.add("Hải Phòng");
        cities.add("Phan Huy Hùng");
        cities.add("Cần Thơ");
        cities.add("An Giang");
        cities.add("Bà Rịa - Vũng Tàu");
        cities.add("Bắc Giang");
        cities.add("Bắc Kạn");

        // Tạo adapter và gán cho ListView
        cityAdapter = new CityAdapter(getContext(), cities);
        listviewCities.setAdapter(cityAdapter);
    }
}
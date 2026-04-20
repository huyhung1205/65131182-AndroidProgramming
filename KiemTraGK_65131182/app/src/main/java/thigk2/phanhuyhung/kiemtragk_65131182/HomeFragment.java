package thigk2.phanhuyhung.kiemtragk_65131182;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get button references
        MaterialButton btn_function1 = view.findViewById(R.id.btn_function1);
        MaterialButton btn_function2 = view.findViewById(R.id.btn_function2);
        MaterialButton btn_function3 = view.findViewById(R.id.btn_function3);
        MaterialButton btn_function4 = view.findViewById(R.id.btn_function4);

        // Get BottomNavigationView from MainActivity
        BottomNavigationView bottomNav = requireActivity().findViewById(R.id.bottom_navigation);

        // Set click listeners for navigation
        btn_function1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new Bai1Fragment())
                    .addToBackStack(null)
                    .commit();
            bottomNav.setSelectedItemId(R.id.nav_bai1);
        });

        btn_function2.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new Bai2Fragment())
                    .addToBackStack(null)
                    .commit();
            bottomNav.setSelectedItemId(R.id.nav_bai2);
        });

        btn_function3.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new Bai3Fragment())
                    .addToBackStack(null)
                    .commit();
            bottomNav.setSelectedItemId(R.id.nav_bai3);
        });

        btn_function4.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new Bai4Fragment())
                    .addToBackStack(null)
                    .commit();
            bottomNav.setSelectedItemId(R.id.nav_bai4);
        });
    }
}
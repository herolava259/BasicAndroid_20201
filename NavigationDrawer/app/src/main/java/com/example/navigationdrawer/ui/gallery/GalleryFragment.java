package com.example.navigationdrawer.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public final String[] currencíes = {"U.S dollar", "Vietnamese dong", "Euro", "Japanese yen", "British pound"};
    public final double[] parValueRates = {1.0000, 22678.0000, 0.8835, 113.3600, 0.7495};

    private int itemFrom = 0;
    private int itemTo = 0;

    public EditText editText;
    public String typeUnit = "^.^";
    private TextView result;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        editText = (EditText)root.findViewById(R.id.convert_unit);
        //editText.setInputType(InputType.Typ

        result = (TextView)root.findViewById(R.id.result_title);


        ArrayAdapter<String> adapterFrom;
        ArrayAdapter<String> adapterTo;
        Spinner spinnerFrom = root.findViewById(R.id.measure_from);
        Spinner spinnerTo = root.findViewById(R.id.measure_to);

        typeUnit = currencíes[0];
        ((TextView) root.findViewById(R.id.convert_title)).setText("Currency");
        adapterFrom = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, currencíes);
        adapterTo = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, currencíes);
        spinnerFrom.setAdapter(adapterFrom);

        spinnerTo.setAdapter(adapterTo);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemFrom = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemTo = i;
                typeUnit = currencíes[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button btn = root.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult(view);
            }
        });

        return root;
    }
    private double caculate(double in) {
        double res = 0.0;
        res = (parValueRates[itemTo] / parValueRates[itemFrom]) * in;

        return res;
    }

    public void showResult(View view) {
        double input_convert = Double.parseDouble(editText.getText().toString());
        result.setText(Double.toString(caculate(input_convert)) + " " + typeUnit);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
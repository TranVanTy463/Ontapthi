package vn.edu.ntu.ontapthi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;
import java.util.List;

import vn.edu.ntu.ontapthi.controller.Icontroller;
import vn.edu.ntu.ontapthi.model.infor;

public class FirstFragment extends Fragment {


    // điều hướng
    NavController navController;
    Icontroller controller;
    infor infor;
    List<infor> inforList;
    private EditText mEdtngay;
    private ImageView mImageView;
    private Spinner mSpinner;
    private EditText mEdtmua;
    private EditText mEdtban;
    private Button mBtnthem;
    private Button mBtnxem;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        addView(view);
        addEvent();
        return view;


    }

    private void addView(View view) {
        mEdtngay = view.findViewById(R.id.edtngay);
        mImageView = view.findViewById(R.id.imageView);
        mSpinner = view.findViewById(R.id.spinner);
        mEdtmua = view.findViewById(R.id.edtmua);
        mEdtban = view.findViewById(R.id.edtban);
        mBtnthem = view.findViewById(R.id.btnthem);
        mBtnxem = view.findViewById(R.id.btnxem);

        // nút chuyển hướng
        navController = NavHostFragment.findNavController(FirstFragment.this);
        // Spinner
        String[] loai = new String[]{"USD", "VND", "YEN"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FirstFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item, loai);
        mSpinner.setAdapter(arrayAdapter);
    }

    private void addEvent() {
        // thiết lập lịch
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // javauntil
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(year);
                        mEdtngay.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener
                        , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        // chuyển hướng
        mBtnxem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        /// thêm
        mBtnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infor= new infor(mEdtngay.getText().toString(),mSpinner.getSelectedItem().toString(),mEdtmua.getText().toString(),
                        mEdtban.getText().toString());
                // Thêm quan trọng
                controller = ((MainActivity) getActivity()).controller;
                inforList = controller.GetAllInfo();
                controller.addinfor(infor);

                Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();

            }
        });
    }


}

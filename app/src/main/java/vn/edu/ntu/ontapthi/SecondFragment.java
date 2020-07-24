package vn.edu.ntu.ontapthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.ntu.ontapthi.controller.Icontroller;
import vn.edu.ntu.ontapthi.model.infor;

public class SecondFragment extends Fragment {

    private RecyclerView mRecycleview;
    NavController navController;
    Icontroller controller;
    List<infor> inforList;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        addView(view);
        addEvent();
        getdata();
        return view;

    }

    private void addEvent() {

    }
    private void getdata() {
        inforList = controller.GetAllInfo();
        infoAdapter adapter =new infoAdapter(inforList);
        // set cho recycle
        mRecycleview.setLayoutManager(new LinearLayoutManager(SecondFragment.this.getActivity()));
        mRecycleview.setAdapter(adapter);
    }
    private void addView(View view) {
        mRecycleview = view.findViewById(R.id.recycleview);
        navController= NavHostFragment.findNavController(SecondFragment.this);
        controller = ((MainActivity)getActivity()).controller;
    }

    private class inforViewHolder extends RecyclerView.ViewHolder
    {

        TextView txthienthi;

        public inforViewHolder(@NonNull View itemView) {
            super(itemView);
            txthienthi = itemView.findViewById(R.id.txtinfor);

        }

        public void bind(infor p)
        {
            txthienthi.setText(p.getDate() + "\n" + p.getTien()
                    +"\n Mua vao: " + p.getMua() + "    Ban ra: " + p.getBan() + "\n");
        }
    }

    private class infoAdapter extends RecyclerView.Adapter<inforViewHolder>
    {
        List<infor> listinfos;

        public infoAdapter(List<infor> listProducts) {
            this.listinfos = listProducts;
        }


        @NonNull
        @Override
        public SecondFragment.inforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.info, parent, false);
            return new inforViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull SecondFragment.inforViewHolder holder, int position) {
            holder.bind(listinfos.get(position));
        }

        @Override
        public int getItemCount() {
            return listinfos.size();
        }
    }
}

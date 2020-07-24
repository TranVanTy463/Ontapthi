package vn.edu.ntu.ontapthi.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.ontapthi.model.infor;

public class controller extends Application implements Icontroller {
    List<infor> inforList = new ArrayList<>();

    public controller() {
      inforList.add(new infor("07/11/2020","USD","1300000","500000"));
        inforList.add(new infor("07/11/2020","USD","1300000","500000"));
        inforList.add(new infor("07/11/2020","USD","1300000","500000"));
        inforList.add(new infor("07/11/2020","USD","1300000","500000"));
    }

    @Override
    public List<infor> GetAllInfo() {
        return inforList ;
    }

    @Override
    public boolean addinfor(infor infor) {
        //return false;
        if(this.inforList.contains(infor))
            return false;
        this.inforList.add(infor);
        return true;

    }
}

package vn.edu.ntu.ontapthi.controller;

import java.util.List;

import vn.edu.ntu.ontapthi.model.infor;

public interface Icontroller {

    public List<infor> GetAllInfo();
   public boolean  addinfor(infor infor);
}

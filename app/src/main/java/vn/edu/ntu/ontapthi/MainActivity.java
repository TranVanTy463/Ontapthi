package vn.edu.ntu.ontapthi;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import vn.edu.ntu.ontapthi.controller.Icontroller;
import vn.edu.ntu.ontapthi.controller.controller;

public class MainActivity extends AppCompatActivity {
    NavController   navController;
    Icontroller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new controller();


    }
}

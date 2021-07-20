package com.poly.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.poly.demo.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // ViewModel - Luu
    // Activity - Fragment

    MyViewModel myViewModel;
    TextView tvText;

    public TextView getTvText() {
        return tvText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User();
        activityMainBinding.setUser(user);

        myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);


        myViewModel.setName("Huy Nguyen");
        tvText = findViewById(R.id.text);
        tvText.setText(myViewModel.getName());
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("AAAAA", "VVVVV");
                myViewModel.setCount(new Random().nextInt());
            }
        });

        myViewModel.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e("CCBCBCB", "VBVBV");
                TextView tv = findViewById(R.id.text);
                tv.setText(integer.toString());

            }
        });


    }


}
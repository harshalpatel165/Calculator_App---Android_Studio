package com.example.calculatorprojectandroidstudio;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    public Calculator() {
        super(R.layout.activity_calculator);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.flFragment,basicFragment,null);
        ft.commit();
    }


    BasicFragment basicFragment = new BasicFragment();
    AdvancedFragment advancedFragment = new AdvancedFragment();


    public void basicButtonOnClick(View view) {
        if(view==findViewById(R.id.basicFragButton)){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.flFragment,basicFragment,null);
            ft.commit();
        }
    }
    public void advancedButtonOnClick(View view) {
        if(view==findViewById(R.id.advancedFragButton)) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction().replace(R.id.flFragment, advancedFragment, null);
            ft.commit();
        }
    }

}
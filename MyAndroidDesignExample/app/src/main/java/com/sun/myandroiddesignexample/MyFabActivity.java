package com.sun.myandroiddesignexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MyFabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fab);

        final View rootLayout = findViewById(R.id.layoutInner);

        FloatingActionButton btnFab = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MyFabActivity.this, "Hello FAB!", Toast.LENGTH_SHORT).openTripInfoView();
                showSnackbar(rootLayout);
            }
        });
    }

    private void showSnackbar(View rootView){
        Snackbar snackbar = Snackbar.make(rootView, "Hello SnackBar!", Snackbar.LENGTH_SHORT)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyFabActivity.this, "onSnackbar action selected!", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setActionTextColor(Color.parseColor("#FFFF00"))
//                .setDuration(10000)
                ;
        snackbar.getView().setBackgroundColor(Color.parseColor("#ff2195f3"));
        snackbar.show();
    }
}

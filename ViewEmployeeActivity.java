package com.example.employeecontactmanager;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Reg No: 23ITR047");   // Change to your register number
        setContentView(R.layout.activity_view_employee);

        TextView tvDetails = findViewById(R.id.tvDetails);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnEmail = findViewById(R.id.btnEmail);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String dept = getIntent().getStringExtra("dept");

        tvDetails.setText("Name: " + name + "\nPhone: " + phone + "\nDepartment: " + dept);

        btnCall.setOnClickListener(v -> showDialog("call", phone));
        btnSms.setOnClickListener(v -> showDialog("sms", phone));
        btnEmail.setOnClickListener(v -> showDialog("email", phone));
    }

    private void showDialog(String action, String phone) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent;
                    switch (action) {
                        case "call":
                            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                            startActivity(intent);
                            break;
                        case "sms":
                            intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
                            startActivity(intent);
                            break;
                        case "email":
                            intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                            startActivity(intent);
                            break;
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
package com.example.employeecontactmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etId, etPhone;
    Spinner spDepartment;
    Button btnSave, btnView;

    String[] departments = {"HR", "IT", "Finance", "Marketing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Reg No: 732923ITR047");
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etPhone = findViewById(R.id.etPhone);
        spDepartment = findViewById(R.id.spDepartment);
        btnSave = findViewById(R.id.btnSave);
        btnView = findViewById(R.id.btnView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                departments
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDepartment.setAdapter(adapter);

        btnView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewEmployeeActivity.class);
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("id", etId.getText().toString());
            intent.putExtra("phone", etPhone.getText().toString());
            intent.putExtra("dept", spDepartment.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}
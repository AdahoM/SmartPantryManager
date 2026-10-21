package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditActivity extends AppCompatActivity {
    EditText etName, etQuantity, etUnit, etExpiry;
    Button btnSave;
    DatabaseHelper db;
    int editId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        db = new DatabaseHelper(this);
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        etUnit = findViewById(R.id.etUnit);
        etExpiry = findViewById(R.id.etExpiry);
        btnSave = findViewById(R.id.btnSave);

        if(getIntent().hasExtra("EDIT_ID")){
            editId = getIntent().getIntExtra("EDIT_ID", -1);
            PantryItem item = db.getPantryItemById(editId);
            if(item!=null){
                etName.setText(item.getName());
                etQuantity.setText(item.getQuantity());
                etUnit.setText(item.getUnit());
                etExpiry.setText(String.valueOf(item.getExpiry()));
            }
        }

        btnSave.setOnClickListener(v->{
            String name = etName.getText().toString().trim();
            String qty = etQuantity.getText().toString().trim();
            String unit = etUnit.getText().toString().trim();
            String expStr = etExpiry.getText().toString().trim();
            if(name.isEmpty()){ etName.setError("Required"); return; }
            if(qty.isEmpty()){ etQuantity.setError("Required"); return; }
            if(expStr.isEmpty()){ etExpiry.setError("Required"); return; }
            int exp = Integer.parseInt(expStr);
            PantryItem item = new PantryItem(name, qty, unit, exp);
            if(editId==-1){
                db.addPantryItem(item);
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
            } else {
                item.setId(editId);
                db.updatePantryItem(item);
                Toast.makeText(this, "Item Updated", Toast.LENGTH_SHORT).show();
            }
            finish();
        });
    }
}

package com.example.sqlcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private Button btnXoa;
    private Button btnSua;
    private EditText edtID;
    private EditText edtName;
    private EditText edtToan;
    private EditText edtLi;
    private EditText edtHoa;
    private  MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initListener();
        intview();
    }



    private void initListener() {
        btnThem = findViewById(R.id.btn_them);
        btnSua = findViewById(R.id.btn_sua);
        btnXoa = findViewById(R.id.btn_xoa);
        edtID = findViewById(R.id.edit_id);
        edtName = findViewById(R.id.edit_name);
        edtToan = findViewById(R.id.edit_toan);
        edtLi = findViewById(R.id.edit_li);
        edtHoa = findViewById(R.id.edit_hoa);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String toan = edtToan.getText().toString();
                String li = edtLi.getText().toString();
                String hoa = edtHoa.getText().toString();
                boolean bl=myDatabase.insertData(name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Chèn thành công!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Không thành công!",Toast.LENGTH_SHORT).show();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                String name = edtName.getText().toString();
                String toan = edtToan.getText().toString();
                String li = edtLi.getText().toString();
                String hoa = edtHoa.getText().toString();
                boolean bl=myDatabase.updateData(id,name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Sửa thành công!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Sửa Không thành công!",Toast.LENGTH_SHORT).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                boolean bl = myDatabase.deleteData(id);
                if(bl){
                    Toast.makeText(MainActivity.this,"Xóa thành công!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Xóa Không thành công!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void intview() {
    }
}
package com.example.secondlessonhwthirdmonth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextTitle, editTextSms;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.edit_text_email);
        editTextTitle = findViewById(R.id.edit_text_line);
        editTextSms = findViewById(R.id.edit_text_sms);
        buttonSend = findViewById(R.id.btn_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextEmail.getText().toString().isEmpty() && !editTextTitle.getText().toString().isEmpty()
                    && !editTextSms.getText().toString().isEmpty()) {

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(editTextEmail)});
                    intent.putExtra(Intent.EXTRA_SUBJECT, editTextTitle.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, editTextSms.getText().toString());

                    intent.setType("text/plain");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Нет программы.",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Заполни все поля",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
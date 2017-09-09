package com.example.administrator.demo0906;

import android.app.AppOpsManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                final View view =inflater.inflate(R.layout.login_dialog,null);

                builder.setView(view)
                        .setTitle("login")
                        .setPositiveButton("login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText editText= (EditText) view.findViewById(R.id.editText);
                                EditText editText2= (EditText) view.findViewById(R.id.editText2);
                                String str1=editText.getText().toString();
                                String str2=editText2.getText().toString();
                                String id=new String("abc");
                                String password=new String("123");

                                if(str1.equals(id) && str2.equals(password) )
                                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("cencel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                builder.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("dialog").setTitle("dialog");

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"按下确认按钮",Toast.LENGTH_LONG).show();

                    }
                })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消按钮",Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.settings:
                Toast.makeText(this, "settings",Toast.LENGTH_SHORT).show();
            case R.id.another:
                Toast.makeText(this, "another",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}

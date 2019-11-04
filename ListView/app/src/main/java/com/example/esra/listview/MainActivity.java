package com.example.esra.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] ulkeler={"ABD","ALMANYA","TÜRKİYE","JAPONYA","ÇİN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listemiz = (ListView) findViewById(R.id.liste);

        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler);


        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder dialogOlusturucu = new AlertDialog.Builder(MainActivity.this);
                dialogOlusturucu.setMessage(ulkeler[position]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });
                dialogOlusturucu.create().show();
            }
        });
    }
}

package com.santirodriguezlorenzo.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private LinearLayout viewSend;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        viewSend = (LinearLayout) findViewById(R.id.view_send);
        btnSend = (Button) findViewById(R.id.btn_send);

        viewSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString();
                if(!result.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    //el putExtra sirve para en un Intent pasar algun parametro a la siguiente pantalla
                    //la primera variable es la clave con la que se recuperara el valor, la segunda variable es el valor
                    intent.putExtra("texto", result);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, getText(R.string.edit_text_empty), Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString();
                if(!result.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    //el putExtra sirve para en un Intent pasar algun parametro a la siguiente pantalla
                    //la primera variable es la clave con la que se recuperara el valor, la segunda variable es el valor
                    intent.putExtra("texto", result);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

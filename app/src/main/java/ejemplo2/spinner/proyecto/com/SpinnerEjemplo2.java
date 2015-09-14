package ejemplo2.spinner.proyecto.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerEjemplo2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
    //Estos atributos representan la posición y selección actual del Spinner

    protected int position;
    protected String selection;

    //ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
    protected ArrayAdapter<CharSequence> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ejemplo2);

        //Obtener instancia del GameSpinner
        Spinner spinner = (Spinner) findViewById(R.id.GameSpinner);

        //Asignas el origen de datos desde los recursos
        adapter = ArrayAdapter.createFromResource(this,R.array.Games,android.R.layout.simple_spinner_item);

        //Asignas el layout a inflar para cada elemento
        //al momento de desplegar la lista
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Seteas el adaptador
        spinner.setAdapter(adapter);

        //Asignado la escucha
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spinner_ejemplo2, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //Salvar la posición y valor del item actual
        this.position = position;
        selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner

        Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

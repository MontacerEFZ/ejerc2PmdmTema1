package montacer.elfazazi.ejerc2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import montacer.elfazazi.ejerc2.modelos.Coche;

public class MainActivity extends AppCompatActivity {

    private EditText txtCoche;
    private EditText txtMoto;
    private EditText txtBici;
    private TextView lbCoche;
    private TextView lbMoto;
    private TextView lbBici;
    private Button btnCoche;
    private Button btnMoto;
    private Button btnBici;


    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVista();
       // inicializarLauncher();

        btnCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocheActivity.class);
                launcherCoches.launch(intent);
            }
        });
    }

    private void iniciarVista() {
        txtCoche = findViewById(R.id.txtCochesMain);
        txtCoche.setText(0);

        txtMoto = findViewById(R.id.txtMotosMain);
        txtMoto.setText(0);

        txtBici = findViewById(R.id.txtBicisMain);
        txtBici.setText(0);

        btnCoche = findViewById(R.id.btnCrearCocheMain);
        btnMoto = findViewById(R.id.btnCrearMotoMain);
        btnBici = findViewById(R.id.btnCrearBiciMain);

        lbCoche = findViewById(R.id.labelCochesMain);
        lbMoto = findViewById(R.id.labelMotosMain);
        lbBici = findViewById(R.id.labelBicisMain);
    }

    private void inicializarLauncher() {
        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null){
                                Bundle bundle = result.getData().getExtras();
                            }
                        }
                //HACER LA CLASE COCHEACTIVITY COMO LA DE CREARDIRECCIONACTIVITY
                        //Y TERMINAR EL LAUNCHER DE AQUI DEL MAIN
                    }
                }
        );

    }
}
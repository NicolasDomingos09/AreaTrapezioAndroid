/*
 * @author: Nicolas Domingos
 */
package br.edu.fateczl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private TextView tvArea;
    private TextView tvResultado;
    private Button bCalcular;
    private Button bLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etAltura = findViewById(R.id.etAltura);
        tvArea = findViewById(R.id.tvArea);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        bCalcular = findViewById(R.id.bCalcular);
        bLimpar = findViewById(R.id.bLimpar);

        bCalcular.setOnClickListener(click -> calcularArea());
        bLimpar.setOnClickListener(click -> limparTela());
    }

    private void limparTela() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void calcularArea() {
        int baseMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int baseMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int altura = Integer.parseInt(etAltura.getText().toString());

        int area = ((baseMaior + baseMenor)*altura)/2;

        tvResultado.setText(String.valueOf(area));
        tvResultado.setVisibility(TextView.VISIBLE);
    }
}
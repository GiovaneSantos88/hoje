package solicitacaoferias.etechoracio.com.br;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import solicitacaoferias.etechoracio.com.br.Utils.DateTimeUtils;

public class SolicitacaoActivity extends AppCompatActivity {
    private RadioGroup getRadio;
    private RadioButton radioSim;
    private RadioButton radioNao;
    private Button btnData;
    private Spinner spnQtde;
    private EditText editFim;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

       this.radioNao = findViewById(R.id.radioNao);
       this.radioSim = findViewById(R.id.radioSim);
        btnData = findViewById(R.id.btnData);
        spnQtde = findViewById(R.id.spnQtde);
        editFim = findViewById(R.id.editFim);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        spnQtde = (Spinner) findViewById(R.id.spnQtde);
        spnQtde.setAdapter(radioSim());
    }

    // condição do radio btn//
    private ArrayAdapter radioSim(){
        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(20, 30));
    }
    private ArrayAdapter radioNao(){
        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(10,15,20,30));
    }

    public void OnRadioClick(View view) {
        if (view.getId() == R.id.radioSim)
        {
            spnQtde.setAdapter(radioSim());
        }
        else
        {
            spnQtde.setAdapter(radioNao());
        }
    }

    //calcular a data inicio//
    public Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.btnData:
                return new DatePickerDialog(this, dataInicio, ano, mes, dia);

        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener dataInicio = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia)
        {

            btnData.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));
        }


    };
    public void onSelecionarData(View v)
    {
        showDialog(v.getId());
    }

    public void OnBtnRegistrar(View view)
    {
        Date data = DateTimeUtils.toDate(btnData.getText().toString());

        if (!DateTimeUtils.isSegundaFeira(data)){
            Toast toast = Toast.makeText(this, "Data informada não é segunda-feira", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}






package mx.edu.uttt.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double valor1 = 0, valor2 = 0;

    private TextView txtResult, txtOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        txtOperation = findViewById(R.id.txtOperation);
    }
    public void onClick(View view){
        Button button = (Button)view;
        if("0123456789".contains(button.getText())){
            String number = String.valueOf(button.getText());
            txtResult.setText(txtResult.getText()+number);
        }
        if(".".contains(String.valueOf(button.getText()))){
            if(String.valueOf(txtResult.getText()).contains(".")){
                txtResult.setText(txtResult.getText());
            }else{
                String number = String.valueOf(button.getText());
                txtResult.setText(txtResult.getText()+number);
            }
        }
        if("+-/*".contains(button.getText())){
            txtOperation.setText(String.valueOf(button.getText()));
            valor1 = Double.valueOf(String.valueOf(txtResult.getText()));
            txtResult.setText("");
        }
        if("=".contains(button.getText())){
            valor2 = Double.valueOf(String.valueOf(txtResult.getText()));
            switch(String.valueOf(txtOperation.getText())){
                case "+":
                    txtResult.setText(String.valueOf(valor1+valor2));
                    break;
                case "-":
                    txtResult.setText(String.valueOf(valor1-valor2));
                    break;
                case "*":
                    txtResult.setText(String.valueOf(valor1*valor2));
                    break;
                case "/":
                    txtResult.setText(String.valueOf(valor1/valor2));
                    break;
            }
        }
        if("C".contains(button.getText())){
            txtResult.setText("");
            txtOperation.setText("");
        }
    }
}
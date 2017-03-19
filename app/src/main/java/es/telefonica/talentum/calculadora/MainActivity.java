package es.telefonica.talentum.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.telefonica.talentum.calculadora.model.Calculator;

import static es.telefonica.talentum.calculadora.model.CalculatorOperation.ADD;
import static es.telefonica.talentum.calculadora.model.CalculatorOperation.DIVIDE;
import static es.telefonica.talentum.calculadora.model.CalculatorOperation.MULTIPLY;
import static es.telefonica.talentum.calculadora.model.CalculatorOperation.SUBTRACT;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_button_zero) Button mainButtonZero;
    @BindView(R.id.activity_main_button_one) Button mainButtonOne;
    @BindView(R.id.activity_main_button_two) Button mainButtonTwo;
    @BindView(R.id.activity_main_button_three) Button mainButtonThree;
    @BindView(R.id.activity_main_button_four) Button mainButtonFour;
    @BindView(R.id.activity_main_button_five) Button mainButtonFive;
    @BindView(R.id.activity_main_button_six) Button mainButtonSix;
    @BindView(R.id.activity_main_button_seven) Button mainButtonSeven;
    @BindView(R.id.activity_main_button_eight) Button mainButtonEight;
    @BindView(R.id.activity_main_button_nine) Button mainButtonNine;

    @BindView(R.id.activity_main_button_add) Button mainButtonAdd;
    @BindView(R.id.activity_main_button_subtract) Button mainButtonSubtract;
    @BindView(R.id.activity_main_button_multiply) Button mainButtonMultiply;
    @BindView(R.id.activity_main_button_divide) Button mainButtonDivide;
    @BindView(R.id.activity_main_button_ce) Button mainButtonCE;
    @BindView(R.id.activity_main_button_calculate) Button mainButtonCalculate;
    @BindView(R.id.activity_main_button_point) Button mainButtonPoint;

    @BindView(R.id.activity_main_button_in_memory) Button mainButtonInMemory;
    @BindView(R.id.activity_main_button_out_memory) Button mainButtonOutMemory;
    @BindView(R.id.activity_main_text_result)TextView mainTextResult;
    @BindView(R.id.activity_main_button_delete) ImageButton mainImageButtonDelete;
    // @BindView(R.id.activity_main_button_vat) Button mainButtonVat;
    Button mainButtonVat;

    float mem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);     // intenta buscar el boton de vat, pero no existe. si la pantalla es menor de 820. No se puede usar el BindView

        mainButtonVat = (Button) findViewById(R.id.activity_main_button_vat);
        final Calculator calculadora = new Calculator(); // Cuando se sale de onCreate, calculadora desaparece. Necesario tipo final
        calculadora.clear();

        Button[] arrayButtons = {mainButtonZero, mainButtonOne, mainButtonTwo, mainButtonThree, mainButtonFour, mainButtonFive, mainButtonSix, mainButtonSeven, mainButtonEight, mainButtonNine, mainButtonPoint};
        for (final Button b: arrayButtons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addDigit(b.getText().toString());
                }
            });
        }

/*        mainButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("1");
            }
        });

        mainButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("2");
            }
        });

        mainButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("3");
            }
        });
        mainButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("4");
            }
        });

        mainButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("5");
            }
        });

        mainButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("6");
            }
        });

        mainButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("7");
            }
        });

        mainButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("8");
            }
        });

        mainButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("9");
            }
        });

        mainButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(".");
            }
        });*/

        mainButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora.setNum1(Float.parseFloat(mainTextResult.getText().toString()));
                calculadora.setOperation(ADD);
                mainTextResult.setText("0");
            }
        });

        mainButtonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora.setNum1(Float.parseFloat(mainTextResult.getText().toString()));
                calculadora.setOperation(SUBTRACT);
                mainTextResult.setText("0");
            }
        });

        mainButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora.setNum1(Float.parseFloat(mainTextResult.getText().toString()));
                calculadora.setOperation(MULTIPLY);
                mainTextResult.setText("0");
            }
        });

        mainButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora.setNum1(Float.parseFloat(mainTextResult.getText().toString()));
                calculadora.setOperation(DIVIDE);
                mainTextResult.setText("0");
            }
        });

        mainButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainTextResult.getText().toString().equals("")) {
                    // TODO completar para que no pete
                } else {

                }
                calculadora.setNum2(Float.parseFloat(mainTextResult.getText().toString()));
                System.out.println(calculadora.getNum1());
                System.out.println(calculadora.getNum2());
                float result = calculadora.calculate(calculadora.getNum1(),calculadora.getNum2(),calculadora.getOperation());
                mainTextResult.setText("" + result);
                calculadora.setNum1(result);
            }
        });

        mainButtonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora.clear();
                mainTextResult.setText("");
            }
        });

        mainButtonInMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem = Float.parseFloat(mainTextResult.getText().toString());
                mainTextResult.setText("");
                calculadora.setNum1(mem);
            }
        });

        mainButtonOutMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextResult.setText("" + calculadora.getNum1());
            }
        });
        if(mainButtonVat != null) {
            mainButtonVat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculadora.setNum1(Float.parseFloat(mainTextResult.getText().toString()));
                    mainTextResult.setText("" + calculadora.getNum1());
                }
            });
        }

        mainImageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mainTextResult.getText().toString();
                if(str.length() != 0) {
                    String subStr = str.substring(0, str.length() - 1);
                    mainTextResult.setText(subStr);
                }
                if(str.length() == 1) {
                    mainTextResult.setText("0");
                }
            }
        });
    }
    private void addDigit(String digit) {
        String currentNumberText = mainTextResult.getText().toString();

        if(currentNumberText.equals("0")) {
            currentNumberText = digit;
        } else {
            currentNumberText = currentNumberText + digit;
        }
        mainTextResult.setText(currentNumberText);
        //mainTextResult.setText(mainTextResult.getText() + digit);
    }
}

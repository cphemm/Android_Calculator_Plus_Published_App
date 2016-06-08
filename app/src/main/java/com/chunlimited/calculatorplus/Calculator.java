package com.chunlimited.calculatorplus;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity {

    private final int MENUITEM_CLOSE = 300;

    private EditText calculateInput = null;

    private Button piButton = null;
    private Button sinButton = null;
    private Button cosButton = null;
    private Button tanButton = null;
    private Button logButton = null;
    private Button eRaisedButton = null;
    private Button numberE = null;

    private Button zeroButton = null;
    private Button oneButton = null;
    private Button twoButton = null;
    private Button threeButton = null;
    private Button fourButton = null;
    private Button fiveButton = null;
    private Button sixButton = null;
    private Button sevenButton = null;
    private Button eightButton = null;
    private Button nineButton = null;

    private Button backspaceButton = null;
    private Button minusButton = null;
    private Button plusMinusButton = null;
    private Button multiplyButton = null;
    private Button divideButton = null;
    private Button plusButton = null;

    private Button cubeButton = null;
    private Button exponentButton = null;
    private Button sqrRootButton = null;

    private Button clearButton = null;

    private Button decimalPointButton = null;

    private Button mmButton = null;
    private Button mcButton = null;
    private Button mrButton = null;
    private Button mplusButton = null;

    private Button equalsButton = null;


    private Button percentButton = null;


    private boolean readyToClear = false;
    private double memoryNumber = 0;
    private int operator = 1;
    private boolean hasChanged = false;
    private double number = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        setUpReferences();
        initializeScreenLayout();
        reset();

    }

    private void setUpReferences() {
        calculateInput = (EditText) findViewById(R.id.calculateInput);
        piButton = (Button) findViewById(R.id.piButton);
        sinButton = (Button) findViewById(R.id.sinButton);
        cosButton = (Button) findViewById(R.id.cosButton);
        tanButton = (Button) findViewById(R.id.tanButton);
        logButton = (Button) findViewById(R.id.logButton);
        eRaisedButton = (Button) findViewById(R.id.eRaisedButton);
        numberE = (Button) findViewById(R.id.numberE);

        zeroButton = (Button) findViewById(R.id.zeroButton);
        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        decimalPointButton = (Button) findViewById(R.id.decimalPointButton);

        sqrRootButton = (Button) findViewById(R.id.sqrRootButton);
        plusMinusButton = (Button) findViewById(R.id.plusMinusButton);
        cubeButton = (Button) findViewById(R.id.cubeButton);
        exponentButton = (Button) findViewById(R.id.exponentButton);

        mcButton = (Button) findViewById(R.id.mcButton);
        mrButton = (Button) findViewById(R.id.mrButton);
        mmButton = (Button) findViewById(R.id.mmButton);
        mplusButton = (Button) findViewById(R.id.mplusButton);
        backspaceButton = (Button) findViewById(R.id.backspaceButton);
        percentButton = (Button) findViewById(R.id.percentButton);

        piButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(12);
            }
        });

        sinButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(7);
            }
        });

        cosButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(8);
            }
        });

        tanButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(9);
            }
        });

        logButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(10);
            }
        });

        eRaisedButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(11);
            }
        });

        numberE.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(13);
            }
        });

        zeroButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(0);
            }
        });

        cubeButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(Math.cbrt(Double.parseDouble(calculateInput
                        .getText().toString()))));
            }
        });

        exponentButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(6);
            }
        });

        oneButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(1);
            }
        });

        twoButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(2);
            }
        });

        threeButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(3);
            }
        });

        fourButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(4);
            }
        });

        fiveButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(5);
            }
        });

        sixButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(6);
            }
        });
        sevenButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(7);
            }
        });

        eightButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(8);
            }
        });

        nineButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                testNumber(9);
            }
        });

        plusButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(1);
            }
        });

        minusButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(2);
            }
        });

        multiplyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(3);
            }
        });

        divideButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(4);
            }
        });

        equalsButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                calculateNumbers(0);
            }
        });

        clearButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });

        decimalPointButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setUpDecimal();
            }
        });

        plusMinusButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setUpPlusMinus();
            }
        });

        mcButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memoryNumber = 0;
            }
        });

        mrButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(memoryNumber));
            }
        });

        mmButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memoryNumber = memoryNumber
                        - Double.parseDouble(calculateInput.getText().toString());
                operator = 0;
            }
        });

        mplusButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                memoryNumber = memoryNumber
                        + Double.parseDouble(calculateInput.getText().toString());
                operator = 0;
            }
        });

        backspaceButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setUpBackspace();
            }
        });

        sqrRootButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(Math.sqrt(Double.parseDouble(calculateInput
                        .getText().toString()))));
            }
        });

        percentButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue(Double.toString(number
                        * (0.01 * Double.parseDouble(calculateInput.getText()
                        .toString()))));
            }
        });

        calculateInput.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int i, android.view.KeyEvent e) {
                if (e.getAction() == KeyEvent.ACTION_DOWN) {
                    int keyCode = e.getKeyCode();

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_0:
                            testNumber(0);
                            break;

                        case KeyEvent.KEYCODE_1:
                            testNumber(1);
                            break;

                        case KeyEvent.KEYCODE_2:
                            testNumber(2);
                            break;

                        case KeyEvent.KEYCODE_3:
                            testNumber(3);
                            break;

                        case KeyEvent.KEYCODE_4:
                            testNumber(4);
                            break;

                        case KeyEvent.KEYCODE_5:
                            testNumber(5);
                            break;

                        case KeyEvent.KEYCODE_6:
                            testNumber(6);
                            break;

                        case KeyEvent.KEYCODE_7:
                            testNumber(7);
                            break;

                        case KeyEvent.KEYCODE_8:
                            testNumber(8);
                            break;

                        case KeyEvent.KEYCODE_9:
                            testNumber(9);
                            break;

                        case 43:
                            calculateNumbers(1);
                            break;

                        case KeyEvent.KEYCODE_EQUALS:
                            calculateNumbers(0);
                            break;

                        case KeyEvent.KEYCODE_MINUS:
                            calculateNumbers(2);
                            break;

                        case KeyEvent.KEYCODE_PERIOD:
                            setUpDecimal();
                            break;

                        case KeyEvent.KEYCODE_C:
                            reset();
                            break;

                        case KeyEvent.KEYCODE_SLASH:
                            calculateNumbers(4);
                            break;

                        case KeyEvent.KEYCODE_DPAD_DOWN:
                            return false;
                    }
                }

                return true;
            }
        });
    }

    private void initializeScreenLayout() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int height = dm.heightPixels;
        int width = dm.widthPixels;

        if (height < 400 || width < 300) {
            calculateInput.setTextSize(20);
        }

        calculateInput.setKeyListener(null);

    }

    private void setUpBackspace() {
        if (!readyToClear) {
            String text = calculateInput.getText().toString();
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
                if (text.equals(""))
                    text = "0";

                calculateInput.setText(text);
                calculateInput.setSelection(text.length());
            }
        }
    }

    private void setUpPlusMinus() {
        if (!readyToClear) {
            String text = calculateInput.getText().toString();
            if (!text.equals("0")) {
                if (text.charAt(0) == '-')
                    text = text.substring(1, text.length());
                else
                    text = "-" + text;

                calculateInput.setText(text);
                calculateInput.setSelection(text.length());
            }
        }
    }

    private void calculateNumbers(int newOperator) {
        if (hasChanged) {
            switch (operator) {
                case 1:
                    number = number + Double.parseDouble(calculateInput.getText().toString());
                    break;
                case 2:
                    number = number - Double.parseDouble(calculateInput.getText().toString());
                    break;
                case 3:
                    number = number * Double.parseDouble(calculateInput.getText().toString());
                    break;
                case 4:
                    number = number / Double.parseDouble(calculateInput.getText().toString());
                    break;
                case 5:
                    number = Math.pow(number, 2);
                    break;
                case 6:
                    number = Math.pow(number,
                            Double.parseDouble(calculateInput.getText().toString()));
                    break;
                case 7:
                    number = number
                            + Math.sin(Double.parseDouble(calculateInput.getText()
                            .toString()));
                    break;
                case 8:
                    number = number
                            + Math.cos(Double.parseDouble(calculateInput.getText()
                            .toString()));
                    break;
                case 9:
                    number = number
                            + Math.tan(Double.parseDouble(calculateInput.getText()
                            .toString()));
                    break;
                case 10:
                    number = Math
                            .log(Double.parseDouble(calculateInput.getText().toString()));
                    break;
                case 11:
                    double loge = Math.log(Double.parseDouble(calculateInput.getText()
                            .toString()));
                    number = Math.exp(loge);
                    break;
                case 12:
                    number = Math.PI;
                    break;
                case 13:
                    number = Math.E;
                    break;
            }

            String txt = Double.toString(number);
            calculateInput.setText(txt);
            calculateInput.setSelection(txt.length());

            readyToClear = true;
            hasChanged = false;
        }

        operator = newOperator;
    }


    private void testNumber(int number) {
        if (operator == 0)
            reset();

        String text = calculateInput.getText().toString();
        if (readyToClear) {
            text = "";
            readyToClear = false;
        } else if (text.equals("0"))
            text = "";

        text = text + Integer.toString(number);

        calculateInput.setText(text);
        calculateInput.setKeyListener(null);
        calculateInput.setSelection(text.length());

        hasChanged = true;
    }

    private void setValue(String value) {
        if (operator == 0)
            reset();

        if (readyToClear) {
            readyToClear = false;
        }

        calculateInput.setText(value);
        calculateInput.setSelection(value.length());

        hasChanged = true;
    }

    private void setUpDecimal() {
        if (operator == 0)
            reset();

        if (readyToClear) {
            calculateInput.setText("0.");
            calculateInput.setSelection(2);
            readyToClear = false;
            hasChanged = true;
        } else {
            String text = calculateInput.getText().toString();

            if (!text.contains(".")) {
                calculateInput.append(".");
                hasChanged = true;
            }
        }
    }

    private void reset() {
        number = 0;
        calculateInput.setText("0");
        calculateInput.setSelection(1);
        operator = 1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, MENUITEM_CLOSE, "Close");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENUITEM_CLOSE:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
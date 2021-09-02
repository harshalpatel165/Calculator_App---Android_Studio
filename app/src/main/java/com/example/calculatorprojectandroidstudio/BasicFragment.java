package com.example.calculatorprojectandroidstudio;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */

public class BasicFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BasicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BasicFragment newInstance(String param1, String param2) {
        BasicFragment fragment = new BasicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BasicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private void updateText(String str, EditText textView1){
        String currStr = textView1.getText().toString();
        int cursorPos = textView1.getSelectionStart();
        String leftStr = currStr.substring(0, cursorPos);
        String rightStr = currStr.substring(cursorPos);
        textView1.setText(String.format("%s%s%s",leftStr,str,rightStr));
        textView1.setSelection(cursorPos+str.length());

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_basic, container, false);
        Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSubtract,
                buttonMultiply, buttonDivide, buttonEqual, buttonDecimal, buttonPercent, buttonNegative, buttonPar, buttonClear;
        ImageButton buttonUndo;

        button0 = (Button) view.findViewById(R.id.button0);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        button6 = (Button) view.findViewById(R.id.button6);
        button7 = (Button) view.findViewById(R.id.button7);
        button8 = (Button) view.findViewById(R.id.button8);
        button9 = (Button) view.findViewById(R.id.button9);
        buttonDecimal = (Button) view.findViewById(R.id.buttonDecimal);
        buttonAdd = (Button) view.findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) view.findViewById(R.id.buttonSubtract);
        buttonMultiply = (Button) view.findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) view.findViewById(R.id.buttonDivide);
        buttonPercent = (Button) view.findViewById(R.id.buttonPercent);
        buttonNegative = (Button) view.findViewById(R.id.buttonNegative);
        buttonEqual = (Button) view.findViewById(R.id.buttonEqual);
        buttonPar = (Button) view.findViewById(R.id.buttonPar);
        buttonClear = (Button) view.findViewById(R.id.buttonClear);
        buttonUndo = (ImageButton) getActivity().findViewById(R.id.buttonUndo);
        EditText textView1 = (EditText) getActivity().findViewById(R.id.textView);
        textView1.setShowSoftInputOnFocus(false);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("0",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("x0", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("x0", textView1);
                            } else {
                                updateText("0", textView1);
                            }
                    }
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("1",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("x1", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("x1", textView1);
                            } else {
                                updateText("1", textView1);
                            }
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("2",textView1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("3",textView1);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("4",textView1);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("5",textView1);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("6",textView1);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("7",textView1);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("8",textView1);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("9",textView1);
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText(".",textView1);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("+",textView1);
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("-",textView1);
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("x",textView1);
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("/",textView1);
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    Toast.makeText(getActivity(),"Invalid format used",Toast.LENGTH_SHORT).show();
                }else{
                    updateText("%x",textView1);
                }
            }
        });
        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("-",textView1);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =  textView1.getText().toString();
                if(text.length()==0){
                    updateText("",textView1);
                } else {
                    text = text.replaceAll("x","*");
                    text = text.replaceAll("\u03c0","pi");
                    Expression expression = new Expression(text);
                    String ans = String.valueOf(expression.calculate());
                    if(ans.endsWith(".0")){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    textView1.setText(ans);
                    textView1.setSelection(ans.length());
                }
            }
        });
        buttonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPos = textView1.getSelectionStart();
                int openParCnt = 0;
                int closeParCnt = 0;
                int len = textView1.getText().length();
                for(int i = 0; i < cursorPos; i++){
                    if(textView1.getText().toString().charAt(i) == '('){
                        openParCnt+=1;
                    }
                    if(textView1.getText().toString().charAt(i) == ')'){
                        closeParCnt+=1;
                    }
                }
                if(textView1.getText().length()==0){
                    if(openParCnt == closeParCnt || textView1.getText().toString().charAt(len - 1) == '('){
                        updateText("(",textView1);
                    }
                    else if(closeParCnt < openParCnt && textView1.getText().toString().charAt(len - 1) != '('){
                        updateText(")",textView1);
                    }
                } else {
                    if(openParCnt == closeParCnt || textView1.getText().toString().charAt(len - 1) == '('){
                        int cursorPos2 = textView1.getSelectionStart();
                        String currText = textView1.getText().toString();
                        switch (currText.charAt(cursorPos2-1)) {
                            case 'e':
                            case '\u03c0':
                            case '!':
                                updateText("x(",textView1);
                                break;
                            default:
                                if (Character.isDigit(currText.charAt(cursorPos2-1))) {
                                    updateText("x(",textView1);
                                } else{
                                    updateText("(",textView1);
                                }
                        }
                    }
                    else if(closeParCnt < openParCnt && textView1.getText().toString().charAt(len - 1) != '('){
                        updateText(")",textView1);
                    }
                }

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
            }
        });
        buttonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString=textView1.getText().toString();
                int selectionStart=textView1.getSelectionStart();
                int selectionEnd=textView1.getSelectionEnd();
                String selectedText = inputString.substring(selectionStart, selectionEnd);
                if(!selectedText.isEmpty()) {
                    String selectionDeletedString=inputString.replace(selectedText,"");
                    textView1.setText(selectionDeletedString);
                }
                int cursorPos = textView1.getSelectionStart();
                int len = textView1.getText().length();
                if(cursorPos !=0 && len != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) textView1.getText();
                    selection.replace(cursorPos-1,cursorPos,"");
                    textView1.setText(selection);
                    textView1.setSelection(cursorPos-1);
                }
            }
        });
        return view;
    }

}
package com.example.calculatorprojectandroidstudio;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdvancedFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class AdvancedFragment extends Fragment {

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
    public static AdvancedFragment newInstance(String param1, String param2) {
        AdvancedFragment fragment = new AdvancedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AdvancedFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_advanced, container, false);
        Button buttonAbsolute, buttonPi, buttone, buttonXPow, buttonxPow3, button2Powx, buttonePow, buttonCubeRoot, buttonFactorial, buttonLn, buttonSquared, buttonSquareRoot,
                buttonLog, buttonTan, buttonCos, buttonSin, button1OverX, buttonInvTan, buttonInvCos, buttonInvSin;


        buttonAbsolute = (Button) view.findViewById(R.id.buttonAbsolute);
        buttonPi = (Button) view.findViewById(R.id.buttonPi);
        buttone = (Button) view.findViewById(R.id.buttone);
        buttonXPow = (Button) view.findViewById(R.id.buttonXPow);
        buttonxPow3 = (Button) view.findViewById(R.id.buttonxPow3);
        button2Powx = (Button) view.findViewById(R.id.button2Powx);
        buttonePow = (Button) view.findViewById(R.id.buttonePow);
        buttonCubeRoot = (Button) view.findViewById(R.id.buttonCubeRoot);
        buttonFactorial = (Button) view.findViewById(R.id.buttonFactorial);
        buttonLn = (Button) view.findViewById(R.id.buttonLn);
        buttonSquared = (Button) view.findViewById(R.id.buttonSquared);
        buttonSquareRoot = (Button) view.findViewById(R.id.buttonSquareRoot);
        buttonLog = (Button) view.findViewById(R.id.buttonLog);
        buttonTan = (Button) view.findViewById(R.id.buttonTan);
        buttonCos = (Button) view.findViewById(R.id.buttonCos);
        buttonSin = (Button) view.findViewById(R.id.buttonSin);
        button1OverX = (Button) view.findViewById(R.id.button1OverX);
        buttonInvTan = (Button) view.findViewById(R.id.buttonInvTan);
        buttonInvCos = (Button) view.findViewById(R.id.buttonInvCos);
        buttonInvSin = (Button) view.findViewById(R.id.buttonInvSin);

        EditText textView1 = (EditText) getActivity().findViewById(R.id.textView);

        buttonAbsolute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("abs(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xabs(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xabs(", textView1);
                            } else {
                                updateText("abs(", textView1);
                            }
                    }
                }
            }
        });
        buttonPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("\u03c0",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("x\u03c0",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("x\u03c0",textView1);
                            } else{
                                updateText("\u03c0",textView1);
                            }
                    }
                }
            }
        });
        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("e",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xe",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xe",textView1);
                            } else{
                                updateText("e",textView1);
                            }
                    }
                }
            }
        });
        buttonXPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    Toast.makeText(getActivity(),"Invalid format used",Toast.LENGTH_SHORT).show();
                }else{
                    updateText("^(",textView1);
                }
            }
        });
        buttonxPow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    Toast.makeText(getActivity(),"Invalid format used",Toast.LENGTH_SHORT).show();
                }else{
                    updateText("^3",textView1);
                }
            }
        });
        button2Powx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("2^(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("x2^(",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("x2^(",textView1);
                            } else{
                                updateText("2^(",textView1);
                            }
                    }
                }
            }
        });
        buttonePow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("e^(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xe^(",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xe^(",textView1);
                            } else{
                                updateText("e^(",textView1);
                            }
                    }
                }
            }
        });
        buttonCubeRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("root(3,",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xroot(3,",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xroot(3,",textView1);
                            } else{
                                updateText("root(3,",textView1);
                            }
                    }
                }
            }
        });
        buttonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    Toast.makeText(getActivity(),"Invalid format used",Toast.LENGTH_SHORT).show();
                }else{
                    updateText("!",textView1);
                }
            }
        });
        buttonLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("ln(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xln(",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xln(",textView1);
                            } else{
                                updateText("ln(",textView1);
                            }
                    }
                }
            }
        });
        buttonSquared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    Toast.makeText(getActivity(),"Invalid format used",Toast.LENGTH_SHORT).show();
                }else{
                    updateText("^2",textView1);
                }
            }
        });
        buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("sqrt(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xsqrt(",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xsqrt(",textView1);
                            } else{
                                updateText("sqrt(",textView1);
                            }
                    }
                }
            }
        });
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("log10(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos-1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xlog10(",textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos-1))) {
                                updateText("xlog10(",textView1);
                            } else{
                                updateText("log10(",textView1);
                            }
                    }
                }
            }
        });
        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("tan(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xtan(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xtan(", textView1);
                            } else {
                                updateText("tan(", textView1);
                            }
                    }
                }
            }
        });
        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("cos(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xcos(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xcos(", textView1);
                            } else {
                                updateText("cos(", textView1);
                            }
                    }
                }
            }
        });
        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("sin(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xsin(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xsin(", textView1);
                            } else {
                                updateText("sin(", textView1);
                            }
                    }
                }
            }
        });
        button1OverX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("a1/((",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("x1/((", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("x1/((", textView1);
                            } else {
                                updateText("1/((", textView1);
                            }
                    }
                }
            }
        });
        buttonInvTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("atan(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xatan(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xatan(", textView1);
                            } else {
                                updateText("atan(", textView1);
                            }
                    }
                }
            }
        });
        buttonInvCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("acos(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xacos(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xacos(", textView1);
                            } else {
                                updateText("acos(", textView1);
                            }
                    }
                }
            }
        });
        buttonInvSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().length()==0){
                    updateText("asin(",textView1);
                } else {
                    int cursorPos = textView1.getSelectionStart();
                    String currText = textView1.getText().toString();
                    switch (currText.charAt(cursorPos - 1)) {
                        case 'e':
                        case '\u03c0':
                        case '!':
                            updateText("xasin(", textView1);
                            break;
                        default:
                            if (Character.isDigit(currText.charAt(cursorPos - 1))) {
                                updateText("xasin(", textView1);
                            } else {
                                updateText("asin(", textView1);
                            }
                    }
                }
            }
        });

        return view;
    }
}
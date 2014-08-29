package com.example.luisalonso.tabhost;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by luisalonso on 28/08/14.
 */
public class Console extends Fragment {

    private Switch aSwitch;
    private Button input_clear, output_clear, send;
    private EditText input_text;
    private TextView output_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState){
        super.onCreateView(inflater,group,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_console,group,false);
        initComponents(view);
        updateView();
        addListeners();
        return view;
    }

    public void initComponents(View view){
        aSwitch = (Switch)view.findViewById(R.id.a_switch);
        input_clear = (Button)view.findViewById(R.id.clear_input_button);
        input_clear.setEnabled(false);
        output_clear = (Button)view.findViewById(R.id.clear_output_button);
        output_clear.setEnabled(false);
        send = (Button)view.findViewById(R.id.send_input_button);
        send.setEnabled(false);
        input_text = (EditText)view.findViewById(R.id.input_text);
        output_text = (TextView)view.findViewById(R.id.output_text);
    }

    public void addListeners(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateView();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAction();
                updateView();
            }
        });
        input_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!aSwitch.isChecked()){
                    if(s!=null){
                        output_text.setText(s);
                    }
                }
                updateView();
            }
        });
        input_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInput();
                updateView();
            }
        });
        output_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearOutput();
                updateView();
            }
        });
    }

    public void updateView(){
        if(aSwitch.isChecked()){
            send.setEnabled(true);
        }else{
            send.setEnabled(false);
        }
        if(output_text.getText().length()!=0)
            output_clear.setEnabled(true);
        else output_clear.setEnabled(false);
        if(input_text.getText().length()!=0)
            input_clear.setEnabled(true);
        else input_clear.setEnabled(false);
    }

    public void sendAction(){output_text.setText(input_text.getText());}
    public void clearInput(){input_text.setText("");}
    public void clearOutput(){output_text.setText("");}
}
package com.example.tl.hnust;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import tools.Tools;

/**
 * Created by gesangdianzi on 2016/10/25.
 */
public class Login extends Activity implements View.OnClickListener{
    private Button login;
    private EditText editText_admin;
    private EditText editText_password;
    private String admin;
    private String password;
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioGroup rg;
    int grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login=(Button)findViewById(R.id.login);
        editText_admin=(EditText)findViewById(R.id.login_admin) ;
        editText_password=(EditText)findViewById(R.id.login_password);
        a=(RadioButton)findViewById(R.id.a);
        b=(RadioButton)findViewById(R.id.b);
        c=(RadioButton)findViewById(R.id.c);
        rg=(RadioGroup)findViewById(R.id.rg);
        login.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==a.getId()){
                    grade=3;
                }
                if(checkedId==b.getId()){
                    grade=2;
                }
                if(checkedId==c.getId()){
                    grade=1;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        admin=editText_admin.getText().toString();
        password=editText_password.getText().toString();
        if (Tools.loginGrade(admin, password,grade)==0) {
            Toast.makeText(this, "该职务下错误的账号或密码", Toast.LENGTH_SHORT).show();
        }
        else if(Tools.loginGrade(admin, password,grade)==1){
            Intent intent=new Intent(this,PersonList.class);
            startActivity(intent);
        }else{

        }
    }
    }


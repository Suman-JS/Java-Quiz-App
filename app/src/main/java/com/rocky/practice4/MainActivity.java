package com.rocky.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  String[] questions = {"Java is a object oriented programming language ? ",
            "Java was introduced in 1923 ?", "Java has abstract classes ?", "Java supports interfaces ?", "int x[] = new int[]{10,20,30}; Arrays can also be created and initialize as in above statement.", "In an instance method or a constructor, \"this\" is a reference to the current object.","Garbage Collection is manual process.","The JRE deletes objects when it determines that they are no longer being used. This process is called Garbage Collection.","Constructor overloading is not possible in Java.","Assignment operator is evaluated Left to Right.","All binary operators except for the assignment operators are evaluated from Left to Right.","Java programming is not statically-typed, means all variables should not first be declared before they can be used.","In Java SE 7 and later, underscore characters \"_\" can appear anywhere between digits in a numerical literal.","Variable name can begin with a letter, \"$\", or \"_\".",
            "Interfaces can be instantiated.","The modifiers public and static cannot written in either order \"public static\" or \"static public\".","A .class file contains bytecodes?","James Gosling is father of Java?","Java technology is both a programming language and a platform.","The modulus operator (%) in Java can be used only with variables of integer type."};
    private  boolean[] ans = {true, false, true, true,true,true,false,true,false,false,true,false,true,true,false,false,true,true,true,false};
    private int score = 0;
    private int index = 0;
    Button yes;
    Button no;
    TextView question;
    public static final String EXTRA_RESULT = "com.rocky.practice4.extra.result";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        yes = findViewById (R.id.yes);
        no = findViewById (R.id.no);
        question = findViewById (R.id.question);
        question.setText (questions[index]);
        yes.setOnClickListener (v -> {
            if (index <= questions.length - 1) {
                if (ans[index]) {
                    score ++;
                }
                index++;
                if (index <= questions.length - 1) {
                    question.setText (questions[index]);
                }
                else {
                    Toast.makeText (this, "Calculating Result", Toast.LENGTH_SHORT).show ();
                    openActivity ();
                }
            }

        });
        no.setOnClickListener (v -> {
            if (index <= questions.length - 1) {
                if (!ans[index]) {
                    score ++;
                }
                index++;
                if (index <= questions.length - 1) {
                    question.setText (questions[index]);
                }
                else {
                    Toast.makeText (this, "Calculating Result", Toast.LENGTH_SHORT).show ();
                    openActivity ();
                }

            }

        });
    }
    public void openActivity () {
        Intent intent = new Intent (this,MainActivity2.class);
        String result = (score + "/" + questions.length);
        intent.putExtra (EXTRA_RESULT,result);
        startActivity (intent);
    }
}

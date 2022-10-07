package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText gamer = findViewById(R.id.gamer);

        TextView status = findViewById(R.id.status);
        TextView winner = findViewById(R.id.winner);
        TextView name = findViewById(R.id.name);
        TextView mmora = findViewById(R.id.mmora);
        TextView cmora = findViewById(R.id.cmora);

        RadioGroup radioGroup=findViewById(R.id.radioGroup);
        RadioButton scissor = findViewById(R.id.scissor);
        RadioButton rock = findViewById(R.id.rock);
        RadioButton paper= findViewById(R.id.paper);

        Button btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (gamer.length() < 1)
                    status.setText("請輸入玩家姓名");
                else
                {
                    name.setText(String.format("名字\n%s", gamer.getText().toString()));

                    if (scissor.isChecked())
                        mmora.setText("我方出拳\n剪刀");
                    else if (rock.isChecked())
                        mmora.setText("我方出拳\n石頭");
                    else
                        mmora.setText("我方出拳\n布");

                    int computer = (int) (Math.random() * 3);
                    if (computer == 0)
                        cmora.setText("電腦出拳\n剪刀");
                    else if (computer == 1)
                        cmora.setText("電腦出拳\n石頭");
                    else
                        cmora.setText("電腦出拳\n布");

                    if ((scissor.isChecked() && computer == 2) || (rock.isChecked() && computer == 0) || (paper.isChecked() && computer == 1)) {
                        winner.setText("勝利者\n" + gamer.getText().toString());
                        status.setText("恭喜你獲勝了!!!");
                    } else if ((scissor.isChecked() && computer == 1) || (rock.isChecked() && computer == 2) || (paper.isChecked() && computer == 0)) {
                        winner.setText("勝利者\n電腦");
                        status.setText("可惜，電腦獲勝了!");
                    } else
                         {
                        winner.setText("勝利者\n平手");
                        status.setText("平局，請再試一次!");
                         }

                }
            }

        });


    }
}
package Vue;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mesure_glycmie.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConsultActivity extends AppCompatActivity {
        private Button btnReturn;
        private TextView tvReponse;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consult);
            init();
            Intent intent=getIntent();
            String reponse=intent.getStringExtra("reponse");
            tvReponse.setText(reponse);
            btnReturn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent();
                    if(reponse!=null)
                        setResult(RESULT_OK,intent);
                    else
                        setResult(RESULT_CANCELED,intent);
                    finish();
                }
            });
        }
        private void init()
        {
            tvReponse=(TextView) findViewById(R.id.tvReponse);
            btnReturn=(Button) findViewById(R.id.btnReturn);
        }
    }




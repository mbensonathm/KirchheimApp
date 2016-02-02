package com.example.elmedin.kirchheim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ImpressumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impressum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                String[] to = new String[] {"markus.boehmfeld@kirchheim-heimstetten.de"};
                //String[] cc = new String[]{};
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto:"));
                i.setType("text/plain");

                i.putExtra(Intent.EXTRA_EMAIL, to);
                //i.putExtra(Intent.EXTRA_CC, cc);
                i.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                i.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ImpressumActivity.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTextContent();
    }

    private void setTextContent(){
        TextView tView = (TextView) findViewById(R.id.impressumText);
        String title = "Impressum\n";
        String subTitle = "Diese App ist ein Angebot der Gemeinde Kirchheim b. München in Kooperation mit der Hochschule München\n";
        String contactSectionTitle = "\nHerr Böhmfeld\n";
        String contactContent = "Gemeinde Kirchheim b. München, Münchner Str. 6, 85551 Kirchheim b. München\n" +
                "Tel.: 49 (89) 9090932\n" +
                "Fax : 49 (89) 909097532\n" +
                "e-mail: markus.boehmfeld@kirchheim-heimstetten.de\n";
        SpannableString s1 = TextHelper.formatText(1, title);
        SpannableString s2 = TextHelper.formatText(3, subTitle);
        SpannableString s3 = TextHelper.formatText(2, contactSectionTitle);
        SpannableString s4 = TextHelper.formatText(3, contactContent);
        //SpannableStringBuilder()
        tView.setText(TextUtils.concat(s1, s2, s3, s4));
    }

}

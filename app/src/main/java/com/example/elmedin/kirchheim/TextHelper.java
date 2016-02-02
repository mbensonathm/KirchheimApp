package com.example.elmedin.kirchheim;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

public class TextHelper{

    public static SpannableString formatText(int lvl, String content){

        int tmpLenght = content.length() -1;
        SpannableString output = new SpannableString(content);

                switch(lvl){
                    case 1: output.setSpan(new StyleSpan(Typeface.BOLD), 0 , tmpLenght, 0);
                        break;
                    case 2:
                        output.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0 , tmpLenght, 0);
                        break;
                    case 3:  output.setSpan(new RelativeSizeSpan(0.75f), 0,tmpLenght,0);
                        break;
                    default:
                        break;
                }
        return output;

    }
}
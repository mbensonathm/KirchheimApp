public class TextHelper{

    public SpannableString formatText(int lvl, String content){

        int tmpLenght = content.lenght -1;
        SpannableString output = new SpannableString(content);

                switch(lvl){
                    case 1: output.setSpan(new StyleSpan(Typeface.BOLD), 0 , tmpLenght, 0);
                        break;
                    case 2: output.setSpan(new StyleSpan(Typeface.BOLD), 0 , tmpLenght, 0);
                        break;
                    default:
                        break;
                }
        return output;

    }
}
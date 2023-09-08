public class WordMatch {
    private String x;
    int guessLength;
    public WordMatch(String s){
        x = s;
    }
    public int scoreGuess(String guess){
        if (guess.equals("")) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if(guess.length() > x.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int count = 0;
        guessLength = guess.length();
        for(int i = 0 ; i < x.length() - (guessLength - 1); i++)
        {
            if(x.substring(i,i+guessLength).equals(guess))
                count++;
        }
        return (count * guessLength * guessLength);
    }



    public String findBetterGuess(String guess1 , String guess2){
        if (guess1.equals ("") || guess2.equals("")){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess1.length()>(x.length()) || guess2.length()>(x.length())) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int s1 = scoreGuess(guess1);
        int s2 = scoreGuess(guess2);
        if (s1>s2) {
            return guess1;
        }
        else if (s2>s1) {
            return guess2;
        }
        else {
            if(guess1.compareTo(guess2)>0)
            {
                return guess1;
            }
            return guess2;
        }
    }
}

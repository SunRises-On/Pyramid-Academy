public class main{
    public static void main(String args[]){

        String str = "Reverse A String";

        System.out.println(ReverseString(str));
    }

    public static String ReverseString( String s){
        String reverse = "";

        for(int i = s.length()-1 ; i >= 0 ;  --i){
            char c = s.charAt(i);
            reverse = reverse + c;
        }

        return reverse;
    }
}


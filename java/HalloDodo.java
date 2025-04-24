import java.util.*;

class HalloDodo{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int jumlahCase = scanner.nextInt();

        for(int i = 0; i<jumlahCase; i++){
            int key = scanner.nextInt();
            String value = scanner.next();

            int panjangValue = value.length();
            int asciiValue = 0;
            for(int j = 0; j<panjangValue; j++){
                asciiValue = (asciiValue * 256 + value.charAt(j)) % 7121;
            }

            if(key == asciiValue){
                System.out.println("utuh");
            } else{
                System.out.println("rusak");
            }
        }
    }
}
import java.util.*;
public class enjel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pjgJalan = sc.nextInt();
        int jrkTempuh = sc.nextInt();
        int n = sc.nextInt();
        int[] jarakPom = new int[n];
        for(int i=0;i<n;i++) {
            jarakPom[i]=sc.nextInt();
        }
        int temp = 0;
        int bensin = jrkTempuh;
        String hasil="";
        for(int i=0;i<n;i++){
            if(temp<=pjgJalan){
                bensin=bensin-(jarakPom[i]-temp);
                if(i==n-1){
                    if(pjgJalan-jarakPom[i]-bensin>0) {
                        hasil+=(i+1)+" ";
                    }
                }else{
                    if(jarakPom[i+1]-jarakPom[i]-bensin>0){
                        hasil+=(i+1)+" ";
                        bensin=jrkTempuh;

                        if (jrkTempuh < jarakPom[i+1] - jarakPom[i]) {
                            break;
                        }
                    }
                }
            }
            temp=jarakPom[i];
        }

        String[] arr = hasil.split("\\s+");
        int pomTerakhir = Integer.parseInt(arr[arr.length-1]);
        if(jarakPom[pomTerakhir-1]+jrkTempuh>=pjgJalan){
            System.out.println(arr.length);
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }else{
            System.out.println(-1);
        }

    }
}
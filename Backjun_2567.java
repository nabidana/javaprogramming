import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aeriug {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lenth = Integer.parseInt(br.readLine());
        int[][] arrz = new int[102][102];
        int maxxsize = 0;
        int maxysize = 0;
        for(int i = 0; i < lenth; i++){
            String s = br.readLine();
            int startx = Integer.parseInt(s.split(" ")[0])+1;
            int starty = Integer.parseInt(s.split(" ")[1])+1;

            for(int j = 0; j < 10; j++){
                if( (j+startx) == 101){
                    break;
                }
                for(int k = 0; k < 10; k++){
                    if( (k+starty) == 101){
                        break;
                    }
                    if( (j+startx) > maxxsize){
                        maxxsize = (j+startx);
                    }
                    if( (k+starty) > maxysize){
                        maxysize = (k+starty);
                    }
                    arrz[j+startx][k+starty] = 1;
                }
            }    
        }

        int counting = 0;
        for(int j = 0; j < (maxxsize+1); j++){
            for(int k = 0; k < (maxysize+1); k++){
                //색종이일때
                if(arrz[j][k] == 1){
                    //끝변일때
                    //case1 - 왼쪽아랫변
                    //case2 - 오른쪽 아랫변
                    //case3 - 왼쪽윗변
                    //casr4 - 오른쪽 윗변
                    if(
                    ( (arrz[j-1][k] != 1) && (arrz[j][k+1] != 1) && (arrz[j+1][k] == 1) && (arrz[j][k-1] == 1) )
                    ||
                    ( (arrz[j+1][k] != 1) && (arrz[j][k+1] != 1) && (arrz[j-1][k] == 1) && (arrz[j][k-1] == 1) )
                    ||
                    ( (arrz[j-1][k] != 1) && (arrz[j][k-1] != 1) && (arrz[j+1][k] == 1) && (arrz[j][k+1] == 1) )
                    ||
                    ( (arrz[j+1][k] != 1) && (arrz[j][k-1] != 1) && (arrz[j-1][k] == 1) && (arrz[j][k+1] == 1) )
                    ){
                        counting = counting + 2;
                    }else if(
                    (arrz[j+1][k] == 1) && (arrz[j-1][k] == 1) && (arrz[j][k-1] == 1) && (arrz[j][k+1] == 1)
                    ){
                        continue;
                    }
                    else{
                        counting = counting + 1;
                    }
                }
            }
        }
        System.out.println(counting);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class erwtyh {
    private int score = 0;
    private String name = "";

    public erwtyh(String s, int n){
        this.name = s;
        this.score = n;
    }
    public int prtscore(){
        return this.score;
    }
    public String prtname(){
        return this.name;
    }
    public void changes(String s, int n){
        this.name = s;
        this.score = n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<erwtyh> peopleList = new ArrayList<erwtyh>();

        while(true){
            System.out.println("메뉴선택");
            System.out.println("1) 항색입력");
            System.out.println("2) 학생조회");
            System.out.println("q) 종료");
            String ss = br.readLine();
            if(ss.equals("q")){
                System.exit(0);
            }else if(ss.equals("1")){
                System.out.println("이름 입력 :");
                String inname = br.readLine();
                System.out.println("성적 입력 :");
                int nums = Integer.parseInt(br.readLine());
                peopleList.add(new erwtyh(inname, nums));
            }else if(ss.equals("2")){
                if(peopleList.size() < 1){
                    System.out.println("수부족");
                    continue;
                }
                //어레이리스트 sort방법
                // Collections.sort(peopleList, new Comparator<erwtyh>() {
                //     @Override
                //     public int compare(erwtyh o1, erwtyh o2) {
                //         return o1.prtscore() - o2.prtscore();
                //     }
                    
                // });
                for(int i = 0; i < (peopleList.size() -1); i++){
                    for(int k = (i+1) ; k < peopleList.size(); k++){
                        if( peopleList.get(i).prtscore() < peopleList.get(k).prtscore()){
                            erwtyh imsi = new erwtyh(peopleList.get(i).prtname(), peopleList.get(k).prtscore());
                            peopleList.set(i, peopleList.get(k));
                            peopleList.set(k, imsi);
                        }
                    }
                }
                System.out.println("name: " + peopleList.get(0).prtname()
                + " score: " + String.valueOf(peopleList.get(0).prtscore()));
            }
        }
    }
}

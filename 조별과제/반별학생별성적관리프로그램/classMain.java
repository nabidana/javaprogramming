
import java.util.Scanner;

public class classMain {
    public static boolean inORout = false;
    public static Mainclass[] mainList;
    public static String csname = "A,B,C";
    public static boolean isNum(String s){
        boolean flag = true;
        if(!s.matches("[0-9]+")){
            flag = false;
        }
        return flag;
    }
    public static int chNum(String s){
        return Integer.valueOf(s);
    }
    public static void main(String[] args) {
        Scanner scaneer = new Scanner(System.in);
        int lenNum = 0;
        int csNum = 0;
        boolean tORf = true;
        while(true){
            if( tORf) {
                System.out.print("반의 개수를 입력해주세요 : ");
                String sin8 = scaneer.nextLine();
                System.out.println("");
                if( isNum(sin8) == false) {
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(sin8) <= 0){
                    System.out.println("ERROR");;
                    continue;
                }else{
                    csNum = chNum(sin8);
                }
                System.out.print("각 반별 학생수를 입력해주세요.");
                String sin1 = scaneer.nextLine();
                System.out.println("");
                if( isNum(sin1) == false) {
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(sin1) <= 0){
                    System.out.println("ERROR");;
                    continue;
                }else{
                    lenNum = chNum(sin1);
                }
                mainList = new Mainclass[csNum];
                if(csNum > 3){
                    for(int i = 3; i < csNum; i++) {
                        csname = csname + "," + Integer.valueOf(i);
                    }
                }
                for(int i = 0 ; i < mainList.length; i++) {
                    mainList[i] = new Mainclass(lenNum, i);
                }
                tORf = false;
            }
            
            System.out.println("메뉴 선택");
            System.out.println("1) 학생 정보 입력");
            System.out.println("2) 학생 전체 조회");
            System.out.println("3) 반 별 정보 조회");
            System.out.println("4) 전체 평균 조회");
            System.out.println("5) 반 이름 변경");
            System.out.println("q) 종료");
            System.out.print("입력 : ");
            String sin2 = scaneer.nextLine();
            System.out.println("");
            if( sin2.equals("q")){
                System.exit(0);
            }
            if( isNum(sin2) == false) {
                System.out.println("ERROR");
                continue;
            }else if(chNum(sin2) <=0 || chNum(sin2) > 5){
                System.out.println("ERROR");
                continue;
            }
            int inNuma = chNum(sin2);

            //1번메뉴
            if( inNuma == 1) {
                System.out.println("어느 반의 학생을 입력하실 건가요?");
                System.out.println("현재 총 반의 개수 : " + csNum);
                String[] csLists = csname.split(",");
                for(int z = 0; z < csLists.length; z++) {
                    System.out.print( (z + 1) + ")\t" + csLists[z] +"\t");
                }
                System.out.println("");
                System.out.print("입력 : ");
                String sp1 = scaneer.nextLine();
                System.out.println("");
                if(isNum(sp1) == false) {
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(sp1) <= 0 || chNum(sp1) > csNum){
                    System.out.println("ERROR");
                    continue;
                }
                int chooseCS = chNum(sp1) -1;
                System.out.println("몇명의 학생수를 입력하실건가요?");
                System.out.print("입력 : ");
                String sin4 = scaneer.nextLine();
                if(isNum(sin4) == false) {
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(sin4) <= 0){
                    System.out.println("ERROR");
                    continue;
                }
                int plusNum = Integer.valueOf(sin4);
                mainList[chooseCS].inputStd(plusNum);
            }
            
            //2번메뉴
            if( inNuma == 2) {
                boolean yesOut = false;
                for(int i = 0 ; i < mainList.length; i++) {
                    if(mainList[i].yeORno() == false) {
                        yesOut = true;
                        break;
                    }
                    mainList[i].outstd();
                }
                if(yesOut){
                    System.out.println("정보가 없어서 출력이 불가능합니다.");
                }
            }

            if(inNuma == 3){
                System.out.println("조회할 반을 입력해주세요");
                String[] csnam = csname.split(",");
                for(int i = 0; i < csnam.length; i++) {
                    System.out.print((i + 1) + ")\t" + csnam[i]+"\t");
                }
                System.out.println("");
                System.out.print("입력 : ");
                String sin3 = scaneer.nextLine();
                System.out.println("");
                if( isNum(sin3) == false){
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(sin3) <=0 || chNum(sin3) > csnam.length){
                    System.out.println("ERROR");
                    continue;
                }

                int choisecs = chNum(sin3) -1;
                System.out.println(csnam[choisecs] + "반을 선택하셨습니다.");
                mainList[choisecs].outstd();
            }

            if(inNuma == 4){
                //전체평균조회
                System.out.println("전체 평균을 조회합니다.");
                int alPG = 0;
                boolean tORn = true;
                for(int i = 0 ; i < mainList.length; i++) {
                    if(mainList[i].yeORno() == false){
                        System.out.println("학생 정보 부족으로 인해 조회 불가");
                        tORn = false;
                        break;
                    }
                    alPG = alPG + mainList[i].allPG();
                }
                if(tORn){
                    alPG = alPG / 3;
                    System.out.println("전체학생" + lenNum + "명의 평균은" + alPG);
                }

            }

            if(inNuma == 5){
                //반이름변경
                String[] csnam = csname.split(",");
                System.out.println("반 이름을 변경합니다.");
                System.out.println("변경할 반을 선택해주세요.");
                for(int i = 0; i < csnam.length; i++) {
                    System.out.print( (i + 1) + ")\t" + csnam[i] + "\t");
                }
                System.out.println("");
                System.out.print("입력 : ");
                String chncs = scaneer.nextLine();
                if(isNum(chncs) == false) {
                    System.out.println("ERROR");
                    continue;
                }else if(chNum(chncs) <= 0 || chNum(chncs) > csnam.length){
                    System.out.println("ERROR");
                    continue;
                }
                int chnNum = chNum(chncs) -1;
                System.out.println("변경할 이름을 입력해주세요");
                String clasName = scaneer.nextLine();
                csnam[chnNum] = clasName;
                csname = "";
                for(int i = 0 ; i < csnam.length; i++) {
                    if(i != 0) {
                        csname = csname + ",";
                    }
                    csname = csname + csnam[i];
                }

            }
            
        }

        
    }
}

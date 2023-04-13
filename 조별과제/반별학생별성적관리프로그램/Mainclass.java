public class Mainclass{
    private int classname = 0;
    private Student[] studentinfo;
    private boolean inORout = false;
    private int studentCount = 0;

    public Mainclass(int n, int y){
        if(inORout == true) {
            System.out.println("ERROR 이미 입력햇음.");
            return;
        }
        this.classname = y;
        studentinfo = new Student[n];
        for(int i = 0; i < studentinfo.length; i++) {
            studentinfo[i] = new Student();
            inORout = true;
        }
    }
    public void inputStd(int n){
        if(inORout == false || studentCount == studentinfo.length){
            System.out.println("ERROR");
            return;
        }
        int endCount = this.studentCount;
        if( studentCount + n > studentinfo.length) {
            System.out.println("ERROR TOO MANY INDEX COUNT");
            return;
        }
        for(int i = studentCount; i < endCount + n; i++) {
            studentinfo[i].inputStudent();
            this.studentCount = this.studentCount + 1;
        }
    }
    public void outstd(){
        if( studentCount == 0) {
            System.out.println("정보가 없음");
            return;
        }
        for(int i = 0 ; i <studentCount; i++) {
            studentinfo[i].stuAllInfo();
        }
        System.out.println("");
    }

    public int allPG(){
        int totalNum = 0;
        for(int i = 0; i < studentCount; i++) {
            totalNum = totalNum + studentinfo[i].getTotalScore();
        }
        return totalNum = 0;
    }

    public boolean yeORno(){
        boolean chk = true;
        if(studentCount == 0) {
            return false;
        }
        for(int i = 0; i < studentCount; i++) {
            if( studentinfo[i].canORcant() == false ) {
                chk = false;
                break;
            }
        }
        return chk;
    }
}

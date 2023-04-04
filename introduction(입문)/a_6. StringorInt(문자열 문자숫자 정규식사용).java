public static boolean isNum3(String s) {    //정규표현식으로 사용
  return ( s!= null && s.matches("[0-9]+"));  //"[0-9]+" 또는 "\\d+"사용
}

public static boolean isNum4(String s) {
  return ( s!=null && s.matches("\\d+"));
}


    public static boolean isNum2(String s) {    //람다식
        if(s == null || s.equals("")) {
            return false;
        }
        return s.chars().allMatch(Character::isDigit);  //char형 문자 하나하나 숫자여부 판별하는 함수
    }




public static List<ExchangeVO> makeVOlist(ExchangeVO exchangeVO, String jsonData){

  //ExchangeVO 형식의 list를 arraylist로 생성.
  List<ExchangeVO> exchangeVOList = new ArrayList<>();
  //jsonData = getSource();
  try {
    //json date 파싱
    //JSON 데이터 자바 객체로 바꾸기위한 mapper 선언
    ObjectMapper objectMapper = new ObjectMapper();
    //JSON형식 데이터를 object로 추출
    JSONObject obd = (JSONObject)new JSONParser().parse(jsonData);
    //추출한 데이터를 MAP형식으로 변환
    Map<String, Object> maps = new ObjectMapper().readValue(obd.toJSONString(), Map.class);

    //map의 키들만 추출해서 새로운 list를 선언
    List<String> keysetting = new ArrayList<>(maps.keySet());
    //list를 정렬시키는 함수.
    Collections.sort(keysetting);
    
    //클래스에 데이터 삽입 후 결과 리턴
    int idx = 1;

    //list의 0번 index부터 끝 인덱스까지 불러와서 클래스에 담아서 return
    for(String keyz : keysetting) {

      exchangeVO = new ExchangeVO();
      exchangeVO.setIdx(idx);
      
      String dates = String.valueOf(keyz);
      String price_val = String.valueOf(maps.get(keyz));
      exchangeVO.setDate(dates);
      exchangeVO.setCurrency(price_val);
      exchangeVOList.add(exchangeVO);
      idx++;
    }
    
  } catch (Exception e) {
    e.printStackTrace();
  }

  return exchangeVOList;
}

/*request and response
sendREST Function -> input params : sendurl( Server url), jsonValue( Json data value)
*/
public static String sendREST(String sendUrl, String jsonValue) throws IllegalStateException {

  //get response data
  String inputLine = null; 

  //final return string value(response 받은 데이터를 문자열로 변환해서 반환해주기 위한 임시 문자열)
  StringBuffer outResult = new StringBuffer();

    try{
    //logger.debug("REST API Start");
      //URL setting
      URL url = new URL(sendUrl);
      //connection to url using httpconnection(해당 url로 http연결 시도)
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      //request(POST). OutputStream으로 POST 데이터를 넘겨주겠다는 옵션
      conn.setDoOutput(true);

      //request options. Request 받는 방식 설정
      conn.setRequestMethod("POST");

      //make response data to JSON. JSON형식의 Response 요청
      conn.setRequestProperty("Content-Type", "application/json");

      //encdoing UTF-8. UTF-8로 인코딩 시키기
      conn.setRequestProperty("Accept-Charset", "UTF-8"); 

      //server connect time out. 서버 접속 연결 Time out 시간
      conn.setConnectTimeout(10000);

      //server read time out. 서버 연결 Time out 시간
      conn.setReadTimeout(10000);

      //OutputStream : 바이트 기반 출력 스트림. Request Body에 data 적재.
      OutputStream os = conn.getOutputStream();

      //Request Body에 UTF-8로 인코딩된 JSON Data 쓰기.
      os.write(jsonValue.getBytes("UTF-8"));
      //OutputStream 저장
      os.flush();
        
        /* 리턴된 결과 읽기
        BufferdRead : 버퍼 입력 함수
        InputStreamReader : 버퍼단위로 읽어들이기
        getInputStream : Response Body내용을 UTF-8로 인코딩해서 가져옴.
        */
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

      //readLine으로 불러오는 data가 없을때 까지, 계속해서 outResult에 추가해준다.
      while ((inputLine = in.readLine()) != null) {
        outResult.append(inputLine);
      }

      //HTTP 연결 해제.
      conn.disconnect();  
    }catch(Exception e){
        e.printStackTrace();
    }	

    //String 으로 반환.
    return outResult.toString();
}

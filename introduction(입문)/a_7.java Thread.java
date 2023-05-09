        System.out.println("현재날짜구하기");
        SimpleDateFormat sdmps = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = sdmps.format(new java.util.Date());
        System.out.println(nowtime);

        System.out.println("2023-05-07 말일 구하기");
        Calendar cal = Calendar.getInstance();
        cal.set(2023, (5-1), 07);
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        System.out.println("20230407 문자열 데이터로 변환");
        //데이터 변환시 문자열형식과 바꾸는 format형식이 일치하여야 동작한다.
        try{
            String dt1 = "2023-04-07";
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date dtz = new Date(fmt.parse(dt1).getTime());
            System.out.println(dtz);

        }catch(ParseException e){
            e.printStackTrace();
        }
        
        LocalDateTime lcdt1 = LocalDateTime.of(2023,04,07,14,12,10);
        LocalDateTime lcdt2 = LocalDateTime.of(2023,05,01,17,20,10);

        System.out.println("20230407 이랑 20230501 날짜 차이구하기");
        Period diff = Period.between(lcdt1.toLocalDate(), lcdt2.toLocalDate());
        System.out.printf("차이 : %d년%d월%d일",diff.getYears(),diff.getMonths(),diff.getDays());
        System.out.println("");
        System.out.println("20230407 이랑 20230501 시간 차이구하기");
        Duration diff2 = Duration.between(lcdt1.toLocalTime(), lcdt2.toLocalTime());
        System.out.printf("차이 : %d시, %d분, %d초",diff2.toHours(), diff2.toMinutes(), diff2.getSeconds());

        System.out.println("");
        //현재날짜와 시간의 차이 구하기
        //기준은 1970년
        java.util.Date now = new java.util.Date();
        System.out.println(now.getTime());

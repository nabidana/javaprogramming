		@RequestMapping(value="/allapi.do", method = RequestMethod.POST)
		public String allapi(@ModelAttribute("exchangeVO") ExchangeVO exchangeVO,
				HttpServletRequest request, ModelMap model) throws Exception{

      //request value 가져오기
			String past_year = request.getParameter("year");
			String past_month = request.getParameter("month");
			String past_day = request.getParameter("day");
			System.out.println("Y:"+past_year+"M:"+past_month);

      //year및 month 선택 안할시 error 반환
			if("".equals(past_year) || "".equals(past_month)) {
				model.addAttribute("message", "날짜를 선택해주세요");
				model.addAttribute("url", "/chart.do");
				return "/board/alert";
			}else if(!"".equals(past_month) && !"".equals(past_year)) {
				int year_int = Integer.parseInt(past_year);
				int month_int = Integer.parseInt(past_month);
				
				if(year_int == 2021 && month_int < 6) {
					model.addAttribute("message", "2021년 6월 1일 이후 날짜를 선택해주세요");
					model.addAttribute("url", "/chart.do");
					return "/board/alert";
				}
			}
			
			String days = past_year+"-"+past_month+"-"+past_day;
			//request userid, usertype value 가져오기
			String u_id = String.valueOf(request.getSession().getAttribute("userId"));
			String u_type = String.valueOf(request.getSession().getAttribute("type"));
			System.out.println(u_type);

      //JSON DATA보내기 위해서 hash map setting.
			HashMap<String, String> resultMap = new HashMap<>();
			resultMap.put("StartDate", days);
			resultMap.put("SendType", "past data");
			resultMap.put("type", u_type);
      //JSON DATA 만들기
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(resultMap);
      //request 보낼 server ip
			String now_dollar_url = "http://localhost:9005/predictexrates";
			String past_dollar_url = "http://localhost:9005/pastexrates";
			String now_uro_url = "http://localhost:9005/predictexrateseuro";
			String past_uro_url = "http://localhost:9005/pastexrateseuro";
			//현재 달러 request & response
			String now_dolmap = sendREST(now_dollar_url, json);
			List<?> now_dolsource = makeVOlist(exchangeVO, now_dolmap);
			model.addAttribute("dollarList", now_dolsource);
			//과거 달러 request & response
			String past_dolmap = sendREST(past_dollar_url, json);
			List<?> past_dolsource = makeVOlistpast(exchangeVO, past_dolmap);
			model.addAttribute("dollarPast", past_dolsource);
			//현재 유로 request & response
			String now_uromap = sendREST(now_uro_url, json);
			List<?> now_urosource = makeVOlistpast(exchangeVO, now_uromap);
			model.addAttribute("euroList", now_urosource);
			//과거 유로 request & response
			String past_uromap = sendREST(past_uro_url, json);
			List<?> past_urosource = makeVOlistpast(exchangeVO, past_uromap);
			model.addAttribute("euroPast", past_urosource);
			
			return "/board/chartPast";
		}

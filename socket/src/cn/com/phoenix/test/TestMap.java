package cn.com.phoenix.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TestMap {
	public static Map RestoreData() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("QueueId", "11111");
		map.put("BuzName", "22222");
		map.put("TicketTime", "33333");
		map.put("CallTime", "44444");
		map.put("EndServiceTeller", "55555");
		map.put("ServiceTeller", "66666");
		map.put("CounterNo", "77777");
		map.put("TicketToken", "88888");
		return map;
	}
}

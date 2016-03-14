package mysellf.thread.collection;

import java.util.HashMap;
import java.util.Map;

public class MapRemoveTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < 100; i++) {
			map.put("key_" + i, i);
		}
		System.out.println(map);
		int count = 0;
		for(String key : map.keySet()) {
			Integer num = map.get(key);
//			System.out.println(num);
			count++;
			if(num > 90) {
				map.remove(key);
			}
		}
		System.out.println(count);
	}

}

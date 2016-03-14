package mysellf.string;

import java.util.Properties;

public class String_Test {

	public static void main(String[] args) {
		Properties proes = System.getProperties();
		for(Object obj : proes.keySet()) {
			if("catalina.home".equals(obj)) {
				System.out.println(obj + " = " + proes.get(obj));
			}
		}
	}
	
}

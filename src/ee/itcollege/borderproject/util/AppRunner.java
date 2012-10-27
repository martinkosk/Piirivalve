package ee.itcollege.borderproject.util;

import java.util.List;

import ee.itcollege.borderproject.model.Guard;

public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GuardGenerator guardGenerator = new GuardGenerator();
		List<Guard> randomGuards = guardGenerator.generate(100);
		
		for (int i = 0; i < randomGuards.size(); i++) {
			String line = String.format(
					"%s Name: %s Age: %s", 
					i + 1, 
					randomGuards.get(i).getName(), 
					randomGuards.get(i).getAge());
			
			System.out.println(line);
		}
	}
}

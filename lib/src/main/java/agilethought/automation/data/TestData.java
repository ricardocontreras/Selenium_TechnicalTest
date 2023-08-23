package agilethought.automation.data;

import java.util.Arrays;
import java.util.List;

public class TestData {

	static List<String> expectedMenuItems = Arrays.asList(
		    "Microsoft 365", "Windows", "Surface", "Xbox", "Deals", "Small Business", "Support"
		);

	public static List<String> getExpectedMenuItems() {
		return expectedMenuItems;
	}
}

package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
@Test
public void createOrderTest() {
	System.out.println("create order test case");
}
@Test(dependsOnMethods = "createOrderTest")
public void billingAnOderTest() {
	System.out.println("billing an order test case");
}
}

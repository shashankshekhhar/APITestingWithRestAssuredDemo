package testcases;

import org.junit.Test;

import BDD.APITestProjectDemo.complexpayload;
import io.restassured.path.json.JsonPath;

public class Learningextractingresponse {

	@Test
	public void extractResponse() {

		JsonPath js = new JsonPath(complexpayload.comppayload());

		// Print No of courses returned by API
		int noofcourses=js.getInt("courses.size()");
		
		System.out.println(noofcourses);

		//Purchase Amount
		
		int purchaseamount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		//Print Title of the first course
		System.out.println(js.getString("courses.title[0]"));
		
		
		 //Print All course titles and their respective Prices
		for(int i=0;i<noofcourses;i++) {
			
			System.out.println(js.getList("courses.title").get(i)+"   "+js.getList("courses.price").get(i));
			
		}
		
		
		//Print no of copies sold by RPA Course
		
		for(int i=0;i<noofcourses;i++) {
			if(js.getList("courses.title").get(i).equals("RPA")) {
				System.out.println(js.getList("courses.copies").get(i));
			}
		}
		//Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<noofcourses;i++) {
		
			sum=(js.getInt(("courses["+i+"].copies"))*js.getInt(("courses["+i+"].price")))+sum;
			
			System.out.println(sum);
		}
		
		
		
}}

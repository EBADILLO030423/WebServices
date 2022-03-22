

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class BookTest {
	
	@BeforeTest()
	public void setup() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me/"; 

}
	@Test (enabled =false)
	public void getMessage() {
	
		
		given().log().all()
		.when().get()
		.then().log().all().assertThat().statusCode(200).body("message", equals("Welcome to the Simple Books API."));
		
	}
	
	@Test (enabled = false)
	public void  availableBooks() {
		given()
		.when().get("/books")
		.then().log().all().assertThat().statusCode(200);
		
	}
	@Test (enabled = false)
	public void fictionBooks() {
		given().queryParam("type", "fiction")
		.when().get("/books")  
		.then().log().all().assertThat().statusCode(200);
		
	}
	
	@Test (enabled = false)
	public void nonFictionBooks() {
		given().queryParam("type", "non-fiction")
		.when().get("/books")  
		.then().log().all().assertThat().statusCode(200);
		
		
	}
	
	@Test(enabled = false)
	public void singleBook() {
		getBook(1);
	}
	private void getBook(int i) {
		
		
	}
	@Test (enabled = false)
	public void LimitBooks() {
		given().queryParam("limit", "5") 
		.when().get("/books")  
		.then().log().all().assertThat().statusCode(200);
		
	}
	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}
	@Test (enabled = false)
	public void RegisterApiClientProfile() { 
		given().header("Content-Type", "application/json").body("{\n"
		 		+ "    \"clientName\": \"Irene Aguilar\",\n"
		 		+ "    \"clientEmail\": \"ireneaguilar1665@gmail.com\"\n"
		 		+ "}")
		 .when().post("api-clients")
		 .then().log().all().assertThat().statusCode(201).body("$", hasKey("accessToken"));
			}
	private Object hasKey(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	@Test(enabled = false)
	public void placeOrder() {
		given().header("Authorization", "Bearer 3b918328557799b459e03d8d5ff3e1426ff48eec3b5a258226b895dd5abef8ce")
		.body("{\n"
				+ "    \"bookId\": 3,\n"
				+ "    \"customerName\": \"ireneAP\"\n"
				+ "}")
				.when().get("orders")
				.then().log().all().assertThat().statusCode(200).body("$", hasKey("orderId"));
	}
}

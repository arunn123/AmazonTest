package Testcases;

import java.io.IOException;

import Pages.Firstwindow;
import Pages.Secondwindow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon {

	@Given("^launch the Amazon URL$")
	public void launch_the_Amazon_URL() {
		Firstwindow.launch_the_Amazon_URL();
	}

	@When("^user enters product name by choosing category and hit search$")
	public void user_enters_product_name_by_choosing_category_and_hit_search() throws IOException {
		Firstwindow.user_enters_product_name_by_choosing_category_and_hit_search();
	}

	@Then("^list of products should be displayed with product name and price$")
	public void list_of_products_should_be_displayed_with_product_name_and_price() throws IOException {
		Firstwindow.list_of_products_should_be_displayed_with_product_name_and_price();
	}

	@When("^user clicks on first displayed mobile result$")
	public void user_clicks_on_first_displayed_mobile_result() {
		Firstwindow.user_clicks_on_first_displayed_mobile_result();
	}

	@Then("^chosen mobile should open in new window with its details and the user reads the item and price$")
	public void chosen_mobile_should_open_in_new_window_with_its_details_and_the_user_reads_the_item_and_price() {
		Secondwindow.chosen_mobile_should_open_in_new_window_with_its_details_and_the_user_reads_the_item_and_price();
	}

	@Then("^hit on add to cart$")
	public void hit_on_add_to_cart() throws InterruptedException {
		Secondwindow.hit_on_add_to_cart();
	}

	@Then("^user clicks on cart to view cart details$")
	public void user_clicks_on_cart_to_view_cart_details() {
		Secondwindow.user_clicks_on_cart_to_view_cart_details();
	}

	@Then("^mobile name and price should be displayed and validated by user$")
	public void mobile_name_and_price_should_be_displayed_and_validated_by_user() {
		Secondwindow.mobile_name_and_price_should_be_displayed_and_validated_by_user();
	}

	@When("^the user places the order by clicking proceed to checkout$")
	public void the_user_places_the_order_by_clicking_proceed_to_checkout() {
		Secondwindow.the_user_places_the_order_by_clicking_proceed_to_checkout();
	}

	@Then("^user enters the login details$")
	public void user_enters_the_login_details() {
		Secondwindow.user_enters_the_login_details();
	}

	@Then("^user chooses delivery address and continue to payment$")
	public void user_chooses_delivery_address_and_continue_to_payment() {
		Secondwindow.user_chooses_delivery_address_and_continue_to_payment();
	}

	@Then("^user removes product from cart$")
	public void user_removes_product_from_cart() {
		Secondwindow.user_removes_product_from_cart();
	}
	
	@And("^user closes the browser$")
	public void user_closes_the_browser() {
		Secondwindow.user_closes_the_browser();
	}


}

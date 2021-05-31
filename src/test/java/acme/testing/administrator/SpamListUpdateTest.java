package acme.testing.administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmePlannerTest;

public class SpamListUpdateTest extends AcmePlannerTest {

	// Internal state ---------------------------------------------------------

	// Lifecycle management ---------------------------------------------------

	

	// Test cases -------------------------------------------------------------
	/**
	 * 
	 * Caso positivo:
	 * Al loguearnos como administrador, accedemos a la pagina de "spam filter"
	 * y debe realizar una actualización de la lista de estas palabras en 
	 * la base de datos
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/UpdateSpamList/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdate(final String threshold, final String lista) {
		this.signIn("administrator", "administrator");

		this.UpdateSpamWordList(threshold, lista);
		super.clickOnMenu("Administrator", "Spam filter");


	
		assert super.exists(By.id("lista"));
	}
	/**
	 * 
	 * Caso negativos:
	 * Al loguearnos como administrador, accedemos a la pagina de "spam filter"
	 * e intentamos actualizar la base de datos con un threshold que no 
	 * pase las restricciones, deberia saltarnos un errror
	 */
	@ParameterizedTest
    @CsvFileSource(resources = "/UpdateSpamList/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void negativeUpdate(final String threshold, final String lista) {
		this.signIn("administrator", "administrator");
		this.UpdateSpamWordList(threshold, lista);
		super.checkErrorsExist();
    }
	// Ancillary methods ------------------------------------------------------

	@Override
	protected void signIn(final String username, final String password) {
		super.navigateHome();
		super.clickAndGo(By.linkText("Sign in"));
		super.fill(By.id("username"), username);
		super.fill(By.id("password"), password);
		super.clickAndGo(By.id("remember$proxy"));
		super.clickOnSubmitButton("Sign in");
	}

	@Override
	protected void signOut() {
		super.navigateHome();
		super.clickOnLink("Sign out");;
	//	super.clickOnSubmitButton("sign-out");
	}
	protected void UpdateSpamWordList(final String threshold, final String lista) {

		super.navigateHome();
		super.clickOnMenu("Administrator", "Spam filter");
		super.fill(By.id("threshold"), threshold);
		super.fill(By.id("lista"), lista);
	
		super.clickOnSubmitButton("update");
	}
	
	

	
	
}
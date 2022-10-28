package com.katalon
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

import com.kms.katalon.core.logging.KeywordLogger

import cucumber.api.java.en.When



class LoginStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("I Hit Login API Endpoint with (.*) and (.*)")
	def I_enter_valid_username_password(String username, String password) throws UnsupportedEncodingException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String uri = "https://api.upbanx.net/auth/login";
		HttpPost request = new HttpPost(uri);
		StringEntity entity = new StringEntity(String.format('{"email_or_phone": "%s","password": "%s"}', username, password));
		request.addHeader("content-type", "application/json");
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		HttpEntity responseEntity = response.getEntity();
		String responseString = EntityUtils.toString(responseEntity, "UTF-8");
		KeywordLogger log = new KeywordLogger();
		log.logInfo(responseString)
	}
}
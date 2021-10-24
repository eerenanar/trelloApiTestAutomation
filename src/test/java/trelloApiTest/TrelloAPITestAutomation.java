package trelloApiTest;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.FileandEnv;

public class TrelloAPITestAutomation extends BaseTest {

    @Test
    public void APIAutomation() throws UnirestException {
        HeaderConfigs headerConfigs = new HeaderConfigs();
        PostAPIBuilder builder = new PostAPIBuilder();
        FileandEnv.envAndFile();
        String boardName="NewBoard";
        String cartName="NewCard";

        test.log(LogStatus.INFO,"My test is starting...");
        test.log(LogStatus.INFO,"Creating board...");
        //Creating board
        Response response = RestAssured.given()
                .contentType("application/json")
                .headers(headerConfigs.headersWithToken(boardName))
                .queryParams(builder.postRequestBody(boardName))
                .when().post(APIPath.apiPath.POST_BOARD).then().extract().response();
        test.log(LogStatus.INFO,"Getting idList from board...");

        //Getting id list on board
        String idList = RestAssured.given()
                .headers(headerConfigs.defaultHeaders())
                .queryParams(builder.getRequestBody())
                .get(APIPath.apiPath.GET_BOARD)
                .body().jsonPath().get("idList");

        test.log(LogStatus.INFO,"Creating 2 cards...");
        //Creating 2 card
        for(int i=0;i<2;i++)
            RestAssured.given()
                    .headers(headerConfigs.headerForCard(idList))
                    .queryParams(builder.postRequestBody(cartName))
                    .when().post(APIPath.apiPath.POST_CARD).then().extract().response();

        test.log(LogStatus.INFO,"Updating card...");
        //Update card
        RestAssured.given()
                .headers(headerConfigs.headerForCard(idList))
                .queryParams(builder.postRequestBody(cartName))
                .when().put(APIPath.apiPath.PUT_CARD).then().extract().response();

        test.log(LogStatus.INFO,"Deleting card...");
        //Delete card
        RestAssured.given()
                .headers(headerConfigs.headerForCard(idList))
                .queryParams(builder.postRequestBody(cartName))
                .when().delete(APIPath.apiPath.DEL_CARD).then().extract().response();

        test.log(LogStatus.INFO,"Deleting board...");
        //Delete board
        RestAssured.given()
                .headers(headerConfigs.headersWithToken(boardName))
                .queryParams(builder.postRequestBody(boardName))
                .when().delete(APIPath.apiPath.DEL_BOARD).then().extract().response();

        APIVerification.responseCodeValidation(response,200);
        APIVerification.responseTimeValidation(response);
        APIVerification.responseKeyValidationFromJsonObject(response,"name");

        test.log(LogStatus.INFO,"My test is ended...");
    }
}

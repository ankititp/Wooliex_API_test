$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/ankit/Downloads/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/Features/Holiday.feature");
formatter.feature({
  "line": 1,
  "name": "A Holday holiday Maker",
  "description": "",
  "id": "a-holday-holiday-maker",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "A happy holidaymaker",
  "description": "",
  "id": "a-holday-holiday-maker;a-happy-holidaymaker",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I like to holiday in Sydney",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I look up the weather forecast",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I receive the weather forecast",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "the temperature is warmer than 10 degrees",
  "keyword": "And "
});
formatter.match({
  "location": "GetAPITest.setUp()"
});
formatter.result({
  "duration": 158827543,
  "status": "passed"
});
formatter.match({
  "location": "GetAPITest.enter_valid_details()"
});
formatter.result({
  "duration": 922006,
  "status": "passed"
});
formatter.match({
  "location": "GetAPITest.recieve_forecast()"
});
formatter.result({
  "duration": 2964057375,
  "status": "passed"
});
formatter.match({
  "location": "GetAPITest.postAPITest()"
});
formatter.result({
  "duration": 1634941959,
  "error_message": "org.json.JSONException: JSONObject[\"\"] not found.\n\tat org.json.JSONObject.get(JSONObject.java:471)\n\tat org.json.JSONObject.getJSONArray(JSONObject.java:618)\n\tat stepDefinitions.GetAPITest.postAPITest(GetAPITest.java:85)\n\tat ✽.And the temperature is warmer than 10 degrees(/Users/ankit/Downloads/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/Features/Holiday.feature:8)\n",
  "status": "failed"
});
});
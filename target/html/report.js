$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("settingsPage/settings.feature");
formatter.feature({
  "line": 1,
  "name": "HKLD admin user is able to do configuration on settings page.",
  "description": "",
  "id": "hkld-admin-user-is-able-to-do-configuration-on-settings-page.",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Open ETender system login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user logs in as the user type HKLD Admin",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user access settings page",
  "keyword": "And "
});
formatter.match({
  "location": "loginStepDefinitions.open_ETender_system_login_page()"
});
formatter.result({
  "duration": 6118090610,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HKLD Admin",
      "offset": 34
    }
  ],
  "location": "loginStepDefinitions.the_user_logs_in_as_the_user_type(String)"
});
formatter.result({
  "duration": 13090192416,
  "status": "passed"
});
formatter.match({
  "location": "DashboardStepDefinitions.user_access_setting_page()"
});
formatter.result({
  "duration": 646542109,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Edit a user",
  "description": "",
  "id": "hkld-admin-user-is-able-to-do-configuration-on-settings-page.;edit-a-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@setting"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "user access Users setting",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "he selects a user name sophie@hkland.com from the user list",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "he clicks Edit button for the single user",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "he add attribute for the single user",
  "rows": [
    {
      "cells": [
        "attribute"
      ],
      "line": 37
    },
    {
      "cells": [
        "General Users"
      ],
      "line": 38
    },
    {
      "cells": [
        "Approver"
      ],
      "line": 39
    },
    {
      "cells": [
        "AH"
      ],
      "line": 40
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "he saves the attributes for the single user",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Users",
      "offset": 12
    }
  ],
  "location": "SettingsStepDefinitions.user_access_settings(String)"
});
formatter.result({
  "duration": 3392744709,
  "error_message": "net.serenitybdd.core.exceptions.SerenityManagedException: Timed out after 2 seconds. Element not found\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027EPCNSZXW0238\u0027, ip: \u002710.22.17.114\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: driver.version: unknown\r\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.ajaxFindElement(SmartAjaxElementLocator.java:145)\r\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.findElement(SmartAjaxElementLocator.java:93)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy23.click(Unknown Source)\r\n\tat pages.SettingsPage.selectUserOption(SettingsPage.java:59)\r\n\tat serenity.SettingsSteps.selectSettingsOption(SettingsSteps.java:20)\r\n\tat serenity.SettingsSteps$$EnhancerByCGLIB$$99426867.CGLIB$selectSettingsOption$7(\u003cgenerated\u003e)\r\n\tat serenity.SettingsSteps$$EnhancerByCGLIB$$99426867$$FastClassByCGLIB$$41250b0c.invoke(\u003cgenerated\u003e)\r\n\tat net.sf.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:228)\r\n\tat net.thucydides.core.steps.StepInterceptor.invokeMethod(StepInterceptor.java:369)\r\n\tat net.thucydides.core.steps.StepInterceptor.executeTestStepMethod(StepInterceptor.java:354)\r\n\tat net.thucydides.core.steps.StepInterceptor.runTestStep(StepInterceptor.java:329)\r\n\tat net.thucydides.core.steps.StepInterceptor.testStepResult(StepInterceptor.java:134)\r\n\tat net.thucydides.core.steps.StepInterceptor.intercept(StepInterceptor.java:61)\r\n\tat serenity.SettingsSteps$$EnhancerByCGLIB$$99426867.selectSettingsOption(\u003cgenerated\u003e)\r\n\tat steps.definition.SettingsStepDefinitions.user_access_settings(SettingsStepDefinitions.java:18)\r\n\tat ✽.When user access Users setting(settingsPage/settings.feature:33)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "sophie@hkland.com",
      "offset": 23
    }
  ],
  "location": "SettingsStepDefinitions.he_selects_a_user_name_from_the_user_list(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsStepDefinitions.he_clicks_Edit_button_for_single_user()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsStepDefinitions.he_add_attribute_for_user(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SettingsStepDefinitions.user_save_attributes_for_single_user()"
});
formatter.result({
  "status": "skipped"
});

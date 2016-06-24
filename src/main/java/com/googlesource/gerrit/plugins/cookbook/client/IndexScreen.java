// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.cookbook.client;

import com.google.gerrit.plugin.client.rpc.RestApi;
import com.google.gerrit.plugin.client.screen.Screen;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Cookies;

class IndexScreen extends VerticalPanel {
  static class Factory implements Screen.EntryPoint {
    @Override
    public void onLoad(Screen screen) {
      screen.setPageTitle("cookbook index");
      screen.show(new IndexScreen());
    }
  }

  TextArea userEmailTextArea = new TextArea();

  IndexScreen() {
    setStyleName("cookbook-panel");
    String userEmailTxt = "Enter account email";
    userEmailTextArea.setText(userEmailTxt);
    Panel panel = new VerticalPanel();
    panel.add(userEmailTextArea);
    add(panel);

    Button helloButton = new Button("Get Gerrit Karma");
    helloButton.addStyleName("cookbook-helloButton");
    helloButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        sayHello();
      }
    });
    add(helloButton);
    helloButton.setEnabled(true);
  }

  private void sayHello() {
    String userEmail = userEmailTextArea.getText();
    Cookies.setCookie("karma_user_email", userEmail);

    /*String projectName = "demo-project";
    RestApi projectRestCall = new RestApi("projects").id(projectName).view("cookbook", "karma");
     restReply = "path: " + projectRestCall.path();

     projectRestCall.get(new AsyncCallback<JavaScriptObject>() {
       @Override
       public void onFailure(Throwable throwable) {
         restReply = restReply + ", error: " + throwable.getMessage();
         textArea.setText(restReply);
       }

        @Override
        public void onSuccess(JavaScriptObject javaScriptObject) {
          restReply = restReply + ", success: " + new JSONObject(javaScriptObject).toString();
          *//*Cookies browserCookies = new Cookies();
          browserCookies.setCookie("karma_user_email", userEmail);*//*
          //textArea.setText(restReply);
        }
    });*/
    Window.alert("making rest call...");
  }
}

package com.sophiesepp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ComposerNgramQuery extends TextResults implements EntryPoint{

	static VerticalPanel composerngramPanel = new VerticalPanel();
	HorizontalPanel composerngramPanel1= new HorizontalPanel(); 
	VerticalPanel composerngramPanel2 = new VerticalPanel();
	
	final static TextArea dataComposerNgram = new TextArea();
	
	final Label ngramLabel = new Label("Ngram");
	
	


	public void onModuleLoad() {

		composerngramPanel.addStyleName("composerngramPanel");
		composerngramPanel1.addStyleName("composerngramPanel1");
		composerngramPanel2.addStyleName("composerngramPanel2");
		

		
		ngramLabel.addStyleName("text3");
		
		dataComposerNgram.setWidth("600px");
		dataComposerNgram.setVisibleLines(20);
		dataComposerNgram.setEnabled(false);
		
		composerngramPanel.add(RootPanel.get("heading20"));
		composerngramPanel2.add(dataComposerNgram);	

		composerngramPanel.add(composerngramPanel1);
		composerngramPanel.add(composerngramPanel2);

	}


	public static void queryComposerNgram() {

		greetingService.showQueryComposerNgram(buildQueryComposerNgram(),new AsyncCallback<String>(){

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user

			}

			public void onSuccess(String result) {

				dataComposerNgram.getElement().setInnerText(result);
			}

		});
	}
	
	public static String buildQueryComposerNgram(){

		String c = Srsr.composerBox.getText();

		String query = "SELECT table4.ngram AS ngram, count(ngram) AS counts FROM (SELECT scoreId AS scoreId FROM(SELECT workId AS workId FROM workspace.composer AS composers JOIN workspace.work AS works ON composers.personId = works.personId WHERE composers.personId ='";
		query +=c;
		query += "') AS table1 JOIN EACH(SELECT workId AS workId, scoreId AS scoreId FROM workspace.score) AS table2 ON table1.workId = table2.workId) AS table3 JOIN EACH(SELECT scoreId AS scoreId, ngram AS ngram FROM workspace.ngram) AS table4 ON table3.scoreId = table4.scoreId GROUP EACH BY ngram ORDER BY counts DESC LIMIT 10";

		return query;
	}

}


package com.sophiesepp.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sophiesepp.shared.CountryKey;
import com.sophiesepp.shared.HeatmapObject;

public class CountryKeyQuery extends Heatmap implements EntryPoint {
	

	static VerticalPanel countrykeyPanel = new VerticalPanel();
	static HorizontalPanel countrykeycontentPanel = new HorizontalPanel();
	VerticalPanel leftcountrykeyPanel = new VerticalPanel();
	VerticalPanel rightcountrykeyPanel = new VerticalPanel();
	ScrollPanel scrollPanel = new ScrollPanel();

	
	HorizontalPanel countrykeyPanel1= new HorizontalPanel();
	HorizontalPanel  countrykeyPanel2 = new HorizontalPanel();	
	VerticalPanel countrykeyLabel1 = new VerticalPanel();
	VerticalPanel countrykeyLabel2 = new VerticalPanel();
	
	final Button showCountryKeyQueryButton = new Button("Run Query");
	
	final static SuggestBox keyscountry = new SuggestBox(Srsr.country);
	final Label countryLabel = new Label("Select country");
	private static int i = 0;
	private static int yPixelValue = 10;
	private static HashMap<String,Integer> countrykey = new HashMap<String,Integer>();
	
	
	public void onModuleLoad() {
		
		for (i=0;i<com.sophiesepp.client.Srsr.keys.length;i++){
			
			countrykey.put(com.sophiesepp.client.Srsr.keys[i],yPixelValue);
			yPixelValue+=20;
		}
		
		countrykeyPanel.addStyleName("countrykeyPanel");
		countrykeycontentPanel.addStyleName("countrykeycontentPanel");
		leftcountrykeyPanel.addStyleName("leftcountrykeyPanel");
		rightcountrykeyPanel.addStyleName("rightcountrykeyPanel");
		countrykeyPanel1.addStyleName("countrykeyPanel1");
		countrykeyPanel2.addStyleName("countrykeyPanel2");
		
		countrykeyLabel1.addStyleName("label");
		countrykeyLabel2.addStyleName("buttonlabel");
		
		keyscountry.addStyleName("textfield1");
		countryLabel.addStyleName("text3");
		
		showCountryKeyQueryButton.addStyleName("button1");
		
		showCountryKeyQueryButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				CountryKeyQuery.queryCountryKey();
			}
		});
		
		
	
		
	
		
		
		
		countrykeyPanel.add(RootPanel.get("heading5"));
		countrykeyPanel.add(countrykeycontentPanel);
	
		countrykeycontentPanel.add(leftcountrykeyPanel);
		countrykeycontentPanel.add(rightcountrykeyPanel);
		
		leftcountrykeyPanel.add(countrykeyPanel1);
		leftcountrykeyPanel.add(countrykeyPanel2);
		

		countrykeyLabel1.add(countryLabel);
		countrykeyLabel1.add(keyscountry);	
		countrykeyLabel2.add(showCountryKeyQueryButton);

		
		
		countrykeyPanel1.add(RootPanel.get("heatmapCountryKeyCanvas"));
		countrykeyPanel2.add(countrykeyLabel1);
		countrykeyPanel2.add(countrykeyLabel2);
		
		scrollPanel.setSize("280px","500px");
		rightcountrykeyPanel.add(scrollPanel);
		scrollPanel.add(RootPanel.get("rightcountrykeyPanel"));
		

	}

	public static void queryCountryKey() {

		greetingService.showQueryCountryKey(buildQueryCountryKey(),new AsyncCallback<List<CountryKey>>() {
			public void onFailure(Throwable caught) {

			}

			public void onSuccess(List<CountryKey> result) {
				
				int yValue;
					
				List<HeatmapObject> object = new ArrayList<HeatmapObject>();		
				
				for(CountryKey s: result)
				{			
					String key = s.key;
					yValue = countrykey.get(key);
					
					HeatmapObject obj = new HeatmapObject(55,yValue,s.counts);	
					object.add(obj);
					
				}
	
				String json = createJson(object);
				displayDataCountryKey(json);			
			
			

			}
		});
	}
	

	public static String buildQueryCountryKey(){

		String country = keyscountry.getText();

		String query = "SELECT table2.key AS key,count(table2.key) AS counts FROM workspace.composer AS table1 JOIN(SELECT key AS key, personId AS personId FROM workspace.work) AS table2 ON table1.personId=table2.personId WHERE table1.country='";
		query += country;
		query += "' GROUP BY key";
		System.out.println(query);

		return query;
	}
	
	public static native void displayDataCountryKey(String data) /*-{

	var obj = eval('('+data+')');


	// call the heatmap's store's setDataSet method in order to set static data

		$wnd.aa.store.setDataSet(obj);
}-*/;


}

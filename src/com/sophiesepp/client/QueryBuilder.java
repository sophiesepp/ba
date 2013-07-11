package com.sophiesepp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sophiesepp.client.GreetingService;
import com.sophiesepp.client.GreetingServiceAsync;

public class QueryBuilder implements EntryPoint {
	
	protected final static GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	

	
	static VerticalPanel  queryBuilderPanel= new VerticalPanel();
	static VerticalPanel  builderPanel= new VerticalPanel();
	static HorizontalPanel  examplePanel = new HorizontalPanel();
	static Button exampleButton = new Button("Show example");
	static HorizontalPanel  listTypePanel = new HorizontalPanel();
	static HorizontalPanel  builderPanel1 = new HorizontalPanel();
	static HorizontalPanel  builderPanel2 = new HorizontalPanel();
	static HorizontalPanel  builderPanel3 = new HorizontalPanel();
	static HorizontalPanel  builderPanel4 = new HorizontalPanel();
	static HorizontalPanel  builderPanel5 = new HorizontalPanel();
	
	

	
	String[] listTypes = {"please select","Composer","Work","Score"};
	String[] pleaseSelect ={};
	String[] composerCategories={"Name","Year of birth","Native Country","Place of birth","Ranking"};
	String[] workCategories={"Title","Year of publication","Key","Genre","Number of downloads","Ranking"};
	String[] scoreCategories={"Editor","Publisher","Number of pages","Number of downloads","Ranking","Instrumentation"};
	String[] ngramCategories={"Ngram","Type of ngram"};
	String[] name={"is"};
	String[] time ={"is","is before", "is after","is between"};
	String[] ranking ={"is","is better than", "is worse than","is between"};
	String[] number ={"is","is more than", "is less than","is between"};
	String[] instruments ={"is"};
	String[] instrumentation ={ "Keyboard","Chamber-Instrumental","Orchestral","Vocal"};


	// Creating boxes for five panels holding conditions
	
	final static ListBox selectBox = new ListBox(false);
	final static ListBox subjectBox = new ListBox(false);
	final static ListBox predicateBox = new ListBox(false);
	final static TextBox objectBox = new TextBox();
	final static Label connector = new Label("and");
	final static TextBox objectBox2 = new TextBox();
	final static ListBox countryBox = new ListBox(false);
	final static ListBox keyBox = new ListBox(false);
	final static SuggestBox genreBox = new SuggestBox(Srsr.genre);
	
	
	
	final static ListBox secondsubjectBox = new ListBox(false);
	final static ListBox secondpredicateBox = new ListBox(false);
	final static TextBox secondobjectBox = new TextBox();
	final static Label secondconnector = new Label("and");
	final static TextBox secondobjectBox2 = new TextBox();
	final static ListBox secondcountryBox = new ListBox(false);
	final static ListBox secondkeyBox = new ListBox(false);
	final static SuggestBox secondgenreBox = new SuggestBox(Srsr.genre);
	
	final static ListBox thirdsubjectBox = new ListBox(false);
	final static ListBox thirdpredicateBox = new ListBox(false);
	final static TextBox thirdobjectBox = new TextBox();
	final static Label thirdconnector = new Label("and");
	final static TextBox thirdobjectBox2 = new TextBox();
	final static ListBox thirdcountryBox = new ListBox(false);
	final static ListBox thirdkeyBox = new ListBox(false);
	final static SuggestBox thirdgenreBox = new SuggestBox(Srsr.genre);
	
	final static ListBox fourthsubjectBox = new ListBox(false);
	final static ListBox fourthpredicateBox = new ListBox(false);
	final static TextBox fourthobjectBox = new TextBox();
	final static Label fourthconnector = new Label("and");
	final static TextBox fourthobjectBox2 = new TextBox();
	final static ListBox fourthcountryBox = new ListBox(false);
	final static ListBox fourthkeyBox = new ListBox(false);
	final static SuggestBox fourthgenreBox = new SuggestBox(Srsr.genre);
	
	final static ListBox fifthsubjectBox = new ListBox(false);
	final static ListBox fifthpredicateBox = new ListBox(false);
	final static TextBox fifthobjectBox = new TextBox();
	final static Label fifthconnector = new Label("  and  ");
	final static TextBox fifthobjectBox2 = new TextBox();
	final static ListBox fifthcountryBox = new ListBox(false);
	final static ListBox fifthkeyBox = new ListBox(false);
	final static SuggestBox fifthgenreBox = new SuggestBox(Srsr.genre);
	
	final static TextBox examplesubjectBox1 = new TextBox();
	final static TextBox examplesubjectBox2 = new TextBox();
	final static TextBox examplesubjectBox3 = new TextBox();
	final static TextBox examplesubjectBox4 = new TextBox();
	final static TextBox examplepredicateBox1 = new TextBox();
	final static TextBox examplepredicateBox2 = new TextBox();
	final static TextBox examplepredicateBox3 = new TextBox();
	final static TextBox examplepredicateBox4 = new TextBox();
	final static TextBox exampleobjectBox1 = new TextBox();
	final static TextBox exampleobjectBox2 = new TextBox();
	final static TextBox exampleobjectBox3 = new TextBox();
	final static TextBox exampleobjectBox4 = new TextBox();
	



	final Button addCondition = new Button("Add Condition");
	final Button plusButton1 = new Button("+");
	final Button plusButton2 = new Button("+");
	final Button plusButton3 = new Button("+");
	final Button plusButton4 = new Button("+");
	final Button plusButton5 = new Button("+");
	
	final Button queryBuilderButton = new Button("Get Results");
	
	final static TextArea dataQueryBuilder = new TextArea();
	

	static int count = 0;
	Boolean exampleMode = false;



	public void onModuleLoad() {
		
		dataQueryBuilder.setReadOnly(true);
	
		
		queryBuilderPanel.addStyleName("queryBuilderPanel");
		queryBuilderButton.addStyleDependentName("queryBuilderButton");
		builderPanel.addStyleName("builderPanel");
		examplePanel.addStyleName("examplePanel");
		listTypePanel.addStyleName("listTypePanel");
		selectBox.addStyleName("dropBox");
		builderPanel1.addStyleName("builderPanel1");
		builderPanel2.addStyleName("builderPanel2");
		builderPanel3.addStyleName("builderPanel3");
		builderPanel4.addStyleName("builderPanel4");
		builderPanel5.addStyleName("builderPanel5");
	
		
		subjectBox.addStyleName("subjectBox");
		predicateBox.addStyleName("predicateBox");
		objectBox.addStyleName("objectBox");
		objectBox2.addStyleName("objectBox");
		connector.addStyleName("connector");
		countryBox.addStyleName("objectBoxList");
		keyBox.addStyleName("objectBoxList");
		genreBox.addStyleName("objectBox");
		secondsubjectBox.addStyleName("subjectBox");
		secondpredicateBox.addStyleName("predicateBox");
		secondobjectBox.addStyleName("objectBox");
		secondobjectBox2.addStyleName("objectBox");
		secondconnector.addStyleName("connector");
		secondcountryBox.addStyleName("objectBoxList");
		secondkeyBox.addStyleName("objectBoxList");
		secondgenreBox.addStyleName("objectBox");
		thirdsubjectBox.addStyleName("subjectBox");
		thirdpredicateBox.addStyleName("predicateBox");
		thirdobjectBox.addStyleName("objectBox");
		thirdobjectBox2.addStyleName("objectBox");
		thirdconnector.addStyleName("connector");
		thirdcountryBox.addStyleName("objectBoxList");
		thirdkeyBox.addStyleName("objectBoxList");
		thirdgenreBox.addStyleName("objectBox");
		fourthsubjectBox.addStyleName("subjectBox");
		fourthpredicateBox.addStyleName("predicateBox");
		fourthobjectBox.addStyleName("objectBox");
		fourthobjectBox2.addStyleName("objectBox");
		fourthconnector.addStyleName("connector");
		fourthcountryBox.addStyleName("objectBoxList");
		fourthkeyBox.addStyleName("objectBoxList");
		fourthgenreBox.addStyleName("objectBox");
		fifthsubjectBox.addStyleName("subjectBox");
		fifthpredicateBox.addStyleName("predicateBox");
		fifthobjectBox.addStyleName("objectBox");
		fifthobjectBox2.addStyleName("objectBox");
		fifthconnector.addStyleName("connector");
		fifthcountryBox.addStyleName("objectBoxList");
		fifthkeyBox.addStyleName("objectBoxList");
		fifthgenreBox.addStyleName("objectBox");
		plusButton1.addStyleName("plusButton");
		plusButton2.addStyleName("plusButton");
		plusButton3.addStyleName("plusButton");
		plusButton4.addStyleName("plusButton");
		
		plusButton1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				plusButton1.setEnabled(false);
				count++;
				showCategory(secondsubjectBox, selectBox.getSelectedIndex());
			}
		});
		
		plusButton2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				plusButton2.setEnabled(false);
				count++;
				showCategory(thirdsubjectBox, selectBox.getSelectedIndex());
			}
		});
		
		plusButton3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				plusButton3.setEnabled(false);
				count++;
				showCategory(fourthsubjectBox, selectBox.getSelectedIndex());
			}
		});
		
		plusButton4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				plusButton4.setEnabled(false);
				count++;
				showCategory(fifthsubjectBox, selectBox.getSelectedIndex());
			}
		});
	
	
		
		exampleButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			
				exampleMode= true;
				selectBox.setItemSelected(2, true);
				
				examplesubjectBox1.setVisible(true);			
				examplesubjectBox1.setText("Key");
				examplesubjectBox1.setEnabled(false);
			
				examplesubjectBox2.setVisible(true);	
				examplesubjectBox2.setText("Genre");
				examplesubjectBox2.setEnabled(false);
				
				examplesubjectBox3.setVisible(true);
				examplesubjectBox3.setText("Year of publication");
				examplesubjectBox3.setEnabled(false);
				
				examplesubjectBox4.setVisible(true);
				examplesubjectBox4.setText("Number of downloads");
				examplesubjectBox4.setEnabled(false);
				
				examplepredicateBox1.setVisible(true);
				examplepredicateBox1.setText("is");
				examplepredicateBox1.setEnabled(false);
				
				examplepredicateBox2.setVisible(true);
				examplepredicateBox2.setText("is");
				examplepredicateBox2.setEnabled(false);
				
				examplepredicateBox3.setVisible(true);
				examplepredicateBox3.setText("is before");
				examplepredicateBox3.setEnabled(false);
				
				examplepredicateBox4.setVisible(true);
				examplepredicateBox4.setText("is more than");
				examplepredicateBox4.setEnabled(false);
				
			
			 
			    keyBox.setVisible(true);
				keyBox.setItemSelected(1, true);
				secondobjectBox.setVisible(true);
				secondobjectBox.setText("1800");
				thirdgenreBox.setVisible(true);
				thirdgenreBox.setText("Kritis");
				fourthobjectBox.setVisible(true);
				fourthobjectBox.setText("10000");
				fourthobjectBox.setEnabled(false);
				
				plusButton1.setVisible(true);
				plusButton2.setVisible(true);
				plusButton3.setVisible(true);
				plusButton4.setVisible(true);
				
				
				plusButton1.setEnabled(false);
				plusButton2.setEnabled(false);
				plusButton3.setEnabled(false);
				plusButton4.setEnabled(false);
				
				querybuilderExample();
			
				
			}
		});
		
		queryBuilderButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				querybuilder();
			}
		});
		
		selectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				
				exampleMode=false;
				
				// buttons should be visible;
				plusButton1.setEnabled(true);
				plusButton2.setEnabled(true);
				plusButton3.setEnabled(true);
				plusButton4.setEnabled(true);
				plusButton5.setEnabled(true);
				
				
				subjectBox.setVisible(false);
				predicateBox.setVisible(false);
				objectBox.setVisible(false);
				objectBox2.setVisible(false);
				connector.setVisible(false);
				countryBox.setVisible(false);
				keyBox.setVisible(false);
				genreBox.setVisible(false);
				
				secondsubjectBox.setVisible(false);
				secondpredicateBox.setVisible(false);
				secondobjectBox.setVisible(false);
				secondobjectBox2.setVisible(false);
				secondconnector.setVisible(false);
				secondcountryBox.setVisible(false);
				secondkeyBox.setVisible(false);
				secondgenreBox.setVisible(false);
				
				thirdsubjectBox.setVisible(false);
				thirdpredicateBox.setVisible(false);
				thirdobjectBox.setVisible(false);
				thirdobjectBox2.setVisible(false);
				thirdconnector.setVisible(false);
				thirdcountryBox.setVisible(false);
				thirdkeyBox.setVisible(false);
				thirdgenreBox.setVisible(false);
				
				fourthsubjectBox.setVisible(false);
				fourthpredicateBox.setVisible(false);
				fourthobjectBox.setVisible(false);
				fourthobjectBox2.setVisible(false);
				fourthconnector.setVisible(false);
				fourthcountryBox.setVisible(false);
				fourthkeyBox.setVisible(false);
				fourthgenreBox.setVisible(false);
				
				fifthsubjectBox.setVisible(false);
				fifthpredicateBox.setVisible(false);
				fifthobjectBox.setVisible(false);
				fifthobjectBox2.setVisible(false);
				fifthconnector.setVisible(false);
				fifthcountryBox.setVisible(false);
				fifthkeyBox.setVisible(false);
				fifthgenreBox.setVisible(false);
				
				examplesubjectBox1.setVisible(false);
				examplesubjectBox2.setVisible(false);
				examplesubjectBox3.setVisible(false);
				examplesubjectBox4.setVisible(false);
				
				examplepredicateBox1.setVisible(false);
				examplepredicateBox2.setVisible(false);
				examplepredicateBox3.setVisible(false);
				examplepredicateBox4.setVisible(false);
				
				exampleobjectBox1.setVisible(false);
				exampleobjectBox2.setVisible(false);
				exampleobjectBox3.setVisible(false);
				exampleobjectBox4.setVisible(false);
				
				plusButton1.setVisible(false);
				plusButton2.setVisible(false);
				plusButton3.setVisible(false);
				plusButton4.setVisible(false);
				queryBuilderButton.setVisible(false);
				count = 0;
				showCategory(subjectBox, selectBox.getSelectedIndex());
				

			}
		});

		selectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				exampleMode=false;
				
				// buttons should be visible;
				plusButton1.setEnabled(true);
				plusButton2.setEnabled(true);
				plusButton3.setEnabled(true);
				plusButton4.setEnabled(true);
				plusButton5.setEnabled(true);
				
				
				subjectBox.setVisible(false);
				predicateBox.setVisible(false);
				objectBox.setVisible(false);
				objectBox2.setVisible(false);
				connector.setVisible(false);
				countryBox.setVisible(false);
				keyBox.setVisible(false);
				genreBox.setVisible(false);
				
				secondsubjectBox.setVisible(false);
				secondpredicateBox.setVisible(false);
				secondobjectBox.setVisible(false);
				secondobjectBox2.setVisible(false);
				secondconnector.setVisible(false);
				secondcountryBox.setVisible(false);
				secondkeyBox.setVisible(false);
				secondgenreBox.setVisible(false);
				
				thirdsubjectBox.setVisible(false);
				thirdpredicateBox.setVisible(false);
				thirdobjectBox.setVisible(false);
				thirdobjectBox2.setVisible(false);
				thirdconnector.setVisible(false);
				thirdcountryBox.setVisible(false);
				thirdkeyBox.setVisible(false);
				thirdgenreBox.setVisible(false);
				
				fourthsubjectBox.setVisible(false);
				fourthpredicateBox.setVisible(false);
				fourthobjectBox.setVisible(false);
				fourthobjectBox2.setVisible(false);
				fourthconnector.setVisible(false);
				fourthcountryBox.setVisible(false);
				fourthkeyBox.setVisible(false);
				fourthgenreBox.setVisible(false);
				
				fifthsubjectBox.setVisible(false);
				fifthpredicateBox.setVisible(false);
				fifthobjectBox.setVisible(false);
				fifthobjectBox2.setVisible(false);
				fifthconnector.setVisible(false);
				fifthcountryBox.setVisible(false);
				fifthkeyBox.setVisible(false);
				fifthgenreBox.setVisible(false);
				
				plusButton1.setVisible(false);
				plusButton2.setVisible(false);
				plusButton3.setVisible(false);
				plusButton4.setVisible(false);
				queryBuilderButton.setVisible(false);
				count = 0;
				showCategory(subjectBox, selectBox.getSelectedIndex());
				

			}
		});

		
		

		subjectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				objectBox.setVisible(false);
				objectBox2.setVisible(false);
				connector.setVisible(false);
				countryBox.setVisible(false);
				keyBox.setVisible(false);
				genreBox.setVisible(false);
				predicateBox.setVisible(false);
				showPredicate(predicateBox,selectBox.getSelectedIndex(),subjectBox.getSelectedIndex());
			}
			}
		});
		
		secondsubjectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				secondobjectBox.setVisible(false);
				secondobjectBox2.setVisible(false);
				secondconnector.setVisible(false);
				secondcountryBox.setVisible(false);
				secondkeyBox.setVisible(false);
				secondgenreBox.setVisible(false);
				secondpredicateBox.setVisible(false);
				showPredicate(secondpredicateBox,selectBox.getSelectedIndex(),secondsubjectBox.getSelectedIndex());
				}
			}
		});
		
		thirdsubjectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				thirdobjectBox.setVisible(false);
				thirdobjectBox2.setVisible(false);
				thirdconnector.setVisible(false);
				thirdcountryBox.setVisible(false);
				thirdkeyBox.setVisible(false);
				thirdgenreBox.setVisible(false);
				thirdpredicateBox.setVisible(false);
				showPredicate(thirdpredicateBox,selectBox.getSelectedIndex(),thirdsubjectBox.getSelectedIndex());
			}
			}
		});
		
		fourthsubjectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				fourthobjectBox.setVisible(false);
				fourthobjectBox2.setVisible(false);
				fourthconnector.setVisible(false);
				fourthcountryBox.setVisible(false);
				fourthkeyBox.setVisible(false);
				fourthgenreBox.setVisible(false);
				fourthpredicateBox.setVisible(false);
				showPredicate(fourthpredicateBox,selectBox.getSelectedIndex(),fourthsubjectBox.getSelectedIndex());
			}
			}
		});
		
		fifthsubjectBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				fifthobjectBox.setVisible(false);
				fifthobjectBox2.setVisible(false);
				fifthconnector.setVisible(false);
				fifthcountryBox.setVisible(false);
				fifthkeyBox.setVisible(false);
				fifthgenreBox.setVisible(false);
				fifthpredicateBox.setVisible(false);
				showPredicate(fifthpredicateBox,selectBox.getSelectedIndex(),fifthsubjectBox.getSelectedIndex());
				}
			}
		});
		
		subjectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				predicateBox.setVisible(false);
				showPredicate(predicateBox,selectBox.getSelectedIndex(),subjectBox.getSelectedIndex());
			}
			}
		});
		
		secondsubjectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				secondpredicateBox.setVisible(false);
				showPredicate(secondpredicateBox,selectBox.getSelectedIndex(),secondsubjectBox.getSelectedIndex());
			}
			}
		});
		
		thirdsubjectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				thirdpredicateBox.setVisible(false);
				showPredicate(thirdpredicateBox,selectBox.getSelectedIndex(),thirdsubjectBox.getSelectedIndex());
			}
			}
		});

		fourthsubjectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				fourthpredicateBox.setVisible(false);
				showPredicate(fourthpredicateBox,selectBox.getSelectedIndex(),fourthsubjectBox.getSelectedIndex());
			}
			}
		});
		
		fifthsubjectBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				fifthpredicateBox.setVisible(false);
				showPredicate(fifthpredicateBox,selectBox.getSelectedIndex(), fifthsubjectBox.getSelectedIndex());
			}
			}
		});
		predicateBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				objectBox.setVisible(false);
				objectBox2.setVisible(false);
				connector.setVisible(false);
				showObject(predicateBox,subjectBox,objectBox,objectBox2,countryBox, keyBox, genreBox, plusButton1,connector);
				
			}
			}
		});
		
		secondpredicateBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				secondobjectBox.setVisible(false);
				secondobjectBox2.setVisible(false);
				secondconnector.setVisible(false);				
				showObject(secondpredicateBox,secondsubjectBox,secondobjectBox,secondobjectBox2,secondcountryBox,secondkeyBox,secondgenreBox,plusButton2,secondconnector);
			}
			}
		});
		
		thirdpredicateBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				thirdobjectBox.setVisible(false);
				thirdobjectBox2.setVisible(false);
				thirdconnector.setVisible(false);	
				showObject(thirdpredicateBox,thirdsubjectBox,thirdobjectBox,thirdobjectBox2,thirdcountryBox, thirdkeyBox,thirdgenreBox,plusButton3,thirdconnector);
				
			}
			}
		});
		
		fourthpredicateBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				fourthobjectBox.setVisible(false);
				fourthobjectBox2.setVisible(false);
				fourthconnector.setVisible(false);	
				showObject(fourthpredicateBox,fourthsubjectBox,fourthobjectBox,fourthobjectBox2,fourthcountryBox, fourthkeyBox, fourthgenreBox, plusButton4,fourthconnector);
				}
			}
		});
		
		fifthpredicateBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if(exampleMode==false){
				fifthobjectBox.setVisible(false);
				fifthobjectBox2.setVisible(false);
				fifthconnector.setVisible(false);	
				showObject(fifthpredicateBox,fifthsubjectBox,fifthobjectBox,fifthobjectBox2,fifthcountryBox,fifthkeyBox, fifthgenreBox, plusButton5,fifthconnector);
				}
			}
		});
		predicateBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				showObject(predicateBox,subjectBox,objectBox,objectBox2,countryBox,keyBox, genreBox,plusButton1,connector);
				}
			}
		});
		secondpredicateBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				showObject(secondpredicateBox,secondsubjectBox,secondobjectBox,secondobjectBox2,secondcountryBox, secondkeyBox,secondgenreBox, plusButton2,secondconnector);
			}
			}
		});
	
		thirdpredicateBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				showObject(thirdpredicateBox,thirdsubjectBox,thirdobjectBox,thirdobjectBox2,thirdcountryBox, thirdkeyBox, thirdgenreBox,plusButton3,thirdconnector);
			}
			}
		});
		
		fourthpredicateBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				showObject(fourthpredicateBox,fourthsubjectBox,fourthobjectBox,fourthobjectBox2,fourthcountryBox, fourthkeyBox, fourthgenreBox, plusButton4,fourthconnector);
			}
			}
		});
		
		fifthpredicateBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(exampleMode==false){
				showObject(fifthpredicateBox,fifthsubjectBox,fifthobjectBox,fifthobjectBox2,fifthcountryBox, fifthkeyBox,fifthgenreBox,plusButton5,fifthconnector);
			}
			}
		});
	
	

		

		for (int i = 0; i < listTypes.length; i++) {
			selectBox.addItem(listTypes[i]);
		}

		for (int i = 0; i < Srsr.countries.length; i++) {
			countryBox.addItem(Srsr.countries[i]);
		}
		
		for (int i = 0; i < Srsr.countries.length; i++) {
			secondcountryBox.addItem(Srsr.countries[i]);
		}
		
		for (int i = 0; i < Srsr.countries.length; i++) {
			thirdcountryBox.addItem(Srsr.countries[i]);
		}
		
		for (int i = 0; i < Srsr.countries.length; i++) {
			fourthcountryBox.addItem(Srsr.countries[i]);
		}
		
		for (int i = 0; i < Srsr.countries.length; i++) {
			fifthcountryBox.addItem(Srsr.countries[i]);
		}
		
		for (int i = 0; i < Srsr.keys.length; i++) {
			keyBox.addItem(Srsr.keys[i]);
		}
		
		for (int i = 0; i < Srsr.keys.length; i++) {
			secondkeyBox.addItem(Srsr.keys[i]);
		}
		
		for (int i = 0; i < Srsr.keys.length; i++) {
			thirdkeyBox.addItem(Srsr.keys[i]);
		}
		
		for (int i = 0; i < Srsr.keys.length; i++) {
			fourthkeyBox.addItem(Srsr.keys[i]);
		}
		
		for (int i = 0; i < Srsr.keys.length; i++) {
			fifthkeyBox.addItem(Srsr.keys[i]);
		}
		
		

		queryBuilderPanel.add(builderPanel);
		examplePanel.add(exampleButton);
		listTypePanel.add(selectBox);
		listTypePanel.add(queryBuilderButton);	
		selectBox.addStyleName("box");
		
		// As five conditions can be specified a panel for each condition
		builderPanel.add(examplePanel);
		builderPanel.add(listTypePanel);
		builderPanel.add(builderPanel1);
		builderPanel.add(builderPanel2);
		builderPanel.add(builderPanel3);
		builderPanel.add(builderPanel4);
		builderPanel.add(builderPanel5);



		builderPanel1.add(addCondition);
		builderPanel1.add(subjectBox);
		builderPanel1.add(predicateBox);
		builderPanel1.add(objectBox);
		builderPanel1.add(connector);
		builderPanel1.add(objectBox2);	
		builderPanel1.add(countryBox);	
		builderPanel1.add(keyBox);
		builderPanel1.add(genreBox);	
		builderPanel1.add(plusButton1);
		
		builderPanel2.add(secondsubjectBox);
		builderPanel2.add(secondpredicateBox);
		builderPanel2.add(secondobjectBox);
		builderPanel2.add(secondconnector);
		builderPanel2.add(secondobjectBox2);	
		builderPanel2.add(secondcountryBox);	
		builderPanel2.add(secondkeyBox);
		builderPanel2.add(secondgenreBox);	
		builderPanel2.add(plusButton2);
	
		builderPanel3.add(thirdsubjectBox);
		builderPanel3.add(thirdpredicateBox);
		builderPanel3.add(thirdobjectBox);
		builderPanel3.add(thirdconnector);
		builderPanel3.add(thirdobjectBox2);	
		builderPanel3.add(thirdcountryBox);	
		builderPanel3.add(thirdkeyBox);
		builderPanel3.add(thirdgenreBox);	
		builderPanel3.add(plusButton3);
		
		builderPanel4.add(fourthsubjectBox);
		builderPanel4.add(fourthpredicateBox);
		builderPanel4.add(fourthobjectBox);
		builderPanel4.add(fourthconnector);
		builderPanel4.add(fourthobjectBox2);	
		builderPanel4.add(fourthcountryBox);
		builderPanel4.add(fourthkeyBox);
		builderPanel4.add(fourthgenreBox);	
		builderPanel4.add(plusButton4);
		
		builderPanel5.add(fifthsubjectBox);
		builderPanel5.add(fifthpredicateBox);
		builderPanel5.add(fifthobjectBox);
		builderPanel5.add(fifthconnector);
		builderPanel5.add(fifthobjectBox2);	
		builderPanel5.add(fifthcountryBox);	
		builderPanel5.add(fifthkeyBox);	
		builderPanel5.add(fifthgenreBox);	
		
		builderPanel1.add(examplesubjectBox1);
		builderPanel1.add(examplepredicateBox1);
		builderPanel1.add(exampleobjectBox1);
		builderPanel2.add(examplesubjectBox2);
		builderPanel2.add(examplepredicateBox2);
		builderPanel2.add(exampleobjectBox2);
		builderPanel3.add(examplesubjectBox3);
		builderPanel3.add(examplepredicateBox3);
		builderPanel3.add(exampleobjectBox3);
		builderPanel4.add(examplesubjectBox4);
		builderPanel4.add(examplepredicateBox4);
		builderPanel4.add(exampleobjectBox4);
	
		
	
		
		
		dataQueryBuilder.setWidth("500px");
		dataQueryBuilder.setVisibleLines(20);
		
		
		queryBuilderPanel.add(dataQueryBuilder);
		
		
		// no graphical elements are visible at the beginning
		
		addCondition.setVisible(false);
		subjectBox.setVisible(false);
		predicateBox.setVisible(false);
		objectBox.setVisible(false);   
		connector.setVisible(false);   
		objectBox2.setVisible(false);
		countryBox.setVisible(false);	
		keyBox.setVisible(false);
		genreBox.setVisible(false);
		queryBuilderButton.setVisible(false);
		plusButton1.setVisible(false);
		
		secondsubjectBox.setVisible(false);
		secondpredicateBox.setVisible(false);
		secondobjectBox.setVisible(false);   
		secondconnector.setVisible(false);   
		secondobjectBox2.setVisible(false);
		secondcountryBox.setVisible(false);	
		secondkeyBox.setVisible(false);
		secondgenreBox.setVisible(false);
		plusButton2.setVisible(false);
		
		thirdsubjectBox.setVisible(false);
		thirdpredicateBox.setVisible(false);
		thirdobjectBox.setVisible(false);   
		thirdconnector.setVisible(false);   
		thirdobjectBox2.setVisible(false);
		thirdcountryBox.setVisible(false);
		thirdkeyBox.setVisible(false);
		thirdgenreBox.setVisible(false);
		plusButton3.setVisible(false);
		
		fourthsubjectBox.setVisible(false);
		fourthpredicateBox.setVisible(false);
		fourthobjectBox.setVisible(false);   
		fourthconnector.setVisible(false);   
		fourthobjectBox2.setVisible(false);
		fourthcountryBox.setVisible(false);	
		fourthkeyBox.setVisible(false);
		fourthgenreBox.setVisible(false);
		plusButton4.setVisible(false);
		
		fifthsubjectBox.setVisible(false);
		fifthpredicateBox.setVisible(false);
		fifthobjectBox.setVisible(false);   
		fifthconnector.setVisible(false);   
		fifthobjectBox2.setVisible(false);
		fifthcountryBox.setVisible(false);	 
		fifthkeyBox.setVisible(false);
		fifthgenreBox.setVisible(false);
		
		
		
	}
	

	public static void querybuilder() {

		greetingService.showQueryBuilderResults(buildQuery(),new AsyncCallback<String>(){
			public void onFailure(Throwable caught) {


			}

			public void onSuccess(String result) {

				dataQueryBuilder.getElement().setInnerText(result);
			

			}
		});
	}
	
	public static void querybuilderExample() {

		greetingService.showQueryBuilderResults(buildQueryExample(),new AsyncCallback<String>(){
			public void onFailure(Throwable caught) {


			}

			public void onSuccess(String result) {

				dataQueryBuilder.getElement().setInnerText(result);
			

			}
		});
	}
	
	
	

	

	public void showCategory(ListBox listBox,int category) {

		listBox.clear();
		String[] listData = null;
		switch (category) {
		case 0:
			listData =  pleaseSelect;
			break;
		case 1:
			listData = composerCategories;
			break;
		case 2:
			listData = workCategories;
			break;
		case 3:
			listData = scoreCategories;
			break;
		case 4:
			listData = ngramCategories;
			break;
		}
		for (int i = 0; i < listData.length; i++) {
			listBox.addItem(listData[i]);
		}
		listBox.setVisible(true);
	}



	public void showPredicate(ListBox listBox,int category, int category2) {

		listBox.clear();
		String[] listData = null;
		switch (category) {
		case 1:
			switch (category2){
			case 0:
				listData =  name;
				break;
			case 1:
				listData =  time;
				break;
			case 2:
				listData =  name;
				break;
			case 3:
				listData =  name;
				break;
			case 4:
				listData =  ranking;
				break;
			case 5:
				listData =  name;
				break;
			}
			break;
		case 2:
			switch (category2){
			case 0:
				listData =  name;
				break;
			case 1:
				listData =  time;
				break;
			case 2:
				listData =  name;
				break;
			case 3:
				listData =  name;
				break;
			case 4:
				listData =  number;
				break;
			case 5:
				listData =  ranking;
				break;
			}
			break;
		case 3:
			switch (category2){
			case 0:
				listData =  name;
				break;
			case 1:
				listData =  name;
				break;
			case 2:
				listData =  number;
				break;
			case 3:
				listData =  number;
				break;
			case 4:
				listData =  ranking;
				break;
			case 5:
				listData =  instruments;
				break;
			}
			break;
	
		}

		for (int i = 0; i < listData.length; i++) {
			listBox.addItem(listData[i]);
		}
		listBox.setVisible(true);

	}



	public void showObject(ListBox predicateBox, ListBox subjectBox, TextBox objectBox, TextBox objectBox2, ListBox countryBox, ListBox keyBox, SuggestBox genreBox, Button button, Label connector ) {
		if(predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is between")){
			connector.setVisible(true);
			objectBox.setVisible(true);
			objectBox2.setVisible(true);
			
		}
		else{
			if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Native Country")){
				countryBox.setVisible(true);
			}
			else if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Key")){
				keyBox.setVisible(true);
			}
			else if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Genre")){
				genreBox.setVisible(true);
			}
			else{
				objectBox.setVisible(true);
				
			}
		}
		
		queryBuilderButton.setVisible(true);
		if(count<4){
		button.setVisible(true);
		}
	}







	public static String buildQuery(){

		String query = "SELECT ";
		String item = null;
		//testing which dropbox item is selected
		if(selectBox.getItemText(selectBox.getSelectedIndex()).equals("Composer")){
			System.out.print("composer");
			query += "personId FROM workspace.composer WHERE ";
			
			String subject = buildqueryComposer(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += subject;
			String predicateobject = buildPredicateObject(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += predicateobject;
			
			if(count>0){;
			query += " AND ";
			String subject2 = buildqueryComposer(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += subject2;
			String predicateobject2 = buildPredicateObject(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += predicateobject2;
			}
			
			if(count>1){;
			query += " AND ";
			String subject3 = buildqueryComposer(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += subject3;
			String predicateobject3 = buildPredicateObject(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += predicateobject3;
			}
			
			if(count>2){;
			query += " AND ";
			String subject4 = buildqueryComposer(fourthsubjectBox,fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += subject4;
			String predicateobject4 = buildPredicateObject(fourthsubjectBox,fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += predicateobject4;
			}
			
			if(count>3){;
			query += " AND ";
			String subject5 = buildqueryComposer(fifthsubjectBox,fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += subject5;
			String predicateobject5 = buildPredicateObject(fifthsubjectBox,fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += predicateobject5;
			}
			
			query += ";";
	
		}
		if(selectBox.getItemText(selectBox.getSelectedIndex()).equals("Work")){
			query += "workId FROM workspace.work WHERE ";
			
			String subject = buildqueryWork(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += subject;
			String predicateobject = buildPredicateObject(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += predicateobject;
			
			if(count>0){;
			query += " AND ";
			String subject2 = buildqueryWork(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += subject2;
			String predicateobject2 = buildPredicateObject(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += predicateobject2;
			}
			
			if(count>1){;
			query += " AND ";
			String subject3 = buildqueryWork(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += subject3;
			String predicateobject3 = buildPredicateObject(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += predicateobject3;
			}
			
			if(count>2){;
			query += " AND ";
			String subject4 = buildqueryWork(fourthsubjectBox,fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += subject4;
			String predicateobject4 = buildPredicateObject(fourthsubjectBox,fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += predicateobject4;
			}
			
			if(count>3){;
			query += " AND ";
			String subject5 = buildqueryWork(fifthsubjectBox,fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += subject5;
			String predicateobject5 = buildPredicateObject(fifthsubjectBox,fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += predicateobject5;
			}
			
			query += ";";
		
			
			}
			if(selectBox.getItemText(selectBox.getSelectedIndex()).equals("Score")){
			query += "scoreId FROM workspace.score WHERE ";
				
			String subject = buildqueryScore(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += subject;
			String predicateobject = buildPredicateObject(subjectBox,predicateBox, objectBox, objectBox2, item);
			query += predicateobject;
			
			if(count>0){;
			query += " AND ";
			String subject2 = buildqueryScore(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += subject2;
			String predicateobject2 = buildPredicateObject(secondsubjectBox,secondpredicateBox, secondobjectBox, secondobjectBox2, item);
			query += predicateobject2;
			}
			
			if(count>1){;
			query += " AND ";
			String subject3 = buildqueryScore(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += subject3;
			String predicateobject3 = buildPredicateObject(thirdsubjectBox,thirdpredicateBox, thirdobjectBox, thirdobjectBox2, item);
			query += predicateobject3;
			}
			
			if(count>2){;
			query += " AND ";
			String subject4 = buildqueryScore(fourthsubjectBox,fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += subject4;
			String predicateobject4 = buildPredicateObject(fourthsubjectBox, fourthpredicateBox, fourthobjectBox, fourthobjectBox2, item);
			query += predicateobject4;
			}
			
			if(count>3){;
			query += " AND ";
			String subject5 = buildqueryScore(fifthsubjectBox, fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += subject5;
			String predicateobject5 = buildPredicateObject(fifthsubjectBox,fifthpredicateBox, fifthobjectBox, fifthobjectBox2, item);
			query += predicateobject5;
			}
			
			query += ";";
			
			
		
		}
		
		
		System.out.println(query);
		return query;
	}
	
	
	public static String buildqueryComposer(ListBox subjectbox, ListBox prediactebox, TextBox objectbox, TextBox objectbox2, String item ){
		
		String query = "";
		
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Name")){
			query += "name";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Year of birth")){
			query += "birth";
			item="birth";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Native Country")){
			query += "country";
		}

		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Place of birth")){
			query += "city";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Ranking")){
			query += "ranking";
			item="ranking";
		}
		
		return query;
	}

	public static String buildqueryWork(ListBox subjectbox, ListBox prediactebox, TextBox objectbox, TextBox objectbox2, String item ){
	
	String query = "";
		
	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Title")){
		query += "title";
	}
	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Year of publication")){
		query += "publication";
		item="publication";
	}
	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Key")){
		query += "key";
	}

	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Genre")){
		query += "genre";
	}
	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Number of downloads")){
		query += "downloads";
		item="downloads";
	}
	if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Ranking")){
		query += "ranking";
		item="ranking";
	}
	
	return query;
		
	}
	
	public static String buildqueryScore(ListBox subjectbox, ListBox prediactebox, TextBox objectbox, TextBox objectbox2, String item ){
		
		String query = "";
		
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Editor")){
			query += "editor";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Publisher")){
			query += "publisher";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Number of pages")){
			query += "pages";
			item="pages";
		}

		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Number of downloads")){
			query += "downloads";
			item="downloads";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Ranking")){
			query += "ranking";
			item="ranking";
		}
		if(subjectbox.getItemText(subjectbox.getSelectedIndex()).equals("Instruments")){
			query += "instrumentation";
			item="instrumentation";
		}
		
		return query;
	}
	
	public static String buildPredicateObject(ListBox subjectBox, ListBox predicateBox, TextBox objectBox, TextBox objectBox2, String item){
		
		String query = "";
		
		//testing which predicateBox item is selected
				if(predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is")){
					if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Native Country")){
						query += "='";
						query += countryBox.getItemText(countryBox.getSelectedIndex());
						query += "'";
						
					}
					else if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Key")){
						query += "='";
						query += keyBox.getItemText(keyBox.getSelectedIndex());
						query += "'";
						
					}
					else if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Genre")){
						query += "='";
						query += genreBox.getText();
						query += "'";
						
					}
					else{
						//testing if the parameter has to be added to the query as String
						if(subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Name")||
								subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Place of birth")||
								subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Title")||
								subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Genre")||
								subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Editor")||
								subjectBox.getItemText(subjectBox.getSelectedIndex()).equals("Publisher"))
						{
							query += "='";
							query += objectBox.getText();
							query += "'";
							
						}
						else{
							// parameter has to be added as int
							query += "=";
							query += objectBox.getText();
							
						}
					}
				}
				if(predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is before")||predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is better than")||predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is less than")){
					query += "<";
					query += objectBox.getText();
				
				}
				if(predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is after")||predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is worse than")||predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is more than")){
					query += ">";
					query += objectBox.getText();
					
				}
				if(predicateBox.getItemText(predicateBox.getSelectedIndex()).equals("is between")){
					query += ">";
					query += objectBox.getText();
					query += " AND "+item+"<";
					query += objectBox2.getText();
					
				}

				return query;
		}
	
	
	public static String buildQueryExample(){
		
		String query = "SELECT workId FROM workspace.work WHERE key='Db' AND genre ='Landler' AND publication<1800 AND downloads>10000";
		System.out.println(query);
		return query;
	}
		
		
		


}

package com.sophiesepp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sophiesepp.shared.D3Object2ParameterType1;
import com.sophiesepp.shared.WorkScorePercent;

public class WorkScorePercentQuery extends D3 implements EntryPoint{
	

	


	static VerticalPanel workscorePanel = new VerticalPanel();
	static HorizontalPanel workscorecontentPanel = new HorizontalPanel();
	VerticalPanel leftworkscorePanel = new VerticalPanel();
	VerticalPanel rightworkscorePanel = new VerticalPanel();
	ScrollPanel scrollPanel = new ScrollPanel();


	VerticalPanel  workscorePanel1 = new VerticalPanel();

	public void onModuleLoad() {
	
	
		
		
		workscorePanel.addStyleName("workscorePanel");
		workscorecontentPanel.addStyleName("workscorecontentPanel");
		leftworkscorePanel.addStyleName("leftworkscorePanel");
		rightworkscorePanel.addStyleName("rightworkscorePanel");
		workscorePanel1.addStyleName("workscorePanel1");
		
		workscorePanel.add(RootPanel.get("heading9"));
		workscorePanel.add(workscorecontentPanel);
		
		workscorecontentPanel.add(leftworkscorePanel);
		workscorecontentPanel.add(rightworkscorePanel);
		
		leftworkscorePanel.add(workscorePanel1);
		
		workscorePanel1.add(RootPanel.get("pieWorkScore"));
		

		scrollPanel.setSize("280px","500px");
		rightworkscorePanel.add(scrollPanel);
		scrollPanel.add(RootPanel.get("rightworkscorePanel"));
		
	}
	

	public static void queryWorkScorePercent() {

		greetingService.showQueryWorkScorePercent(buildQueryWorkScorePercent(),new AsyncCallback<List<WorkScorePercent>>(){
			public void onFailure(Throwable caught) {


			}

			public void onSuccess(List<WorkScorePercent> result) {
				
				List<D3Object2ParameterType1> object = new ArrayList<D3Object2ParameterType1>();
				
				
				for(WorkScorePercent s: result)
				{			
					D3Object2ParameterType1 obj = new D3Object2ParameterType1(s.scores,s.works);	
					object.add(obj);
					
				}
				
				String json = createJson2ParameterType1(object,"scores","works");



				displayDataWorkScorePercent(json);
			}
		});
	}
	


	public static String buildQueryWorkScorePercent(){


		String query = "SELECT counts AS scores, count(workId) AS works FROM (SELECT table1.workId AS workId,count(table2.scoreId) AS counts FROM workspace.work AS table1 JOIN (SELECT scoreId AS scoreId, workId AS workId FROM workspace.score) AS table2 ON table1.workId=table2.workId GROUP BY workId) GROUP BY scores ORDER BY works ASC";

		System.out.println(query);

		return query;
	}


	public static native void displayDataWorkScorePercent(String data) /*-{

	var obj = eval(data);
	$wnd.workscore(obj);	



	}-*/;


}

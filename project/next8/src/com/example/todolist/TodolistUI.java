package com.example.todolist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
@Theme("todolist")
@Title("next 8 app")
public class TodolistUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TodolistUI.class)
	public static class Servlet extends VaadinServlet {
	}

	
	public static Database db = new Database("jdbc:h2:~/vaadin", "sa", "");
	@SuppressWarnings("deprecation")
	@Override
	
	
	
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Statement stmt = null;
		ResultSet rs = null;
	
		
			try {
				if (db.connect()) {
					System.out.println("H2 DATABASE connection_on - PROOF OF CONCEPT");
					stmt = db.conn.createStatement();
					rs = stmt.executeQuery("SELECT DEADLINE, TASK, STATUS FROM TASK");
					rs.next();
					System.out.println(rs.getDate(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.disconnect();
			}
			
//ABOUT THIS APP
	/**GOAL
	//The goal is to have a todo app with add function (delete too if time allows)
	//The information to fields should be fetched from a datasource (SQL or XML)
	//The list will be sorted to top8, having the next deadline at top.
	
	//DEPENDENCIES
	//H2 DATABASE SOFTWARE (Version which is included in the zip)
	 * 
	 **/

		//try{
		//LABEL, WELCOME
						Label appLabel = new Label("<h2>welcome to next8.</h2>", Label.CONTENT_XHTML);

		//BUTTONS
						Button print = new Button("Print the 8");
						print.addClickListener(new Button.ClickListener() {
						    public void buttonClick(ClickEvent event) {
						        										// Print the current page
						        JavaScript.getCurrent().execute("print();");
						    }
						});
						Button aboutApp = new Button("About");		//Configure "About this app" button
						aboutApp.addClickListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
							Notification.show("This is an app to manage your deadlines! Niki Virmanen, Cédric Héaulme. 2014");
							}
						});
						Button nextEight = new Button("Next 8");		//Configure "Next 8 Tasks" button
						Button prevEight = new Button("Prev 8");		//Configure "Prev 8 Tasks" button
						
						Button newTask = new Button("New Task");		//Configure "New task" button
						// ADD COMMIT TO H2 DATABASE FUNCTION!
						// CLICKLISTENER + STRING

						Button exitApp = new Button("Exit App");		//Configure "Exit" button
						exitApp.addClickListener(new Button.ClickListener() {
						    public void buttonClick(ClickEvent event) {
						        										// close (fade) the current page
						    	close();
						    }
						});
						final Button submitnewTask = new Button("Submit New Task!");	//Configure "Submit new task" button
						submitnewTask.setVisible(false);
						newTask.addClickListener(new Button.ClickListener() {
							 public void buttonClick(ClickEvent event) {
								submitnewTask.setVisible(true); }
							});	
						submitnewTask.addClickListener(new Button.ClickListener() {
							public void buttonClick(ClickEvent event) {
								submitnewTask.setVisible(false);
																						//ADD TO DATABASE CALL!
								}
							});
						

		//FIELDS

																		//Configure 8 Date Fields	
						DateField d1 = new DateField();
						//d1.setValue(rs.getDate(1));		// get string from H2 Database
						DateField d2 = new DateField();
						DateField d3 = new DateField();
						DateField d4 = new DateField();
						DateField d5 = new DateField();
						DateField d6 = new DateField();
						DateField d7 = new DateField();
						DateField d8 = new DateField();
																		//"New task" Date Field
						DateField dnew = new DateField();
						
																		//Configure 8 Text Fields
						TextField field1 = new TextField();
						//field1.setValue(rs.getString(2));  // get string from H2 Database
						TextField field2 = new TextField();
						TextField field3 = new TextField();
						TextField field4 = new TextField();
						TextField field5 = new TextField();
						TextField field6 = new TextField();
						TextField field7 = new TextField();
						TextField field8 = new TextField();
																		//"New task" Text Field
						TextField fieldnew = new TextField();

																		//Configure 8 Combobox Fields
						
																		//1
						ComboBox combo1 = new ComboBox();
							//combo1.setValue(rs.getString(3));	//get string from H2 Database
		        			combo1.setInvalidAllowed(false);
		        			combo1.setNullSelectionAllowed(false);
		        			combo1.addItem("Not Done");
		        			combo1.addItem("In Progress");
		        			combo1.addItem("Done");
		        			combo1.addItem("Postponed");
		        														//2
						ComboBox combo2 = new ComboBox();
		        			combo2.setInvalidAllowed(false);
		        			combo2.setNullSelectionAllowed(false);
		        			combo2.addItem("Not Done");
		        			combo2.addItem("In Progress");
		        			combo2.addItem("Done");
		        			combo2.addItem("Postponed");
		        														//3
						ComboBox combo3 = new ComboBox();
		        			combo3.setInvalidAllowed(false);
		        			combo3.setNullSelectionAllowed(false);
		        			combo3.addItem("Not Done");
		        			combo3.addItem("In Progress");
		        			combo3.addItem("Done");
		        			combo3.addItem("Postponed");
		        														//4
						ComboBox combo4 = new ComboBox();
		        			combo4.setInvalidAllowed(false);
		        			combo4.setNullSelectionAllowed(false);
		        			combo4.addItem("Not Done");
		        			combo4.addItem("In Progress");
		        			combo4.addItem("Done");
		        			combo4.addItem("Postponed");
		        														//5
						ComboBox combo5 = new ComboBox();
		        			combo5.setInvalidAllowed(false);
		        			combo5.setNullSelectionAllowed(false);
		        			combo5.addItem("Not Done");
		        			combo5.addItem("In Progress");
		        			combo5.addItem("Done");
		        			combo5.addItem("Postponed");
		        														//6
						ComboBox combo6 = new ComboBox();
		        			combo6.setInvalidAllowed(false);
		        			combo6.setNullSelectionAllowed(false);
		        			combo6.addItem("Not Done");
		        			combo6.addItem("In Progress");
		        			combo6.addItem("Done");
		        			combo6.addItem("Postponed");
		        														//7
						ComboBox combo7 = new ComboBox();
		        			combo7.setInvalidAllowed(false);
		        			combo7.setNullSelectionAllowed(false);
		        			combo7.addItem("Not Done");
		        			combo7.addItem("In Progress");
		        			combo7.addItem("Done");
		        			combo7.addItem("Postponed");
		        														//8
						ComboBox combo8 = new ComboBox();
		        			combo8.setInvalidAllowed(false);
		        			combo8.setNullSelectionAllowed(false);
		        			combo8.addItem("Not Done");
		        			combo8.addItem("In Progress");
		        			combo8.addItem("Done");
		        			combo8.addItem("Postponed");
		        														//"New Task" ComboBox
						ComboBox combonew = new ComboBox();
			        		combonew.setInvalidAllowed(false);
			        		combonew.setNullSelectionAllowed(false);
			        		combonew.addItem("Not Done");
			        		combonew.addItem("In Progress");
			        		combonew.addItem("Done");
			        		combonew.addItem("Postponed");
		        			
			        													//Configure Table for 8 Tasks
		        		Table table = new Table("");
	        			table.setHeight("263px");
	        			table.setWidth("491px");
		        		table.addContainerProperty("Deadline", DateField.class, null);
		        				table.setColumnWidth("Deadline", 100);
		        		table.addContainerProperty("Task Name", TextField.class, null);
		        				table.setColumnWidth("Task Name", 250);
		        		table.addContainerProperty("Status", ComboBox.class, null);
		        				table.setColumnWidth("Status", 100);
		        				
		        														//Configure Table for "Add New Task"
				        final Table table2 = new Table("");
			        	table2.setHeight("53px");
			        		table2.setWidth("491px");
				        		table2.addContainerProperty("Deadline", DateField.class, null);
				        			table2.setColumnWidth("Deadline", 100);
				        		table2.addContainerProperty("Task Name", TextField.class, null);
				        			table2.setColumnWidth("Task Name", 250);
				        		table2.addContainerProperty("Status", ComboBox.class, null);
				        			table2.setColumnWidth("Status", 100);
				        			
									newTask.addClickListener(new Button.ClickListener() {
										 public void buttonClick(ClickEvent event) {
											table2.setVisible(true); }
										});	
		        				
		      
					
		//LAYOUTS

				        												//Configure TASKLIST Row 1
						d1.setWidth("100px");
						field1.setWidth("250px");
						field1.setHeight("22px");
						combo1.setWidth("100px");
																		//Configure TASKLIST Row 2
						d2.setWidth("100px");
						field2.setWidth("250px");
						field2.setHeight("22px");
						combo2.setWidth("100px");
																		//Configure TASKLIST Row 3
						d3.setWidth("100px");
						field3.setWidth("250px");
						field3.setHeight("22px");
						combo3.setWidth("100px");
																		//Configure TASKLIST Row 4
						d4.setWidth("100px");
						field4.setWidth("250px");
						field4.setHeight("22px");
						combo4.setWidth("100px");
																		//Configure TASKLIST Row 5
						d5.setWidth("100px");
						field5.setWidth("250px");
						field5.setHeight("22px");
						combo5.setWidth("100px");
																		//Configure TASKLIST Row 6
						d6.setWidth("100px");
						field6.setWidth("250px");
						field6.setHeight("22px");
						combo6.setWidth("100px");
																		//Configure TASKLIST Row 7
						d7.setWidth("100px");
						field7.setWidth("250px");
						field7.setHeight("22px");
						combo7.setWidth("100px");
																		//Configure TASKLIST Row 8
						d8.setWidth("100px");
						field8.setWidth("250px");
						field8.setHeight("22px");
						combo8.setWidth("100px");
																		//Configure TASKLIST New Task
						HorizontalLayout horiz_new = new HorizontalLayout();
						dnew.setWidth("100px");
						fieldnew.setWidth("250px");
						fieldnew.setHeight("22px");
						combonew.setWidth("100px");
						
																		//Configure TABLE layout
						table.addItem(new Object[] {d1, field1, combo1}, new Integer(1));
						table.addItem(new Object[] {d2, field2, combo2}, new Integer(2));
						table.addItem(new Object[] {d3, field3, combo3}, new Integer(3));
						table.addItem(new Object[] {d4, field4, combo4}, new Integer(4));
						table.addItem(new Object[] {d5, field5, combo5}, new Integer(5));
						table.addItem(new Object[] {d6, field6, combo6}, new Integer(6));
						table.addItem(new Object[] {d7, field7, combo7}, new Integer(7));
						table.addItem(new Object[] {d8, field8, combo8}, new Integer(8));

																		//Configure TABLE2 layout (Add new task)
						table2.addItem(new Object[] {dnew, fieldnew, combonew}, new Integer(9));
						table2.setVisible(false);						//Visibility OFF on page load
						submitnewTask.addClickListener(new Button.ClickListener() {		
							public void buttonClick(ClickEvent event) {
								table2.setVisible(false);				//Visibility OFF on submit
								}
							});
																		//Configure submitnewtaskbutton	
						HorizontalLayout button2 = new HorizontalLayout();
						button2.addComponent(submitnewTask);
						button2.setWidth("491");
						submitnewTask.setWidth("100%");
																		// Configure Buttons
						HorizontalLayout buttons = new HorizontalLayout();
						buttons.setWidth("491");

						buttons.addComponent(print);
						buttons.addComponent(prevEight);	
						buttons.addComponent(nextEight);
						buttons.addComponent(aboutApp);
						buttons.addComponent(newTask);
						buttons.addComponent(exitApp);
						
						print.setWidth("100%");
						aboutApp.setWidth("100%");
						nextEight.setWidth("100%");
						prevEight.setWidth("100%");
						newTask.setWidth("100%");
						exitApp.setWidth("100%");
										
																		//Configure Label
						HorizontalLayout label = new HorizontalLayout();
						label.addComponent(appLabel);
						
																		//Add everything to main layout
						layout.addComponent(label);

						layout.addComponent(table);
						layout.addComponent(buttons);
						layout.addComponent(horiz_new);
						layout.addComponent(table2);
						layout.addComponent(button2);
						
		//} catch (Exception e){
			
		//}
						
						
	}

}
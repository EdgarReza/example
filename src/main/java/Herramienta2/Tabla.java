package Herramienta2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
import java.util.ArrayList;
import io.appium.java_client.android.AndroidDriver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import operation.ReadObject;
import operation.UIOperation;
import operation.UIOperationMobile;
 
public class Tabla extends Application {
 
    private TableView<Person> table = new TableView<Person>();
    private TableView<String> tableView = new TableView<>();
    TableColumn<String, String> tableColumn = new TableColumn<>("Suite de CP");
    private TableView<String> tableEstatus = new TableView<>();
    TableColumn<String, String> tableColumn1 = new TableColumn<>("Estatus");
   
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
            );
    
    private ObservableList<String> items1 =
            FXCollections.observableArrayList(
            );
    
    private ObservableList<String> items =
            FXCollections.observableArrayList(
            );
   
   
    final HBox hb = new HBox();
    final HBox hc = new HBox();
    final HBox hd = new HBox();
    final HBox he = new HBox();
    final HBox ce = new HBox();
    final HBox de = new HBox();
    final HBox tv = new HBox();
    final HBox ta = new HBox();
    final HBox te = new HBox();
    final HBox ag = new HBox();
    final HBox pn = new HBox();
    
    //pantalla agregar
    final HBox pe = new HBox();
    final HBox ps = new HBox();
    final HBox comb = new HBox();
    final HBox gu = new HBox();
    final HBox gu1 = new HBox();
    final HBox wait = new HBox();
    final HBox wait1 = new HBox();
    final HBox photo = new HBox();
    final HBox photo1 = new HBox();
    final HBox gettext = new HBox();
    final HBox gettext1 = new HBox();
    final HBox vacio = new HBox();
    final HBox vacio1 = new HBox();
    final HBox fallados = new HBox();
    final HBox suite_fallado = new HBox();
    final HBox suite_pasado = new HBox();
    final HBox dropdown = new HBox();
    final HBox dropdown1 = new HBox();
    final HBox swipe= new HBox();
    final HBox swipe1= new HBox();
    final HBox swipeweb= new HBox();
    final HBox swipeweb1= new HBox();
    final HBox pressback= new HBox();
    final HBox pressback1= new HBox();
    final HBox alert= new HBox();
    final HBox alert1= new HBox();
    final HBox changew= new HBox();
    final HBox changew1= new HBox();
    
    //pantalla modificar cp
    final HBox modificar = new HBox();
    
    //pantalla eliminar
    final HBox pant_eliminar = new HBox();
    final HBox eliminar_pasos_prueba = new HBox();
    
    //pantalla suite
    final HBox pant_suite = new HBox();
    
    //pantalla insertar
    final HBox insertar = new HBox();
    final HBox suite_para_dipositivo = new HBox();
    
    String tipo_browser;
    String tipo_browser_suite;
    int satisfactorio=0;
    int incorrecto=0;
    int insatisfactorio=0;
    int total_pruebas=0;
    int resultado_insatisfactorios=0;
    String str;
    int satisfactorio_suite=0;
    int insatisfactorio_suite=0;
    int total_pruebas_suite=0;
    int resultado_insatisfactorios_suite=0;
    String repetir_caso;
    String nombre_caso;
    String suite_caso;
    
    List<String> cp_ejecutar = new ArrayList<>();
    List<String> cp_estatus = new ArrayList<>();
 
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        Scene scene1 = new Scene(new Group());
        stage.setTitle("Automation Tool");
        stage.setWidth(600);
        stage.setHeight(700);
        stage.setResizable(false);
        final Objetos app=new Objetos();
        
        TableColumn<String, String> dos = new TableColumn<>("Estatus");
        dos.setCellValueFactory(cellData -> {
        return new ReadOnlyStringWrapper();
        
        });
        
        tableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
        tableView.getColumns().add(tableColumn);
        tableColumn1.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
        tableEstatus.getColumns().add(tableColumn1);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableEstatus.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
            
        final Label label = new Label("Automation Tool");
        label.setFont(new Font("Arial", 20));
        
        TextField casoprueba = new TextField();
        casoprueba.setPromptText("Write Test Case Name");
        
        TextField insertar_caso1 = new TextField();
        insertar_caso1.setPromptText("Write Test Case Name");
        
        final TextField consultacp = new TextField();
        consultacp.setPromptText("Test Case");
        
        final TextField casos_pasados = new TextField();
        casos_pasados.setEditable(false);
        casos_pasados.setFont(new Font("Arial", 17));
        Paint value1 = Paint.valueOf("green");
        casos_pasados.setStyle("-fx-control-inner-background: #"+value1.toString().substring(2));
     
        
        final TextField casos_fallados = new TextField();
        casos_fallados.setEditable(false);
        casos_fallados.setFont(new Font("Arial", 17));
        Paint value0 = Paint.valueOf("red");
        casos_fallados.setStyle("-fx-control-inner-background: #"+value0.toString().substring(2));

        
        final TextField suite_pasados = new TextField();
        suite_pasados.setEditable(false);
        suite_pasados.setFont(new Font("Arial", 17));
        Paint value3 = Paint.valueOf("green");
        suite_pasados.setStyle("-fx-control-inner-background: #"+value3.toString().substring(2));
        
        TextField suite_fallados = new TextField();
        suite_fallados.setEditable(false);
        suite_fallados.setFont(new Font("Arial", 17));
        Paint value2 = Paint.valueOf("red");
        suite_fallados.setStyle("-fx-control-inner-background: #"+value2.toString().substring(2));
        
        TextField cp_modificar = new TextField();
        cp_modificar.setPromptText("Update TC ");
        
        TextField paso_modificar = new TextField();
        paso_modificar.setPromptText("Update Step ");
        
        TextField eliminar = new TextField();
        eliminar.setPromptText("Delete TC");
        
        TextField caso_a_eliminar = new TextField();
        caso_a_eliminar.setPromptText("TC Name ");
        
        TextField paso_a_eliminar = new TextField();
        paso_a_eliminar.setPromptText("Step to delete ");
               
        final Label browser = new Label ("Device : ");
        browser.setFont(new Font("Arial", 17));
        
        final Label dispositivo_suite = new Label ("Device :  ");
        dispositivo_suite.setFont(new Font("Arial", 17));
        
        final Label nomcaso = new Label ("TC Name :");
        nomcaso.setFont(new Font("Arial", 15));
        
        final Label seleccionar_caso = new Label ("Select TC :");
        seleccionar_caso.setFont(new Font("Arial", 15));
        
        final Label eliminar_pasos1 = new Label ("TC and Step to Delete ");
        eliminar_pasos1.setFont(new Font("Arial", 20));
        
        final Label lblpasados = new Label ("Passed TC :");
        lblpasados.setFont(new Font("Arial", 20));
                
        final Label lblfallados = new Label ("Failed TC :");
        lblfallados.setFont(new Font("Arial", 20));
        
        final Label lblsuite_pasados = new Label ("Passed TC :");
        lblsuite_pasados.setFont(new Font("Arial", 20));
                
        final Label lblsuite_fallados = new Label ("Failed TC :");
        lblsuite_fallados.setFont(new Font("Arial", 20));
                
        final Label casos_a_ejecutar = new Label ("TC to execute :");
        casos_a_ejecutar.setFont(new Font("Arial", 16));
        
        final Label suite_pruebas = new Label ("Test Suite");
        suite_pruebas.setFont(new Font("Arial", 30));
        
        final Label agrega_paso = new Label ("Add Step to TC");
        agrega_paso.setFont(new Font("Arial", 30));
        
        final Label modifica_paso = new Label ("Select Keyword");
        modifica_paso.setFont(new Font("Arial", 20));
        
        final Label accion_insertar = new Label ("TC to insert step ");
        accion_insertar.setFont(new Font("Arial", 20));

        final Label cp_eliminar = new Label ("TC to delete");
        cp_eliminar.setFont(new Font("Arial", 20));
        
        Line line = new Line(90, 40, 600, 40);
        line.setStroke(Color.BLACK);
        
        Line line2 = new Line(90, 40, 600, 40);
        line2.setStroke(Color.BLACK);
        
        ComboBox<String> comboBox_buscar =new ComboBox();
        
        
 
        TableColumn firstNameCol = new TableColumn("Keyword");
        firstNameCol.setMinWidth(130);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setFirstName(t.getNewValue());
                }
            }
        );
 
 
        TableColumn lastNameCol = new TableColumn("Object");
        lastNameCol.setMinWidth(130);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                }
            }
        );
 
        TableColumn emailCol = new TableColumn("Type");
        emailCol.setMinWidth(130);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                }
            }
        );
        
        TableColumn value = new TableColumn("Data");
        value.setMinWidth(120);
        value.setCellValueFactory(
            new PropertyValueFactory<Person, String>("value"));
        value.setCellFactory(TextFieldTableCell.forTableColumn());
        value.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                }
            }
        );
    
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,value);
 
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Accion");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Object");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Search");
        final TextField valor = new TextField();
        valor.setMaxWidth(value.getPrefWidth());
        valor.setPromptText("Send");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	
                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText(),
                        valor.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
                valor.clear();                
            }
        });
        
        
        final Button action = new Button("Run");
        action.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	
            	++total_pruebas;
            	String keyword="";
            	String objeto="";
            	String type="";
            	String value ="";
            	Browser browser=new Browser();
            	WebDriver driver = null;
            	AndroidDriver driverm = null;
            	Properties allObjects = null;
            	String cp=consultacp.getText();
            	
            	if(tipo_browser==null) {
            	
            		
            	Alert alerta = new Alert(AlertType.ERROR);
            	alerta.setTitle("Test Automation");
            	alerta.setHeaderText("Select Device");
            	alerta.showAndWait();
            	
            	}else {
            	
            	
            	if(tipo_browser != "Android") {
            	
            	try {
					driver=browser.seleccionarBrowser(tipo_browser);
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					++incorrecto;
				}
            	}
            	
            	else if (tipo_browser == "Android") {
            		try {
            			
            			String ruta=app.app();
            			String name=app.deviceName();
						driverm=browser.seleccionar_Mobile(ruta,name);
						System.out.println("cuanto vale driver"+driverm);
						
						
					}catch (WebDriverException e1) {
						// TODO Auto-generated catch block
						
                    	++incorrecto;
    					e1.printStackTrace();
    					String error="You does not have a device connected";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					
						
					} 
            		
            		catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						++incorrecto;
					
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						++incorrecto;
						
					}
            		
            		}

                ReadObject object = new ReadObject();
                
            	try {
					allObjects = object.getObjectRepository();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//++incorrecto;
				}
            	
            	UIOperationMobile mobile=new UIOperationMobile(driverm);
            	UIOperation operation = new UIOperation(driver);
            	
            	int numero=table.getItems().size();
	        	System.out.println(numero);
            	
            	for(int j=0;j<numero;j++) {
                    for(int i=0;i<=3;i++) {
                    	     	                 	
                     if(i==0) {      
                     keyword=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();
                     System.out.println(keyword);
                     }
                    
                     else if(i==1) {
                     objeto=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
                     System.out.println(objeto);
                     }
                     
                     else if(i==2) {
                    	 type=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
                    	 System.out.println(type);
                       }
                     
                     else if(i==3) {
                    	 value=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();  
                    	 System.out.println(value);
                       }
                     
                     
                    
                   }
                    try {
                    	if(tipo_browser != "Android") {
                    		System.out.println("web");
                    		if(j==numero-1) {
    					operation.perform(allObjects, keyword,objeto,type,value);
    					
                    		}
                    		else {
                    	operation.perform(allObjects, keyword,objeto,type,value);
                    	 }
                    		
                    	}
                    	else if(tipo_browser == "Android") {
                    		System.out.println("movil");
                    		if(j==numero-1) {
                    		mobile.perform(allObjects, keyword, objeto, type, value);
                    		
                    		
                        		}
                        		else {
                        	mobile.perform(allObjects, keyword,objeto,type,value);
                        		}
                    	}
                    	
    				} catch (TimeoutException e1) {
    					// TODO Auto-generated catch block
    					
    					++incorrecto;
    					e1.printStackTrace();
    					String error="Timeout";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
    					
    				}catch (NoSuchElementException e1) {
    					// TODO Auto-generated catch block
    					
    					++incorrecto;
    					e1.printStackTrace();
    					String error="The object was not found";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
    					
                    }catch (StaleElementReferenceException e1) {
    					// TODO Auto-generated catch block
    					
    					++incorrecto;
    					e1.printStackTrace();
    					String error="It not shows the page DOM";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
    					
                    }catch (ElementNotVisibleException e1) {
    					// TODO Auto-generated catch block
    					
    					++incorrecto;
    					e1.printStackTrace();
    					String error="The element is not visible";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
    					
                    }catch (ElementNotSelectableException e1) {
    					// TODO Auto-generated catch block
    					
    					++incorrecto;
    					e1.printStackTrace();
    					String error="It is not possible to work with the object";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
    					
                    }  catch (WebDriverException e1) {
						// TODO Auto-generated catch block
                    	++incorrecto;
    					e1.printStackTrace();
    					String error="Unknown error";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
						
					}catch (Exception e1) {
						// TODO Auto-generated catch block
                    	++incorrecto;
    					e1.printStackTrace();
    					String error="Unknown error";
    					Base.appendToFile(e1,nombre_caso,error,objeto);
    					break;
						
					}
            	}
           
            	resultado_insatisfactorios=total_pruebas-incorrecto;
            	System.out.println("insatisfactorio"+incorrecto);
            	System.out.println("caso satisfactorio"+resultado_insatisfactorios);
            	casos_pasados.setText(String.valueOf(resultado_insatisfactorios));
            	casos_fallados.setText(String.valueOf(incorrecto));
            	
            	
            }
            }
            
            
        });
			       
                   Button btn = new Button();
			        btn.setText("Save");
			        btn.setOnAction((ActionEvent event) -> {
			        	
			        	String keyword="";
		            	String objeto="";
		            	String type="";
		            	String valor1="";
		            	int k=0;
		            	String paso;
			        	
			            Base insertar=new Base();
			        	String texto=casoprueba.getText();
			        	int numero=table.getItems().size();
			        	System.out.println(numero);
			        	
			        	for(int j=0;j<numero;j++) {
		                    for(int i=0;i<=3;i++) {
		                    	     	                 	
		                     if(i==0) {      
		                     keyword=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();
		                     System.out.println(keyword);
		                     }
		                    
		                     else if(i==1) {
		                     objeto=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
		                     System.out.println(objeto);
		                     }
		                     
		                     else if(i==2) {
		                    	 type=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
		                    	 System.out.println(type);
		                       }
		                     
		                     else if(i==3) {
		                    	 valor1=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();  
		                    	 System.out.println(valor1);
		                       }
		                     
		                                        
		                   }
		                    ++k;
		                    paso = String.valueOf(k);
		                    try {
								insertar.insert(texto, keyword, objeto, type, valor1,paso);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                   
			        	}
			        	
			 
			        });
			        

			        final Button consultar = new Button("Search TC");
			        consultar.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent e) {
			            	
			             String caso1="null";
			       	     String keyword="null";
			       	     String object="null";
			       	     String type="null";
			       	     String value="null";
			       	    
			       	     ResultSet rs = null;
			       	     Connection conn;
			       	     String dato=comboBox_buscar.getValue();
			       	     nombre_caso=dato;
			       	     //String texto=consultacp.getText();
			       	    	
			       	try { 
			       		Base conn1=new Base();
			       		 conn = conn1.connect();
			       		 String sql = "SELECT * FROM casos_prueba where num_caso = ?";
			       		 PreparedStatement ps = conn.prepareStatement(sql);
			       		 ps.setString(1, dato);
			       		 rs = ps.executeQuery();
			       		 
			       		 
			       		 while(rs.next()) {
			       			     				 
			       		 caso1=rs.getString(1);
			       		 keyword=rs.getString(2);
			       		 object=rs.getString(3);
			       		 type=rs.getString(4);
			       		 value=rs.getString(5);
			       		 
			       		    System.out.println(caso1);
			                System.out.println(keyword);
			                System.out.println(object);
			                System.out.println(type);
			                System.out.println(value);	
			               
			                data.add(new Person(
			            			keyword,
			                        object,
			                        type,
			                        value));
			                addFirstName.clear();
			                addLastName.clear();
			                addEmail.clear();
			                valor.clear();  
			       			 }
			                
			              
			                
			        		} catch (Exception e1) {
			       		 
			       		 System.out.println(e1.getMessage());
			       		 e1.printStackTrace();
			       		}
			            	
			            		            	
			            	
			            }
			        });
			        
			        
			        final Button limpiar = new Button("Clean Window");
			        limpiar.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent e) {
			            	
			            	data.removeAll(data);
			            	table.refresh();
			            	
			            }
			        });
        
			        
			     ObservableList<String> options = 
			         FXCollections.observableArrayList(
			       	        "Chrome",
			       	        "Firefox",
			       	        "IE",
			       	        "Android"
			       	        
			        );
			     
			     
			     
			   final ComboBox comboBox = new ComboBox(options);
			   
			   
			   comboBox.getSelectionModel().selectedItemProperty()
			    .addListener(new ChangeListener<String>() {
			        public void changed(ObservableValue<? extends String> observable,
			                            String oldValue, String seleccion) {
			            System.out.println("Value is: "+seleccion);
			            tipo_browser=seleccion;
			            
			            
			        }
			     			});
			   
               final ComboBox comboBox_suite = new ComboBox(options);
			   
			   
			   comboBox_suite.getSelectionModel().selectedItemProperty()
			    .addListener(new ChangeListener<String>() {
			        public void changed(ObservableValue<? extends String> observable,
			                            String oldValue, String seleccion) {
			            System.out.println("Value is: "+seleccion);
			            tipo_browser_suite=seleccion;
			            
			            
			        }
			     			});
			   
			   final ComboBox<String> comboBox2 =new ComboBox();
			   
			   final Button actualizar_combo = new Button("Refresh");
		       actualizar_combo.setOnAction(new EventHandler<ActionEvent>() {
		       public void handle(ActionEvent e) {
	       	     ResultSet rs = null;
	       	     Connection conn1;
	       	     List<String> strings = new ArrayList<>();
	
	       	    	
	       	try { 
	       		Base conn2=new Base();
	       		 conn1 = conn2.connect();
	       		 String sql = "SELECT DISTINCT num_caso FROM casos_prueba";
	       		 PreparedStatement ps = conn1.prepareStatement(sql);
	        	  rs = ps.executeQuery();
	       		
	       		 while(rs.next()) {
	       	     strings.add(rs.getString(1));
	       	     comboBox2.setItems(FXCollections.observableArrayList(strings));
	               			                
	        		} 
	       		 }catch (Exception e1) {
	       		 
	       		 System.out.println(e1.getMessage());
	       		 e1.printStackTrace();
	       		}
	       	
		       }
		        });
	    	
		       
	       	comboBox2.getSelectionModel().selectedItemProperty()
	        .addListener(new ChangeListener<String>() {
		        public void changed(ObservableValue<? extends String> observable,
		                            String oldValue, String casos_ejecutar) {
		
		        	
		        	System.out.println("Value is: "+casos_ejecutar);
		        	repetir_caso=casos_ejecutar;
		            cp_ejecutar.add(casos_ejecutar);
		            items = FXCollections.observableArrayList(cp_ejecutar);
		            tableView.setItems(items);
		           
		           
		            for(String str : cp_ejecutar) {
		            	
		            	System.out.println(str);
		            }
		          
		        
		            
		        }
		       
		     			});
	       	

	       	
	       	final Button suite = new Button("Run Suite");
	        suite.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e) {
	            	
	            	
	            	String keyword="";
	            	String objeto="";
	            	String type="";
	            	String value ="";
	            	String caso_fallado="";
	            	Browser browser=new Browser();
	            	WebDriver driver = null;
	            	AndroidDriver driverm = null;
	            	ResultSet rs = null;
		       	    Connection conn3;
		       	    String dato=comboBox2.getValue();
	       	        suite_caso=dato;
		       	  
	            	Properties allObjects = null;
	            	ReadObject object = new ReadObject();
	            	
	            	
	            	if(tipo_browser_suite==null) {
	                	
	                	Alert alerta = new Alert(AlertType.ERROR);
	                	alerta.setTitle("Automatización");
	                	alerta.setHeaderText("Selecciona un dispositivo");
	                	alerta.showAndWait();
	                	
	                	}else {
	                
	            	try {
						allObjects = object.getObjectRepository();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
        	
		        	for(int i=0;i<cp_ejecutar.size();i++)
		            {
		        	try { 
			       		 Base conn1=new Base();
			       		 conn3 = conn1.connect();
			       		 String sql = "SELECT * FROM casos_prueba where num_caso = ?";
			       		 PreparedStatement ps = conn3.prepareStatement(sql);
			       		 ps.setString(1, cp_ejecutar.get(i));
			       		 rs = ps.executeQuery();
			       		 
			       		if(tipo_browser_suite != "Android") {
			            	
				            
							driver=browser.seleccionarBrowser(tipo_browser_suite);
						
		            	}
		            	
		            	else if (tipo_browser_suite == "Android") {
		            		    String ruta=app.app();
	            			    String name=app.deviceName();
								driverm=browser.seleccionar_Mobile(ruta,name);
							            	}
			       		
			       		UIOperationMobile mobile=new UIOperationMobile(driverm);
		            	UIOperation operation = new UIOperation(driver);
			       		 
			       		 while(rs.next()) {
			       			  
			       			 caso_fallado=rs.getString(1);
			       			 keyword=rs.getString(2);
				       		 objeto=rs.getString(3);
				       		 type=rs.getString(4);
				       		 value=rs.getString(5);
			       		  

				       		if(tipo_browser_suite != "Android") {
	                    		System.out.println("web");
	                    		
	    					operation.perform(allObjects, keyword,objeto,type,value);
	    					                 	
	                    		
	                    	}
	                    	else if(tipo_browser_suite == "Android") {
	                    	
	        					
	                        	mobile.perform(allObjects, keyword,objeto,type,value);
	                        	
	                    	} 
				       		 
			       			 }
			       		
			       		++satisfactorio_suite;
			       		cp_estatus.add("Pasado");
			       		 
			        		} 
		        	  
		        	 catch (TimeoutException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					++incorrecto;
	    					e1.printStackTrace();
	    					String error="Timeout";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
	    					
	    				}catch (NoSuchElementException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					++incorrecto;
	    					e1.printStackTrace();
	    					String error="The object was not found";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
	    					
	                    }catch (StaleElementReferenceException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					++incorrecto;
	    					e1.printStackTrace();
	    					String error="It not shows the page DOM";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
	    					
	                    }catch (ElementNotVisibleException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					++incorrecto;
	    					e1.printStackTrace();
	    					String error="The element is not visible";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
	    					
	                    }catch (ElementNotSelectableException e1) {
	    					// TODO Auto-generated catch block
	    					
	    					++incorrecto;
	    					e1.printStackTrace();
	    					String error="It is not possible to work with the object";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
	    					
	                    } catch (Exception e1) {
							// TODO Auto-generated catch block
	                    	++incorrecto;
	    					e1.printStackTrace();
	    					String error="Unknown error";
	    					Base.appendToFile(e1,suite_caso,error,objeto);
	    					cp_estatus.add("Fallado");
							
						}
		        	
		        	
		        	++total_pruebas_suite;
		        				       	
		            }
		        	resultado_insatisfactorios_suite=total_pruebas_suite-satisfactorio_suite;
	            	System.out.println("insatisfactorio"+resultado_insatisfactorios_suite);
	            	System.out.println("caso satisfactorio"+satisfactorio_suite);
	            	suite_pasados.setText(String.valueOf(satisfactorio_suite));
	            	suite_fallados.setText(String.valueOf(resultado_insatisfactorios_suite));
	            	
	            	for(String str : cp_estatus) {
	            		
	            		System.out.println(str);
	            	}
	            	
	            	items1 = FXCollections.observableArrayList(cp_estatus);
		            tableEstatus.setItems(items1);
	              
	                	}
	            } 
	        });
	        
	        final Button limpiar_suite = new Button("Clean Suite");
	        limpiar_suite.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	
	            	items1.removeAll(items1); 
	            	items.removeAll(items); 
	            	items1.clear();
	            	items.clear();
	            	cp_estatus.clear();
	            	cp_ejecutar.clear();
	            }
	        });
	        
	        final Button repetir = new Button("Repeat TC");
	        repetir.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	
	            	 cp_ejecutar.add(repetir_caso);
	            	 items = FXCollections.observableArrayList(cp_ejecutar);
			         tableView.setItems(items);
	            }
	        });
	        

            Button actualizar = new Button();
		        actualizar.setText("Update TC");
		        actualizar.setOnAction((ActionEvent event) -> {
		        	
		        	String keyword="";
	            	String objeto="";
	            	String type="";
	            	String valor1="";
	            	
		        	
		            Base update=new Base();
		        	String caso=cp_modificar.getText();
		        	String paso=paso_modificar.getText();
		        	int numero=table.getItems().size();
		        	System.out.println(numero);
		        	
		        	for(int j=0;j<numero;j++) {
	                    for(int i=0;i<=3;i++) {
	                    	     	                 	
	                     if(i==0) {      
	                     keyword=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();
	                     System.out.println(keyword);
	                     }
	                    
	                     else if(i==1) {
	                     objeto=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
	                     System.out.println(objeto);
	                     }
	                     
	                     else if(i==2) {
	                    	 type=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
	                    	 System.out.println(type);
	                       }
	                     
	                     else if(i==3) {
	                    	 valor1=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();  
	                    	 System.out.println(valor1);
	                       }
	                     
	                                        
	                   }
	                    
	                    update.update(caso, keyword, objeto, type, valor1,paso);
	                   
		        	}
		        	
		 
		        });
		        
		        final Button btn_eliminar = new Button("Delete TC");
		        btn_eliminar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	Base eliminar1=new Base();
		            	String cp_eliminar=eliminar.getText();
		            	eliminar1.delete(cp_eliminar);
		            	
		            }
		        });
		        
		        
		    		        
		        final Button borrar_resultados = new Button("Delete Results");
		        borrar_resultados.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	casos_pasados.clear();
		            	casos_fallados.clear();
		            	
		            	resultado_insatisfactorios=0;
		            	incorrecto=0;
		            	resultado_insatisfactorios_suite=0;
		            	satisfactorio_suite=0;
		            	total_pruebas_suite=0;
		            	total_pruebas=0;
		            	
		            	
		            }
		        });
		        
		     
		        Button pantalla_agregar = new Button("Add Step");
		        pantalla_agregar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		               	
		            	 pn.getChildren().clear(); 
		                 pe.getChildren().clear(); 
		                 ps.getChildren().clear(); 
		                 comb.getChildren().clear(); 
		                 gu.getChildren().clear(); 
		                 gu1.getChildren().clear();
		                 wait.getChildren().clear(); 
		                 wait1.getChildren().clear();
		                 photo.getChildren().clear(); 
		                 photo1.getChildren().clear();
		                 gettext.getChildren().clear(); 
		                 gettext1.getChildren().clear();
		                 vacio.getChildren().clear(); 
		                 vacio1.getChildren().clear();
		                 dropdown.getChildren().clear(); 
		                 dropdown1.getChildren().clear();
		                 swipe.getChildren().clear(); 
		                 swipe1.getChildren().clear();
		                 swipeweb.getChildren().clear(); 
		                 swipeweb1.getChildren().clear();
		                 pressback.getChildren().clear(); 
		                 pressback1.getChildren().clear();
		                 alert.getChildren().clear(); 
		                 alert1.getChildren().clear();
		                 changew.getChildren().clear(); 
		                 changew1.getChildren().clear();
		                 
		                 ObservableList<String> opciones = 
			   			         FXCollections.observableArrayList(
			   			       	        "xpath",
			   			       	        "classname",
			   			       	        "name",
			   			       	        "css",
			   			       	        "link",
			   			       	        "id",
			   			       	        "PARTIALLINK"
			   			        );

			   			final ComboBox types = new ComboBox(opciones);
		                 
		                ObservableList<String> acciones = 
		   			         FXCollections.observableArrayList(
		   			       	        "Click",
		   			       	        "SetText",
		   			       	        "GotoUrl",
		   			       	        "Wait",
		   			       	        "Photo",
		   			       	        "CompareText",
		   			       	        "Dropdown",
		   			       	        "SwipeMovil",
		   			       	        "SwipeWeb",
		   			       	        "PressBackMobile",
		   			       	        "Alert",
		   			       	        "Switch",
		   			       	        ""
		   			        );

		   			final ComboBox agregar = new ComboBox(acciones);
		   			final Button agregar_datos = new Button("Add");  
		   			
		   			
		   			agregar.getSelectionModel().selectedItemProperty()
			        .addListener(new ChangeListener<String>() {
				        public void changed(ObservableValue<? extends String> observable,
				                            String oldValue, String seleccion) {
				        	
				    
				        	
				        	if(seleccion=="Click") {
				        		
				        		gettext.getChildren().clear();	
				        		photo.getChildren().clear();
				        		wait.getChildren().clear();
				        		ps.getChildren().clear();
				        		gu.getChildren().clear();
				        		swipe.getChildren().clear();
				        		dropdown.getChildren().clear();
				        		swipeweb.getChildren().clear();
				        		pressback.getChildren().clear();
				        		alert.getChildren().clear();
				        		changew.getChildren().clear();
				        		pe.getChildren().addAll(addLastName,types,agregar_datos);
					   	        pe.setSpacing(3);
					   	 
					   	        
					   	         agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					            	 
					            	 Object j=types.getValue();
					            					            	 
					             	
					                 data.add(new Person(
					                         "Click",
					                         addLastName.getText(),
					                         (String) j));
					                        // valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                // valor.clear();  
					                 
					                 pe.getChildren().clear();
					             }
					         });
					            
				        	}
				        	
				        	else if(seleccion=="SetText") {
				        		
				        		gettext.getChildren().clear();	
				        		photo.getChildren().clear();
				        		wait.getChildren().clear();
				        		pe.getChildren().clear();
				        		gu.getChildren().clear();
				        		swipe.getChildren().clear();
				        		dropdown.getChildren().clear();
				        		swipeweb.getChildren().clear();
				        		pressback.getChildren().clear();
				        		alert.getChildren().clear();
				        		changew.getChildren().clear();
				        		ps.getChildren().addAll(addLastName,types,valor,agregar_datos);
					   	        ps.setSpacing(3);
					   	        
					   	       
					   	        
					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					            	 
					            	  Object j=types.getValue();
					             	
					                 data.add(new Person(
					                         "SetText",
					                         addLastName.getText(),
					                         (String) j,
					                         valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                 valor.clear();   
					                 ps.getChildren().clear(); 
					             }
					         });
				        		
				        	}
				        	
                              else if(seleccion=="GotoUrl") {
				        		
                                gettext.getChildren().clear();  
                            	photo.getChildren().clear();  
                            	wait.getChildren().clear();
                            	ps.getChildren().clear();
                            	pe.getChildren().clear();
                            	swipe.getChildren().clear();
                            	dropdown.getChildren().clear();
                            	swipeweb.getChildren().clear();
                            	pressback.getChildren().clear();
                            	alert.getChildren().clear();
                            	changew.getChildren().clear();
				        		gu.getChildren().addAll(valor,agregar_datos);
					   	        gu.setSpacing(3);
					   	        
					   	        
					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					             	
					            	 Object j=types.getValue();
					            	 
					                 data.add(new Person(
					                         "GotoUrl",
					                         addLastName.getText(),
					                         (String) j,
					                         valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                 valor.clear();   
					                 gu.getChildren().clear(); 
					             }
					         });
				        		
				        	}
				        	
                              else if(seleccion=="Wait") {
  				        		
                            	gettext.getChildren().clear();  
                            	photo.getChildren().clear(); 
                            	gu.getChildren().clear();  
                              	ps.getChildren().clear();
                              	pe.getChildren().clear();
                              	swipe.getChildren().clear();
                              	dropdown.getChildren().clear();
                              	swipeweb.getChildren().clear();
                              	pressback.getChildren().clear();
                              	alert.getChildren().clear();
                              	changew.getChildren().clear();
  				        		wait.getChildren().addAll(valor,agregar_datos);
  					   	        wait.setSpacing(3);
  					   	        
  					   	        
  					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
  					             public void handle(ActionEvent e) {
  					             	
  					                 data.add(new Person(
  					                         "Wait",
  					                         addLastName.getText(),
  					                         addEmail.getText(),
  					                         valor.getText()));
  					                 addFirstName.clear();
  					                 addLastName.clear();
  					                 addEmail.clear();
  					                 valor.clear();   
  					                 wait.getChildren().clear(); 
  					             }
  					         });
  				        		
  				        	}
				        	
                              else if(seleccion=="Photo") {
    				        	
                            	gettext.getChildren().clear(); 
                            	wait.getChildren().clear(); 
                              	gu.getChildren().clear();  
                                ps.getChildren().clear();
                                pe.getChildren().clear();
                                swipe.getChildren().clear();
                                dropdown.getChildren().clear();
                                swipeweb.getChildren().clear();
                                pressback.getChildren().clear();
                                alert.getChildren().clear();
                                changew.getChildren().clear();
    				        	photo.getChildren().addAll(valor,agregar_datos);
    					   	    photo.setSpacing(3);
    					   	        
    					   	        
    					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
    					             public void handle(ActionEvent e) {
    					             	
    					                 data.add(new Person(
    					                         "Photo",
    					                         addLastName.getText(),
    					                         addEmail.getText(),
    					                         valor.getText()));
    					                 addFirstName.clear();
    					                 addLastName.clear();
    					                 addEmail.clear();
    					                 valor.clear();   
    					                 photo.getChildren().clear(); 
    					             }
    					         });
    				        		
    				        	}
				        	
                              else if(seleccion=="CompareText") {
      				        	
                            	photo.getChildren().clear(); 
                              	wait.getChildren().clear(); 
                                gu.getChildren().clear();  
                                ps.getChildren().clear();
                                pe.getChildren().clear();
                                swipe.getChildren().clear();
                                dropdown.getChildren().clear();
                                swipeweb.getChildren().clear();
                                pressback.getChildren().clear();
                                alert.getChildren().clear();
                                changew.getChildren().clear();
      				        	gettext.getChildren().addAll(addLastName,types,valor,agregar_datos);
      					   	    gettext.setSpacing(3);
      					   	        
      					   	        
      					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
      					             public void handle(ActionEvent e) {
      					            	 
      					            	Object j=types.getValue();
      					             	
      					                 data.add(new Person(
      					                         "CompareText",
      					                         addLastName.getText(),
      					                         (String) j,
      					                         valor.getText()));
      					                 addFirstName.clear();
      					                 addLastName.clear();
      					                 addEmail.clear();
      					                 valor.clear();   
      					                 gettext.getChildren().clear(); 
      					             }
      					         });
      				        		
      				        	}
				        	
                              else if(seleccion=="Dropdown") {
                            	  
                            	ps.getChildren().clear();
  				        		gettext.getChildren().clear();	
  				        		photo.getChildren().clear();
  				        		wait.getChildren().clear();
  				        		pe.getChildren().clear();
  				        		gu.getChildren().clear();
  				        		swipe.getChildren().clear();
  				        		swipeweb.getChildren().clear();
  				        		pressback.getChildren().clear();
  				        		alert.getChildren().clear();
  				        		changew.getChildren().clear();
  				        		dropdown.getChildren().addAll(addLastName,types,valor,agregar_datos);
  					   	        dropdown.setSpacing(3);
  					   	        
  					 					   	       
  					   	        
  					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
  					             public void handle(ActionEvent e) {
  					            	 
  					            	  Object j=types.getValue();
  					             	
  					                 data.add(new Person(
  					                         "Dropdown",
  					                         addLastName.getText(),
  					                         (String) j,
  					                         valor.getText()));
  					                 addFirstName.clear();
  					                 addLastName.clear();
  					                 addEmail.clear();
  					                 valor.clear();   
  					                 dropdown.getChildren().clear(); 
  					             }
  					         });
  				        		
  				        	}
				        	
                              else if(seleccion=="SwipeMovil") {
    				        		
                              	gettext.getChildren().clear(); 
                              	wait.getChildren().clear();
                              	photo.getChildren().clear(); 
                              	gu.getChildren().clear();  
                                ps.getChildren().clear();
                                pe.getChildren().clear();
                                dropdown.getChildren().clear();
                                swipeweb.getChildren().clear();
                                pressback.getChildren().clear();
                                alert.getChildren().clear();
                                changew.getChildren().clear();
    				        	swipe.getChildren().addAll(agregar_datos);
    					   	    swipe.setSpacing(3);
    					   	    
    					   	
    					   	        
    					   	        
    					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
    					             public void handle(ActionEvent e) {
    					             	
    					                 data.add(new Person(
    					                         "SwipeMovil",
    					                         addLastName.getText(),
    					                         addEmail.getText(),
    					                         valor.getText()));
    					                 addFirstName.clear();
    					                 addLastName.clear();
    					                 addEmail.clear();
    					                 valor.clear();   
    					                 swipe.getChildren().clear(); 
    					             }
    					         });
    				        		
    				        	}
				        	
                              else if(seleccion=="SwipeWeb") {
  				        		
                                 gettext.getChildren().clear();  
                                 photo.getChildren().clear();
                                 wait.getChildren().clear();
                                 gu.getChildren().clear();  
                                 ps.getChildren().clear();
                                 pe.getChildren().clear();
                                 dropdown.getChildren().clear();
                                 swipe.getChildren().clear();
                                 pressback.getChildren().clear();
                                 alert.getChildren().clear();
                                 changew.getChildren().clear();
      				        	 swipeweb.getChildren().addAll(agregar_datos);
      					   	     swipeweb.setSpacing(3);
      					   	     
      					
      					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
      					             public void handle(ActionEvent e) {
      					             	
      					                 data.add(new Person(
      					                         "SwipeWeb",
      					                         addLastName.getText(),
      					                         addEmail.getText(),
      					                         valor.getText()));
      					                 addFirstName.clear();
      					                 addLastName.clear();
      					                 addEmail.clear();
      					                 valor.clear();   
      					                 swipeweb.getChildren().clear(); 
      					             }
      					         });
      				        		
      				        	}
				        	
                              else if(seleccion=="PressBackMobile") {
    				        		
                                  gettext.getChildren().clear();  
                                  photo.getChildren().clear(); 
                                  wait.getChildren().clear();
                                  gu.getChildren().clear();  
                                  ps.getChildren().clear();
                                  pe.getChildren().clear();
                                  swipeweb.getChildren().clear();
                                  dropdown.getChildren().clear();
                                  swipe.getChildren().clear();
                                  alert.getChildren().clear();
                                  changew.getChildren().clear();
       				        	  pressback.getChildren().addAll(agregar_datos);
       					   	      pressback.setSpacing(3);
       					   	
       					   	        
       					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
       					             public void handle(ActionEvent e) {
       					             	
       					                 data.add(new Person(
       					                         "PressBackMobile",
       					                         addLastName.getText(),
       					                         addEmail.getText(),
       					                         valor.getText()));
       					                 addFirstName.clear();
       					                 addLastName.clear();
       					                 addEmail.clear();
       					                 valor.clear();   
       					                 pressback.getChildren().clear(); 
       					             }
       					         });
       				        		
       				        	}
				        	
                              else if(seleccion=="Switch") {
  				        		
                                  gettext.getChildren().clear();  
                                  photo.getChildren().clear(); 
                                  wait.getChildren().clear();
                                  gu.getChildren().clear();  
                                  ps.getChildren().clear();
                                  pe.getChildren().clear();
                                  swipeweb.getChildren().clear();
                                  dropdown.getChildren().clear();
                                  swipe.getChildren().clear();
                                  alert.getChildren().clear();
                                  pressback.getChildren().clear();
       				        	  changew.getChildren().addAll(agregar_datos);
       					   	      changew.setSpacing(3);
       					   	
       					   	        
       					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
       					             public void handle(ActionEvent e) {
       					             	
       					                 data.add(new Person(
       					                         "Switch",
       					                         addLastName.getText(),
       					                         addEmail.getText(),
       					                         valor.getText()));
       					                 addFirstName.clear();
       					                 addLastName.clear();
       					                 addEmail.clear();
       					                 valor.clear();   
       					                 changew.getChildren().clear(); 
       					             }
       					         });
       				        		
       				        	}
				        	
                              else if(seleccion=="Alert") {
  				        		
                                  gettext.getChildren().clear();  
                                  photo.getChildren().clear(); 
                                  wait.getChildren().clear();
                                  gu.getChildren().clear();  
                                  ps.getChildren().clear();
                                  pe.getChildren().clear();
                                  swipeweb.getChildren().clear();
                                  dropdown.getChildren().clear();
                                  swipe.getChildren().clear();
                                  changew.getChildren().clear();
                                  pressback.getChildren().clear();
       				        	  alert.getChildren().addAll(agregar_datos);
       					   	      alert.setSpacing(3);
       					   	
       					   	        
       					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
       					             public void handle(ActionEvent e) {
       					             	
       					                 data.add(new Person(
       					                         "Alert",
       					                         addLastName.getText(),
       					                         addEmail.getText(),
       					                         valor.getText()));
       					                 addFirstName.clear();
       					                 addLastName.clear();
       					                 addEmail.clear();
       					                 valor.clear();   
       					                 alert.getChildren().clear(); 
       					             }
       					         });
       				        		
       				        	}
 				        	
				        	
				        	

                              else if(seleccion=="") {
      				        	
                            	  gettext.getChildren().clear();  
                                  photo.getChildren().clear(); 
                                  wait.getChildren().clear();
                                  gu.getChildren().clear();  
                                  ps.getChildren().clear();
                                  pe.getChildren().clear();
                                  swipeweb.getChildren().clear();
                                  dropdown.getChildren().clear();
                                  swipe.getChildren().clear();
                                  alert.getChildren().clear();
                                  changew.getChildren().clear();
                                  pressback.getChildren().clear();
      					   	        
      					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
      					             public void handle(ActionEvent e) {
      					             	
      					                 data.add(new Person(
      					                         "",
      					                         addLastName.getText(),
      					                         addEmail.getText(),
      					                         valor.getText()));
      					                 addFirstName.clear();
      					                 addLastName.clear();
      					                 addEmail.clear();
      					                 valor.clear();   
      					                 dropdown.getChildren().clear(); 
      					             }
      					         });
      				        		
      				        	}
				        	 
				        	
				
				        }
			
				     			});
			       	
		   			pn.getChildren().addAll(agregar,pe);
		   	        pn.setSpacing(3);
		   	        comb.getChildren().addAll(agregar,ps);
		   	        comb.setSpacing(3); 
		   	        gu1.getChildren().addAll(agregar,gu);
		   	        gu1.setSpacing(3); 
		   	        wait1.getChildren().addAll(agregar,wait);
		   	        wait1.setSpacing(3);
		   	        photo1.getChildren().addAll(agregar,photo);
		   	        photo1.setSpacing(3);
		   	        gettext1.getChildren().addAll(agregar,gettext);
		   	        gettext1.setSpacing(3);
		   	        vacio1.getChildren().addAll(agregar,vacio);
		   	        vacio1.setSpacing(3);
		   	        dropdown1.getChildren().addAll(agregar,dropdown);
		   	        dropdown1.setSpacing(3);
		   	        swipe1.getChildren().addAll(agregar,swipe);
		   	        swipe1.setSpacing(3);
		   	        swipeweb1.getChildren().addAll(agregar,swipeweb);
		   	        swipeweb1.setSpacing(3);
		   	        pressback1.getChildren().addAll(agregar,pressback);
		   	        pressback1.setSpacing(3);
		   	        alert1.getChildren().addAll(agregar,alert);
		   	        alert1.setSpacing(3);
		   	        changew1.getChildren().addAll(agregar,changew);
		   	        changew1.setSpacing(3);
		  
		   			final VBox vbox1 = new VBox();
		   	        vbox1.setSpacing(5);
		   	        vbox1.setPadding(new Insets(10, 0, 0, 10));
		   	        vbox1.getChildren().addAll(agrega_paso,pn,comb,gu1,wait1,photo1,gettext1,vacio1,dropdown1,swipe1,swipeweb1,pressback1,alert1,changew1);
		   	        
		   	      
		   	        Stage secondStage = new Stage();
		   	        secondStage.setTitle("Automation Tool");
		   	        secondStage.setWidth(500);
		   	        secondStage.setHeight(220);
		   	        
		   	        secondStage.setScene(new Scene(vbox1));
		   	    
		   	        secondStage.show();
		   	    
		                
		            }
		        });
		        
		        
		        Button modificar_cp = new Button();
		        modificar_cp.setText("Update Step TC");
		        modificar_cp.setOnAction((ActionEvent event) -> {
		        
		        	
		        	
		        	 pn.getChildren().clear(); 
	                 pe.getChildren().clear(); 
	                 ps.getChildren().clear(); 
	                 comb.getChildren().clear(); 
	                 gu.getChildren().clear(); 
	                 gu1.getChildren().clear();
	                 wait.getChildren().clear(); 
	                 wait1.getChildren().clear();
	                 photo.getChildren().clear(); 
	                 photo1.getChildren().clear();
	                 gettext.getChildren().clear(); 
	                 gettext1.getChildren().clear();
	                 vacio.getChildren().clear(); 
	                 vacio1.getChildren().clear();
	                 modificar.getChildren().clear();
	                 dropdown.getChildren().clear(); 
	                 dropdown1.getChildren().clear();
	                 swipe.getChildren().clear(); 
	                 swipe1.getChildren().clear();
	                 swipeweb.getChildren().clear(); 
	                 swipeweb1.getChildren().clear();
	                 pressback.getChildren().clear(); 
	                 pressback1.getChildren().clear();
	                 alert.getChildren().clear(); 
	                 alert1.getChildren().clear();
	                 changew.getChildren().clear(); 
	                 changew1.getChildren().clear();
	                 
	                 ObservableList<String> opciones = 
		   			         FXCollections.observableArrayList(
		   			       	        "xpath",
		   			       	        "classname",
		   			       	        "name",
		   			       	        "css",
		   			       	        "link",
		   			       	        "id",
		   			       	        "PARTIALLINK"
		   			        );

		   			final ComboBox types = new ComboBox(opciones);
	                 
	                ObservableList<String> acciones = 
	   			         FXCollections.observableArrayList(
	   			       	        "Click",
	   			       	        "SetText",
	   			       	        "GotoUrl",
	   			       	        "Wait",
	   			       	        "Photo",
	   			       	        "CompareText",
	   			       	        "Dropdown",
	   			       	        "SwipeMovil",
	   			       	        "SwipeWeb",
	   			       	        "PressBackMobile",
	   			       	        "Alert",
	   			       	        "Switch",
	   			       	        ""
	   			        );

	   			final ComboBox agregar = new ComboBox(acciones);
	   			final Button agregar_datos = new Button("Add");  
	   			
	   			agregar.getSelectionModel().selectedItemProperty()
		        .addListener(new ChangeListener<String>() {
			        public void changed(ObservableValue<? extends String> observable,
			                            String oldValue, String seleccion) {
			        	
			        	
			        	if(seleccion=="Click") {
			        		
			        		gettext.getChildren().clear();	
			        		photo.getChildren().clear();
			        		wait.getChildren().clear();
			        		ps.getChildren().clear();
			        		gu.getChildren().clear();
			        		dropdown.getChildren().clear();
			        		swipe.getChildren().clear();
			        		swipeweb.getChildren().clear();
			        		pressback.getChildren().clear();
			        		alert.getChildren().clear();
			        		changew.getChildren().clear();
			        		pe.getChildren().addAll(addLastName,types,agregar_datos);
				   	        pe.setSpacing(3);
				   	        
				   	         agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
				             public void handle(ActionEvent e) {
				            	 
				            	 Object j=types.getValue();
				             	
				                 data.add(new Person(
				                         "Click",
				                         addLastName.getText(),
				                         (String) j));
				                        // valor.getText()));
				                 addFirstName.clear();
				                 addLastName.clear();
				                 addEmail.clear();
				                // valor.clear();  
				                 
				                 pe.getChildren().clear();
				             }
				         });
				            
			        	}
			        	
			        	else if(seleccion=="SetText") {
			        		
			        		gettext.getChildren().clear();	
			        		photo.getChildren().clear();
			        		wait.getChildren().clear();
			        		pe.getChildren().clear();
			        		gu.getChildren().clear();
			        		dropdown.getChildren().clear();
			        		swipe.getChildren().clear();
			        		swipeweb.getChildren().clear();
			        		pressback.getChildren().clear();
			        		alert.getChildren().clear();
			        		changew.getChildren().clear();
			        		ps.getChildren().addAll(addLastName,types,valor,agregar_datos);
				   	        ps.setSpacing(3);
				   	        
				   	        
				             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
				             public void handle(ActionEvent e) {
				            	 
				            	 Object j=types.getValue();
				             	
				                 data.add(new Person(
				                         "SetText",
				                         addLastName.getText(),
				                         (String) j,
				                         valor.getText()));
				                 addFirstName.clear();
				                 addLastName.clear();
				                 addEmail.clear();
				                 valor.clear();   
				                 ps.getChildren().clear(); 
				             }
				         });
			        		
			        	}
			        	
                         else if(seleccion=="GotoUrl") {
			        		
                        gettext.getChildren().clear();  
                       	photo.getChildren().clear();  
                       	wait.getChildren().clear();
                       	ps.getChildren().clear();
                       	pe.getChildren().clear();
                       	dropdown.getChildren().clear();
                       	swipe.getChildren().clear();
                       	swipeweb.getChildren().clear();
                       	pressback.getChildren().clear();
                       	changew.getChildren().clear();
                       	alert.getChildren().clear();
			        		gu.getChildren().addAll(valor,agregar_datos);
				   	        gu.setSpacing(3);
				   	        
				   	        
				             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
				             public void handle(ActionEvent e) {
				             	
				                 data.add(new Person(
				                         "GotoUrl",
				                         addLastName.getText(),
				                         addEmail.getText(),
				                         valor.getText()));
				                 addFirstName.clear();
				                 addLastName.clear();
				                 addEmail.clear();
				                 valor.clear();   
				                 gu.getChildren().clear(); 
				             }
				         });
			        		
			        	}
			        	
                         else if(seleccion=="Wait") {
				        		
                       	gettext.getChildren().clear();  
                       	photo.getChildren().clear(); 
                       	gu.getChildren().clear();  
                        ps.getChildren().clear();
                        pe.getChildren().clear();
                        dropdown.getChildren().clear();
                        swipe.getChildren().clear();
                        swipeweb.getChildren().clear();
                        pressback.getChildren().clear();
                        changew.getChildren().clear();
                        alert.getChildren().clear();
				        		wait.getChildren().addAll(valor,agregar_datos);
					   	        wait.setSpacing(3);
					   	        
					   	        
					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					             	
					                 data.add(new Person(
					                         "Wait",
					                         addLastName.getText(),
					                         addEmail.getText(),
					                         valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                 valor.clear();   
					                 wait.getChildren().clear(); 
					             }
					         });
				        		
				        	}
			        	
                         else if(seleccion=="Photo") {
				        	
                       	gettext.getChildren().clear(); 
                       	wait.getChildren().clear(); 
                        gu.getChildren().clear();  
                        ps.getChildren().clear();
                        pe.getChildren().clear();
                        dropdown.getChildren().clear();
                        swipe.getChildren().clear();
                        swipeweb.getChildren().clear();
                        pressback.getChildren().clear();
                        changew.getChildren().clear();
                        alert.getChildren().clear();
				        	photo.getChildren().addAll(valor,agregar_datos);
					   	    photo.setSpacing(3);
					   	        
					   	        
					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					             	
					                 data.add(new Person(
					                         "Photo",
					                         addLastName.getText(),
					                         addEmail.getText(),
					                         valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                 valor.clear();   
					                 photo.getChildren().clear(); 
					             }
					         });
				        		
				        	}
			        	
                         else if(seleccion=="CompareText") {
 				        	
                       	   photo.getChildren().clear(); 
                           wait.getChildren().clear(); 
                           gu.getChildren().clear();  
                           ps.getChildren().clear();
                           pe.getChildren().clear();
                           dropdown.getChildren().clear();
                           swipe.getChildren().clear();
                           swipeweb.getChildren().clear();	
                           pressback.getChildren().clear();
                           alert.getChildren().clear();
                           changew.getChildren().clear();
 				           gettext.getChildren().addAll(addLastName,types,valor,agregar_datos);
 					   	   gettext.setSpacing(3);
 					   	        
 					   	        
 					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
 					             public void handle(ActionEvent e) {
 					            	 
 					            	Object j=types.getValue();
 					             	
 					                 data.add(new Person(
 					                         "CompareText",
 					                         addLastName.getText(),
 					                         (String) j,
 					                         valor.getText()));
 					                 addFirstName.clear();
 					                 addLastName.clear();
 					                 addEmail.clear();
 					                 valor.clear();   
 					                 gettext.getChildren().clear(); 
 					             }
 					         });
 				        		
 				        	}
			        	
                         else if(seleccion=="Dropdown") {
				        		
				        		gettext.getChildren().clear();	
				        		photo.getChildren().clear();
				        		ps.getChildren().clear();
				        		wait.getChildren().clear();
				        		pe.getChildren().clear();
				        		gu.getChildren().clear();
				        		swipe.getChildren().clear();
				        		swipeweb.getChildren().clear();
				        		pressback.getChildren().clear();
				        		alert.getChildren().clear();
				        		changew.getChildren().clear();
				        		dropdown.getChildren().addAll(addLastName,types,valor,agregar_datos);
					   	        dropdown.setSpacing(3);
					   	        
					   	       
					   	        
					             agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
					             public void handle(ActionEvent e) {
					            	 
					            	  Object j=types.getValue();
					             	
					                 data.add(new Person(
					                         "Dropdown",
					                         addLastName.getText(),
					                         (String) j,
					                         valor.getText()));
					                 addFirstName.clear();
					                 addLastName.clear();
					                 addEmail.clear();
					                 valor.clear();   
					                 dropdown.getChildren().clear(); 
					             }
					         });
				        		
				        	}
			        	
                         else if(seleccion=="SwipeMovil") {
 				        	
                            	gettext.getChildren().clear(); 
                            	wait.getChildren().clear(); 
                              	gu.getChildren().clear();  
                                ps.getChildren().clear();
                                pe.getChildren().clear();
                                photo.getChildren().clear();
                                dropdown.getChildren().clear();
                                swipeweb.getChildren().clear();
                                pressback.getChildren().clear();
                                alert.getChildren().clear();
                                changew.getChildren().clear();
     				        	swipe.getChildren().addAll(agregar_datos);
     					   	    swipe.setSpacing(3);
     					   	        
     					   	        
     					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
     					             public void handle(ActionEvent e) {
     					             	
     					                 data.add(new Person(
     					                         "SwipeMovil",
     					                         addLastName.getText(),
     					                         addEmail.getText(),
     					                         valor.getText()));
     					                 addFirstName.clear();
     					                 addLastName.clear();
     					                 addEmail.clear();
     					                 valor.clear();   
     					                 swipe.getChildren().clear(); 
     					             }
     					         });
     				        		
     				        	}
			        	
                         else if(seleccion=="SwipeWeb") {
  				        	
                         	gettext.getChildren().clear(); 
                         	wait.getChildren().clear(); 
                           	gu.getChildren().clear();  
                            ps.getChildren().clear();
                            pe.getChildren().clear();
                            photo.getChildren().clear();
                            dropdown.getChildren().clear();
                            swipe.getChildren().clear();
                            pressback.getChildren().clear();
                            alert.getChildren().clear();
                            changew.getChildren().clear();
  				        	swipeweb.getChildren().addAll(agregar_datos);
  					   	    swipeweb.setSpacing(3);
  					   	        
  					   	        
  					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
  					             public void handle(ActionEvent e) {
  					             	
  					                 data.add(new Person(
  					                         "SwipeWeb",
  					                         addLastName.getText(),
  					                         addEmail.getText(),
  					                         valor.getText()));
  					                 addFirstName.clear();
  					                 addLastName.clear();
  					                 addEmail.clear();
  					                 valor.clear();   
  					                 swipeweb.getChildren().clear(); 
  					             }
  					         });
  				        		
  				        	}
			        	
                         else if(seleccion=="PressBackMobile") {
   				        	
                          	gettext.getChildren().clear(); 
                          	wait.getChildren().clear(); 
                            	gu.getChildren().clear();  
                             ps.getChildren().clear();
                             pe.getChildren().clear();
                             photo.getChildren().clear();
                             dropdown.getChildren().clear();
                             swipe.getChildren().clear();
                             swipeweb.getChildren().clear();
                             alert.getChildren().clear();
                             changew.getChildren().clear();
   				        	pressback.getChildren().addAll(agregar_datos);
   					   	    pressback.setSpacing(3);
   					   	    

   					   	        
   					   	        
   					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
   					             public void handle(ActionEvent e) {
   					             	
   					                 data.add(new Person(
   					                         "PressBackMobile",
   					                         addLastName.getText(),
   					                         addEmail.getText(),
   					                         valor.getText()));
   					                 addFirstName.clear();
   					                 addLastName.clear();
   					                 addEmail.clear();
   					                 valor.clear();   
   					                 pressback.getChildren().clear(); 
   					             }
   					         });
   				        		
   				        	}
			        	
                         else if(seleccion=="Alert") {
    				        	
                           	gettext.getChildren().clear(); 
                           	wait.getChildren().clear(); 
                             	gu.getChildren().clear();  
                              ps.getChildren().clear();
                              pe.getChildren().clear();
                              photo.getChildren().clear();
                              dropdown.getChildren().clear();
                              swipe.getChildren().clear();
                              swipeweb.getChildren().clear();
                              pressback.getChildren().clear();
                              changew.getChildren().clear();
    				          alert.getChildren().addAll(agregar_datos);
    					   	  alert.setSpacing(3);
    					   	    

    					   	        
    					   	        
    					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
    					             public void handle(ActionEvent e) {
    					             	
    					                 data.add(new Person(
    					                         "Alert",
    					                         addLastName.getText(),
    					                         addEmail.getText(),
    					                         valor.getText()));
    					                 addFirstName.clear();
    					                 addLastName.clear();
    					                 addEmail.clear();
    					                 valor.clear();   
    					                 alert.getChildren().clear(); 
    					             }
    					         });
    				        		
    				        	}
			        	
                         else if(seleccion=="Switch") {
    				        	
                           	gettext.getChildren().clear(); 
                           	wait.getChildren().clear(); 
                             	gu.getChildren().clear();  
                              ps.getChildren().clear();
                              pe.getChildren().clear();
                              photo.getChildren().clear();
                              dropdown.getChildren().clear();
                              swipe.getChildren().clear();
                              swipeweb.getChildren().clear();
                              alert.getChildren().clear();
                              
    				        	changew.getChildren().addAll(agregar_datos);
    					   	    changew.setSpacing(3);
    					   	    

    					   	        
    					   	        
    					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
    					             public void handle(ActionEvent e) {
    					             	
    					                 data.add(new Person(
    					                         "Switch",
    					                         addLastName.getText(),
    					                         addEmail.getText(),
    					                         valor.getText()));
    					                 addFirstName.clear();
    					                 addLastName.clear();
    					                 addEmail.clear();
    					                 valor.clear();   
    					                 pressback.getChildren().clear(); 
    					             }
    					         });
    				        		
    				        	}
			        	
			        	

                         else if(seleccion=="") {
 				        	
                       	   photo.getChildren().clear(); 
                           wait.getChildren().clear(); 
                           gu.getChildren().clear();  
                           ps.getChildren().clear();
                           pe.getChildren().clear();
                           gettext.getChildren().clear();
                           dropdown.getChildren().clear();
                           pressback.getChildren().clear();
                           swipe.getChildren().clear();
                           alert.getChildren().clear();
                           changew.getChildren().clear();
                           swipeweb.getChildren().clear();
 					   	        
 					   	        
 					            agregar_datos.setOnAction(new EventHandler<ActionEvent>() {
 					             public void handle(ActionEvent e) {
 					             	
 					                 data.add(new Person(
 					                         "",
 					                         addLastName.getText(),
 					                         addEmail.getText(),
 					                         valor.getText()));
 					                 addFirstName.clear();
 					                 addLastName.clear();
 					                 addEmail.clear();
 					                 valor.clear();   
 					                 gettext.getChildren().clear(); 
 					             }
 					         });
 				        		
 				        	}
			        	 
			        	
			
			        }
		
			     			});
		       	
	   			pn.getChildren().addAll(agregar,pe);
	   	        pn.setSpacing(3);
	   	        comb.getChildren().addAll(agregar,ps);
	   	        comb.setSpacing(3); 
	   	        gu1.getChildren().addAll(agregar,gu);
	   	        gu1.setSpacing(3); 
	   	        wait1.getChildren().addAll(agregar,wait);
	   	        wait1.setSpacing(3);
	   	        photo1.getChildren().addAll(agregar,photo);
	   	        photo1.setSpacing(3);
	   	        gettext1.getChildren().addAll(agregar,gettext);
	   	        gettext1.setSpacing(3);
	   	        vacio1.getChildren().addAll(agregar,vacio);
	   	        vacio1.setSpacing(3);
	   	        dropdown1.getChildren().addAll(agregar,dropdown);
	   	        dropdown1.setSpacing(3);
	   	        swipe1.getChildren().addAll(agregar,swipe);
	   	        swipe1.setSpacing(3);
	   	        swipeweb1.getChildren().addAll(agregar,swipeweb);
	   	        swipeweb1.setSpacing(3);
	   	        pressback1.getChildren().addAll(agregar,pressback);
	   	        pressback1.setSpacing(3);
	   	        alert1.getChildren().addAll(agregar,alert);
	   	        alert1.setSpacing(3);
	   	        changew1.getChildren().addAll(agregar,changew);
	   	        changew1.setSpacing(3);
		        	
		        	
		        	
	   	            modificar.getChildren().addAll(cp_modificar,paso_modificar,actualizar);
	                modificar.setSpacing(10);
	                
		        	final VBox vbox1 = new VBox();
		   	        vbox1.setSpacing(5);
		   	        vbox1.setPadding(new Insets(10, 0, 0, 10));
		   	        vbox1.getChildren().addAll(modifica_paso,pn,comb,gu1,wait1,photo1,gettext1,vacio1,dropdown1,swipe1,swipeweb1,pressback1,alert1,changew1,modificar);
		   	        
		        	Stage thirdStage = new Stage();
		   	        thirdStage.setTitle("Automation Tool");
		   	        thirdStage.setWidth(500);
		   	        thirdStage.setHeight(220);
		   	        
		   	        thirdStage.setScene(new Scene(vbox1));
		   	    
		   	        thirdStage.show();	
		        	
		 
		        });

		        
		        Button eliminar_paso = new Button();
		        eliminar_paso.setText("Delete Step");
		        Button eliminar_caso = new Button();
		        eliminar_caso.setText("Delete TC");
		        Button eliminar_cp = new Button();
		        eliminar_cp.setText("Delete");
		        eliminar_cp.setOnAction((ActionEvent event) -> {
		        pant_eliminar.getChildren().clear();
		        eliminar_pasos_prueba.getChildren().clear();
		       
		        	eliminar_caso.setOnAction(new EventHandler<ActionEvent>() {
			             public void handle(ActionEvent e) {
			             	
			            	// pant_eliminar.getChildren().clear();
					         Base eliminar1=new Base();
					         String cp_eliminar=eliminar.getText();
					         eliminar1.delete(cp_eliminar);
					            	
					        // pant_eliminar.getChildren().clear();
			             }
			         });

		        	eliminar_paso.setOnAction(new EventHandler<ActionEvent>() {
			             public void handle(ActionEvent e) {
			             	
			            	// pant_eliminar.getChildren().clear();
					         Base eliminar1=new Base();
					         String caso=caso_a_eliminar.getText();
					         String paso=paso_a_eliminar.getText();
					         eliminar1.delete_paso(caso, paso);
					            	
					        // pant_eliminar.getChildren().clear();
			             }
			         });
		
		        	pant_eliminar.getChildren().addAll(eliminar,eliminar_caso);
		        	pant_eliminar.setSpacing(10);
		        	
		        	eliminar_pasos_prueba.getChildren().addAll(caso_a_eliminar,paso_a_eliminar,eliminar_paso);
		        	eliminar_pasos_prueba.setSpacing(10);
	                
		        	final VBox vbox1 = new VBox();
		   	        vbox1.setSpacing(5);
		   	        vbox1.setPadding(new Insets(10, 0, 0, 10));
		   	        vbox1.getChildren().addAll(cp_eliminar,pant_eliminar,eliminar_pasos1,eliminar_pasos_prueba);
		   	        
		        	Stage fourStage = new Stage();
		   	        fourStage.setTitle("Automation Tool");
		   	        fourStage.setWidth(500);
		   	        fourStage.setHeight(200);
		   	        
		   	        fourStage.setScene(new Scene(vbox1));
		   	    
		   	        fourStage.show();	
		        	
		         });

		        final Button borrar_resultados_suite = new Button("Delete Results");
		        borrar_resultados_suite.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	suite_pasados.clear();
		            	suite_fallados.clear();
		            	
		            	resultado_insatisfactorios=0;
		            	incorrecto=0;
		            	resultado_insatisfactorios_suite=0;
		            	satisfactorio_suite=0;
		            	total_pruebas_suite=0;
		            	total_pruebas=0;
		            	
		            	
		            }
		        });
	
		        Button ejecutar_suite = new Button();
		        ejecutar_suite.setText("Run Suite");
		        pant_suite.getChildren().clear();
		        ejecutar_suite.setOnAction((ActionEvent event) -> {
		        pant_suite.getChildren().clear();
		        suite_fallado.getChildren().clear();
		        suite_pasado.getChildren().clear();
		        suite_para_dipositivo.getChildren().clear();
		        
		        	{
		        	pant_suite.getChildren().addAll(casos_a_ejecutar,comboBox2,actualizar_combo,repetir,suite,limpiar_suite);
		        	pant_suite.setSpacing(5);
		        	suite_fallado.getChildren().addAll(lblsuite_fallados,suite_fallados);
		        	suite_pasado.getChildren().addAll(lblsuite_pasados,suite_pasados);
		        	suite_para_dipositivo.getChildren().addAll(dispositivo_suite,comboBox_suite);
		        	}
		        	
		        	
		        	
		        	final VBox vbox1 = new VBox();
		   	        vbox1.setSpacing(5);
		   	        vbox1.setPadding(new Insets(10, 0, 0, 10));
		   	        vbox1.getChildren().addAll(suite_pruebas,suite_para_dipositivo,pant_suite,tv,suite_pasado,suite_fallado,borrar_resultados_suite);
		   	        
		        	Stage fiveStage = new Stage();
		        	fiveStage.setTitle("Automation Tool");
		        	fiveStage.setWidth(600);
		        	fiveStage.setHeight(630);
		        	fiveStage.setResizable(false);
		        	fiveStage.setScene(new Scene(vbox1));
		   	    
		        	fiveStage.show();	
		        	
		        	
		         });
		        
		      
				   
				   final Button actualizar_combo_buscar = new Button("Refresh");
			       actualizar_combo_buscar.setOnAction(new EventHandler<ActionEvent>() {
			       public void handle(ActionEvent e) {
		       	     ResultSet rs = null;
		       	     Connection conn1;
		       	     List<String> strings = new ArrayList<>();
		
		       	    	
		       	try { 
		       		Base conn2=new Base();
		       		 conn1 = conn2.connect();
		       		 String sql = "SELECT DISTINCT num_caso FROM casos_prueba";
		       		 PreparedStatement ps = conn1.prepareStatement(sql);
		        	  rs = ps.executeQuery();
		       		
		       		 while(rs.next()) {
		       	     strings.add(rs.getString(1));
		       	     comboBox_buscar.setItems(FXCollections.observableArrayList(strings));
		               			                
		        		} 
		       		 }catch (Exception e1) {
		       		 
		       		 System.out.println(e1.getMessage());
		       		 e1.printStackTrace();
		       		}
		       	
			       }
			        });
			       
			       
			        Button paso_a_insertar = new Button();
			        paso_a_insertar.setText("Insert Step");
			        Button insertar_paso = new Button();
			        insertar_paso.setText("Insert Step TC");
			        insertar_paso.setOnAction((ActionEvent event) -> {
			        insertar.getChildren().clear();
			        	
			        	paso_a_insertar.setOnAction(new EventHandler<ActionEvent>() {
				             public void handle(ActionEvent e) {
				             
				            	String keyword="";
					           	String objeto="";
					           	String type="";
					           	String valor1="";
						        Base insertar=new Base();
						        String cp_eliminar=insertar_caso1.getText();
						        String paso=insertar.consultar(cp_eliminar);
						        int numEntero = Integer.parseInt(paso);
						        int paso_final=numEntero+1;
						        String cadena_paso = String.valueOf(paso_final);
						         
						         
						         int numero=table.getItems().size();
						        	System.out.println(numero);
						        	
						        	for(int j=0;j<numero;j++) {
					                    for(int i=0;i<=3;i++) {
					                    	     	                 	
					                     if(i==0) {      
					                     keyword=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();
					                     System.out.println(keyword);
					                     }
					                    
					                     else if(i==1) {
					                     objeto=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
					                     System.out.println(objeto);
					                     }
					                     
					                     else if(i==2) {
					                    	 type=(String) table.getColumns().get(i).getCellObservableValue(j).getValue(); 
					                    	 System.out.println(type);
					                       }
					                     
					                     else if(i==3) {
					                    	 valor1=(String) table.getColumns().get(i).getCellObservableValue(j).getValue();  
					                    	 System.out.println(valor1);
					                       }
					                     
					                                        
					                   }
					                    
					                    try {
											insertar.insert_step(cp_eliminar, keyword, objeto, type, valor1,cadena_paso);
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
					                   
						        	}
						            	
						
				             }
				         });
			        	
			        	insertar.getChildren().addAll(insertar_caso1,paso_a_insertar);
			        	insertar.setSpacing(5);
			        	
			        	final VBox vbox1 = new VBox();
			   	        vbox1.setSpacing(5);
			   	        vbox1.setPadding(new Insets(10, 0, 0, 10));
			   	        vbox1.getChildren().addAll(accion_insertar,insertar);
			   	        
			        	Stage sixStage = new Stage();
			        	sixStage.setTitle("Automation Tool");
			        	sixStage.setWidth(500);
			        	sixStage.setHeight(150);
			   	        
			        	sixStage.setScene(new Scene(vbox1));
			   	    
			        	sixStage.show();	
			        	
			        	
			         });
		    	

	   	        
        hb.getChildren().addAll(nomcaso,casoprueba,pantalla_agregar,btn,limpiar);
        hb.setSpacing(3);
        
        hc.getChildren().addAll(seleccionar_caso,comboBox_buscar,actualizar_combo_buscar,consultar);
        hc.setSpacing(10);
        
        ta.getChildren().addAll(modificar_cp,insertar_paso,eliminar_cp);
        ta.setSpacing(10);
        
       // te.getChildren().addAll(eliminar,btn_eliminar);
        //te.setSpacing(10);
        
        hd.getChildren().addAll(browser,comboBox,action,ejecutar_suite);
        hd.setSpacing(10);
        
        fallados.getChildren().addAll(lblfallados,casos_fallados);
        fallados.setSpacing(10);
        
        he.getChildren().addAll(lblpasados,casos_pasados);
        he.setSpacing(10);
        
        tv.getChildren().addAll(tableView,tableEstatus);
        tv.setSpacing(0);
        
        ce.getChildren().addAll(table);
        ce.setSpacing(10);
        
        //de.getChildren().addAll(casos_a_ejecutar,comboBox2,suite,limpiar_suite,repetir,actualizar_combo);
        //de.setSpacing(2);
        
        ag.getChildren().addAll(borrar_resultados);
        ag.setSpacing(2);
        
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hd,ce,hb,hc,ta,line,he,fallados,line2,ag);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
        
    }
 
    public class Person {
 
        private final SimpleStringProperty keyword;
        private final SimpleStringProperty object;
        private final SimpleStringProperty type;
        private final SimpleStringProperty value;
 
        Person(String fName, String lName, String email,String values) {
            this.keyword = new SimpleStringProperty(fName);
            this.object = new SimpleStringProperty(lName);
            this.type = new SimpleStringProperty(email);
            this.value = new SimpleStringProperty(values);
        }
        

        Person(String fName, String lName, String email) {
            this.keyword = new SimpleStringProperty(fName);
            this.object = new SimpleStringProperty(lName);
            this.type = new SimpleStringProperty(email);
            this.value = new SimpleStringProperty(null);
        }
 
        public String getFirstName() {
            return keyword.get();
        }
 
        public void setFirstName(String fName) {
            keyword.set(fName);
        }
 
        public String getLastName() {
            return object.get();
        }
 
        public void setLastName(String fName) {
            object.set(fName);
        }
 
        public String getEmail() {
            return type.get();
        }
 
        public void setEmail(String fName) {
            type.set(fName);
        }
        
        public String getValue() {
            return value.get();
        }
 
        public void setValue(String fName) {
            value.set(fName);
        }
    }
}
package mtp.Herramienta2;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
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
import javafx.scene.control.Button;
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
    
    String tipo_browser;
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
    
    List<String> cp_ejecutar = new ArrayList<>();
    List<String> cp_estatus = new ArrayList<>();
 
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Automatización I+D");
        stage.setWidth(1070);
        stage.setHeight(731);
        Objetos app=new Objetos();
        
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
        
            
        final Label label = new Label("Herramienta de Automatización");
        label.setFont(new Font("Arial", 20));
        
        TextField casoprueba = new TextField();
        casoprueba.setPromptText("Ingresar nombre del caso de prueba");
        
        TextField consultacp = new TextField();
        consultacp.setPromptText("Caso de prueba");
        
        TextField casos_pasados = new TextField();
        casos_pasados.setPromptText("CP Pasados");
        casos_pasados.setEditable(false);
        casos_pasados.setStyle("-fx-background-color: green;");        
        
        TextField casos_fallados = new TextField();
        casos_fallados.setPromptText("CP Fallados");
        casos_fallados.setEditable(false);
        casos_fallados.setStyle("-fx-background-color: red;");
        
        TextField cp_modificar = new TextField();
        cp_modificar.setPromptText("CP a Modificar ");
        
        TextField paso_modificar = new TextField();
        paso_modificar.setPromptText("Paso a Modificar ");
        
        TextField eliminar = new TextField();
        eliminar.setPromptText("CP a Eliminar");
       
        TextField suite_seleccionada = new TextField();
        
        final Label browser = new Label ("Dispositivo :");
        browser.setFont(new Font("Arial", 12));
        
        final Label nomcaso = new Label ("Nombre del CP :");
        nomcaso.setFont(new Font("Arial", 12));
        
        final Label lblpasados = new Label ("CP Pasados :");
        nomcaso.setFont(new Font("Arial", 12));
                
        final Label lblfallados = new Label ("CP Fallados :");
        nomcaso.setFont(new Font("Arial", 12));
                
        final Label casos_a_ejecutar = new Label ("CP a Ejecutar :");
        casos_a_ejecutar.setFont(new Font("Arial", 12));
        
        final Label suite_pruebas = new Label ("Suite de Pruebas");
        suite_pruebas.setFont(new Font("Arial", 18));
        
        
        Line line = new Line(90, 40, 600, 40);
        line.setStroke(Color.BLACK);
        
        Line line2 = new Line(90, 40, 600, 40);
        line2.setStroke(Color.BLACK);
        
        
 
        TableColumn firstNameCol = new TableColumn("Acción");
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
 
 
        TableColumn lastNameCol = new TableColumn("Objeto");
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
 
        TableColumn emailCol = new TableColumn("Como Buscarlo");
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
        
        TableColumn value = new TableColumn("Valor a enviar");
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
        addFirstName.setPromptText("Acción");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Objeto");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Buscarlo");
        final TextField valor = new TextField();
        valor.setMaxWidth(value.getPrefWidth());
        valor.setPromptText("Enviar");
 
        final Button addButton = new Button("Agregar");
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
        
        
        final Button action = new Button("Ejecutar");
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
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						++incorrecto;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						++incorrecto;
					}             	}

                ReadObject object = new ReadObject();
                
            	try {
					allObjects = object.getObjectRepository();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					++incorrecto;
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
                    	
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					++incorrecto;
    					e1.printStackTrace();
    					Base.appendToFile(e1,cp);
    				    				}
                    }
           
            	resultado_insatisfactorios=total_pruebas-incorrecto;
            	System.out.println("insatisfactorio"+incorrecto);
            	System.out.println("caso satisfactorio"+resultado_insatisfactorios);
            	casos_pasados.setText(String.valueOf(resultado_insatisfactorios));
            	casos_fallados.setText(String.valueOf(incorrecto));
            	
            }
            
            
        });
			       
                   Button btn = new Button();
			        btn.setText("Guardar");
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
			        

			        final Button consultar = new Button("Consultar Casos de Prueba");
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
			       	     String texto=consultacp.getText();
			       	    	
			       	try { 
			       		Base conn1=new Base();
			       		 conn = conn1.connect();
			       		 String sql = "SELECT * FROM casos_prueba where num_caso = ?";
			       		 PreparedStatement ps = conn.prepareStatement(sql);
			       		 ps.setString(1, texto);
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
			        
			        
			        final Button limpiar = new Button("Limpiar Pantalla");
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
			   
			   ComboBox<String> comboBox2 =new ComboBox();
			   
			   final Button actualizar_combo = new Button("Actualizar");
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
	       	

	       	
	       	final Button suite = new Button("Ejecutar Suite");
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
		       	    
		       	  
	            	Properties allObjects = null;
	            	
	            	
	                ReadObject object = new ReadObject();
	                
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
			       		 
			       		if(tipo_browser != "Android") {
			            	
				            
							driver=browser.seleccionarBrowser(tipo_browser);
						
		            	}
		            	
		            	else if (tipo_browser == "Android") {
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
			       		  

				       		if(tipo_browser != "Android") {
	                    		System.out.println("web");
	                    		
	    					operation.perform(allObjects, keyword,objeto,type,value);
	    					                 	
	                    		
	                    	}
	                    	else if(tipo_browser == "Android") {
	                    	
	        					
	                        	mobile.perform(allObjects, keyword,objeto,type,value);
	                        	
	                    	} 
				       		 
			       			 }
			       		
			       		++satisfactorio_suite;
			       		cp_estatus.add("Pasado");
			       		 
			        		} catch (Exception e1) {
			       		 
			       		 System.out.println(e1.getMessage());
			       		 e1.printStackTrace();
			       		 Base.appendToFile(e1,caso_fallado);
			       		cp_estatus.add("Fallado");
			       		}
		        	++total_pruebas_suite;
		        				       	
		            }
		        	resultado_insatisfactorios_suite=total_pruebas_suite-satisfactorio_suite;
	            	System.out.println("insatisfactorio"+resultado_insatisfactorios_suite);
	            	System.out.println("caso satisfactorio"+satisfactorio_suite);
	            	casos_pasados.setText(String.valueOf(satisfactorio_suite));
	            	casos_fallados.setText(String.valueOf(resultado_insatisfactorios_suite));
	            	
	            	for(String str : cp_estatus) {
	            		
	            		System.out.println(str);
	            	}
	            	
	            	 items1 = FXCollections.observableArrayList(cp_estatus);
		            tableEstatus.setItems(items1);
	              
	            } 
	        });
	        
	        final Button limpiar_suite = new Button("Limpiar Suite");
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
	        
	        final Button repetir = new Button("Repetir CP");
	        repetir.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	
	            	 cp_ejecutar.add(repetir_caso);
	            	 items = FXCollections.observableArrayList(cp_ejecutar);
			         tableView.setItems(items);
	            }
	        });
	        

            Button actualizar = new Button();
		        actualizar.setText("Modificar CP");
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
		        
		        final Button btn_eliminar = new Button("Eliminar CP");
		        btn_eliminar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	Base eliminar1=new Base();
		            	String cp_eliminar=eliminar.getText();
		            	eliminar1.delete(cp_eliminar);
		            	
		            }
		        });
		        
		        
		        final Button reiniciar = new Button("Refrescar");
		        reiniciar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	
		            	
		            }
		        });
		        
		        final Button borrar_resultados = new Button("Borrar Resultados");
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
		        

       

		 
        hb.getChildren().addAll(addFirstName, addLastName,addEmail,valor, addButton,action,btn);
        hb.setSpacing(3);
        
        hc.getChildren().addAll(consultacp,consultar,limpiar);
        hc.setSpacing(10);
        
        ta.getChildren().addAll(cp_modificar,paso_modificar,actualizar);
        ta.setSpacing(10);
        
        te.getChildren().addAll(eliminar,btn_eliminar);
        te.setSpacing(10);
        
        hd.getChildren().addAll(nomcaso,casoprueba,browser,comboBox);
        hd.setSpacing(10);
        
        he.getChildren().addAll(lblpasados,casos_pasados,lblfallados,casos_fallados);
        he.setSpacing(10);
        
        tv.getChildren().addAll(tableView,tableEstatus);
        tv.setSpacing(0);
        
        ce.getChildren().addAll(table,tv);
        ce.setSpacing(10);
        
        de.getChildren().addAll(casos_a_ejecutar,comboBox2,suite,limpiar_suite,repetir,actualizar_combo);
        de.setSpacing(2);
        
        
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hd,ce,hb,hc,ta,te,line,suite_pruebas,de,line2,he,borrar_resultados);
 
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
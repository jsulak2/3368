package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller implements Initializable //allow certain default values before being created by constructor
{
    //we need to get access to the actor names
    @FXML
    private ListView<Employee> employeeListView; //when using ListView, make sure it is in java
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private CheckBox isActiveCheckBox;

    public Controller() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)->
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                    //firstNameTextField.setText(selectedItem.toString());
                    firstNameTextField.setText(((Employee) selectedItem).firstName);
                }
                );

        ObservableList<Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";
        items.add(employee1);
        items.add(employee2);


        for (int i = 1; i <=10; i++)
        {
            Employee employee = new Employee();
            employee.lastName = "Employee";
            employee.firstName = "Generic";
            employee.hire();
            items.add(employee);
        }

        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = "TerribleWorker";

        items.addAll(staff1,faculty1);

    }
}

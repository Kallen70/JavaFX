package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<Contacts> items = FXCollections.observableArrayList();


    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;


    public void addItems() {
        if (name.getText().isEmpty()|| phone.getText().isEmpty() || email.getText().isEmpty()) {

        } else {
            items.add(new Contacts(name.getText(), phone.getText(), email.getText()));
            name.setText("");
            phone.setText("");
            email.setText("");
        }

    }

    public void removeItem() {
        Contacts item = (Contacts) list.getSelectionModel().getSelectedItem();
        items.remove(item);
    }

    public void toggleItem() {

        Contacts item = (Contacts) list.getSelectionModel().getSelectedItem();

        if (item != null) {
            list.refresh();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(items);
    }

    public void setItems(KeyEvent keyEvent) {
    }
}

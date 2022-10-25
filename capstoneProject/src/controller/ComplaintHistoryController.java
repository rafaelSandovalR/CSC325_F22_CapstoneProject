
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ComplaintHistoryController {
    
      @FXML
    private TableColumn<?, ?> complaintColumn;

    @FXML
    private TableColumn<?, ?> creationDateColumn;

    @FXML
    private TableColumn<?, ?> fNameColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> lNameColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    void backToLoggedInPage(ActionEvent event) {

    }

}

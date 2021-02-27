/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioeventosteclado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Circle circle;
    @FXML
    private GridPane pane;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleScrollAction(ScrollEvent event) {}

    @FXML
    private void handleKeyPressed(KeyEvent event) {        
        int circleRowIndex = GridPane.getRowIndex(circle);
        int circleColumnIndex = GridPane.getColumnIndex(circle);
        
        int maxRow    = 4;
        int maxColumn = 4;

        int nextMove;
        
        switch (event.getCode()) {
            case UP:
                nextMove = circleRowIndex - 1;
                nextMove = nextMove < 0 ? maxRow : nextMove;
                GridPane.setRowIndex(circle, nextMove);
                break;
                
            case DOWN:
                nextMove = circleRowIndex + 1;
                nextMove = nextMove > maxRow ? 0 : nextMove;
                GridPane.setRowIndex(circle, nextMove);
                break;
                
            case LEFT:
                nextMove = circleColumnIndex - 1;
                nextMove = nextMove < 0 ? maxColumn : nextMove;
                GridPane.setColumnIndex(circle, nextMove);
                break;
                
            case RIGHT:
                nextMove = circleColumnIndex + 1;
                nextMove = nextMove > maxColumn ? 0 : nextMove; 
                GridPane.setColumnIndex(circle, nextMove);
                break;
                
            default: break;
        }
    }
    
}

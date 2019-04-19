/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class MainClassController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String algorithm = "";
    int q = 0;

    static boolean disable = false;

    @FXML
    private Button next;

    @FXML
    private Button exit;

    @FXML
    private Label check;

    @FXML
    private RadioButton backtrac;

    @FXML
    private ToggleGroup algo;

    @FXML
    private RadioButton genetic;

    @FXML
    private RadioButton ten;

    @FXML
    private ToggleGroup queen;

    @FXML
    private RadioButton nine;

    @FXML
    private RadioButton eight;

    @FXML
    private RadioButton seven;

    @FXML
    private RadioButton six;

    @FXML
    private RadioButton five;

    @FXML
    private RadioButton four;

    @FXML
    private Label check1;

    @FXML
    void Backtrac(ActionEvent event) {
        this.algorithm = "back";
        check.setText(null);
    }

    @FXML
    void Eight(ActionEvent event) {
        this.q = 8;
        check1.setText(null);
    }

    @FXML
    void Five(ActionEvent event) {
        this.q = 5;
        check1.setText(null);
    }

    @FXML
    void Four(ActionEvent event) {
        this.q = 4;
        check1.setText(null);
    }

    @FXML
    void Genetic(ActionEvent event) {
        this.algorithm = "gen";
        check.setText(null);
    }

    @FXML
    void Nine(ActionEvent event) {
        this.q = 9;
        check1.setText(null);
    }

    @FXML
    void Seven(ActionEvent event) {
        this.q = 7;
        check1.setText(null);
    }

    @FXML
    void Six(ActionEvent event) {
        this.q = 6;
        check1.setText(null);
    }

    @FXML
    void Ten(ActionEvent event) {
        this.q = 10;
        check1.setText(null);
    }

    @FXML
    void Exit(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Next(ActionEvent event) {
        if (algorithm.equals("")) {
            check.setText("CHOOSE AN OPTION");
        } else if (q == 0) {
            check1.setText("CHOOSE AN OPTION");
        } else {
            if (algorithm.equals("back")) {
                this.disable = true;
            } else {
                if (algorithm.equals("gen")) {
                    this.disable = false;
                }
            }
            switch (q) {
                case 4:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fourQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Four Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 5:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fiveQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Five Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 6:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sixQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Six Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 7:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sevenQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Seven Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 8:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/eightQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Eight Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 9:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/nineQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Nine Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 10:
                    try {
                        Stage stage = (Stage) next.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/tenQueens.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage st = new Stage();
                        st.setScene(new Scene(root1));
                        st.setTitle("Ten Queens");
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

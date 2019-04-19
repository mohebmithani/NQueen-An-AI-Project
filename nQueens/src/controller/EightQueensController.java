/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.MainClassController.disable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EightQueensController implements Initializable {

    /**
     * Initializes the controller class.
     */
    backTracking queenSet = new backTracking(8);
    Integer[][] matrix1 = new Integer[8][8];
    String k;
    ArrayList<int[][]> ab = new ArrayList<>();
    boolean genObject = false;
    int iterationsNum = 0;
    int totalIterations = 0;
//    ObservableList<String> list=FXCollections.observableArrayList("1","2","3","4","5");
    ArrayList<ImageView>[][] ivList = new ArrayList[8][8];
    ArrayList<String> s = new ArrayList();
    ArrayList<ImageView> track = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList("1", "20", "40", "60", "80", "100");
    ObservableList<String> list2 = FXCollections.observableArrayList("5", "10", "15", "20");
    ObservableList<String> list3 = FXCollections.observableArrayList("150", "200", "250", "300", "350", "400", "450", "500", "550", "600", "650", "700", "750", "800", "850", "900", "950", "1000", "1050", "1100", "1150", "1200");
    ObservableList<String> list4 = FXCollections.observableArrayList("500", "1000", "1500", "2000", "2500", "3000", "3500", "4000", "4500", "5000");

    @FXML
    private SplitPane pane11;

    @FXML
    private ImageView IV11;

    @FXML
    private SplitPane pane12;

    @FXML
    private ImageView IV12;

    @FXML
    private SplitPane pane14;

    @FXML
    private ImageView IV14;

    @FXML
    private SplitPane pane13;

    @FXML
    private ImageView IV13;

    @FXML
    private SplitPane pane41;

    @FXML
    private ImageView IV41;

    @FXML
    private SplitPane pane31;

    @FXML
    private ImageView IV31;

    @FXML
    private SplitPane pane21;

    @FXML
    private ImageView IV21;

    @FXML
    private SplitPane pane22;

    @FXML
    private ImageView IV22;

    @FXML
    private SplitPane pane24;

    @FXML
    private ImageView IV24;

    @FXML
    private SplitPane pane23;

    @FXML
    private ImageView IV23;

    @FXML
    private SplitPane pane32;

    @FXML
    private ImageView IV32;

    @FXML
    private SplitPane pane34;

    @FXML
    private ImageView IV34;

    @FXML
    private SplitPane pane33;

    @FXML
    private ImageView IV33;

    @FXML
    private SplitPane pane42;

    @FXML
    private ImageView IV42;

    @FXML
    private SplitPane pane44;

    @FXML
    private ImageView IV44;

    @FXML
    private SplitPane pane43;

    @FXML
    private ImageView IV43;

    @FXML
    private SplitPane pane51;

    @FXML
    private ImageView IV51;

    @FXML
    private SplitPane pane52;

    @FXML
    private ImageView IV52;

    @FXML
    private SplitPane pane54;

    @FXML
    private ImageView IV54;

    @FXML
    private SplitPane pane53;

    @FXML
    private ImageView IV53;

    @FXML
    private SplitPane pane15;

    @FXML
    private ImageView IV15;

    @FXML
    private SplitPane pane25;

    @FXML
    private ImageView IV25;

    @FXML
    private SplitPane pane35;

    @FXML
    private ImageView IV35;

    @FXML
    private SplitPane pane45;

    @FXML
    private ImageView IV45;

    @FXML
    private SplitPane pane55;

    @FXML
    private ImageView IV55;

    @FXML
    private SplitPane pane61;

    @FXML
    private ImageView IV61;

    @FXML
    private SplitPane pane16;

    @FXML
    private ImageView IV16;

    @FXML
    private SplitPane pane64;

    @FXML
    private ImageView IV64;

    @FXML
    private SplitPane pane63;

    @FXML
    private ImageView IV63;

    @FXML
    private SplitPane pane62;

    @FXML
    private ImageView IV62;

    @FXML
    private SplitPane pane65;

    @FXML
    private ImageView IV65;

    @FXML
    private SplitPane pane66;

    @FXML
    private ImageView IV66;

    @FXML
    private SplitPane pane56;

    @FXML
    private ImageView IV56;

    @FXML
    private SplitPane pane46;

    @FXML
    private ImageView IV46;

    @FXML
    private SplitPane pane36;

    @FXML
    private ImageView IV36;

    @FXML
    private SplitPane pane26;

    @FXML
    private ImageView IV26;

    @FXML
    private SplitPane pane71;

    @FXML
    private ImageView IV71;

    @FXML
    private SplitPane pane67;

    @FXML
    private ImageView IV67;

    @FXML
    private SplitPane pane57;

    @FXML
    private ImageView IV57;

    @FXML
    private SplitPane pane47;

    @FXML
    private ImageView IV47;

    @FXML
    private SplitPane pane37;

    @FXML
    private ImageView IV37;

    @FXML
    private SplitPane pane27;

    @FXML
    private ImageView IV27;

    @FXML
    private SplitPane pane17;

    @FXML
    private ImageView IV17;

    @FXML
    private SplitPane pane77;

    @FXML
    private ImageView IV77;

    @FXML
    private SplitPane pane76;

    @FXML
    private ImageView IV76;

    @FXML
    private SplitPane pane75;

    @FXML
    private ImageView IV75;

    @FXML
    private SplitPane pane74;

    @FXML
    private ImageView IV74;

    @FXML
    private SplitPane pane73;

    @FXML
    private ImageView IV73;

    @FXML
    private SplitPane pane72;

    @FXML
    private ImageView IV72;

    @FXML
    private SplitPane pane81;

    @FXML
    private ImageView IV81;

    @FXML
    private SplitPane pane18;

    @FXML
    private ImageView IV18;

    @FXML
    private SplitPane pane28;

    @FXML
    private ImageView IV28;

    @FXML
    private SplitPane pane38;

    @FXML
    private ImageView IV38;

    @FXML
    private SplitPane pane48;

    @FXML
    private ImageView IV48;

    @FXML
    private SplitPane pane58;

    @FXML
    private ImageView IV58;

    @FXML
    private SplitPane pane68;

    @FXML
    private ImageView IV68;

    @FXML
    private SplitPane pane78;

    @FXML
    private ImageView IV78;

    @FXML
    private SplitPane pane88;

    @FXML
    private ImageView IV88;

    @FXML
    private SplitPane pane82;

    @FXML
    private ImageView IV82;

    @FXML
    private SplitPane pane83;

    @FXML
    private ImageView IV83;

    @FXML
    private SplitPane pane84;

    @FXML
    private ImageView IV84;

    @FXML
    private SplitPane pane85;

    @FXML
    private ImageView IV85;

    @FXML
    private SplitPane pane86;

    @FXML
    private ImageView IV86;

    @FXML
    private SplitPane pane87;

    @FXML
    private ImageView IV87;

    @FXML
    private Button stop;

    @FXML
    private Button next;

    @FXML
    private ComboBox<String> CB1;

    @FXML
    private ComboBox<String> CB2;

    @FXML
    private ComboBox<String> CB3;

    @FXML
    private ComboBox<String> CB4;

    @FXML
    private Label label12;

    @FXML
    private Label label121;

    @FXML
    private Label label13;

    @FXML
    private Label label14;

    @FXML
    private Label label15;

    @FXML
    private RadioButton yes;

    @FXML
    private ToggleGroup muta;

    @FXML
    private RadioButton no;

    @FXML
    void No(ActionEvent event) {

    }

    @FXML
    void Yes(ActionEvent event) {

    }

    public void fun() {
        matrix1 = queenSet.solveNQueens();
        if (matrix1 != null) {
            for (int i = 0; i < queenSet.getN(); i++) {
                for (int j = 0; j < queenSet.getN(); j++) {
                    if (matrix1[i][j] == 1) {
                        k = String.valueOf(i) + String.valueOf(j);
                        s.add(k);
                    }
                }
            }
        }

    }

    public void display() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("No Further Solution Exist!");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    @FXML
    void Next(ActionEvent event) {
        if (disable == true) {
            s.clear();
            fun();
            if (matrix1 == null) {
                display();
                Stop(event);
            } else {
                for (int i = 0; i < queenSet.getN(); i++) {
                    for (int j = 0; j < queenSet.getN(); j++) //                if (this.board[i][j] == 1) {
                    //                System.out.print(j+1);    
                    //                }
                    {
                        System.out.print(" " + matrix1[i][j]
                                + " ");
                    }
                    System.out.println();
                }
                Image img = new Image("file:2.png");
                for (int j = 0; j < queenSet.getN(); j++) {
                    for (int i = 0; i < queenSet.getN(); i++) {
                        if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(0))) {
                            track.get(0).setImage(null);
                            //IV11.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(0);
                            track.add(0, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(1))) {
                            track.get(1).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(1);
                            track.add(1, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(2))) {
                            track.get(2).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(2);
                            track.add(2, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(3))) {
                            track.get(3).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(3);
                            track.add(3, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(4))) {
                            track.get(4).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(4);
                            track.add(4, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(5))) {
                            track.get(5).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(5);
                            track.add(5, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(6))) {
                            track.get(6).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(6);
                            track.add(6, ivList[j][i].get(0));
                        } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(7))) {
                            track.get(7).setImage(null);
                            //IV21.setImage(null);
                            ivList[j][i].get(0).setImage(img);
                            track.remove(7);
                            track.add(7, ivList[j][i].get(0));
                        }
                    }
                }
            }
        } else if (disable == false) {
            int maxGeneration, maxBoards, noOfQueens, selectingFactor, mutationChance;
            boolean unethicalMutation = false;
            /* System.out.println("Please input maximum Geneation: ");
        maxGeneration = input.nextInt();
        System.out.println("Please input maximum Boards: ");
        maxBoards = input.nextInt();
        System.out.println("Please input number of queens: ");
        noOfQueens = input.nextInt();
        System.out.println("Please input selecting factor: ");
        selectingFactor = input.nextInt();
        System.out.println("Please input mutation chance: ");
        mutationChance = input.nextInt();
        System.out.println("Do you want to do unethical mutation.(yes/no) ");
        if(input.next().equalsIgnoreCase("yes"));
            unethicalMutation = true;*/
            mutationChance = Integer.parseInt(CB1.getValue());
            selectingFactor = Integer.parseInt(CB2.getValue());
            maxBoards = Integer.parseInt(CB3.getValue());
            noOfQueens = queenSet.getN();
            maxGeneration = Integer.parseInt(CB4.getValue());
            if (yes.isDisabled() != true) {
                unethicalMutation = true;
            }
            if (!genObject) {
                genPossibilities(maxGeneration, maxBoards, noOfQueens, selectingFactor, unethicalMutation, mutationChance);
                genObject = true;
                CB1.setDisable(true);
                CB2.setDisable(true);
                CB3.setDisable(true);
                CB4.setDisable(true);
                yes.setDisable(true);
                no.setDisable(true);
            }
            if (iterationsNum < totalIterations) {

                fun1(ab.get(iterationsNum++));

            } else {
                display();
                Stop(event);
            }
        }
    }

    @FXML
    public void n(ArrayList<String> s) {

        //System.out.println("four queens class");
        if (s == null) {
            display();
        } else {
            /*for (int i = 0; i < queensSet.getN(); i++) {
                for (int j = 0; j < queensSet.getN(); j++) //                if (this.board[i][j] == 1) {
                //                System.out.print(j+1);    
                //                }
                {
                    System.out.print(" " + matrix1[i][j]
                            + " ");
                }
                System.out.println();
            }*/
            Image img = new Image("file:2.png");
            for (int j = 0; j < queenSet.getN(); j++) {
                for (int i = 0; i < queenSet.getN(); i++) {
                    if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(0))) {
                        track.get(0).setImage(null);
                        //IV11.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(0);
                        track.add(0, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(1))) {
                        track.get(1).setImage(null);
                        //IV21.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(1);
                        track.add(1, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(2))) {
                        track.get(2).setImage(null);
                        //IV31.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(2);
                        track.add(2, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(3))) {
                        track.get(3).setImage(null);
                        //IV41.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(3);
                        track.add(3, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(4))) {
                        track.get(4).setImage(null);
                        //IV41.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(4);
                        track.add(4, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(5))) {
                        track.get(5).setImage(null);
                        //IV21.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(5);
                        track.add(5, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(6))) {
                        track.get(6).setImage(null);
                        //IV21.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(6);
                        track.add(6, ivList[j][i].get(0));
                    } else if ((Integer.toString(j) + Integer.toString(i)).equalsIgnoreCase(s.get(7))) {
                        track.get(7).setImage(null);
                        //IV21.setImage(null);
                        ivList[j][i].get(0).setImage(img);
                        track.remove(7);
                        track.add(7, ivList[j][i].get(0));
                    }
                }
            }
        }
    }

    public void fun1(int[][] matrix1) {
        s.clear();
        if (matrix1 != null) {
            for (int i = 0; i < queenSet.getN(); i++) {
                for (int j = 0; j < queenSet.getN(); j++) {
                    if (matrix1[i][j] == 1) {
                        k = String.valueOf(i) + String.valueOf(j);
                        s.add(k);
                    }
                }
            }
        }
        n(s);
    }

    @FXML
    void Stop(ActionEvent event) {
        try {
            Stage stage = (Stage) next.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainClass.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.setTitle("nQueens Problem");
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (disable == true) {
            CB1.setDisable(true);
            CB2.setDisable(true);
            CB3.setDisable(true);
            CB4.setDisable(true);
            yes.setDisable(true);
            no.setDisable(true);
        } else {
            CB1.setValue("1");
            CB1.setItems(list);
            CB2.setValue("5");
            CB2.setItems(list2);
            CB3.setValue("150");
            CB3.setItems(list3);
            CB4.setValue("500");
            CB4.setItems(list4);
        }
        for (int i = 0; i < queenSet.getN(); i++) {
            for (int j = 0; j < queenSet.getN(); j++) {
                ivList[i][j] = new ArrayList<>();
            }
        }

        ivList[0][0].add(IV11);
        ivList[0][1].add(IV12);
        ivList[0][2].add(IV13);
        ivList[0][3].add(IV14);
        ivList[0][4].add(IV15);
        ivList[0][5].add(IV16);
        ivList[0][6].add(IV17);
        ivList[0][7].add(IV18);

        ivList[1][0].add(IV21);
        ivList[1][1].add(IV22);
        ivList[1][2].add(IV23);
        ivList[1][3].add(IV24);
        ivList[1][4].add(IV25);
        ivList[1][5].add(IV26);
        ivList[1][6].add(IV27);
        ivList[1][7].add(IV28);

        ivList[2][0].add(IV31);
        ivList[2][1].add(IV32);
        ivList[2][2].add(IV33);
        ivList[2][3].add(IV34);
        ivList[2][4].add(IV35);
        ivList[2][5].add(IV36);
        ivList[2][6].add(IV37);
        ivList[2][7].add(IV38);

        ivList[3][0].add(IV41);
        ivList[3][1].add(IV42);
        ivList[3][2].add(IV43);
        ivList[3][3].add(IV44);
        ivList[3][4].add(IV45);
        ivList[3][5].add(IV46);
        ivList[3][6].add(IV47);
        ivList[3][7].add(IV48);

        ivList[4][0].add(IV51);
        ivList[4][1].add(IV52);
        ivList[4][2].add(IV53);
        ivList[4][3].add(IV54);
        ivList[4][4].add(IV55);
        ivList[4][5].add(IV56);
        ivList[4][6].add(IV57);
        ivList[4][7].add(IV58);

        ivList[5][0].add(IV61);
        ivList[5][1].add(IV62);
        ivList[5][2].add(IV63);
        ivList[5][3].add(IV64);
        ivList[5][4].add(IV65);
        ivList[5][5].add(IV66);
        ivList[5][6].add(IV67);
        ivList[5][7].add(IV68);

        ivList[6][0].add(IV71);
        ivList[6][1].add(IV72);
        ivList[6][2].add(IV73);
        ivList[6][3].add(IV74);
        ivList[6][4].add(IV75);
        ivList[6][5].add(IV76);
        ivList[6][6].add(IV77);
        ivList[6][7].add(IV78);

        ivList[7][0].add(IV81);
        ivList[7][1].add(IV82);
        ivList[7][2].add(IV83);
        ivList[7][3].add(IV84);
        ivList[7][4].add(IV85);
        ivList[7][5].add(IV86);
        ivList[7][6].add(IV87);
        ivList[7][7].add(IV88);

        track.add(IV11);
        track.add(IV21);
        track.add(IV31);
        track.add(IV41);
        track.add(IV51);
        track.add(IV61);
        track.add(IV71);
        track.add(IV81);

    }

    private boolean check(int[][] arr, ActionEvent event) {
        for (int i = 0; i < ab.size(); i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if ((arr[j][k] == 1 && ab.get(i)[j][k] == 1)) {
                        flag++;
//                        break;
                    }
                }

            }
            if (flag == arr.length) {
                System.out.println("board matched!");
                display();
                Stop(event);
                return true;
            }
        }
        return false;
    }

    private void genPossibilities(int maxGeneration, int maxBoards, int noOfQueens, int selectingFactor, boolean unethicalMutation, int mutationChance) {

        GeneticAlgorithm problem = new GeneticAlgorithm(maxGeneration, maxBoards, noOfQueens, selectingFactor, unethicalMutation, mutationChance);

        int[][] arr = new int[noOfQueens][noOfQueens];
        StringManager string = new StringManager();
        int answer = 0, n, flagging = 0;

//        Scanner sc = new Scanner(System.in);
        NQueenBoard[] parentBoard, childBoard;
        try {
            problem.initialization();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FourQueensController.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {

            n = 0;

            for (int i = 0; i < problem.getParent().getMaxBoards() / 2; i++) {
                parentBoard = problem.selection();
                childBoard = problem.crossover(parentBoard);
                problem.mutation(childBoard);
            }
            problem.setGeneration(problem.getGeneration() + 1);
//            System.out.println("generation: "+this.generation);
            problem.setParent(problem.getChild());
            try {
                problem.initialization();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(FourQueensController.class.getName()).log(Level.SEVERE, null, ex);
            }

            BoardController temp = new BoardController(problem.getParent().getMaxBoards(), problem.getParent().getNoOfQueens());
            problem.setChild(temp);
            problem.setNchildBoard(0);

            if (problem.getParent().isIsAnyFit()) {
                do {
                    if (problem.getParent().getBoard(n).getFitnessValue() == 0) {
                        int a = 0;
                        if (problem.getSolutionSet().isEmpty()) {
//                                System.out.println("nQueen board with no queen attacking is found.");
//                                System.out.println("pattern:"+problem.getParent().getBoards()[n].getQueensPosition());
                            arr = string.patternIn2d(problem.getParent().getBoards()[n].getQueensPosition());
                            problem.getSolutionSet().add(problem.getParent().getBoard(n));
//                        if (!check(arr,event)) {
                            ab.add(arr);
//                            fun1(arr);

//                        }
                            flagging++;
                            /*System.out.println("Do you want to see another fit board? press 1 for yes");
                                answer = input.nextInt();
                                if(answer == 2)
                                    return;*/
                        } else {
                            while (a < problem.getSolutionSet().size()) {
                                if (problem.getParent().getBoards()[n].getQueensPosition().equalsIgnoreCase(problem.getSolutionSet().get(a).getQueensPosition())) {
                                    problem.getParent().getBoards()[n].setIsSame(true);
                                    break;
                                }

                                a++;
                            }
                            if (problem.getParent().getBoards()[n].getIsSame() != true) {
                                arr = string.patternIn2d(problem.getParent().getBoards()[n].getQueensPosition());
                                problem.getSolutionSet().add(problem.getParent().getBoard(n));
                                problem.getSolutionSet().add(problem.getParent().getBoard(n));
//                            if (!check(arr,event)) {
                                ab.add(arr);
//                                fun1(arr);
                                flagging++;
//                            }
                                /* System.out.println("Do you want to see another fit board? press 1 for yes");
                                    answer = input.nextInt();
                                    if(answer == 2)
                                        return;*/
                            }

                        }

                        n++;
                    } else {
                        break;
                    }
                } while (flagging < 40);
            }
        } while (problem.getGeneration() < problem.getMaxGenerations());
        totalIterations = ab.size();
        System.out.println(ab.size());
        arr = null;
    }

}

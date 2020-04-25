package esi.atl.g43335.sokoban.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author franc
 */
public class App extends Application {

    private final int BOARD_SIZE = 40;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sokoban");
        primaryStage.setMaximized(true);

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem exit = new MenuItem("Exit");
        menu.getItems().add(exit);

        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);

        HBox gameBoard = new HBox();
        gameBoard.setAlignment(Pos.CENTER);
        root.getChildren().add(gameBoard);

        BoardFX board = new BoardFX();

        gameBoard.getChildren().add(board);

        HBox stats1 = new HBox();
        stats1.setAlignment(Pos.CENTER_LEFT);

        HBox stats2 = new HBox();
        stats2.setAlignment(Pos.CENTER_RIGHT);

        HBox menuBox = new HBox();
        menuBox.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

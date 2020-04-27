package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.controller.Controller;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author franc
 */
public class App extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game(0);
        Maze maze = new Maze();
        View view = new View();
        Controller controller = new Controller(game, view);
        maze.chooseLevel(1);

        primaryStage.setTitle("Sokoban");
        primaryStage.setMaximized(true);

        VBox root = new VBox();
//        root.setAlignment(Pos.TOP_CENTER);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem exit = new MenuItem("Exit");
        menu.getItems().add(exit);

        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);

        BorderPane borderPane = new BorderPane();
        root.getChildren().add(borderPane);

        HBox stats1 = new HBox();
//        stats1.setAlignment(Pos.CENTER_LEFT);
        borderPane.setLeft(stats1);
//        root.getChildren().add(stats1);
        stats1.setPrefWidth(600);
        StatsLeftFX statsLeft = new StatsLeftFX();
        stats1.getChildren().add(statsLeft);

        HBox gameBoard = new HBox();
//        gameBoard.setAlignment(Pos.CENTER);
        borderPane.setCenter(gameBoard);
        BoardFX board = new BoardFX(maze);
        gameBoard.getChildren().add(board);

        HBox stats2 = new HBox();
//        stats2.setAlignment(Pos.TOP_LEFT);
        borderPane.setRight(stats2);
        StatsRightFX statsRight = new StatsRightFX();
        stats2.getChildren().add(statsRight);

        HBox playBox = new HBox();
//        playBox.setAlignment(Pos.BOTTOM_CENTER);
        borderPane.setBottom(playBox);
        PlayMenuFX playMenu = new PlayMenuFX();
        playBox.getChildren().add(playMenu);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

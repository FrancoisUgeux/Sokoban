package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.controller.Controller;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import javafx.application.Application;
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

    private Game game;
    private Maze maze;
    private View view;
    private Controller controller;

//    private BoardFX board;
    public App() {

//        board = new BoardFX(maze);
    }

    public Game getGame() {
        return game;
    }

    public Maze getMaze() {
        return maze;
    }

    public View getView() {
        return view;
    }

    public Controller getController() {
        return controller;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.game = new Game(0);
        this.maze = new Maze();
        this.view = new View();
        this.controller = new Controller(game, view);

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
        StatsLeftFX statsLeft = new StatsLeftFX(game);
        stats1.getChildren().add(statsLeft);

        HBox gameBoard = new HBox();
//        gameBoard.setAlignment(Pos.CENTER);
        BoardFX board = new BoardFX(maze);
        borderPane.setCenter(gameBoard);
        gameBoard.getChildren().add(board);

        HBox stats2 = new HBox();
//        stats2.setAlignment(Pos.TOP_LEFT);
        borderPane.setRight(stats2);
        StatsRightFX statsRight = new StatsRightFX();
        stats2.getChildren().add(statsRight);

        HBox playBox = new HBox();
//        playBox.setAlignment(Pos.BOTTOM_CENTER);
        borderPane.setBottom(playBox);
        PlayMenuFX playMenu = new PlayMenuFX(game, board, statsLeft);
        playBox.getChildren().add(playMenu);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.controller.Controller;
import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Observer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
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

    private Game game;
    private StatsLeftFX statsLeft;
    private BoardFX board;
    private PlayMenuFX playMenu;
    private StatsRightFX statsRight;
    private Scene scene;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.game = new Game(0);
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Sokoban");
        primaryStage.setMaximized(true);

        initComponent();
        addObservers();

        scene.setOnKeyPressed((KeyEvent key) -> {
            if (!game.isOver()) {
                switch (key.getCode()) {
                    case Z:
                        game.move(Direction.UP);
                        break;
                    case Q:
                        game.move(Direction.LEFT);
                        break;
                    case S:
                        game.move(Direction.DOWN);
                        break;
                    case D:
                        game.move(Direction.RIGHT);
                        break;
                }
            }
        });
    }

    private void initComponent() {
        VBox root = new VBox();

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem exit = new MenuItem("Exit");
        menu.getItems().add(exit);

        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);

        BorderPane borderPane = new BorderPane();
        root.getChildren().add(borderPane);

        HBox stats1 = new HBox();
        borderPane.setLeft(stats1);
        stats1.setPrefWidth(585);
        statsLeft = new StatsLeftFX(game);
        stats1.getChildren().add(statsLeft);

        HBox gameBoard = new HBox();
        board = new BoardFX(game);
        borderPane.setCenter(gameBoard);
        gameBoard.getChildren().add(board);

        HBox stats2 = new HBox();
        stats2.setPrefWidth(585);
        borderPane.setRight(stats2);
        statsRight = new StatsRightFX(game);
        stats2.getChildren().add(statsRight);

        HBox playBox = new HBox();
        borderPane.setBottom(playBox);
        playMenu = new PlayMenuFX(game, statsLeft);
        playBox.getChildren().add(playMenu);

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addObservers() {
        game.registerObserver(board);
        game.registerObserver(statsLeft);
        game.registerObserver(statsRight);
    }
}

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Duration;


public class Control {
    PauseTransition pause = new PauseTransition();
    Button startButton = new Button("Start");
    Button pauseButton = new Button("Pause");
    Button resumeButton = new Button("Resume");
    Button stopButton = new Button("Stop");
    public Control(){
        startButton.setOnAction(new EventHandler< ActionEvent >(){
            @Override
            public void handle(ActionEvent actionEvent) {
                pause.play();
            }
        } );
        pauseButton.setOnAction(new EventHandler< ActionEvent >(){
            @Override
            public void handle(ActionEvent actionEvent) {
                pause.setDuration(Duration.seconds(10));
            }
        } );
        resumeButton.setOnAction(new EventHandler< ActionEvent >(){
            @Override
            public void handle(ActionEvent actionEvent) {
                pause.play();
            }
        } );
        stopButton.setOnAction(new EventHandler< ActionEvent >(){
            @Override
            public void handle(ActionEvent actionEvent) {
                pause.stop();
            }
        } );
        startButton.disableProperty().bind(pause.statusProperty().isNotEqualTo(Animation.Status.STOPPED));
        resumeButton.disableProperty().bind(pause.statusProperty().isNotEqualTo(Animation.Status.PAUSED));
        pauseButton.disableProperty().bind(pause.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
        stopButton.disableProperty().bind(pause.statusProperty().isEqualTo(Animation.Status.STOPPED));
    }
}

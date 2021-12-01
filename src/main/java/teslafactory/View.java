package teslafactory;

import javafx.scene.control.ProgressBar;
import teslafactory.model.CarFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class View {

    private static final String TOTAL_MADE_PREFIX = "Total made: ";

    protected static final Logger log = LoggerFactory.getLogger(View.class);

    @FXML
    private Label bodyStorageInfo;
    @FXML
    private Label engineStorageInfo;
    @FXML
    private Label accessoriesStorageInfo;
    @FXML
    private Label carStorageInfo;

    @FXML
    private Label bodyTotalMade;
    @FXML
    private Label engineTotalMade;
    @FXML
    private Label accessoriesTotalMade;
    @FXML
    private Label carTotalMade;

    @FXML
    private Label inProgress;

    @FXML
    private Label totalSold;

    @FXML
    private Label salesInProgress;

    @FXML
    private ProgressBar factoryCapacity;

    @FXML
    private ProgressBar bodyStorageCapacity;
    @FXML
    private ProgressBar engineStorageCapacity;
    @FXML
    private ProgressBar accessoriesStorageCapacity;
    @FXML
    private ProgressBar carStorageCapacity;



    protected Config config;

    protected CarFactory carFactory;

    void setCarFactoryConfig(Config config) {
        this.config = config;
        log.debug("carFactory attached");
    }

    public void onNext() {
        Platform.runLater(() -> {
            var state = carFactory.getState();
            Config config = carFactory.getConfig();
            bodyStorageInfo.setText(state.bodyStorageSize() + "/" + config.bodyStorageMaxSize());
            engineStorageInfo.setText(state.engineStorageSize() + "/" + config.engineStorageMaxSize());
            accessoriesStorageInfo.setText(state.accessoriesStorageSize() + "/" + config.accessoriesStorageMaxSize());
            carStorageInfo.setText(state.carStorageSize() + "/" + config.accessoriesStorageMaxSize());
            bodyStorageCapacity.setProgress((double)state.bodyStorageSize() / config.bodyStorageMaxSize());
            engineStorageCapacity.setProgress((double)state.engineStorageSize() / config.engineStorageMaxSize());
            accessoriesStorageCapacity.setProgress((double)state.accessoriesStorageSize() / config.accessoriesStorageMaxSize());
            carStorageCapacity.setProgress((double)state.carStorageSize() / config.carStorageMaxSize());
            bodyTotalMade.setText(TOTAL_MADE_PREFIX + state.bodiesTotalMade());
            engineTotalMade.setText(TOTAL_MADE_PREFIX + state.enginesTotalMade());
            accessoriesTotalMade.setText(TOTAL_MADE_PREFIX + state.accessoriesTotalMade());
            carTotalMade.setText(TOTAL_MADE_PREFIX + state.carTotalMade());
            inProgress.setText("Cars in build progress: " + state.inProgress());
            totalSold.setText("Total sold: " + state.totalSold());
            salesInProgress.setText("Sales in progress: " + state.salesInProgress());
            factoryCapacity.setProgress((double)state.inProgress() / config.optimalCarStorageSize());
        });
    }
}
package zd.zmk.desktop.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import zd.zmk.desktop.model.VendingMachineModel;
import zd.zmk.desktop.util.ApiClient;
import zd.zmk.entities.VendingMachine;

public class MainController {

    @FXML
    private VBox mainContainer;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button refreshButton;

    @FXML
    private TableView<VendingMachineModel> vendingMachineTable;

    @FXML
    private TableColumn<VendingMachineModel, Integer> idColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> serialNumberColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> inventoryNumberColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> modelColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> companyColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> statusColumn;

    @FXML
    private TableColumn<VendingMachineModel, String> locationColumn;

    private ApiClient apiClient;

    @FXML
    public void initialize() {
        apiClient = new ApiClient();
        welcomeLabel.setText("Добро пожаловать в Вендинговое приложение");

        setupTableColumns();
        setupEventHandlers();
    }

    private void setupTableColumns() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        serialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().serialNumberProperty());
        inventoryNumberColumn.setCellValueFactory(cellData -> cellData.getValue().inventoryNumberProperty());
        modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
    }

    private void setupEventHandlers() {
        refreshButton.setOnAction(event -> {
            // Refresh data from API
            refreshData();
        });
    }

    private void refreshData() {
        // Fetch data from API and populate the table
        ObservableList<VendingMachine> vendingMachines = apiClient.getAllVendingMachines();

        // Convert entities to model objects
        ObservableList<VendingMachineModel> modelList = javafx.collections.FXCollections.observableArrayList();
        for (VendingMachine vm : vendingMachines) {
            VendingMachineModel model = new VendingMachineModel(
                vm.getId(),
                vm.getSerialNumber(),
                vm.getInventoryNumber(),
                vm.getModel(),
                vm.getCompany(),
                vm.getStatus() != null ? vm.getStatus().toString() : "UNKNOWN",
                vm.getLocation()
            );
            modelList.add(model);
        }

        vendingMachineTable.setItems(modelList);
        System.out.println("Data refreshed from API. Loaded " + modelList.size() + " vending machines.");
    }
}
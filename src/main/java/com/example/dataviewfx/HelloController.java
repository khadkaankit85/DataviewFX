package com.example.dataviewfx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {

    @FXML
    private TableView<University> tableView;

    @FXML
    private TableColumn<University, Integer> tableID;
    @FXML
    private TableColumn<University, String> tableName;
    @FXML
    private TableColumn<University, Integer> tableRank;
    @FXML
    private TableColumn<University, String> tableLocation;

    private final String URL = "jdbc:mysql://localhost:3306/university_db";
    private final String USER = "root";
    private final String PASSWORD = null;

    @FXML
    void fetchData() {
        // Set up the TableView columns
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableRank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        tableLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        loadStyles();

        // Load data into the TableView
        loadData();
    }

    public void loadData() {
        ObservableList<University> universityList = FXCollections.observableArrayList(); // Create an empty list

        // Create the database connection and retrieve data
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM universities")) {

            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int rank = resultSet.getInt("rank");
                String location = resultSet.getString("location");

                // Create a University object and add it to the list
                University university = new University(id, name, rank, location);
                universityList.add(university);
            }

            // Set the items in the TableView
            tableView.setItems(universityList);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
    }
    private void loadStyles() {
        // Load CSS from the resources
        tableRank.getStyleClass().add("table-cell-selected");
        tableID.getStyleClass().add("table-cell-selected");
        tableView.getStyleClass().add("table-cell-selected");
        tableName.getStyleClass().add("table-cell-selected");
        tableLocation.getStyleClass().add("table-cell-selected");


    }
}


package backend.implementations;

import backend.dto.Client;
import backend.helper.DatabaseConnection;
import backend.interfaces.ClientInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImplementation implements ClientInterface {
    private final DatabaseConnection db;

    public ClientImplementation() {
        db = DatabaseConnection.getInstance();
    }

    @Override
    public Optional<Client> add(Client client) {
        try {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO client (name, prenoun, birthDate, phone, adresse) VALUES (?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPrenoun());
            preparedStatement.setObject(3, client.getBirthDate());

            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getAdresse());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 1) {
                return Optional.of(client);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        try (Connection conn = db.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM client");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setCode(resultSet.getInt("code"));
                client.setName(resultSet.getString("name"));
                client.setPrenoun(resultSet.getString("prenoun"));
                client.setPhone(resultSet.getString("phone"));
                client.setBirthDate(resultSet.getDate("birthdate").toLocalDate());
                client.setAdresse(resultSet.getString("adresse"));
                clients.add(client);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return clients;
    }
    @Override
    public Optional<Client> getClientById(Integer clientId) {
        try {
            Connection conn = db.getConnection();
            String searchQuery = "SELECT * FROM client WHERE code = ?";

            try (PreparedStatement preparedStatement = conn.prepareStatement(searchQuery)) {
                preparedStatement.setInt(1, clientId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Integer foundCode = resultSet.getInt("code");
                    String name = resultSet.getString("name");
                    String prenoun = resultSet.getString("prenoun");
                    String adresse = resultSet.getString("adresse");
                    String phone = resultSet.getString("phone");
                    LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();

                    Client foundClient = new Client(name, prenoun, birthdate, phone, foundCode, adresse);

                    System.out.println("Client found: " + foundClient); // Add a debug statement
                    return Optional.of(foundClient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception to the console for debugging
        }

        System.out.println("Client not found for ID: " + clientId); // Add a debug statement
        return Optional.empty(); // Return an empty Optional if no client is found
    }



@Override
public Optional<Client> update(Client existingClient){
    String updateQuery = "UPDATE client SET name = ?, prenoun = ?, adresse = ?, phone = ?, birthdate = ? WHERE code = ?";
    try {
        Connection conn = db.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

        preparedStatement.setString(1, existingClient.getName());
        preparedStatement.setString(2, existingClient.getPrenoun());
        preparedStatement.setString(3, existingClient.getAdresse());
        preparedStatement.setString(4, existingClient.getPhone());

        preparedStatement.setDate(5, java.sql.Date.valueOf(existingClient.getBirthDate()));
        preparedStatement.setInt(6, existingClient.getCode());
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            return Optional.of(existingClient);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}


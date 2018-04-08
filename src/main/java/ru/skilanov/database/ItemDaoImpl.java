package ru.skilanov.database;

import ru.skilanov.model.Item;
import ru.skilanov.model.ItemList;

import java.sql.*;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private static final String SELECT = "SELECT * FROM test";
    private static final String DELETE = "DELETE FROM test";
    private static final String INSERT = "INSERT INTO test(task) VALUES (?)";

    @Override
    public void deleteAll() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }


    @Override
    public List<Item> getAll() {
        ItemList itemList = new ItemList();
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                itemList.getItemList().add(new Item(resultSet.getInt("task")));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList.getItemList();
    }

    @Override
    public void insert(Item item) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(INSERT);
            for (int i = 0; i < item.getField(); i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

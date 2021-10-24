package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.Integer.*;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
        Properties config = new Properties();
        config.load(in);
        Class.forName(config.getProperty("driver-class-name"));
        cn = DriverManager.getConnection(
                config.getProperty("url"),
                config.getProperty("username"),
                config.getProperty("password")
        );
        PreparedStatement ps = cn.prepareStatement("CREATE TABLE IF NOT EXISTS items (id serial primary key, name varchar(255))");
        ps.executeUpdate();
        ps.close();
    } catch (Exception e) {
        throw new IllegalStateException(e);
    }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items (name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS)) {
           ps.setString(1, item.getName());
           ps.executeUpdate();
           try (ResultSet keys = ps.getGeneratedKeys()) {
               if (keys.next()) {
                item.setId(keys.getInt(1));
               }
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items SET name = (?) WHERE id = (?)")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id = (?)")) {
            ps.setInt(1, valueOf(id));
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE name LIKE (?)")) {
            ps.setString(1, String.join(key, "%", "%"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE id = (?)")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Item(rs.getString("name"));
                result.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

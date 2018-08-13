package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class photoRepository {

    @Autowired
    public DataSource dataSource;

    public List<photos> getphotos() {
        List<photos> allPhotos = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM gallery");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                photos p = new photos(resultSet.getInt("imageID"), resultSet.getString("url"), resultSet.getString("title"));
                allPhotos.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allPhotos;
    }

    public void addNewPhoto(String url, String title) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO gallery(url, title) VALUES(?,?)", new String[]{"imageID"});
            ps.setString(1, url);
            ps.setString(2, title);
            ps.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

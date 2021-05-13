package mate.academy.dao;

import mate.academy.literaryformate.LiteraryFormat;
import mate.academy.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LiteraryDaoImpl implements LiteraryFormatDao{
    @Override
    public List<LiteraryFormat> getAll() {
        List<LiteraryFormat> allFormats = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection();
             Statement getAllDataFromDB= connection.createStatement()) {
            ResultSet resultSet = getAllDataFromDB.executeQuery("SELECT * FROM library where delted = false ;");
            while (resultSet.next()) {
                String format = resultSet.getString("formate");
                Long id = resultSet.getObject("id", Long.class);
                LiteraryFormat literaryFormat = new LiteraryFormat();
                literaryFormat.setId(id);
                literaryFormat.setTitle(format);
                allFormats.add(literaryFormat);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Cant get all foramts", e);
        }
        return allFormats;
    }

    @Override
    public LiteraryFormat create(LiteraryFormat format) {
        String insertFormatRequest = "INSERT INTO library(formate) values(?);";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement createFormatStatement =
                     connection.prepareStatement(insertFormatRequest, Statement.RETURN_GENERATED_KEYS)){
            createFormatStatement.setString(1, format.getTitle());
            createFormatStatement.executeUpdate();
            ResultSet generatedKeys = createFormatStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                format.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cant insert ", e);
        }
        return format;
    }

    @Override
    public boolean deleted(Long id) {
       String deletedQuery = "UPDATE library SET delted = true where id = ?";
       try (Connection connection = ConnectionDB.getConnection();
       PreparedStatement preparedStatement =
               connection.prepareStatement(deletedQuery, Statement.RETURN_GENERATED_KEYS)){
           preparedStatement.setLong(1, id);
          return preparedStatement.executeUpdate() >= 1;
       } catch (SQLException e) {
           throw new RuntimeException("can't deleted format", e);
       }
    }
}

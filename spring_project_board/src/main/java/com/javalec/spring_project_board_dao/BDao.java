package com.javalec.spring_project_board_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalec.spring_project_board_dto.BDto;

public class BDao {
  DataSource dataSource;

  public BDao() {
    try {
      Context context = new InitialContext();
      dataSource = (DataSource) context.lookup("java:comp/env/jdbc/springmvcdb");
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public BDto contentView(String strId) {
    upHit(strId);

    BDto dto = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = dataSource.getConnection();

      String query = "select * from mvc_board where bId = ?";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, Integer.parseInt(strId));
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        int bId = resultSet.getInt("bId");
        String bName = resultSet.getString("bName");
        String bTitle = resultSet.getString("bTitle");
        String bContent = resultSet.getString("bContent");
        Timestamp bDate = resultSet.getTimestamp("bDate");
        int bHit = resultSet.getInt("bHit");
        int bGroup = resultSet.getInt("bGroup");
        int bStep = resultSet.getInt("bStep");
        int bIndent = resultSet.getInt("bIndent");

        dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if (preparedStatement != null)
          preparedStatement.close();
        if (connection != null)
          connection.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return dto;
  }

  private void upHit(String bId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = dataSource.getConnection();
      String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, bId);

      int rn = preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (preparedStatement != null)
          preparedStatement.close();
        if (connection != null)
          connection.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }

  public void write(String bName, String bTitle, String bContent) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = dataSource.getConnection();
      String query = "INSERT INTO mvc_board(bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)"
          + "VALUE (?, ?, ?, 0, 0, 0, 0)";
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, bName);
      preparedStatement.setString(2, bTitle);
      preparedStatement.setString(3, bContent);

      int rn = preparedStatement.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (preparedStatement != null)
          preparedStatement.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public ArrayList<BDto> list() {
    ArrayList<BDto> dtos = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = dataSource.getConnection();
      String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent"
          + " from mvc_board order by bGroup desc, bStep asc";
      preparedStatement = connection.prepareStatement(query);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int bId = resultSet.getInt("bId");
        String bName = resultSet.getString("bName");
        String bTitle = resultSet.getString("bTitle");
        String bContent = resultSet.getString("bContent");
        Timestamp bDate = resultSet.getTimestamp("bDate");
        int bHit = resultSet.getInt("bHit");
        int bGroup = resultSet.getInt("bGroup");
        int bStep = resultSet.getInt("bStep");
        int bIndent = resultSet.getInt("bIndent");

        BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
        dtos.add(dto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if (preparedStatement != null)
          preparedStatement.close();
        if (connection != null)
          connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dtos;
  }
}

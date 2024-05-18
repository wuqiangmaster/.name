package com.wuqing.service;

import com.wuqing.model.Student;
import com.wuqing.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    public static Connection connection;
    public static PreparedStatement preparedStatement;
    public static ResultSet res;

    public static ArrayList<Student> selectAll() {
        ArrayList<Student> arrayList = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from " + "student_info";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                arrayList.add(new Student(res.getInt(1), res.getString(2), res.getString(3),
                                          res.getInt(4), res.getString(5), res.getString(6),
                                          res.getString(7), res.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static Student selectByField(String field, String value) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from student_info where " + field + " = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                return new Student(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),
                                   res.getString(5), res.getString(6), res.getString(7),
                                   res.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement, res);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static boolean deleteByNumber(String number) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from " + "student_info where number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean updateAll(String number, String name, String age, String sex, String tel,
                                    String email, String address) {
        try {
            connection = JDBCUtils.getConnection();
            String sql =
                    "update student_info set name = ? , age = ? , sex = ? , tel = ? , email = ? ," +
                            " address = ?  where number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, tel);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, number);
            int res=preparedStatement.executeUpdate();
            if ( res > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean updateByNumber(String number, String field, String value) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update student_info set "+ field+ " = ? where number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, number);
            int res=preparedStatement.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean insert(String number, String name, String age, String sex, String tel,
                                    String email, String address) {
        try {
            connection = JDBCUtils.getConnection();
            String sql =
                    "INSERT INTO student_info (number,name, age, sex, tel, email, address)" +
                            "VALUES (?, ?, ?, ?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5,tel);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, address);
            int res=preparedStatement.executeUpdate();
            if ( res > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package ru.artsok.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;


public class Test {


    public static void main(String[] args) throws IOException, SQLException {

        byte[] b =
                readBinaryFile(new File("P:\\java\\ArtsokShopV0.1\\src\\main\\webapp\\resources\\images\\production_menu\\aist.jpg"));

//        try {
//            new Test().insert(b);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        saveBinaryFile(new Test().selectById(8), new File("P:\\java\\ArtsokShopV0.1\\src\\main\\java\\ru\\artsok\\test\\1.jpg"));
    }


    public static byte[] readBinaryFile(File f)
            throws IOException {
        byte[] bytes = null;
        FileInputStream fin = new FileInputStream(f);
        try {
            long length = f.length();
            if (length > Integer.MAX_VALUE) {
                throw new IOException("File is too large: " +
                        f.getAbsolutePath());
            }

            bytes = new byte[(int) length];
            int numBytes = fin.read(bytes);
            if (numBytes != length) {
                throw new IOException("Could not completely read file: " +
                        f.getAbsolutePath());
            }
        } finally {
            fin.close();
        }

        return (bytes);
    }

    public static void saveBinaryFile(byte[] bytes, File f) throws IOException {
        FileOutputStream fout = new FileOutputStream(f);
        try {
            fout.write(bytes);
        } finally {
            fout.close();
        }
    }

    public void insert(byte[] b) throws SQLException {
//        jdbcTemplate.update("INSERT INTO productions(main_image) VALUE (?)", b, 1);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/artsok_sql", "postgres", "11")) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO productions (main_image) VALUES (?)")){
                statement.setBytes(1, b);
                statement.execute();
            }
        }
    }

    public byte[] selectById(int id) throws SQLException {
        byte[] b = null;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/artsok_sql", "postgres", "11")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT main_image FROM productions WHERE id=?")){
                statement.setInt(1, id);
                statement.execute();
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                b = resultSet.getBytes(1);
            }
        }

        return b;
    }

}

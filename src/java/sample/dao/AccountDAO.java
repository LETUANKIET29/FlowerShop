/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sample.dto.Account;
import sample.untils.DBUtils;

/**
 *
 * @author tuank
 */
public class AccountDAO {

    // lớp này để chứa các câu query lấy từ database trong bảng account database
    // hàm này để lấy tất cả các account và password
    public static Account getAccounts(String email, String password) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        try {
            cn = DBUtils.makeConnection();
            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql = "select [accID], [email], [password],"
                        + " [fullname], [phone], [status], "
                        + "[role] from [dbo].[Accounts]"
                        + "where status = 1 and email = ? and password = ? "
                        + "COLLATE Latin1_General_CS_AS ";

                // câu này để khởi chạy query phía trên trong DB
                PreparedStatement pst = cn.prepareStatement(sql);
                // gán giá trị email và pass nhận được vào dấu ?
                // 1 2 là vị trí ? trong chuỗi query
                pst.setString(1, email);
                pst.setString(2, password);

                // trả về kết quả từ DB
                ResultSet rs = pst.executeQuery();
                // bước 3: xử lý đáp án
                // nếu đáp án không bị rỗng
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    // gán giá trị nhận được từ BD vào biến acc
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // bước 4: đóng connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }

    // hàm này để lấy tất cả các account với roles bằng 0 hoặc 1
    public static ArrayList<Account> getAccountsWithRole(int role) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        ArrayList<Account> result = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "select [accID], [email], [password],"
                        + " [fullname], [phone], [status], "
                        + "[role] from [dbo].[Accounts] where role=?";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);
                pst.setInt(1, role);
                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {
                        int accid = table.getInt("accID");
                        String email = table.getString("email");
                        String password = table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        int status = table.getInt("status");
                        // role=table.getInt("role");
                        acc = new Account(accid, email, password, fullname, status, phone, role);
                        result.add(acc);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // in tất cả các account
    public static ArrayList<Account> printAllAccounts() throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;
        ArrayList<Account> list = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();
            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql = "select [accID], [email], [password],"
                        + " [fullname], [phone], [status], "
                        + "[role] from [dbo].[Accounts]";

                // câu này để khởi chạy query phía trên trong DB
                PreparedStatement pst = cn.prepareStatement(sql);
                // gán giá trị email và pass nhận được vào dấu ?
                // 1 2 là vị trí ? trong chuỗi query

                // trả về kết quả từ DB
                ResultSet rs = pst.executeQuery();
                // bước 3: xử lý đáp án
                // nếu đáp án không bị rỗng
                if (rs != null) {
                    while (rs.next()) {
                        int AccID = rs.getInt("accID");
                        String Email = rs.getString("email");
                        String Password = rs.getString("password");
                        String Fullname = rs.getString("fullname");
                        String Phone = rs.getString("phone");
                        int Status = rs.getInt("status");
                        int Role = rs.getInt("role");
                        // gán giá trị nhận được từ BD vào biến acc
                        acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                        list.add(acc);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // bước 4: đóng connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    // hàm này để lấy 1 account dựa vào email, password và status 
    // phải bằng 1 (1 là acctive)
    public static ArrayList<Account> getAccountsWithEmail(String email, String password) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        ArrayList<Account> result = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "select [accID], [email], [password],"
                        + " [fullname], [phone], [status], "
                        + "[role] from [dbo].[Accounts] "
                        + "where email like ? "
                        + "and password COLLATE SQL_Latin1_General_CP1_CS_AS like ? "
                        + "and status = 1";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setString(1, email);
                pst.setString(2, password);
                // pst.setInt(3, status);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {
                        int accid = table.getInt("accID");
                        // String email=table.getString("email");
                        // String password=table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        int status = table.getInt("status");
                        int role = table.getInt("role");
                        acc = new Account(accid, email, password, fullname, status, phone, role);
                        result.add(acc);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // hàm này để chèn 1 account vào bảng account
    public static ArrayList<Account> createAccounts(String email, String password,
            String fullname, String phone) throws Exception {

        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        ArrayList<Account> result = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "insert into Accounts ([email],[password],[fullname],[phone],[status],[role]) "
                        + " values (?, ?, ?, ?, ?, ?)";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, fullname);
                pst.setString(4, phone);
                pst.setInt(5, 1);
                pst.setInt(6, 0);
                ResultSet rs = pst.executeQuery();

                // bước 3: xử lý đáp án
                if (rs != null) {
                    while (rs.next()) {
                        int accid = 0;
                        acc = new Account(accid, email, password, fullname, 1, phone, 0);
                        result.add(acc);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {

        }
        return result;
    }

    // hàm này để sửa status của 1 account khi biết accid
    public static ArrayList<Account> UpdateRoleAccounts(int accid, int status) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        ArrayList<Account> result = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "UPDATE Accounts \n"
                        + "SET status = ?\n"
                        + "WHERE accID = ?;";

                String sql2 = "select * from [dbo].[Accounts] where accID=?";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setInt(1, status);
                pst.setInt(2, accid);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {

                        // int accid=table.getInt("accID");
                        String email = table.getString("email");
                        String password = table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        // status=table.getInt("status");
                        int role = table.getInt("role");

                        acc = new Account(accid, email, password, fullname, status, phone, role);
                        result.add(acc);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {

        }
        return result;
    }

    // hàm này để sửa profile ( sửa các cột ngoài tru accid )
    public static ArrayList<Account> UpdateProfile(String email, String password, String fullname,
            String phone, int status, int role, int accid) throws Exception {
        // String sql = "update Accounts set fullname =?, phone=?, status=?, where accid=?";

        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        ArrayList<Account> result = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "UPDATE Accounts \n"
                        + "SET [email] = ?, [password] = ?, "
                        + "[fullname] = ?, [phone]= ?, "
                        + "[status]= ?, [role]= ?\n"
                        + "WHERE accID = ?;";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, fullname);
                pst.setString(4, phone);
                pst.setInt(5, status);
                pst.setInt(6, role);
                pst.setInt(7, accid);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {
                        acc = new Account(accid, email, password, fullname, status, phone, role);
                        result.add(acc);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {

        }
        return result;
    }

    // register
    public static boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newSatus, int newRole) {
        Connection cn = null;
        Account acc = null;
        ArrayList<Account> list = new ArrayList<>();
        boolean check = true;
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "insert into Accounts ([email],[password],[fullname],[phone],[status],[role]) "
                        + " values (?, ?, ?, ?, ?, ?)";
                // and fullname like ?, thêm điều kiện, ? là con trỏ

                PreparedStatement pst = cn.prepareStatement(sql1);
                pst.setString(1, newEmail);
                pst.setString(2, newPassword);
                pst.setString(3, newFullname);
                pst.setString(4, newPhone);
                pst.setInt(5, newSatus);
                pst.setInt(6, newRole);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {
                        acc = new Account(0, newEmail, newPassword, newFullname, newSatus, newPhone, newRole);
                        list.add(acc);
                    }
                } else {
                    check = false;
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // lấy account với token
    public static Account getAccountswithToken(String Token) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        try {
            cn = DBUtils.makeConnection();
            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql = "select [accID], [email], [password],"
                        + " [fullname], [phone], [status], "
                        + "[role] from [dbo].[Accounts]"
                        + "where token = ? "
                        + "COLLATE Latin1_General_CS_AS ";

                // câu này để khởi chạy query phía trên trong DB 
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, Token);
                // trả về kết quả từ DB
                ResultSet rs = pst.executeQuery();
                // bước 3: xử lý đáp án
                // nếu đáp án không bị rỗng
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    // gán giá trị nhận được từ BD vào biến acc
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // bước 4: đóng connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }

    public static boolean updateToken(String token, String email) throws Exception {
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "update dbo.Accounts set email=?,token=? where email like ?";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, token);
            pst.setString(3, email);

            pst.executeUpdate();
            cn.close();
            return true;
        }
        return false;
    }

    public static boolean updateAccountStatus(String email, int status) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = -1;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Accounts\n"
                        + "SET status = ?\n"
                        + "WHERE email = ?;";
                pst = con.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, email);
                rs = pst.executeUpdate();

            }
        } catch (Exception e) {
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return !(rs == -1 || rs == 0);
    }

    public static ArrayList<Account> getAccountswithName(String email) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;
        ArrayList<Account> list = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();
            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql = "select * from Accounts \n"
                        + "where email like ?";

                // câu này để khởi chạy query phía trên trong DB
                PreparedStatement pst = cn.prepareStatement(sql);
                // gán giá trị email và pass nhận được vào dấu ?
                // 1 2 là vị trí ? trong chuỗi query
                pst.setString(1, "%" + email + "%");

                // trả về kết quả từ DB
                ResultSet rs = pst.executeQuery();
                // bước 3: xử lý đáp án
                // nếu đáp án không bị rỗng
                while (rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    // gán giá trị nhận được từ BD vào biến acc
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                    list.add(acc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // bước 4: đóng connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static Account checkNameSignUp(String email) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Account acc = null;

        try {
            cn = DBUtils.makeConnection();
            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql = "select * from Accounts \n"
                        + " where email = ?";

                // câu này để khởi chạy query phía trên trong DB
                PreparedStatement pst = cn.prepareStatement(sql);
                // gán giá trị email và pass nhận được vào dấu ?
                // 1 2 là vị trí ? trong chuỗi query
                pst.setString(1, email);

                // trả về kết quả từ DB
                ResultSet rs = pst.executeQuery();
                // bước 3: xử lý đáp án
                // nếu đáp án không bị rỗng
                while (rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    // gán giá trị nhận được từ BD vào biến acc
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // bước 4: đóng connection
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }

    public static Account updateProfileWithEmail(String email, String fullname, String phone) throws SQLException {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Accounts\n"
                        + "SET fullname = ? ,phone = ?\n"
                        + "WHERE email = ?;";

                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, fullname);
                pst.setString(2, phone);
                pst.setString(3, email);

                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    // gán giá trị nhận được từ BD vào biến acc
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return acc;
    }
}

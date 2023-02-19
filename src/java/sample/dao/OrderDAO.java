/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import sample.dto.Account;
import sample.dto.Categories;
import sample.dto.Order;
import sample.dto.OrderDetail;
import sample.untils.DBUtils;

/**
 *
 * @author tuank
 */
public class OrderDAO {

    public static ArrayList<Order> getOrders(String email) {
        Connection cn = null;
        Order order = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                String sql = "select o.OrderID,o.OrdDate,o.shipdate,o.status,o.AccID\n"
                        + "from dbo.Orders o\n"
                        + "join dbo.Accounts a on o.AccID=a.accID\n"
                        + "where a.email= ? COLLATE Latin1_general_CS_AS";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("accID");

                        order = new Order(orderID, status, accID, orderDate, shipDate);
                        list.add(order);
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

    public static ArrayList<Order> getAllOrders(String email) {
        Connection cn = null;
        Order order = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                String sql = "select o.OrderID,o.OrdDate,o.shipdate,o.status,o.AccID \n"
                        + "from dbo.Orders o join dbo.Accounts a on o.AccID=a.accID\n"
                        + "where a.email like ? COLLATE Latin1_general_CS_AS";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + email + "%");
                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("accID");

                        order = new Order(orderID, status, accID, orderDate, shipDate);
                        list.add(order);
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
    
    public static boolean updateShipDate(int id) {
        Connection cn=null;
        try {
            cn=DBUtils.makeConnection();
            if(cn!=null) {
                String sql="update Orders set ShipDate=? where OrderID=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                String date=null;
                Date d=new Date(System.currentTimeMillis());
                date=d.toString();
                pst.setString(1, date);
                pst.setInt(2, id);
                pst.executeUpdate();
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn!=null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    
    public static boolean updateShipDateNull(int id) {
        Connection cn=null;
        try {
            cn=DBUtils.makeConnection();
            if(cn!=null) {
                String sql="update Orders set ShipDate=? where OrderID=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                String date=null;   
                pst.setString(1, date);
                pst.setInt(2, id);
                pst.executeUpdate();
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn!=null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static ArrayList<Order> UpdateRoleOrder(int orderid, int status) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Order order = null;

        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "UPDATE Orders \n"
                        + "SET status = ?\n"
                        + "WHERE OrderID = ?;";

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setInt(1, status);
                pst.setInt(2, orderid);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {

                        //int accid=table.getInt("accID");
                        String OrderDate = table.getString("OrdDate");
                        String ShipDate = table.getString("shipdate");
                        status = table.getInt("status");
                        int accID = table.getInt("AccID");

                        order = new Order(orderid, status, accID, OrderDate, ShipDate);
                        list.add(order);
                    }
                }
                // bước 4: đóng connection
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {

        Connection cn = null;
        ArrayList<OrderDetail> list = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                String sql = "select[DetailId],[OrderID],[PID],[PName],[price],[imgPath],[quantity]\n"
                        + "from [dbo].[OrderDetails],[dbo].[Plants]\n"
                        + "where OrderID=? and OrderDetails.FID=Plants.PID";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int detailID = rs.getInt("DetailId");
                        int PlantID = rs.getInt("PID");
                        String PlantName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        int quantity = rs.getInt("quantity");
                        OrderDetail orderdetail = new OrderDetail(detailID, orderID, PlantID, price, quantity, PlantName, imgPath);
                        list.add(orderdetail);
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static ArrayList<Order> searchOrders(String orderID) {
        Connection cn = null;
        PreparedStatement pst;
        Order ord = null;
        String sql;

        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {

                sql = "select o.OrderID,o.OrdDate,o.shipdate,o.status,o.AccID\n"
                        + "from dbo.Orders o\n"
                        + "join dbo.Accounts a on o.AccID=a.accID\n"
                        + "where o.OrderID like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + orderID + "%");

                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int order_ID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("accID");
                        ord = new Order(order_ID, status, accID, orderDate, shipDate);
                        list.add(ord);
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

    public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        Connection cn = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                int accid = 0, orderid = 0;
                cn.setAutoCommit(false); // off auto commit
                //get account by id email
                String sql = "select accID from Accounts where Accounts.email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }

                //insert a new order
                System.out.println("accountID: " + accid);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("order date: " + d);
                sql = "insert Orders (OrdDate, status, AccID) values(?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, d);
                pst.setInt(2, 1);
                pst.setInt(3, accid);

                pst.executeUpdate();

                //get order id that is the lagest number
                sql = "select top 1 orderID from Orders order by orderID desc";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    orderid = rs.getInt("orderID");
                }
                //insert order details
                System.out.println("orderid " + orderid);
                Set<String> pids = cart.keySet();
                for (String pid : pids) {
                    sql = "insert OrderDetails values(?,?,?) ";
                    pst = cn.prepareStatement(sql);
                    pst.setInt(1, orderid);
                    pst.setInt(2, Integer.parseInt(pid.trim()));
                    pst.setInt(3, cart.get(pid));
                    pst.executeUpdate();
                    cn.commit();
                    cn.setAutoCommit(true);
                }
                return true;
            } else {
                System.out.println("k chen order dc");
            }
        } catch (Exception e) {

            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            result = false;
            System.out.println(e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean cancelOrder(int orderid) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = -1;
        boolean check = false;

        try {

            con = DBUtils.makeConnection();
            if (con != null) {
                String url = "UPDATE [dbo].[Orders]\n"
                        + "SET [status] = 3 \n"
                        + "WHERE [OrderID]= ?";
                pst = con.prepareStatement(url);
                pst.setInt(1, orderid);
                rs = pst.executeUpdate();
                if (rs != -1 && rs != 0) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public static boolean Orderagian(int orderid) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rs = -1;
        boolean check = false;

        try {

            con = DBUtils.makeConnection();
            if (con != null) {
                String url = "UPDATE [dbo].[Orders]\n"
                        + "SET [status] = 1 \n"
                        + "WHERE [OrderID]= ?";
                pst = con.prepareStatement(url);
                pst.setInt(1, orderid);
                rs = pst.executeUpdate();
                if (rs != -1 && rs != 0) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public static ArrayList<Order> searchOrdersWithDate(String orderDate, String shipDate, String email) {
        Connection cn = null;
        PreparedStatement pst;
        Order ord = null;
        String sql;

        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {

                sql = "select o.OrderID,o.OrdDate,o.shipdate,o.status,o.AccID, a.email\n"
                        + "from dbo.Orders o\n"
                        + "join dbo.Accounts a on o.AccID=a.accID\n"
                        + "where  OrdDate Between ? and ? and a.email = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, orderDate);
                pst.setString(2, shipDate);
                pst.setString(3, email);

                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int order_ID = rs.getInt("OrderID");
                        orderDate = rs.getString("OrdDate");
                        shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("accID");
                        ord = new Order(order_ID, status, accID, orderDate, shipDate);
                        list.add(ord);
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
}

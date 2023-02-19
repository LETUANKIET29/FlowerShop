/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sample.dto.Categories;
import sample.dto.Plant;
import sample.untils.DBUtils;

/**
 *
 * @author tuank
 */
public class PlantDAO {

    public static ArrayList<Plant> getPlants(String keyword, String searchby) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();

            if (cn != null && searchby != null) {
                String sql = "select PID, PName, price,imgPath, description, status, Plants.CateID as 'CateID', CateName \n"
                        + "from Plants join Categories on Plants.CateID=Categories.CateID ";

                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + " where Plants.PName like ?";
                } else if (searchby.equalsIgnoreCase("bycate")) {
                    sql = sql + " where CateID like ?";
                }

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");

                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Plant> printAllPlants() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();

            String sql = "select PID, PName, price,imgPath, description, status, Plants.CateID as 'CateID', CateName \n"
                    + "from Plants join Categories on Plants.CateID=Categories.CateID";

            if (cn != null) {
                PreparedStatement pst = cn.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Categories> printCategories() {

        Connection cn = null;
        Categories categories = null;
        ArrayList<Categories> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                String sql = "select * from Categories";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int CateID = rs.getInt("CateID");
                        String CateName = rs.getString("CateName");

                        categories = new Categories(CateID, CateName);
                        list.add(categories);
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

    public static ArrayList<Plant> UpdateRolePlant(int plantid, int status) throws Exception {
        // bước 1: make connection
        Connection cn = null;
        Plant plant = null;

        ArrayList<Plant> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();

            // bước 2: viết các câu query và execute nó
            if (cn != null) {
                String sql1 = "UPDATE Plants \n"
                        + "SET status = ?\n"
                        + "WHERE PID = ?;";

                PreparedStatement pst = cn.prepareStatement(sql1);

                pst.setInt(1, status);
                pst.setInt(2, plantid);

                ResultSet table = pst.executeQuery();
                // bước 3: xử lý đáp án
                if (table != null) {
                    while (table.next()) {
                        String PName = table.getString("PName");
                        String imgPath = table.getString("imgPath");
                        String description = table.getString("description");
                        status = table.getInt("status");
                        int price = table.getInt("price");
                        int CateID = table.getInt("CateID");

                        plant = new Plant(CateID, PName, price, imgPath, description, status, CateID, PName);
                        list.add(plant);
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

    public static Plant getPlant(int pid) {
        Plant p = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT PID, PName, price, imgPath, description, status, Plants.CateID as 'CateID', CateName "
                        + "FROM Plants, Categories "
                        + "WHERE Plants.CateID = Categories.CateID and PID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pid);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    pid = rs.getInt("PID");
                    String name = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("CateID");
                    String catename = rs.getString("CateName");
                    p = new Plant(pid, name, price, imgpath, description, status, cateid, catename);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    public static ArrayList<Plant> searchPlant(String pid) {
        Plant p = null;
        Connection cn = null;
        ArrayList<Plant> list = new ArrayList<>();

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {

                String sql = "select * from Plants where PName like ?";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + pid + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    int plantid = rs.getInt("PID");
                    String name = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    p = new Plant(plantid, name, price, imgpath, description, status, plantid, name);
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static Plant addPlant(String Pname, int price, String imgPath, String description, int status, int CateID) {
        Plant p = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Plants(PName, Price, imgPath, description, status, CateID)\n"
                        + "values (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1, Pname);
                pst.setInt(2, price);
                pst.setString(3, imgPath);
                pst.setString(4, description);
                pst.setInt(5, status);
                pst.setInt(6, CateID);

                ResultSet rs = pst.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    public static boolean updatePlant(String PName, int price, String img, String desc, int status, int cateId, int pid) {
        Connection cn=null;
        try {
            cn=DBUtils.makeConnection();
            if(cn!=null) {
                String sql="update [dbo].[Plants] set [PName]=?, [price]=?, [imgPath]=?, [description]=?, [status]=?, [CateID]=? where [PID]=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                
                pst.setString(1, PName);
                pst.setInt(2, price);
                pst.setString(3, img);
                pst.setString(4, desc);
                pst.setInt(5, status);
                pst.setInt(6, cateId);
                pst.setInt(7, pid);
                
                pst.executeUpdate();
                cn.close();
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
}

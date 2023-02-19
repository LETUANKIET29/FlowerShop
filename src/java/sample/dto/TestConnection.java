/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.util.ArrayList;
import java.util.Scanner;
import sample.dao.AccountDAO;
import sample.dao.OrderDAO;
import sample.dao.PlantDAO;

/**
 *
 * @author tuank
 */
public class TestConnection {

    public static void main(String[] args) throws Exception {

        System.out.println("input your choice");
        System.out.println("1. test account");
        System.out.println("2. get account with role 1");
        System.out.println("3. print all account");
        System.out.println("4. get account with email and pass");
        System.out.println("5. create new account");
        System.out.println("6. edit role account");
        System.out.println("7. update profile");
        System.out.println("8. print all product");
        System.out.println("9. search product");
        System.out.println("10.show orderlist with email");
        System.out.println("11.get product with orderID");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        choice = sc.nextInt();
        switch (choice) {
            // test account
            case 1:
                Account acc = AccountDAO.getAccounts("test@gmail.com", "test");
                if (acc != null) {
                    if (acc.getRole() == 1) {
                        System.out.println("i am an admin");
                    } else {
                        System.out.println("i am a user");
                    }
                } else {
                    System.out.println("login fail");
                }
                break;
            // lấy account bằng role
            case 2:
                ArrayList<Account> rolelist1 = AccountDAO.getAccountsWithRole(1);
                ArrayList<Account> rolelist0 = AccountDAO.getAccountsWithRole(0);
                try {
                    System.out.println("chon role ban muon nhap 0 or 1");
                    System.out.println("role 0");
                    System.out.println("role 1");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        for (Account account : rolelist1) {
                            System.out.println(account);
                        }
                    } else if (choice == 0) {
                        for (Account account : rolelist0) {
                            System.out.println(account);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // lấy tất cả account
            case 3:
                ArrayList<Account> alllist = AccountDAO.printAllAccounts();
                try {
                    for (Account account : alllist) {
                        System.out.println(account);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("Nhập account cua ban");
                sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                ArrayList<Account> list4 = AccountDAO.getAccountsWithEmail(email, password);
                try {
                    if (email == null && password == null) {
                        System.out.println("xin hay nhap lai tai khoan");
                    }
                    for (Account account : list4) {
                        if (account.getRole() == 0) {
                            System.out.println("account cua ban co role la 0");
                        } else {
                            System.out.println("Dang nhap thanh cong !");
                            System.out.println("Thong tin tai khoan");
                            System.out.println(account);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // tạo account mới
            case 5:
                System.out.println("Tao tai khoan moi");
                sc.nextLine();
                System.out.print("Email: ");
                email = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();
                System.out.print("Fullname: ");
                String fullname = sc.nextLine();
                System.out.print("Phone: ");
                String phone = sc.nextLine();

                ArrayList<Account> list5 = AccountDAO.createAccounts(email, password, fullname, phone);
                try {
                    if (email == null && password == null) {
                        System.out.println("xin hay nhap lai tai khoan");
                    } else {
                        System.out.println("Tai khoan duoc them thanh cong");
                        System.out.println("ban co muon xem danh sach tai khoan khong");
                        System.out.println("1. co      2. khong");
                        choice = sc.nextInt();
                        
                        if (choice == 1) {
                            alllist = AccountDAO.printAllAccounts();
                            for (Account account : alllist) {
                                System.out.println(account);
                            }
                        } else {

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            // sửa status tài khoản
            case 6:
                System.out.println("Nhap ID tai khoan ban can tim");
                sc.nextLine();
                System.out.println("ID Account: ");
                int accID = sc.nextInt();
                System.out.println("Status: ");
                int status = sc.nextInt();
                
                ArrayList<Account> list6 = AccountDAO.UpdateRoleAccounts(accID, status);
                try {
                    if (accID == 0) {
                        System.out.println("xin hay nhap lai tai khoan");
                    } else {
                        System.out.println("Da cap nhat tai khoan");
                        System.out.println("ban co muon xem danh sach tai khoan khong");
                        System.out.println("1. co      2. khong");
                        choice = sc.nextInt();
                        
                        if (choice == 1) {
                            alllist = AccountDAO.printAllAccounts();
                            for (Account account : alllist) {
                                System.out.println(account);
                            }
                        } else {

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
            // sửa profile
            case 7:
                
                System.out.println("Nhap ID tai khoan ban can tim");
                sc.nextLine();
                System.out.println("ID Account: ");
                accID = sc.nextInt();
                
                sc.nextLine();
                System.out.println("Email: ");
                email = sc.nextLine();  
                System.out.println("Password: ");
                password = sc.nextLine();           
                System.out.println("Fullname: ");
                fullname = sc.nextLine();
                System.out.println("Phone: ");
                phone = sc.nextLine();
                System.out.println("Status: ");
                status = sc.nextInt();
                System.out.println("Role: ");
                int role = sc.nextInt();
                
                ArrayList<Account> list7 = AccountDAO.UpdateProfile(email, password, fullname, phone, status, role, accID);
                try {
                    if (accID == 0) {
                        System.out.println("xin hay nhap lai tai khoan");
                    } else {
                        System.out.println("Da cap nhat tai khoan");
                        System.out.println("ban co muon xem danh sach tai khoan khong");
                        System.out.println("1. co      2. khong");
                        choice = sc.nextInt();
                        
                        if (choice == 1) {
                            alllist = AccountDAO.printAllAccounts();
                            for (Account account : alllist) {
                                System.out.println(account);
                            }
                        } else {

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 8:
                ArrayList<Plant> prolist = PlantDAO.printAllPlants();
                try {
                    for (Plant plant : prolist) {
                        System.out.println(plant);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
            case 9:
                System.out.println("Nhap ten san pham ban muon tim kiem: ");
                sc.nextLine();
                String keyword = sc.nextLine();
                String searchby = "byname";
                
                ArrayList<Plant> searchlist = PlantDAO.getPlants(keyword, searchby);
                try {
                    for (Plant plant : searchlist) {
                        System.out.println(plant);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;    
            
            case 10:
                System.out.println("Nhap email ban muon tim kiem: ");
                sc.nextLine();
                email = sc.nextLine();
                ArrayList<Order> list = OrderDAO.getOrders(email);
                try {
                    for (Order order : list) {
                        System.out.println(order);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
            case 11:
                System.out.println("Nhap order ban muon tim kiem");
                sc.nextLine();
                int orderID = sc.nextInt();
                ArrayList<OrderDetail> list1 = OrderDAO.getOrderDetail(orderID);
                
                try {
                    for (OrderDetail order : list1) {
                        System.out.println(order);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
            case 12:
                System.out.println("Nhap acccount ban muon dang nhap");
        }
    }
}

//package socialmedia;

import java.sql.*;
import java.io.*;
import java.util.regex.Pattern;

public class Sociamedia {

    static final String JDBC_driver = "com.mysql.cj.jbdc.Driver";
    // Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
    static final String db_url = "jdbc:mysql://localhost:1527/social_media";

    static final String user = "social";
    static final String pass = "media";

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        System.out.println("1. Register\n2. Login\n3. Exit");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean u = true;
        while (u) {
            System.out.print("Enter Choice: ");
            String ch1 = br.readLine();
            if (ch1.equals("1")) {
                u = false;
                System.out.println();
                register();
            } else if (ch1.equals("2")) {
                u = false;
                System.out.println();
                login();
            } else if (ch1.equals("3")) {
                u = false;
                System.out.println();
                exit();
            } else {
                System.out.println("Kindly enter a valid choice: ");
                u = true;
            }
        }
    }

    public static void register() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement newacc = null;
        Connection conn = null;
        String reg = null;
        System.out.println("-----REGISTER-----\n");
        System.out.print("Email: ");
        String email = br.readLine();
        System.out.print("Username: ");
        String un = br.readLine();
        boolean vp = true;
        while (vp) {
            System.out.print("Password(must include lahat type): ");
            String pw = br.readLine();

            // password validation
            boolean a = Pattern.matches((".*[A-Z].*"), pw);
            boolean b = Pattern.matches(".*[a-z].*", pw);
            boolean c = Pattern.matches(".*\\d.*", pw);
            boolean d = Pattern.matches(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*", pw);

            if ((a == true) && (b == true) && (c == true) && (d == true)) {
                try {
                    Class.forName(JDBC_driver);
                    conn = DriverManager.getConnection(db_url, user, pass);
                    newacc = conn.createStatement();
                    reg = "Insert into Account values('" + un + "','" + pw + "','" + email + "',10)";

                    System.out.print("Confirm Password: ");
                    String cpw = br.readLine();

                    if (pw.equals(cpw)) {
                        newacc.executeUpdate(reg);
                        System.out.println("\nRegistered Successfully!");
                    } else if (!pw.equals(cpw)) {
                        do {
                            System.out.print("(Password do not match)\nConfirm Password: ");
                            cpw = br.readLine();
                            if (!pw.equals(cpw)) {
                            } else {
                                System.out.println("\nRegistered Successfully!");
                                newacc.executeUpdate(reg);
                                break;
                            }
                        } while (true);
                    }
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vp = false;
            } else {
                System.out.println("Invalid password");
                vp = true;
            }
        }
    }

    public static void login1() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt = null;
        Statement forupdate = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_driver);
            conn = DriverManager.getConnection(db_url, user, pass);
            stmt = conn.createStatement();
            forupdate = conn.createStatement();
            String sql1 = "Select * from Account";
            // String up ="Select password from account where username ='"accnum"'";
            ResultSet rs1 = stmt.executeQuery(sql1);
            boolean u = true;
            int h = 1;
            System.out.print("Enter username:");
            String accnum = br.readLine();

            while (rs1.next()) {
                if (accnum.equals(rs1.getString("username"))) {
                    if (rs1.getInt("attempt") <= 0) {
                        System.out.println("No attempts left! Kindly contact the administrator.");
                        break;
                    }
                    while (u) {
                        System.out.print("Enter password:");
                        String pw = br.readLine();
                        if (pw.equals(rs1.getString("password"))) {
                            System.out.println("hello world");
                            u = false;
                            break;
                        } else {
                            int p = rs1.getInt("attempt");
                            int pn = p - h;
                            String csql = "Update Account " + "Set attempt = " + pn + "where username ='" + accnum
                                    + "'";
                            stmt.executeUpdate(csql);
                            System.out.println(pn);
                            h++;
                            u = true;
                            if (pn <= 0) {
                                System.out.println("No more attempt left! Kindly contact the administrator.");
                                break;
                            }
                        }
                    }
                }
                /*
                 * else if(!accnum.contentEquals(rs1.getString("username"))){
                 * System.out.print("Username doesn't exist\nKindly register...\n"); menu(); }
                 */
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void login() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_driver);
            conn = DriverManager.getConnection(db_url, user, pass);
            stmt = conn.createStatement();
            String sql1 = "Select * from Account";
            ResultSet rs1 = stmt.executeQuery(sql1);

            boolean u = true;
            System.out.print("Enter username:");
            String un = br.readLine();
            // what if wrong username??
            while (rs1.next()) {
                if (un.equals(rs1.getString("username"))) {
                    while (u) {
                        System.out.print("Enter password:");
                        String pw = br.readLine();
                        if (pw.equals(rs1.getString("password"))) {
                            System.out.println("\nhello world\n");
                            display(un);
                            u = false;
                            break;
                        } else {
                            System.out.println("wrong password");
                            u = true;
                        }
                    }
                }
            }
            /*
             * else{ System.out.println("-- account doesnt exist --"); }
             */
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        // exit lng
    }

    public static void display(String un) throws Exception {
        // may createpost, newsfeed, my posts
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t1) Newsfeed\n\t2) My posts\n\t3) Create Post\n\t4) Account Settings\n\t5) Log-out");
        boolean u = true;
        while (u) {
            System.out.print("\tEnter Choice: ");
            String ch1 = br.readLine();
            if (ch1.equals("1")) {
                u = false;
                System.out.println();
                newsfeed(un);
            } else if (ch1.equals("2")) {
                u = false;
                System.out.println();
                myposts(un);
            } else if (ch1.equals("4")) {
                u = false;
                System.out.println();
                accset();
            } else if (ch1.equals("5")) {
                u = false;
                System.out.println();
                menu();
            } else if (ch1.equals("3")) {
                u = false;
                System.out.println();
                createpost(un);
            } else {
                System.out.println("Kindly enter a valid choice: ");
                u = true;
            }
        }
    }

    public static void myposts(String un) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt = null;
        Connection conn = null;
        boolean u = true;
        try {
            Class.forName(JDBC_driver);
            conn = DriverManager.getConnection(db_url, user, pass);
            stmt = conn.createStatement();
            String sql1 = "Select * from posts where username_of_poster='" + un + "'";
            ResultSet rs1 = stmt.executeQuery(sql1);

            // String title = ;
            // String post = ;
            while (rs1.next()) {
                System.out.println("~" + rs1.getString("title_of_post") + "~");
                System.out.println(rs1.getString("post") + "\n");
                System.out.println("LIKES  : " + rs1.getString("likes"));

                System.out.println("1) Next\n2) View Comments");

                System.out.print("pick>>");
                String chs = br.readLine();
                if (chs.equals(1)) {

                } else if (chs.equals(2)) {
                    viewcomments();
                }

            }
            System.out.println("No more posts");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createpost(String un) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_driver);
            conn = DriverManager.getConnection(db_url, user, pass);
            stmt = conn.createStatement();

            System.out.print(" Create title : ");
            String title = br.readLine();

            System.out.print(" Lagay mo laman ng post : ");
            String laman = br.readLine();

            String uplod = "Insert into posts values('" + un + "','" + title + "','" + laman + "'," + null + ")";
            stmt.executeUpdate(uplod);

            System.out.println("~~ UPLOADED KA BOI ~~\n(press enter to go back)");
            String enter = br.readLine();
            display(un);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newsfeed(String un) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_driver);
            conn = DriverManager.getConnection(db_url, user, pass);
            stmt = conn.createStatement();
            String sql1 = "Select * from posts";
            ResultSet rs1 = stmt.executeQuery(sql1);

            while (rs1.next()) {
                System.out.println("~" + rs1.getString("title_of_post") + "~");
                System.out.println(rs1.getString("post") + "\n");
                System.out.println("LIKES  : " + rs1.getString("likes"));

                System.out.println("1) Next\n2) View Comments\n3)Like post");

                System.out.print("pick>>");
                int chs = Integer.parseInt(br.readLine());
                switch (chs) {
                    case 1:
                    case 2:
                        viewcomments();
                    case 3:
                        likepost();
                }
                /*
                 * if(chs.equals(1)){
                 * 
                 * } else if(chs.equals(2)){ viewcomments(); } else if(chs.equals(3)){ }
                 */

            }
            System.out.println("No more posts");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewcomments() {
        System.out.println("COMMENTS:");

    }

    public static void accset() {

    }

    public static void likepost() {

    }
}

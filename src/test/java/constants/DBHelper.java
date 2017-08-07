package constants;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Poppy_Zhang on 2017/7/20.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://hkld-qa.princeton.epam.com:3306/hkld_cms";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "cms";
    public static final String password = "hkldcms";
    public Connection conn = null;
    public PreparedStatement pst = null;
    static String sql = null;
    static DBHelper dbHelper = null;

    public DBHelper(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearDataFromDB(String tableName)throws Exception{
        //SQL语句
        sql = "Delete from " +tableName+ " where 1=1";
        //创建DBHelper对象
        dbHelper = new DBHelper(sql);
        try {
            //执行语句，得到结果集
            int result= dbHelper.pst.executeUpdate();
            if(result==1||result==0) {
                System.out.println("Clear data in " + tableName + " table from database succeed, test pass!");
            }
            else
                System.out.println("Clear data in " + tableName + " table from database get error, test fail!");
            //关闭连接
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearRolesTableFromDB() throws Exception{
        String sqlCommand = "DELETE FROM `roles` WHERE `id`!= '5976ee2f2c71f53d43471940'";
        DBHelper db = new DBHelper(sqlCommand);
        try{
            int result = db.pst.executeUpdate();
            if(result==1||result==0) {
                System.out.println("Clear data in roles table from database succeed, test pass!");
            }
            else
                System.out.println("Clear data in roles table from database get error, test fail!");
            db.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void changeClosingDate(String currentDateBefore,String prNo)throws Exception{
        String sqlCommand = "UPDATE tenders SET closingDate = '"+currentDateBefore+"' WHERE prNo = '"+prNo+"'";
        //创建DBHelper对象
        dbHelper = new DBHelper(sqlCommand);
        try {
            //执行语句，得到结果集
            int result= dbHelper.pst.executeUpdate();
            if(result==1||result==0) {
                System.out.println("Update closing date in tenders table succeed, test pass!");
            }
            else
                System.out.println("Update closing date in tenders table get error, test fail!");
            //关闭连接
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void changePersonInCharge()throws Exception{
        String sqlCommand = "UPDATE tenders SET personInCharge='poppy_zhang@epam.com' where prNo='59000'";
        //创建DBHelper对象
        dbHelper = new DBHelper(sqlCommand);
        try {
            //执行语句，得到结果集
            int result= dbHelper.pst.executeUpdate();
            if(result==1||result==0) {
                System.out.println("Update personInCharge in tenders table succeed, test pass!");
            }
            else
                System.out.println("Update personInCharge in tenders table get error, test fail!");
            //关闭连接
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

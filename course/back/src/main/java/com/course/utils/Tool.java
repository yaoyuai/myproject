package com.course.utils;

import com.course.pojo.ExerInfo;
import com.course.qo.ExerInfoQo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Tool {

    private static  String []imgArr=new String[]{"jpg","png","jpeg","gif","bmp"};
    public static long imgLen=1048576;
    public static final String[] CODES ={"1","2","3","4","5","6",
            "7","8","9","a","A","b","B","c","C",
            "d","D","e","E","f","F","g","G","h","H","j","J",
            "k","K","m","M","n","N","p","P","q","Q","r","R",
            "s","S","t","T","u","U","v","V","w","W","x","X",
            "y","Y","z","Z"};
    //    public static final String[] CODES={"0"};
    public static  Color[] COLORS = {Color.RED, Color.BLACK, Color.CYAN, Color.GRAY, Color.BLUE,Color.PINK, Color.ORANGE, Color.GREEN};
    public static  int OUT_CODE_LENGTH =0;
    public static  int OUT_CODE_WIDTH =  0;
    public static  int OUT_CODE_HEIGHT = 0;
    public static  int OUT_CODE_WIDTH_RANDOM = 0;
    public static  int OUT_CODE_HEIGHT_RANDOM = 0;
    public static  int OUT_CODE_FONT_SIZE = 0;
    public static  int OUT_CODE_SIZE_RANDOM = 0;
    public static  int OUT_CODE_LINE_SIZE = 0;



    static {
        initCodeData();
    }


    /**
     * 作者: 姚宇
     * 方法名：initCodeData
     * 作用：初始化验证码
     */
    public static  void initCodeData(){
        Properties properties=new Properties();
        try {
            properties.load(Tool.class.getClassLoader().getResourceAsStream("static/param.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        OUT_CODE_LENGTH = Integer.parseInt(properties.getProperty("OUT_CODE_LENGTH"));
        OUT_CODE_WIDTH =  Integer.parseInt(properties.getProperty("OUT_CODE_WIDTH"));
        OUT_CODE_HEIGHT = Integer.parseInt(properties.getProperty("OUT_CODE_HEIGHT"));
        OUT_CODE_WIDTH_RANDOM = Integer.parseInt(properties.getProperty("OUT_CODE_WIDTH_RANDOM"));
        OUT_CODE_HEIGHT_RANDOM = Integer.parseInt(properties.getProperty("OUT_CODE_HEIGHT_RANDOM"));
        OUT_CODE_FONT_SIZE = Integer.parseInt(properties.getProperty("OUT_CODE_FONT_SIZE"));
        OUT_CODE_SIZE_RANDOM = Integer.parseInt(properties.getProperty("OUT_CODE_SIZE_RANDOM"));
        OUT_CODE_LINE_SIZE = Integer.parseInt(properties.getProperty("OUT_CODE_LINE_SIZE"));
    }

    public static void expandAll(JTree tree, TreePath parent, boolean expand) {
        // Traverse children
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }

        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }



    public static String getDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        return "/"+year+"/"+(month<10?"0"+month:month)+"/"+(day<10?"0"+day:day)+"/";

    }




    public static boolean judgeHasImg(String type){
        boolean flag=false;
        for (String s : imgArr) {
            System.out.println("执行到了");
            if(s.equalsIgnoreCase(type)){
                flag=true;
                break;
            }
        }
        return flag;
    }



    //根据文件路径返回 集合对象
    public static Object receiveFile(String fileName){
        try {
            POIFSFileSystem fspoi=new POIFSFileSystem(new FileInputStream(fileName));
            HSSFWorkbook workbook=new HSSFWorkbook(fspoi);
            HSSFSheet sheet=workbook.getSheet("sheet1");
            List<ExerInfo> exerInfoList= new ArrayList<ExerInfo>();
//            for(int i=1;i<sheet.getLastRowNum()+1;i++){
//                HSSFRow row=sheet.getRow(i);
//
//            }

//            for(int i=1;i<sheet.getLastRowNum()+1;i++){
//                HSSFRow row = sheet.getRow(i);
//                TicketInfoQo ticketInfoQo=new TicketInfoQo();
//                ticketInfoQo.setCarTimes(row.getCell(0).toString());
//                ticketInfoQo.setBeginStation(row.getCell(1).toString());
//                ticketInfoQo.setEndStation(row.getCell(2).toString());
//                ticketInfoQo.setBeginDateTime(row.getCell(3).toString());
//                ticketInfoQo.setEndDateTime(row.getCell(4).toString());
//                ticketInfoQo.setTicketNum(row.getCell(5).toString());
//                ticketInfoQo.setTicketMoney(row.getCell(5).toString());
//                ticketInfoQoList.add(ticketInfoQo);
//            }
//            return ticketInfoQoList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }








//    public static void judge(){
//        List<String> list=new ArrayList<String>();
//        boolean flag = list.contains(".doc");
//        if(flag){
//            System.out.println("存在");
//        }else{
//            System.out.println("不存在");
//        }
//
//    }
}

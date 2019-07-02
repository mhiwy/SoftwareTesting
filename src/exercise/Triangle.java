package exercise;

import java.io.*;

import static java.lang.Integer.parseInt;

public class Triangle {
    public static void exec(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/7.csv")), "GBK"));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/7_res.csv")),
                    "GBK"));
            String lineTxt = null;
            output.write("a,b,c,预期输出，实际输出");
            output.newLine();
            int a, b, c;
            while ((lineTxt = input.readLine()) != null) {
                String[] names = lineTxt.split(",");
                a = parseInt(names[0]);
                b = parseInt(names[1]);
                c = parseInt(names[3]);
                if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
                    output.write(lineTxt + "," + "非三角形");
                } else if (a == b && b == c) {
                    output.write(lineTxt + "," + "等边三角形");
                } else if (a == b || b == c || a == c) {
                    output.write(lineTxt + "," + "等腰三角形");
                } else {
                    output.write(lineTxt + "," + "普通三角形");
                }
                output.newLine();
                output.flush();
                input.close();
                output.close();
            }
        }
        catch (Exception e) {
            System.out.println("测试失败");
        }
    }
}
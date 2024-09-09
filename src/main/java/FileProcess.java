import java.io.*;
/**
 * 文件处理相关接口
 * @author 刘宇婷.CN
 */
public class FileProcess {
    /**
     * 根据命令行参数读取文件
     */
    public static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
    /**
     * 根据命令行参数路径写文件
     */
    public static void writeResult(String filePath, double similarity) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.printf("%.2f%n", similarity);
        }
    }
}

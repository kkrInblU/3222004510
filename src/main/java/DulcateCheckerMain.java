import java.io.IOException;
import java.util.Set;

/**
 * @author 刘宇婷.CN
 */
public class DulcateCheckerMain {
    public static void main(String[] args) {
        final int fileNum = 3 ;
        if (args.length != fileNum) {
            System.out.println("Usage: java PersonalProject <original_file_path> <plagiarized_file_path> <output_file_path>");
            return;
        }
        String originalFilePath = args[0];
        String plagiarizedFilePath = args[1];
        String outputFilePath = args[2];
        try {
            // 读取文件内容
            String originalText = FileProcess.readFile(originalFilePath);
            String plagiarizedText = FileProcess.readFile(plagiarizedFilePath);
            // 分词
            Set<String> originalTokens = TextProcess.tokenize(originalText);
            Set<String> plagiarizedTokens = TextProcess.tokenize(plagiarizedText);
            // 计算 Jaccard 相似度
            double similarity = TextProcess.calculateJaccardSimilarity(originalTokens, plagiarizedTokens);
            // 写入结果到文件
            FileProcess.writeResult(outputFilePath, similarity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

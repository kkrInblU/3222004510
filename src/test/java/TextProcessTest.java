import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 刘宇婷.CN
 */
public class TextProcessTest {

    @Test
    public void testTokenize() {
        String text = "你好，我是哈哈。";
        Set<String> tokens = TextProcess.tokenize(text);

        assertTrue(tokens.contains("你好"));
        assertTrue(tokens.contains("，"));
        assertTrue(tokens.contains("我"));
        assertTrue(tokens.contains("是"));
        assertTrue(tokens.contains("哈哈"));
        assertTrue(tokens.contains("。"));
    }

    @Test
    public void testCalculateJaccardSimilarity() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        Set<String> set2 = new HashSet<>();
        set2.add("b");
        set2.add("c");
        set2.add("d");

        double similarity = TextProcess.calculateJaccardSimilarity(set1, set2);
        assertEquals(0.5, similarity, 0.01);
    }
}

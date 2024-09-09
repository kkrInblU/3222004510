import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 文本处理相关接口
 * @author 刘宇婷.CN
 */
public class TextProcess {
    /**
     * 分词工具
     */
    public static Set<String> tokenize(String text) {
        List<Term> terms = ToAnalysis.parse(text).getTerms();
        Set<String> set = new HashSet<>();
        for (Term term : terms) {
            String name = term.getName();
            set.add(name);
        }
        return set;
    }
    /**
     * Jaccard相似度计算
     */
    public static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        return (double) intersection.size() / union.size();
    }
}

import java.io.Serializable;

public class XmasPresent implements Serializable {
    private String message;
    private String content;
    private String recommendedSpot;
    private String recommendedPresent;
    private String luckyItem;  // 新しいプロパティを追加

    public XmasPresent() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecommendedSpot() {
        return recommendedSpot;
    }

    public void setRecommendedSpot(String recommendedSpot) {
        this.recommendedSpot = recommendedSpot;
    }

    public String getRecommendedPresent() {
        return recommendedPresent;
    }

    public void setRecommendedPresent(String recommendedPresent) {
        this.recommendedPresent = recommendedPresent;
    }

    public String getLuckyItem() {  // 新しいgetterメソッドを追加
        return luckyItem;
    }

    public void setLuckyItem(String luckyItem) {  // 新しいsetterメソッドを追加
        this.luckyItem = luckyItem;
    }
}

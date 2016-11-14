package win.ccav1.mod.response;

/**
 * Created by Administrator on 2016/11/12.
 */




/**
 * 文本消息
 *
 * @author liufeng
 * @date 2013-05-19
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
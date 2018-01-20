package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 文本消息。
 *
 */
public class TxtMessage extends BaseMessage {
	private String content = "";
	private String extra = "";
	private transient static final String TYPE = "RC:TxtMsg";
	
	public TxtMessage(String content, String extra) {
		this.content = content;
		this.extra = extra;
	}
	
	public String getType() {
		return TYPE;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, TxtMessage.class);
	}
}
package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 提示条（小灰条）通知消息。此类型消息没有 Push 通知。
 *
 */
public class InfoNtfMessage extends BaseMessage {
	private String message = "";
	private String extra = "";
	private transient static final String TYPE = "RC:InfoNtf";
	
	public InfoNtfMessage(String message, String extra) {
		this.message = message;
		this.extra = extra;
	}
	
	public String getType() {
		return TYPE;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, InfoNtfMessage.class);
	}
}
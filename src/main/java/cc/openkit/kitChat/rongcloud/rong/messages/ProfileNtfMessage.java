package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 资料通知消息。此类型消息没有 Push 通知。
 *
 */
public class ProfileNtfMessage extends BaseMessage {
	private String operation = "";
	private String data = "";
	private String extra = "";
	private transient static final String TYPE = "RC:ProfileNtf";
	
	public ProfileNtfMessage(String operation, String data, String extra) {
		this.operation = operation;
		this.data = data;
		this.extra = extra;
	}
	
	public String getType() {
		return TYPE;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, ProfileNtfMessage.class);
	}
}
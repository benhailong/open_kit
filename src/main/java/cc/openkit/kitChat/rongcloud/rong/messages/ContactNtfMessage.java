package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 * 添加联系人消息。
 */
public class ContactNtfMessage extends BaseMessage {
	private String operation = "";
	private String extra = "";
	private String sourceUserId = "";
	private String targetUserId = "";
	private String message = "";
	private transient static final String TYPE = "RC:ContactNtf";
	
	public ContactNtfMessage(String operation, String extra, String sourceUserId, String targetUserId, String message) {
		this.operation = operation;
		this.extra = extra;
		this.sourceUserId = sourceUserId;
		this.targetUserId = targetUserId;
		this.message = message;
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
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public String getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, ContactNtfMessage.class);
	}
}
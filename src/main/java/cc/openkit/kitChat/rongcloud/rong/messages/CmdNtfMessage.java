package cc.openkit.kitChat.rongcloud.rong.messages;


import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 通用命令通知消息。此类型消息没有 Push 通知。
 *
 */
public class CmdNtfMessage extends BaseMessage {
	private String name = "";
	private String data = "";
	private transient static final String TYPE = "RC:CmdNtf";
	
	public CmdNtfMessage(String name, String data) {
		this.name = name;
		this.data = data;
	}
	
	public String getType() {
		return TYPE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, CmdNtfMessage.class);
	}
}
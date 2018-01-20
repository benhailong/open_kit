package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 语音消息。
 *
 */
public class VoiceMessage extends BaseMessage {
	private String content = "";
	private String extra = "";
	private Long duration = 0L;
	private transient static final String TYPE = "RC:VcMsg";
	
	public VoiceMessage(String content, String extra, Long duration) {
		this.content = content;
		this.extra = extra;
		this.duration = duration;
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
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, VoiceMessage.class);
	}
}
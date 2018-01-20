package cc.openkit.kitChat.rongcloud.rong.messages;


import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 图片消息。
 *
 */
public class ImgMessage extends BaseMessage {
	private String content = "";
	private String extra = "";
	private String imageUri = "";
	private transient static final String TYPE = "RC:ImgMsg";
	
	public ImgMessage(String content, String extra, String imageUri) {
		this.content = content;
		this.extra = extra;
		this.imageUri = imageUri;
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
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, ImgMessage.class);
	}
}
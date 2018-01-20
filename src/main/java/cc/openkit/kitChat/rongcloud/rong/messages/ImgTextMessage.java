package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 图文消息。
 *
 */
public class ImgTextMessage extends BaseMessage {
	private String content = "";
	private String extra = "";
	private String title = "";
	private String imageUri = "";
	private String url = "";
	private transient static final String TYPE = "RC:ImgTextMsg";
	
	public ImgTextMessage(String content, String extra, String title, String imageUri, String url) {
		this.content = content;
		this.extra = extra;
		this.title = title;
		this.imageUri = imageUri;
		this.url = url;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, ImgTextMessage.class);
	}
}
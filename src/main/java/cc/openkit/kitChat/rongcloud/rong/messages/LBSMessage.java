package cc.openkit.kitChat.rongcloud.rong.messages;

import cc.openkit.kitChat.rongcloud.rong.util.GsonUtil;

/**
 *
 * 位置消息。
 *
 */
public class LBSMessage extends BaseMessage {
	private String content = "";
	private String extra = "";
	private double latitude = 0;
	private double longitude = 0;
	private String poi = "";
	private transient static final String TYPE = "RC:LBSMsg";
	
	public LBSMessage(String content, String extra, double latitude, double longitude, String poi) {
		this.content = content;
		this.extra = extra;
		this.latitude = latitude;
		this.longitude = longitude;
		this.poi = poi;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getPoi() {
		return poi;
	}
	public void setPoi(String poi) {
		this.poi = poi;
	}  
	
	@Override
	public String toString() {
		return GsonUtil.toJson(this, LBSMessage.class);
	}
}
package util;

public class myimage_info {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public myimage_info() {
	}
	//UserInfo [id=" + id + ", url=" + name + ", image=" + phone + "]"
	@Override
	public String toString() {
		return "myimage_info [id=" + id + ", name=" + name + ", like=" + like + ", url=" + url + ", type=" + type + "]";
	}
	
	public myimage_info(String id, String name, String like,String url,String type) {
		this.id = id;
		this.name = name;
		this.like  = like;
		this.url = url;
		this.type = type;
	}
	
	
	private String id;
	private String name;
	private String like;
	private String url;
	private String type;

}

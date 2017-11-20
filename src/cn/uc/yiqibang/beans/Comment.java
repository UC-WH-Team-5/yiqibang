package cn.uc.yiqibang.beans;

import java.util.Date;

public class Comment {
	
	private int id;
	private int t_u_id;
	private int t_n_id;
	private String c_content;
	private Date c_createtime;
	private int c_thumbscount;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", t_u_id=" + t_u_id + ", t_n_id=" + t_n_id + ", c_content=" + c_content
				+ ", c_createtime=" + c_createtime + ", c_thumbscount=" + c_thumbscount + "]";
	}
	public Comment(int id, int t_u_id, int t_n_id, String c_content, Date c_createtime, int c_thumbscount) {
//		super();
		this.id = id;
		this.t_u_id = t_u_id;
		this.t_n_id = t_n_id;
		this.c_content = c_content;
		this.c_createtime = c_createtime;
		this.c_thumbscount = c_thumbscount;
	}
	
}

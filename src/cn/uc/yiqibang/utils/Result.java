package cn.uc.yiqibang.utils;
/**
 * 结果集的封装工具类
 * @author Administrator
 *
 */
public class Result {
	
	/**
	 * 响应码
	 */
	private int retCode;
	/**
	 * 结果
	 */
	private boolean retMsg;
	/**
	 * 响应数据
	 */
	private Object retData;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public boolean isRetMsg() {
		return retMsg;
	}
	public void setRetMsg(boolean retMsg) {
		this.retMsg = retMsg;
	}
	public Object getRetData() {
		return retData;
	}
	public void setRetData(Object retData) {
		this.retData = retData;
	}
	public Result(int retCode, boolean retMsg, Object retData) {
//		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
		this.retData = retData;
	}
	@Override
	public String toString() {
		return "Result [retCode=" + retCode + ", retMsg=" + retMsg + ", retData=" + retData + "]";
	}
	
	
}

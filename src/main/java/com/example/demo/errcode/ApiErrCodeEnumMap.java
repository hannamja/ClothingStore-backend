package com.example.demo.errcode;
import java.util.EnumMap;
public class ApiErrCodeEnumMap {
	EnumMap<ApiErrCode, String> apiErrCode;

	public ApiErrCodeEnumMap() {
		super();
		apiErrCode = new EnumMap<>(ApiErrCode.class);
		apiErrCode.put(ApiErrCode.SAVE_SUCCESS, "Lưu thành công");
		apiErrCode.put(ApiErrCode.CONNECT_ERROR, "Lỗi kết nối");
		apiErrCode.put(ApiErrCode.BILL_CONFIRMED_SUCCESS, "Duyệt đơn thành công");
		apiErrCode.put(ApiErrCode.BILL_CONFIRMED_FAIL, "Duyệt đơn thất bại");
		apiErrCode.put(ApiErrCode.BILL_COMPLETED_DELIVERING, "Giao đơn hàng thành công");
		apiErrCode.put(ApiErrCode.BILL_FAIL_TO_DELIVERY, "Giao đơn hàng thất bại");
		apiErrCode.put(ApiErrCode.BILL_CANCELED_SUCCESS, "Hủy đơn thành công");
		apiErrCode.put(ApiErrCode.BILL_CANCLED_FAIL, "Hủy đơn thất bại");
		apiErrCode.put(ApiErrCode.BILL_PROCESSED_SUCCESS, "Giao cho đơn vị vận chuyển thành công");
		apiErrCode.put(ApiErrCode.BILL_PROCESSED_FAIL, "Giao đơn cho đơn vị vận chuyển thất bại");
	}

	public EnumMap<ApiErrCode, String> getApiErrCode() {
		return apiErrCode;
	}

	public void setApiErrCode(EnumMap<ApiErrCode, String> apiErrCode) {
		this.apiErrCode = apiErrCode;
	}
	
	
	
}

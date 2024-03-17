package nckh.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Sửa Thành Công");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
			result.put("message", "Thêm Thành Công");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Xóa Thành Công");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("message", "Lỗi Hệ Thống");
			result.put("alert", "danger");
		}else if(message.equals("createAccout_success")) {
			result.put("message", "Đăng Ký Thành Công");
			result.put("alert", "success");
		}else if(message.equals("inaccurate_information")) {
			result.put("message", "Thông Tin Không Chính Xác");
			result.put("alert", "danger");
		}else if(message.equals("addCart_success")) {
			result.put("message", "Thêm Vào Giỏ Thành Công");
			result.put("alert", "success");
		}else if(message.equals("orders_success")) {
			result.put("message", "Đặt Hàng Thành Công");
			result.put("alert", "success");
		}else if(message.equals("feedback_success")) {
			result.put("message", "Gửi Phản Hồi Thành Công");
			result.put("alert", "success");
		}else if(message.equals("addOrder_success")) {
			result.put("message", "Thêm Vào Đơn Hàng Thành Công");
			result.put("alert", "success");
		}else if(message.equals("deleteOrder_success")) {
			result.put("message", "Hủy Đơn Hàng Thành Công");
			result.put("alert", "success");
		}else if(message.equals("deleteOrder_error")) {
			result.put("message", "Không Thể Hủy Đơn Hàng");
			result.put("alert", "danger");
		}else if(message.equals("updateOrder_Success")) {
			result.put("message", "Cập Nhập Đơn Hàng Thành Công");
			result.put("alert", "success");
		}else if(message.equals("updateOrder_error")) {
			result.put("message", "Lỗi Cập Nhập Đơn Hàng");
			result.put("alert", "danger");
		}else if(message.equals("createOrder_Error")) {
			result.put("message", "Vui Lòng Thêm Sản Phẩm Vào Đơn Hàng");
			result.put("alert", "danger");
		}else if(message.equals("add_import_success")) {
			result.put("message", "Nhập Đơn Hàng Thành Công");
			result.put("alert", "success");
		}else if(message.equals("add_import_error")) {
			result.put("message", "Lỗi Nhập Đơn Hàng");
			result.put("alert", "danger");
		}else if(message.equals("import_error_null")) {
			result.put("message", "Vui Lòng Chọn Sản Phẩm Cần Nhập Hàng ");
			result.put("alert", "danger");
		}
		return result;
	}
	
	
}

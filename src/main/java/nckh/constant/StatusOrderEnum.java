package nckh.constant;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum StatusOrderEnum {

    DA_GIAO_HANG(0, "Đã Giao Hàng"),
    DANG_GIAO_HANG(1, "Đang Giao Hàng"),
    DANG_XU_LY(2, "Đang Xử Lý"),
    DA_HUY(3, "Đã Hủy Đơn");

    private final int status;
    private final String descreiption;

    StatusOrderEnum(int status, String descreiption) {
        this.status = status;
        this.descreiption = descreiption;
    }

    public static String getDescreiption(Integer status) {
        for (Map.Entry<Integer, String> statusEntry : getAllStatusOrder().entrySet()) {
            if (statusEntry.getKey().equals(status)) {
                if (statusEntry.getKey().equals(3)) {
                    return DA_HUY.getDescreiption();
                }
                return statusEntry.getValue();
            }
        }
        return null;
    }
    public static Map<Integer,String>getAllStatusOrder(){

        Map<Integer , String> allStatusOrder = new HashMap<>();
        allStatusOrder.put(DA_GIAO_HANG.getStatus(), DA_GIAO_HANG.descreiption);
        allStatusOrder.put(DANG_GIAO_HANG.getStatus(), DANG_GIAO_HANG.descreiption);
        allStatusOrder.put(DANG_XU_LY.getStatus(), DANG_XU_LY.descreiption);
        allStatusOrder.put(DA_HUY.getStatus(), "Hủy Đơn");

        return allStatusOrder;
    }
}

package nckh.constant;

import org.springframework.stereotype.Component;

@Component
public class SystemConstant {
	
	public static final int ACTIVE_STATUS = 1;
	public static final int INACTIVE_STATUS = 0;
	public static final int IN_CART = 1;
	public static final int IN_ORDER = 0;
	public static final String STARTED_HOUR_DEFAULT = " 00:00:00";
	public static final String FINISHED_HOUR_DEFAULT = " 23:59:59"; // mm-dd
}

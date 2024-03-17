package nckh.service;

public interface ISecurityService {

	String findLoggedInUsername();

	void autologin(String userName, String password);
}

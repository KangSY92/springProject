package kr.co.green.member.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
	private final HttpStatus status;
	private final String path;
	
	public MemberException(String message, HttpStatus status, String path) {
		super(message);
		this.status = status;
		this.path = path;
	}

}

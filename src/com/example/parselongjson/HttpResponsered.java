package com.example.parselongjson;

public interface HttpResponsered {
	public void responseWithError(String error, Object... parameters);
	public void response(String response, Object... parameters);
}

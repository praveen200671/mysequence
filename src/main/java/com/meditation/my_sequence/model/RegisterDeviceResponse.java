package com.meditation.my_sequence.model;

public class RegisterDeviceResponse {
	  private String status;
	    private String message;
	    
	    
		public RegisterDeviceResponse(String status, String message) {
			super();
			this.status = status;
			this.message = message;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "RegisterDeviceResponse [status=" + status + ", message=" + message + "]";
		}
	    
	    
}

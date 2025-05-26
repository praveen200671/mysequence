package com.meditation.my_sequence.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSequenceHistoryRequest {
	private Integer sequenceId;
	private Integer playDuration;
	private LocalDateTime timestamp;
	private Integer userId;
	
}
